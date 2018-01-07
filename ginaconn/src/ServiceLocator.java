import javax.xml.rpc.ServiceException;

import at.chipkarte.client.base.soap.BaseServiceLocator;
import at.chipkarte.client.base.soap.IBaseService;
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
	
	public void connectToBaseService(IBaseService ibs) throws ServiceException {
		BaseServiceLocator baseService = new BaseServiceLocator();
		baseService.setbase_15EndpointAddress(this.hostUrl + baseUrl);
		ibs = baseService.getbase_15();
	}
	
	public void connectToSasService(ISasService isas) throws ServiceException {
		SasServiceLocator sasService = new SasServiceLocator();
		sasService.setsas_12EndpointAddress(this.hostUrl + sasUrl);
		isas = sasService.getsas_12();
	}
	
	public void connectToVdasService(IVdasService ivdas) throws ServiceException {
		VdasServiceLocator vdasService = new VdasServiceLocator();
		vdasService.setvdas_14EndpointAddress(this.hostUrl + vdasUrl);
		ivdas = vdasService.getvdas_14();
	}
}
