//import org.apache.axis.AxisProperties;

import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.rpc.ServiceException;


public class Client {
	private static final char CARD_READER_STATUS_REQUEST 	= 'R';
	private static final char PATIENT_INFORMATION_REQUEST 	= 'P';
	
	public static void main(String[] args) {
		GinaCaller session;
		if((session = init(args)) == null)
			System.exit(-1);
		try (InputStreamReader cin = new InputStreamReader(System.in)) {
			while (true) switch ((char) cin.read()) {
				case CARD_READER_STATUS_REQUEST:
					System.out.print(session.getCardReaderStatus(10000));
					break;
				case PATIENT_INFORMATION_REQUEST:
					System.out.print(session.getPatientInformation());
					break;
				case 'Q':
					cin.close();
					System.exit(-1);
					break;
				default:
					System.err.print("Wrong command code");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static GinaCaller init(String[] args) {
		if (args.length < 2) 
			return null;
		String hostAddr = args[0], cardReaderAddr = args[1];
		GinaCaller session;
		try {
			session = new GinaCaller(hostAddr, cardReaderAddr);
			return session;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
