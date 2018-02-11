import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import at.chipkarte.client.base.soap.BaseServiceLocator;
import at.chipkarte.client.base.soap.IBaseService;
import at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent;
import at.chipkarte.client.sas.soap.ISasService;
import at.chipkarte.client.sas.soap.SasServiceLocator;
import at.chipkarte.client.vdas.soap.IVdasService;
import at.chipkarte.client.vdas.soap.VdasServiceLocator;

public class ServiceLocator {
	private String hostUrl;
	private final String vdasUrl = "/vdas/14", sasUrl = "/sas/12", baseUrl = "/base/15";
	
	public ServiceLocator(String hostUrl) {
		this.hostUrl = hostUrl;
	}
	
}
