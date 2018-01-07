/**
 * Sas_12BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class Sas_12BindingStub extends org.apache.axis.client.Stub implements at.chipkarte.client.sas.soap.ISasService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("adressdatenAbfragen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "adressdaten"));
        oper.setReturnClass(at.chipkarte.client.sas.soap.Adressdaten.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"),
                      "at.chipkarte.client.base.soap.exceptions.AccessExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "accessExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"),
                      "at.chipkarte.client.base.soap.exceptions.DialogExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "dialogExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "SasException"),
                      "at.chipkarte.client.sas.soap.exceptions.SasExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "sasExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "InvalidParameterSuchkriterienException"),
                      "at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "invalidParameterSuchkriterienExceptionContent"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "property"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Property[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"),
                      "at.chipkarte.client.base.soap.exceptions.AccessExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "accessExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"),
                      "at.chipkarte.client.base.soap.exceptions.DialogExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "dialogExceptionContent"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("patientendatenAbfragen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "abfrageErgebnis"));
        oper.setReturnClass(at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"),
                      "at.chipkarte.client.base.soap.exceptions.AccessExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "accessExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"),
                      "at.chipkarte.client.base.soap.exceptions.DialogExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "dialogExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "SasException"),
                      "at.chipkarte.client.sas.soap.exceptions.SasExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "sasExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "InvalidParameterSuchkriterienException"),
                      "at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "invalidParameterSuchkriterienExceptionContent"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("svNummerAbfragen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummerAbfragenSuchkriterien"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "suchkriterien"), at.chipkarte.client.sas.soap.Suchkriterien.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "abfrageErgebnis"));
        oper.setReturnClass(at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"),
                      "at.chipkarte.client.base.soap.exceptions.AccessExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "accessExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"),
                      "at.chipkarte.client.base.soap.exceptions.DialogExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "dialogExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "SasException"),
                      "at.chipkarte.client.sas.soap.exceptions.SasExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "sasExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "InvalidParameterSuchkriterienException"),
                      "at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "invalidParameterSuchkriterienExceptionContent"), 
                      true
                     ));
        _operations[3] = oper;

    }

    public Sas_12BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Sas_12BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Sas_12BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "accessExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.AccessExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "baseExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.BaseExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "dialogExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.DialogExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "invalidParameterSuchkriterienExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "sasExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.exceptions.SasExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "property");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Property.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "abfrageErgebnis");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.AbfrageErgebnis.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "adressdaten");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.Adressdaten.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "suchkriterien");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.Suchkriterien.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public at.chipkarte.client.sas.soap.Adressdaten adressdatenAbfragen(java.lang.String dialogId, java.lang.String svNummer) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.sas.soap.exceptions.SasExceptionContent, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "adressdatenAbfragen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, svNummer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.sas.soap.Adressdaten) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.sas.soap.Adressdaten) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.sas.soap.Adressdaten.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.SasExceptionContent) {
              throw (at.chipkarte.client.sas.soap.exceptions.SasExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent) {
              throw (at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "checkStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.Property[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.Property[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.Property[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.sas.soap.AbfrageErgebnis patientendatenAbfragen(java.lang.String dialogId, java.lang.String svNummer) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.sas.soap.exceptions.SasExceptionContent, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "patientendatenAbfragen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, svNummer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.SasExceptionContent) {
              throw (at.chipkarte.client.sas.soap.exceptions.SasExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent) {
              throw (at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.sas.soap.AbfrageErgebnis svNummerAbfragen(java.lang.String dialogId, at.chipkarte.client.sas.soap.Suchkriterien svNummerAbfragenSuchkriterien) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessExceptionContent, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.sas.soap.exceptions.SasExceptionContent, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummerAbfragen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, svNummerAbfragenSuchkriterien});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.SasExceptionContent) {
              throw (at.chipkarte.client.sas.soap.exceptions.SasExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent) {
              throw (at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
