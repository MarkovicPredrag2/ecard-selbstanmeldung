//import org.apache.axis.AxisProperties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisProperties;

import at.chipkarte.client.base.soap.BaseServiceLocator;
import at.chipkarte.client.base.soap.IBaseService;
import at.chipkarte.client.base.soap.exceptions.CardExceptionContent;
import at.chipkarte.client.base.soap.exceptions.DialogExceptionContent;
import at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent;
import at.chipkarte.client.sas.soap.ISasService;
import at.chipkarte.client.vdas.soap.IVdasService;

public class Client {
	private static final char CARD_READER_STATUS_REQUEST 	= 'R';
	private static final char PATIENT_INFORMATION_REQUEST 	= 'P';
	
	public static void main(String[] args) {
		// Ignore certificate problems
		AxisProperties.setProperty("axis.socketSecureFactory",
				"org.apache.axis.components.net.SunFakeTrustSocketFactory");
		
		GinaCallerWrapper session;
 		if((session = init(args)) == null) {
			System.exit(-1);
		}
		
		System.out.print("{ \"init\": true }");
		
		try (InputStreamReader cin = new InputStreamReader(System.in)) {
			while (true) {
				switch ((char) cin.read()) {
					case CARD_READER_STATUS_REQUEST:
						try {
							System.out.print(session.getCardReaderStatus(10000));
						} catch (Exception e1) {
							System.err.print(
									"Es konnte der Status des Kartenlesegeraets nicht ermittelt werden");
						}
						break;
					case PATIENT_INFORMATION_REQUEST:
						try {
							System.out.print(session.getPatientInformation().toString());
						} catch (Exception e) {
							System.err.print(
									"Versicherungsdaten wurden bereits von dieser Karte empfangen.");
//							e.printStackTrace();
						}
						break;
					case 'Q':
						cin.close();
						System.exit(-1);
						break;
					default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static GinaCallerWrapper init(String[] args) {
		// The 4 params are:
		// 1. host-Addr
		// 2. cardReaderAddr_Patient
		// 3. cardReaderAddr_Ocard
		// 4. O-Card Pin
		if (args.length < 4) {
			return null;
		}
		String hostAddr = args[0],
				cardReaderAddr = args[1],
				ocardReaderAddr = args[2],
				PIN = args[3];
		
		GinaCallerWrapper session;
		try {
			session = new GinaCallerWrapper(cardReaderAddr, ocardReaderAddr, PIN, hostAddr);
			session.invokeDialog();
			return session;
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ServiceExceptionContent e) {
			e.printStackTrace();
		} catch (DialogExceptionContent e) {
			e.printStackTrace();
		} catch (CardExceptionContent e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
