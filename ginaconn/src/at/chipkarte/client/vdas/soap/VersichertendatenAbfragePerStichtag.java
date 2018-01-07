/**
 * VersichertendatenAbfragePerStichtag.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.vdas.soap;

public class VersichertendatenAbfragePerStichtag  extends at.chipkarte.client.vdas.soap.VersichertendatenAbfrage  implements java.io.Serializable {
    private java.lang.String stichtagsdatum;

    public VersichertendatenAbfragePerStichtag() {
    }

    public VersichertendatenAbfragePerStichtag(
           java.lang.String abteilungsFunktionsCode,
           java.lang.String cin,
           java.lang.Boolean forceExecution,
           java.lang.String svNummer,
           java.lang.String svNummerAbgeleitet,
           java.lang.String svtCode,
           java.lang.String stichtagsdatum) {
        super(
            abteilungsFunktionsCode,
            cin,
            forceExecution,
            svNummer,
            svNummerAbgeleitet,
            svtCode);
        this.stichtagsdatum = stichtagsdatum;
    }


    /**
     * Gets the stichtagsdatum value for this VersichertendatenAbfragePerStichtag.
     * 
     * @return stichtagsdatum
     */
    public java.lang.String getStichtagsdatum() {
        return stichtagsdatum;
    }


    /**
     * Sets the stichtagsdatum value for this VersichertendatenAbfragePerStichtag.
     * 
     * @param stichtagsdatum
     */
    public void setStichtagsdatum(java.lang.String stichtagsdatum) {
        this.stichtagsdatum = stichtagsdatum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VersichertendatenAbfragePerStichtag)) return false;
        VersichertendatenAbfragePerStichtag other = (VersichertendatenAbfragePerStichtag) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.stichtagsdatum==null && other.getStichtagsdatum()==null) || 
             (this.stichtagsdatum!=null &&
              this.stichtagsdatum.equals(other.getStichtagsdatum())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getStichtagsdatum() != null) {
            _hashCode += getStichtagsdatum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VersichertendatenAbfragePerStichtag.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertendatenAbfragePerStichtag"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stichtagsdatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "stichtagsdatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
