import at.chipkarte.client.base.soap.*;
import at.chipkarte.client.base.soap.exceptions.CardExceptionContent;
import at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.json.simple.JSONObject;

public class GinaCaller extends BaseServiceLocator {
	private static IBaseService session;
	private static String[] cardReader = new String[1];
	private static JSONObject state = new JSONObject(); 
	private static JSONObject patient = new JSONObject();
	
	public GinaCaller(String hostUrl, String cardReaderID) throws ServiceException {
		super();
		setbase_15EndpointAddress(hostUrl);
		GinaCaller.session = getbase_15();
		GinaCaller.cardReader[0] = cardReaderID;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getCardReaderStatus(Integer timeOut) throws ServiceExceptionContent, CardExceptionContent, RemoteException {
		state.remove("cardinfo");
		
		ReaderStatusEvent statusResult = 
				session.getReaderStatusEvents(null, cardReader, timeOut)
				.getReaderStatusEvents(0);
		
		JSONObject cardstatus = new JSONObject();
		
		state.put("cardinfo", cardstatus);
		cardstatus.put("state", statusResult.getCardReaderState());
		cardstatus.put("cardtype", statusResult.getCardType());
		
		return state;
	}
	
	public JSONObject getPatientInformation() throws ServiceExceptionContent, CardExceptionContent, RemoteException {
		patient.remove("patient");
		
		Card cardData = session.getCardData(cardReader[0]);
		
		JSONObject patientData = new JSONObject();
		
		patient.put("patient", patientData);
		patientData.put("svnr", cardData.getNummer());
		patientData.put("titel", cardData.getTitel());
		patientData.put("vorname", cardData.getVorname());
		patientData.put("nachname", cardData.getNachname());
		patientData.put("geburtsdatum", cardData.getGeburtsdatum());
		
		return patient;
	}
	
	public CardReader[] getCardReaders() throws ServiceExceptionContent, RemoteException {
		return session.getCardReaders();
	}
}
