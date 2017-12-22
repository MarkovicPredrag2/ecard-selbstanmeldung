package at.chipkarte.client.base.soap;

public class IBaseServiceProxy implements at.chipkarte.client.base.soap.IBaseService {
  private String _endpoint = null;
  private at.chipkarte.client.base.soap.IBaseService iBaseService = null;
  
  public IBaseServiceProxy() {
    _initIBaseServiceProxy();
  }
  
  public IBaseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIBaseServiceProxy();
  }
  
  private void _initIBaseServiceProxy() {
    try {
      iBaseService = (new at.chipkarte.client.base.soap.BaseServiceLocator()).getbase_15();
      if (iBaseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iBaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iBaseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iBaseService != null)
      ((javax.xml.rpc.Stub)iBaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public at.chipkarte.client.base.soap.IBaseService getIBaseService() {
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService;
  }
  
  public at.chipkarte.client.base.soap.VertragspartnerV2 authenticateDialog(java.lang.String dialogId, java.lang.String cin, java.lang.String pin, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.authenticateDialog(dialogId, cin, pin, cardReaderId);
  }
  
  public at.chipkarte.client.base.soap.VertragspartnerV2 authenticateDialogEnt(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.authenticateDialogEnt(dialogId);
  }
  
  public void changePin(java.lang.String cardReaderId, java.lang.String cin, java.lang.String oldPin, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.changePin(cardReaderId, cin, oldPin, newPin);
  }
  
  public void changePinWithPuk(java.lang.String cardReaderId, java.lang.String cin, java.lang.String puk, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.changePinWithPuk(cardReaderId, cin, puk, newPin);
  }
  
  public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.checkStatus(dialogId);
  }
  
  public void closeDialog(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.closeDialog(dialogId);
  }
  
  public java.lang.String createDialog(java.lang.String cardReaderId, at.chipkarte.client.base.soap.ProduktInfo produktInfo, java.lang.String extUID, java.lang.Boolean pushMessageEnabled) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.createDialog(cardReaderId, produktInfo, extUID, pushMessageEnabled);
  }
  
  public java.lang.String createDialogEnt(java.lang.String cardReaderId, at.chipkarte.client.base.soap.ProduktInfo produktInfo, java.lang.String extUID, java.lang.String vpNummer, java.lang.Boolean pushMessageEnabled) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.createDialogEnt(cardReaderId, produktInfo, extUID, vpNummer, pushMessageEnabled);
  }
  
  public java.lang.Integer doCardTest(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.doCardTest(cardReaderId);
  }
  
  public java.lang.String[] getBerechtigungen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getBerechtigungen(dialogId);
  }
  
  public at.chipkarte.client.base.soap.Card getCardData(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getCardData(cardReaderId);
  }
  
  public at.chipkarte.client.base.soap.CardReader[] getCardReaders() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getCardReaders();
  }
  
  public at.chipkarte.client.base.soap.Property[] getExtendedCardData(java.lang.String cardReaderId, java.lang.String CIN) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getExtendedCardData(cardReaderId, CIN);
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getFachgebiete() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getFachgebiete();
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getFachgebieteByOrdId(java.lang.String dialogId, java.lang.String ordId, java.lang.String taetigkeitsBereichId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getFachgebieteByOrdId(dialogId, ordId, taetigkeitsBereichId);
  }
  
  public at.chipkarte.client.base.soap.DialogsInfo getFreeDialogs() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getFreeDialogs();
  }
  
  public at.chipkarte.client.base.soap.StatusInformationen getGinaAndServiceavailabilityInformation() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getGinaAndServiceavailabilityInformation();
  }
  
  public at.chipkarte.client.base.soap.GinaVersion getGinaSoftwareVersion() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getGinaSoftwareVersion();
  }
  
  public at.chipkarte.client.base.soap.Message[] getMessages(java.lang.String dialogId, java.lang.Boolean newOnly) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getMessages(dialogId, newOnly);
  }
  
  public java.lang.Integer getMinMsgPollingIntervall(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getMinMsgPollingIntervall(dialogId);
  }
  
  public at.chipkarte.client.base.soap.ReaderStatusResult getReaderStatusEvents(java.lang.String handle, java.lang.String[] cardReaderId, java.lang.Integer timeOut) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getReaderStatusEvents(handle, cardReaderId, timeOut);
  }
  
  public at.chipkarte.client.base.soap.SvtProperty[] getSVTs() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getSVTs();
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getStaaten() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getStaaten();
  }
  
  public at.chipkarte.client.base.soap.VertragsDaten[] getVertraege(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.getVertraege(dialogId);
  }
  
  public at.chipkarte.client.base.soap.MessagePollResult pollMessages(java.lang.String dialogId, java.lang.String suchzeitpunkt) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    return iBaseService.pollMessages(dialogId, suchzeitpunkt);
  }
  
  public void releaseCardReader(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.releaseCardReader(cardReaderId);
  }
  
  public void setCardReader(java.lang.String dialogId, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.setCardReader(dialogId, cardReaderId);
  }
  
  public void setDialogAddress(java.lang.String dialogId, java.lang.String ordinationId, java.lang.String taetigkeitsBereichId, java.lang.String elgaRolle, at.chipkarte.client.base.soap.GdaMa gdaMa, java.lang.String prozess) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId, elgaRolle, gdaMa, prozess);
  }
  
  public void uebersiedelnOrdination(java.lang.String dialogId, java.lang.String ordinationId, java.lang.Boolean forceUebersiedlung) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent{
    if (iBaseService == null)
      _initIBaseServiceProxy();
    iBaseService.uebersiedelnOrdination(dialogId, ordinationId, forceUebersiedlung);
  }
  
  
}