package at.chipkarte.client.vdas.soap;

public class IVdasServiceProxy implements at.chipkarte.client.vdas.soap.IVdasService {
  private String _endpoint = null;
  private at.chipkarte.client.vdas.soap.IVdasService iVdasService = null;
  
  public IVdasServiceProxy() {
    _initIVdasServiceProxy();
  }
  
  public IVdasServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIVdasServiceProxy();
  }
  
  private void _initIVdasServiceProxy() {
    try {
      iVdasService = (new at.chipkarte.client.vdas.soap.VdasServiceLocator()).getvdas_14();
      if (iVdasService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iVdasService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iVdasService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iVdasService != null)
      ((javax.xml.rpc.Stub)iVdasService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public at.chipkarte.client.vdas.soap.IVdasService getIVdasService() {
    if (iVdasService == null)
      _initIVdasServiceProxy();
    return iVdasService;
  }
  
  public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iVdasService == null)
      _initIVdasServiceProxy();
    return iVdasService.checkStatus(dialogId);
  }
  
  public at.chipkarte.client.vdas.soap.VersichertendatenAbfrageErgebnis getVersichertenDaten(java.lang.String dialogId, at.chipkarte.client.vdas.soap.VersichertendatenAbfrage suchKriterien, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent, at.chipkarte.client.vdas.soap.exceptions.InvalidParameterVdasExceptionContent, at.chipkarte.client.vdas.soap.exceptions.VdasExceptionContent{
    if (iVdasService == null)
      _initIVdasServiceProxy();
    return iVdasService.getVersichertenDaten(dialogId, suchKriterien, cardReaderId);
  }
  
  public at.chipkarte.client.vdas.soap.VersichertendatenAbfrageErgebnis retrieveVersichertendatenPerStichtag(java.lang.String dialogId, at.chipkarte.client.vdas.soap.VersichertendatenAbfragePerStichtag suchKriterien, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent, at.chipkarte.client.vdas.soap.exceptions.InvalidParameterVdasExceptionContent, at.chipkarte.client.vdas.soap.exceptions.VdasExceptionContent{
    if (iVdasService == null)
      _initIVdasServiceProxy();
    return iVdasService.retrieveVersichertendatenPerStichtag(dialogId, suchKriterien, cardReaderId);
  }
  
  
}