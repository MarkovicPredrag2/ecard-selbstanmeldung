/**
 * IVdasService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.vdas.soap;

public interface IVdasService extends java.rmi.Remote {
    public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent;
    public at.chipkarte.client.vdas.soap.VersichertendatenAbfrageErgebnis getVersichertenDaten(java.lang.String dialogId, at.chipkarte.client.vdas.soap.VersichertendatenAbfrage suchKriterien, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent, at.chipkarte.client.vdas.soap.exceptions.InvalidParameterVdasExceptionContent, at.chipkarte.client.vdas.soap.exceptions.VdasExceptionContent;
    public at.chipkarte.client.vdas.soap.VersichertendatenAbfrageErgebnis retrieveVersichertendatenPerStichtag(java.lang.String dialogId, at.chipkarte.client.vdas.soap.VersichertendatenAbfragePerStichtag suchKriterien, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent, at.chipkarte.client.vdas.soap.exceptions.InvalidParameterVdasExceptionContent, at.chipkarte.client.vdas.soap.exceptions.VdasExceptionContent;
}
