/**
 * Base_15BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class Base_15BindingStub extends org.apache.axis.client.Stub implements at.chipkarte.client.base.soap.IBaseService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[29];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("authenticateDialog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragspartnerV2"));
        oper.setReturnClass(at.chipkarte.client.base.soap.VertragspartnerV2.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("authenticateDialogEnt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragspartnerV2"));
        oper.setReturnClass(at.chipkarte.client.base.soap.VertragspartnerV2.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        oper.setName("changePin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "oldPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "newPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("changePinWithPuk");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "puk"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "newPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "property"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Property[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("closeDialog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDialog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "produktInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "produktInfo"), at.chipkarte.client.base.soap.ProduktInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "extUID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "pushMessageEnabled"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDialogEnt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "produktInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "produktInfo"), at.chipkarte.client.base.soap.ProduktInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "extUID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vpNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "pushMessageEnabled"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doCardTest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBerechtigungen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCardData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "card"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Card.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCardReaders");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReader"));
        oper.setReturnClass(at.chipkarte.client.base.soap.CardReader[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExtendedCardData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "CIN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "property"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Property[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFachgebiete");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "baseProperty"));
        oper.setReturnClass(at.chipkarte.client.base.soap.BaseProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFachgebieteByOrdId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "taetigkeitsBereichId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "baseProperty"));
        oper.setReturnClass(at.chipkarte.client.base.soap.BaseProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFreeDialogs");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogsInfo"));
        oper.setReturnClass(at.chipkarte.client.base.soap.DialogsInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGinaAndServiceavailabilityInformation");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "statusInformationen"));
        oper.setReturnClass(at.chipkarte.client.base.soap.StatusInformationen.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGinaSoftwareVersion");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ginaVersion"));
        oper.setReturnClass(at.chipkarte.client.base.soap.GinaVersion.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMessages");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "newOnly"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "message"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Message[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMinMsgPollingIntervall");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReaderStatusEvents");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "handle"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "timeOut"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "readerStatusResult"));
        oper.setReturnClass(at.chipkarte.client.base.soap.ReaderStatusResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSVTs");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "svtProperty"));
        oper.setReturnClass(at.chipkarte.client.base.soap.SvtProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getStaaten");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "baseProperty"));
        oper.setReturnClass(at.chipkarte.client.base.soap.BaseProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getVertraege");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragsDaten"));
        oper.setReturnClass(at.chipkarte.client.base.soap.VertragsDaten[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("pollMessages");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "suchzeitpunkt"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "messagePollResult"));
        oper.setReturnClass(at.chipkarte.client.base.soap.MessagePollResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("releaseCardReader");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "serviceExceptionContent"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setCardReader");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"),
                      "at.chipkarte.client.base.soap.exceptions.CardExceptionContent",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setDialogAddress");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordinationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "taetigkeitsBereichId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "elgaRolle"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "gdaMa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "gdaMa"), at.chipkarte.client.base.soap.GdaMa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "prozess"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uebersiedelnOrdination");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordinationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "forceUebersiedlung"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
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
        _operations[28] = oper;

    }

    public Base_15BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Base_15BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Base_15BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "baseExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.BaseExceptionContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "cardExceptionContent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.CardExceptionContent.class;
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

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "authenticationStatus");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.AuthenticationStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "baseProperty");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.BaseProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "card");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Card.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReader");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.CardReader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogsInfo");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.DialogsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "gdaMa");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.GdaMa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ginaInfo");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.GinaInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ginaVersion");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.GinaVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "message");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Message.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "messagePollResult");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.MessagePollResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordination");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Ordination.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "produktInfo");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.ProduktInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "property");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Property.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "readerStatusEvent");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.ReaderStatusEvent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "readerStatusResult");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.ReaderStatusResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "serviceStatusInformation");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.ServiceStatusInformation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "statusInformationen");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.StatusInformationen.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "svtProperty");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.SvtProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "taetigkeitsBereich");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.TaetigkeitsBereich.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragsDaten");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.VertragsDaten.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragspartnerV2");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.VertragspartnerV2.class;
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

    public at.chipkarte.client.base.soap.VertragspartnerV2 authenticateDialog(java.lang.String dialogId, java.lang.String cin, java.lang.String pin, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "authenticateDialog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, cin, pin, cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.VertragspartnerV2) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.VertragspartnerV2) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.VertragspartnerV2.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.VertragspartnerV2 authenticateDialogEnt(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "authenticateDialogEnt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.VertragspartnerV2) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.VertragspartnerV2) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.VertragspartnerV2.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public void changePin(java.lang.String cardReaderId, java.lang.String cin, java.lang.String oldPin, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "changePin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId, cin, oldPin, newPin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void changePinWithPuk(java.lang.String cardReaderId, java.lang.String cin, java.lang.String puk, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "changePinWithPuk"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId, cin, puk, newPin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "checkStatus"));

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

    public void closeDialog(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "closeDialog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public java.lang.String createDialog(java.lang.String cardReaderId, at.chipkarte.client.base.soap.ProduktInfo produktInfo, java.lang.String extUID, java.lang.Boolean pushMessageEnabled) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "createDialog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId, produktInfo, extUID, pushMessageEnabled});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String createDialogEnt(java.lang.String cardReaderId, at.chipkarte.client.base.soap.ProduktInfo produktInfo, java.lang.String extUID, java.lang.String vpNummer, java.lang.Boolean pushMessageEnabled) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "createDialogEnt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId, produktInfo, extUID, vpNummer, pushMessageEnabled});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer doCardTest(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "doCardTest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getBerechtigungen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getBerechtigungen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public at.chipkarte.client.base.soap.Card getCardData(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getCardData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.Card) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.Card) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.Card.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.CardReader[] getCardReaders() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getCardReaders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.CardReader[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.CardReader[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.CardReader[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.Property[] getExtendedCardData(java.lang.String cardReaderId, java.lang.String CIN) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getExtendedCardData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId, CIN});

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
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.BaseProperty[] getFachgebiete() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getFachgebiete"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.BaseProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.BaseProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.BaseProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.BaseProperty[] getFachgebieteByOrdId(java.lang.String dialogId, java.lang.String ordId, java.lang.String taetigkeitsBereichId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getFachgebieteByOrdId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, ordId, taetigkeitsBereichId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.BaseProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.BaseProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.BaseProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public at.chipkarte.client.base.soap.DialogsInfo getFreeDialogs() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getFreeDialogs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.DialogsInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.DialogsInfo) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.DialogsInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.StatusInformationen getGinaAndServiceavailabilityInformation() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getGinaAndServiceavailabilityInformation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.StatusInformationen) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.StatusInformationen) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.StatusInformationen.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.GinaVersion getGinaSoftwareVersion() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getGinaSoftwareVersion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.GinaVersion) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.GinaVersion) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.GinaVersion.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.Message[] getMessages(java.lang.String dialogId, java.lang.Boolean newOnly) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getMessages"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, newOnly});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.Message[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.Message[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.Message[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public java.lang.Integer getMinMsgPollingIntervall(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getMinMsgPollingIntervall"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public at.chipkarte.client.base.soap.ReaderStatusResult getReaderStatusEvents(java.lang.String handle, java.lang.String[] cardReaderId, java.lang.Integer timeOut) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getReaderStatusEvents"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {handle, cardReaderId, timeOut});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.ReaderStatusResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.ReaderStatusResult) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.ReaderStatusResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.SvtProperty[] getSVTs() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getSVTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.SvtProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.SvtProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.SvtProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.BaseProperty[] getStaaten() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getStaaten"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.BaseProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.BaseProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.BaseProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.VertragsDaten[] getVertraege(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "getVertraege"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.VertragsDaten[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.VertragsDaten[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.VertragsDaten[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public at.chipkarte.client.base.soap.MessagePollResult pollMessages(java.lang.String dialogId, java.lang.String suchzeitpunkt) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "pollMessages"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, suchzeitpunkt});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.MessagePollResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.MessagePollResult) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.MessagePollResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public void releaseCardReader(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "releaseCardReader"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void setCardReader(java.lang.String dialogId, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent, at.chipkarte.client.base.soap.exceptions.CardExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "setCardReader"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogExceptionContent) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardExceptionContent) {
              throw (at.chipkarte.client.base.soap.exceptions.CardExceptionContent) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void setDialogAddress(java.lang.String dialogId, java.lang.String ordinationId, java.lang.String taetigkeitsBereichId, java.lang.String elgaRolle, at.chipkarte.client.base.soap.GdaMa gdaMa, java.lang.String prozess) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "setDialogAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, ordinationId, taetigkeitsBereichId, elgaRolle, gdaMa, prozess});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

    public void uebersiedelnOrdination(java.lang.String dialogId, java.lang.String ordinationId, java.lang.Boolean forceUebersiedlung) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceExceptionContent, at.chipkarte.client.base.soap.exceptions.DialogExceptionContent {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "uebersiedelnOrdination"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, ordinationId, forceUebersiedlung});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
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

}
