import at.chipkarte.client.base.soap.*;
import at.chipkarte.client.base.soap.exceptions.AccessExceptionContent;
import at.chipkarte.client.base.soap.exceptions.CardExceptionContent;
import at.chipkarte.client.base.soap.exceptions.DialogExceptionContent;
import at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent;
import at.chipkarte.client.sas.soap.AbfrageErgebnis;
import at.chipkarte.client.sas.soap.Adressdaten;
import at.chipkarte.client.sas.soap.ISasService;
import at.chipkarte.client.sas.soap.SasServiceLocator;
import at.chipkarte.client.sas.soap.Suchkriterien;
import at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent;
import at.chipkarte.client.sas.soap.exceptions.SasExceptionContent;
import at.chipkarte.client.vdas.soap.Anspruchsdaten;
import at.chipkarte.client.vdas.soap.IVdasService;
import at.chipkarte.client.vdas.soap.VdasServiceLocator;
import at.chipkarte.client.vdas.soap.VersichertendatenAbfrage;
import at.chipkarte.client.vdas.soap.VersichertendatenAbfrageErgebnis;
import at.chipkarte.client.vdas.soap.VersichertendatenAbfragePerStichtag;
import at.chipkarte.client.vdas.soap.exceptions.InvalidParameterVdasExceptionContent;
import at.chipkarte.client.vdas.soap.exceptions.VdasExceptionContent;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GinaCallerWrapper implements IBaseService, ISasService, IVdasService {
	// String fields
	private String PIN;
	private String dialogId;
	private String[] cardReader = new String[2];
	
	// Constant JSON objects (for recycling)
	private final JSONObject state = new JSONObject(); 
	private final JSONObject client = new JSONObject();
	
	public GinaCallerWrapper(String cardReaderID, String ocardReaderID, String PIN) {
		super();
		// Note: 
		// 0 is the patient card reader
		// 1 is the o card reader
		this.cardReader[0] = cardReaderID;
		this.cardReader[1] = ocardReaderID;
		this.PIN = PIN;
	}
	
	public void invokeDialog() throws ServiceExceptionContent, DialogExceptionContent, CardExceptionContent, RemoteException {
		ProduktInfo pi = new ProduktInfo();
		pi.setProduktId(1);
		pi.setProduktVersion("1");
		this.dialogId = createDialog(this.cardReader[0], pi, null, false);
		authenticateDialog(dialogId, getCardData(this.cardReader[1]).getCin(), this.PIN, this.cardReader[1]);
	}

	@SuppressWarnings("unchecked")
	public JSONObject getCardReaderStatus(Integer timeOut) throws ServiceExceptionContent, CardExceptionContent, RemoteException {
		state.clear();
		JSONObject cardinfo = new JSONObject();
		state.put("cardinfo", cardinfo);
		ReaderStatusEvent[] statusResult = getReaderStatusEvents(null, cardReader, timeOut).getReaderStatusEvents();
		
		//	ECard status
		JSONObject ecardstatus = new JSONObject();
		
		cardinfo.put("ecardinfo", ecardstatus);
		
		ecardstatus.put("state", statusResult[0].getCardReaderState());
		ecardstatus.put("type", statusResult[0].getCardType());
		
		/*// OCard status
		JSONObject ocardstatus = new JSONObject();
		
		cardinfo.put("oCardinfo", ocardstatus);
		
		ocardstatus.put("state", statusResult[1].getCardReaderState());
		ocardstatus.put("type", statusResult[1].getCardType());*/
		
		return state;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getPatientInformation() throws ServiceExceptionContent, CardExceptionContent, RemoteException {
		client.clear();
		JSONObject patient = new JSONObject();
		client.put("patient", patient);
		Card cardData = getCardData(cardReader[0]);
		
		// Personal information of the patient
		JSONObject person = new JSONObject();
		
		patient.put("person", person);
		
		person.put("geschlecht", cardData.getGeschlechtCode());
		person.put("titel", cardData.getTitel());
		person.put("vorname", cardData.getVorname());
		person.put("nachname", cardData.getNachname());
		person.put("geburtsdatum", cardData.getGeburtsdatum());
		
		// Address data of the patient
		JSONObject address = new JSONObject();
		Adressdaten addressdata = adressdatenAbfragen(this.dialogId, cardData.getNummer());
		
		patient.put("addresse", address);
		
		address.put("abgabestelle", addressdata.getAbgabestelle());
		address.put("anschriftzusatz", addressdata.getAnschriftszusatz());
		address.put("hausnummer", addressdata.getHausnummer());
		address.put("ort", addressdata.getOrt());
		address.put("plz", addressdata.getPlz());
		address.put("postfachnummer", addressdata.getPostfachNummer());
		address.put("postfachtext", addressdata.getPostfachText());
		address.put("staatscode", addressdata.getStaatscode());
		address.put("stocktuernummer", addressdata.getStockTuerNummer());
		address.put("strasse", addressdata.getStrasse());
		
		// Insurance data of the patient
		JSONObject insurance = new JSONObject();
		VersichertendatenAbfrageErgebnis versicherung = getVersichertenDaten(this.dialogId, null, this.cardReader[0]);
		
		patient.put("versicherung", insurance);
		
		insurance.put("svnr", cardData.getNummer());
		JSONArray claimdata = new JSONArray();
		for (Anspruchsdaten anspruch : versicherung.getAnspruchsDaten()) {
			JSONObject claim = new JSONObject();
			claim.put("anspruchsart", anspruch.getAnspruchsart());
			claim.put("svtCode", anspruch.getSvtCode());
			claim.put("versichertenArtCode", anspruch.getVersichertenartCode());
			claim.put("kostenteilbefreit", anspruch.getKostenanteilbefreit());
			claim.put("rezeptbefreit", anspruch.getRezeptgebbefreit());
			claimdata.add(claim);
		}
		insurance.put("anspruchsdaten", claimdata);
		
		return patient;
	}
	
	public CardReader[] getCardReaders() throws ServiceExceptionContent, RemoteException {
		return getCardReaders();
	}

	@Override
	public VersichertendatenAbfrageErgebnis getVersichertenDaten(String dialogId,
			VersichertendatenAbfrage suchKriterien, String cardReaderId)
			throws RemoteException, AccessExceptionContent, ServiceExceptionContent, DialogExceptionContent,
			CardExceptionContent, InvalidParameterVdasExceptionContent, VdasExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersichertendatenAbfrageErgebnis retrieveVersichertendatenPerStichtag(String dialogId,
			VersichertendatenAbfragePerStichtag suchKriterien, String cardReaderId)
			throws RemoteException, AccessExceptionContent, ServiceExceptionContent, DialogExceptionContent,
			CardExceptionContent, InvalidParameterVdasExceptionContent, VdasExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adressdaten adressdatenAbfragen(String dialogId, String svNummer)
			throws RemoteException, AccessExceptionContent, ServiceExceptionContent, DialogExceptionContent,
			SasExceptionContent, InvalidParameterSuchkriterienExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbfrageErgebnis patientendatenAbfragen(String dialogId, String svNummer)
			throws RemoteException, AccessExceptionContent, ServiceExceptionContent, DialogExceptionContent,
			SasExceptionContent, InvalidParameterSuchkriterienExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbfrageErgebnis svNummerAbfragen(String dialogId, Suchkriterien svNummerAbfragenSuchkriterien)
			throws RemoteException, AccessExceptionContent, ServiceExceptionContent, DialogExceptionContent,
			SasExceptionContent, InvalidParameterSuchkriterienExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertragspartnerV2 authenticateDialog(String dialogId, String cin, String pin, String cardReaderId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertragspartnerV2 authenticateDialogEnt(String dialogId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePin(String cardReaderId, String cin, String oldPin, String newPin)
			throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePinWithPuk(String cardReaderId, String cin, String puk, String newPin)
			throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Property[] checkStatus(String dialogId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeDialog(String dialogId) throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String createDialog(String cardReaderId, ProduktInfo produktInfo, String extUID, Boolean pushMessageEnabled)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createDialogEnt(String cardReaderId, ProduktInfo produktInfo, String extUID, String vpNummer,
			Boolean pushMessageEnabled)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer doCardTest(String cardReaderId)
			throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getBerechtigungen(String dialogId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card getCardData(String cardReaderId) throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property[] getExtendedCardData(String cardReaderId, String CIN)
			throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseProperty[] getFachgebiete() throws RemoteException, ServiceExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseProperty[] getFachgebieteByOrdId(String dialogId, String ordId, String taetigkeitsBereichId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DialogsInfo getFreeDialogs() throws RemoteException, ServiceExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInformationen getGinaAndServiceavailabilityInformation()
			throws RemoteException, ServiceExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GinaVersion getGinaSoftwareVersion() throws RemoteException, ServiceExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message[] getMessages(String dialogId, Boolean newOnly)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMinMsgPollingIntervall(String dialogId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReaderStatusResult getReaderStatusEvents(String handle, String[] cardReaderId, Integer timeOut)
			throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SvtProperty[] getSVTs() throws RemoteException, ServiceExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseProperty[] getStaaten() throws RemoteException, ServiceExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertragsDaten[] getVertraege(String dialogId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessagePollResult pollMessages(String dialogId, String suchzeitpunkt)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releaseCardReader(String cardReaderId)
			throws RemoteException, ServiceExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCardReader(String dialogId, String cardReaderId)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent, CardExceptionContent {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDialogAddress(String dialogId, String ordinationId, String taetigkeitsBereichId, String elgaRolle,
			GdaMa gdaMa, String prozess) throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uebersiedelnOrdination(String dialogId, String ordinationId, Boolean forceUebersiedlung)
			throws RemoteException, ServiceExceptionContent, DialogExceptionContent {
		// TODO Auto-generated method stub
		
	}
}
