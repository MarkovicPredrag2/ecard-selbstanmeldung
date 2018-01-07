/**
 * ISasService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public interface ISasService extends java.rmi.Remote {
    public at.chipkarte.client.sas.soap.Adressdaten adressdatenAbfragen(java.lang.String dialogId, java.lang.String svNummer) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.sas.soap.exceptions.SasExceptionContent, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent;
    public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent;
    public at.chipkarte.client.sas.soap.AbfrageErgebnis patientendatenAbfragen(java.lang.String dialogId, java.lang.String svNummer) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.sas.soap.exceptions.SasExceptionContent, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent;
    public at.chipkarte.client.sas.soap.AbfrageErgebnis svNummerAbfragen(java.lang.String dialogId, at.chipkarte.client.sas.soap.Suchkriterien svNummerAbfragenSuchkriterien) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.sas.soap.exceptions.SasExceptionContent, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent;
}
