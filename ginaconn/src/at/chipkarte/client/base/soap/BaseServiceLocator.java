/**
 * BaseServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class BaseServiceLocator extends org.apache.axis.client.Service implements at.chipkarte.client.base.soap.BaseService {

    public BaseServiceLocator() {
    }


    public BaseServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BaseServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for base_15
    private java.lang.String base_15_address = "https://10.196.2.18/base/15";

    public java.lang.String getbase_15Address() {
        return base_15_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String base_15WSDDServiceName = "base_15";

    public java.lang.String getbase_15WSDDServiceName() {
        return base_15WSDDServiceName;
    }

    public void setbase_15WSDDServiceName(java.lang.String name) {
        base_15WSDDServiceName = name;
    }

    public at.chipkarte.client.base.soap.IBaseService getbase_15() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(base_15_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getbase_15(endpoint);
    }

    public at.chipkarte.client.base.soap.IBaseService getbase_15(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            at.chipkarte.client.base.soap.Base_15BindingStub _stub = new at.chipkarte.client.base.soap.Base_15BindingStub(portAddress, this);
            _stub.setPortName(getbase_15WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setbase_15EndpointAddress(java.lang.String address) {
        base_15_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (at.chipkarte.client.base.soap.IBaseService.class.isAssignableFrom(serviceEndpointInterface)) {
                at.chipkarte.client.base.soap.Base_15BindingStub _stub = new at.chipkarte.client.base.soap.Base_15BindingStub(new java.net.URL(base_15_address), this);
                _stub.setPortName(getbase_15WSDDServiceName());
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
        if ("base_15".equals(inputPortName)) {
            return getbase_15();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "BaseService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "base_15"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("base_15".equals(portName)) {
            setbase_15EndpointAddress(address);
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
