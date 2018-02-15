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

public class GinaCallerWrapper {
	// String fields
	private String PIN;
	private String dialogId;
	private String[] cardReader = new String[2];
	private final String vdasUrl = "/vdas/14", sasUrl = "/sas/12", baseUrl = "/base/15";
	
	// Constant JSON objects (for recycling)
	private final JSONObject state = new JSONObject(); 
	private final JSONObject client = new JSONObject();
	private String hostUrl;
	
	// Services
	private IBaseService ibs;
	private ISasService isas;
	private IVdasService ivdas;
	
	public GinaCallerWrapper(String cardReaderID, String ocardReaderID, String PIN, String hostUrl) throws ServiceExceptionContent, RemoteException, ServiceException {
		super();
		// Note: 
		// 0 is the patient card reader
		// 1 is the o card reader
		this.cardReader[0] = cardReaderID;
		this.cardReader[1] = ocardReaderID;
		this.PIN = PIN;
		this.hostUrl = hostUrl;
		
		connectToBaseService();
		connectToSasService();
		connectToVdasService();
	}
	
	public void invokeDialog() throws ServiceExceptionContent, DialogExceptionContent, CardExceptionContent, RemoteException {
		ProduktInfo pi = new ProduktInfo();
		pi.setProduktId(1);
		pi.setProduktVersion("1");
		this.dialogId = ibs.createDialog(this.cardReader[0], pi, null, false);
		
		// Authenticae the dialog
		VertragspartnerV2 vertragspartner = ibs.authenticateDialog(this.dialogId, ibs.getCardData(this.cardReader[1]).getCin(), this.PIN, this.cardReader[1]);

		// Set taetigkeitsbereich
		Ordination[] ordination = vertragspartner.getOrdination();
		ibs.setDialogAddress(this.dialogId, ordination[0].getOrdinationId(), ordination[0].getTaetigkeitsBereich(0).getId(), null, null, null);
	}
	
	public void connectToBaseService() throws ServiceException, ServiceExceptionContent, RemoteException {
		BaseServiceLocator baseService = new BaseServiceLocator();
		baseService.setbase_15EndpointAddress(this.hostUrl + baseUrl);
		ibs = baseService.getbase_15();
	}
	
	public void connectToSasService() throws ServiceException {
		SasServiceLocator sasService = new SasServiceLocator();
		sasService.setsas_12EndpointAddress(this.hostUrl + sasUrl);
		isas = sasService.getsas_12();
	}
	
	public void connectToVdasService() throws ServiceException {
		VdasServiceLocator vdasService = new VdasServiceLocator();
		System.out.println(this.hostUrl + vdasUrl);
		vdasService.setvdas_14EndpointAddress(this.hostUrl + vdasUrl);
		ivdas = vdasService.getvdas_14();
	}

	@SuppressWarnings("unchecked")
	public JSONObject getCardReaderStatus(Integer timeOut) throws ServiceExceptionContent, CardExceptionContent, RemoteException {
		state.clear();
		JSONObject cardinfo = new JSONObject();
		state.put("cardinfo", cardinfo);
		ReaderStatusEvent[] statusResult = ibs.getReaderStatusEvents(null, new String[] { this.cardReader[0] }, timeOut).getReaderStatusEvents();
		
		//	ECard status
		JSONObject ecardstatus = new JSONObject();
		
		cardinfo.put("ecardinfo", ecardstatus);
		
		ecardstatus.put("state", statusResult[0].getCardReaderState());
		ecardstatus.put("type", statusResult[0].getCardType());
		
		// OCard status
//		JSONObject ocardstatus = new JSONObject();
//		
//		cardinfo.put("oCardinfo", ocardstatus);
//		
//		ocardstatus.put("state", statusResult[1].getCardReaderState());
//		ocardstatus.put("type", statusResult[1].getCardType());
		
		return state;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getPatientInformation() throws ServiceExceptionContent, CardExceptionContent, RemoteException {
		client.clear();
		JSONObject patient = new JSONObject();
		client.put("patient", patient);
		Card cardData = ibs.getCardData(cardReader[0]);
		
		// Personal information of the patient
		JSONObject person = new JSONObject();
		
		patient.put("person", person);
		
		person.put("geschlecht", cardData.getGeschlechtCode());
		person.put("titel", cardData.getTitel());
		person.put("vorname", cardData.getVorname());
		person.put("nachname", cardData.getNachname());
		person.put("geburtsdatum", cardData.getGeburtsdatum());
		
		// Address data of the patient
//		JSONObject address = new JSONObject();
//		Adressdaten addressdata = isas.adressdatenAbfragen(this.dialogId, cardData.getNummer());
//		
//		patient.put("addresse", address);
//		
//		address.put("abgabestelle", addressdata.getAbgabestelle());
//		address.put("anschriftzusatz", addressdata.getAnschriftszusatz());
//		address.put("hausnummer", addressdata.getHausnummer());
//		address.put("ort", addressdata.getOrt());
//		address.put("plz", addressdata.getPlz());
//		address.put("postfachnummer", addressdata.getPostfachNummer());
//		address.put("postfachtext", addressdata.getPostfachText());
//		address.put("staatscode", addressdata.getStaatscode());
//		address.put("stocktuernummer", addressdata.getStockTuerNummer());
//		address.put("strasse", addressdata.getStrasse());
		
		// Insurance data of the patient
		JSONObject insurance = new JSONObject();
		
//		VersichertendatenAbfrageErgebnis versicherung = ivdas.getVersichertenDaten(this.dialogId, null, this.cardReader[0]);
		ivdas.
		
//		patient.put("versicherung", insurance);
//		
//		insurance.put("svnr", cardData.getNummer());
//		JSONArray claimdata = new JSONArray();
//		for (Anspruchsdaten anspruch : versicherung.getAnspruchsDaten()) {
//			JSONObject claim = new JSONObject();
//			claim.put("anspruchsart", anspruch.getAnspruchsart());
//			claim.put("svtCode", anspruch.getSvtCode());
//			claim.put("versichertenArtCode", anspruch.getVersichertenartCode());
//			claim.put("kostenteilbefreit", anspruch.getKostenanteilbefreit());
//			claim.put("rezeptbefreit", anspruch.getRezeptgebbefreit());
//			claimdata.add(claim);
//		}
//		insurance.put("anspruchsdaten", claimdata);
		
		return patient;
	}
}
