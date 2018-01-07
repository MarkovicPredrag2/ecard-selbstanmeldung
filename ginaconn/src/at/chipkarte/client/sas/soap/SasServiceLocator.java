/**
 * SasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class SasServiceLocator extends org.apache.axis.client.Service implements at.chipkarte.client.sas.soap.SasService {

    public SasServiceLocator() {
    }


    public SasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for sas_12
    private java.lang.String sas_12_address = "https://10.196.2.18/sas/12";

    public java.lang.String getsas_12Address() {
        return sas_12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String sas_12WSDDServiceName = "sas_12";

    public java.lang.String getsas_12WSDDServiceName() {
        return sas_12WSDDServiceName;
    }

    public void setsas_12WSDDServiceName(java.lang.String name) {
        sas_12WSDDServiceName = name;
    }

    public at.chipkarte.client.sas.soap.ISasService getsas_12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(sas_12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsas_12(endpoint);
    }

    public at.chipkarte.client.sas.soap.ISasService getsas_12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            at.chipkarte.client.sas.soap.Sas_12BindingStub _stub = new at.chipkarte.client.sas.soap.Sas_12BindingStub(portAddress, this);
            _stub.setPortName(getsas_12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsas_12EndpointAddress(java.lang.String address) {
        sas_12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (at.chipkarte.client.sas.soap.ISasService.class.isAssignableFrom(serviceEndpointInterface)) {
                at.chipkarte.client.sas.soap.Sas_12BindingStub _stub = new at.chipkarte.client.sas.soap.Sas_12BindingStub(new java.net.URL(sas_12_address), this);
                _stub.setPortName(getsas_12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("sas_12".equals(inputPortName)) {
            return getsas_12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "SasService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "sas_12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("sas_12".equals(portName)) {
            setsas_12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
