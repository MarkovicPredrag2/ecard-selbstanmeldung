/**
 * VdasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.vdas.soap;

public class VdasServiceLocator extends org.apache.axis.client.Service implements at.chipkarte.client.vdas.soap.VdasService {

    public VdasServiceLocator() {
    }


    public VdasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VdasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for vdas_14
    private java.lang.String vdas_14_address = "https://10.196.2.18/vdas/14";

    public java.lang.String getvdas_14Address() {
        return vdas_14_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String vdas_14WSDDServiceName = "vdas_14";

    public java.lang.String getvdas_14WSDDServiceName() {
        return vdas_14WSDDServiceName;
    }

    public void setvdas_14WSDDServiceName(java.lang.String name) {
        vdas_14WSDDServiceName = name;
    }

    public at.chipkarte.client.vdas.soap.IVdasService getvdas_14() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(vdas_14_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getvdas_14(endpoint);
    }

    public at.chipkarte.client.vdas.soap.IVdasService getvdas_14(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            at.chipkarte.client.vdas.soap.Vdas_14BindingStub _stub = new at.chipkarte.client.vdas.soap.Vdas_14BindingStub(portAddress, this);
            _stub.setPortName(getvdas_14WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setvdas_14EndpointAddress(java.lang.String address) {
        vdas_14_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (at.chipkarte.client.vdas.soap.IVdasService.class.isAssignableFrom(serviceEndpointInterface)) {
                at.chipkarte.client.vdas.soap.Vdas_14BindingStub _stub = new at.chipkarte.client.vdas.soap.Vdas_14BindingStub(new java.net.URL(vdas_14_address), this);
                _stub.setPortName(getvdas_14WSDDServiceName());
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
        if ("vdas_14".equals(inputPortName)) {
            return getvdas_14();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "VdasService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "vdas_14"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("vdas_14".equals(portName)) {
            setvdas_14EndpointAddress(address);
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
