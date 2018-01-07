/**
 * VersichertendatenAbfrage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.vdas.soap;

public class VersichertendatenAbfrage  implements java.io.Serializable {
    private java.lang.String abteilungsFunktionsCode;

    private java.lang.String cin;

    private java.lang.Boolean forceExecution;

    private java.lang.String svNummer;

    private java.lang.String svNummerAbgeleitet;

    private java.lang.String svtCode;

    public VersichertendatenAbfrage() {
    }

    public VersichertendatenAbfrage(
           java.lang.String abteilungsFunktionsCode,
           java.lang.String cin,
           java.lang.Boolean forceExecution,
           java.lang.String svNummer,
           java.lang.String svNummerAbgeleitet,
           java.lang.String svtCode) {
           this.abteilungsFunktionsCode = abteilungsFunktionsCode;
           this.cin = cin;
           this.forceExecution = forceExecution;
           this.svNummer = svNummer;
           this.svNummerAbgeleitet = svNummerAbgeleitet;
           this.svtCode = svtCode;
    }


    /**
     * Gets the abteilungsFunktionsCode value for this VersichertendatenAbfrage.
     * 
     * @return abteilungsFunktionsCode
     */
    public java.lang.String getAbteilungsFunktionsCode() {
        return abteilungsFunktionsCode;
    }


    /**
     * Sets the abteilungsFunktionsCode value for this VersichertendatenAbfrage.
     * 
     * @param abteilungsFunktionsCode
     */
    public void setAbteilungsFunktionsCode(java.lang.String abteilungsFunktionsCode) {
        this.abteilungsFunktionsCode = abteilungsFunktionsCode;
    }


    /**
     * Gets the cin value for this VersichertendatenAbfrage.
     * 
     * @return cin
     */
    public java.lang.String getCin() {
        return cin;
    }


    /**
     * Sets the cin value for this VersichertendatenAbfrage.
     * 
     * @param cin
     */
    public void setCin(java.lang.String cin) {
        this.cin = cin;
    }


    /**
     * Gets the forceExecution value for this VersichertendatenAbfrage.
     * 
     * @return forceExecution
     */
    public java.lang.Boolean getForceExecution() {
        return forceExecution;
    }


    /**
     * Sets the forceExecution value for this VersichertendatenAbfrage.
     * 
     * @param forceExecution
     */
    public void setForceExecution(java.lang.Boolean forceExecution) {
        this.forceExecution = forceExecution;
    }


    /**
     * Gets the svNummer value for this VersichertendatenAbfrage.
     * 
     * @return svNummer
     */
    public java.lang.String getSvNummer() {
        return svNummer;
    }


    /**
     * Sets the svNummer value for this VersichertendatenAbfrage.
     * 
     * @param svNummer
     */
    public void setSvNummer(java.lang.String svNummer) {
        this.svNummer = svNummer;
    }


    /**
     * Gets the svNummerAbgeleitet value for this VersichertendatenAbfrage.
     * 
     * @return svNummerAbgeleitet
     */
    public java.lang.String getSvNummerAbgeleitet() {
        return svNummerAbgeleitet;
    }


    /**
     * Sets the svNummerAbgeleitet value for this VersichertendatenAbfrage.
     * 
     * @param svNummerAbgeleitet
     */
    public void setSvNummerAbgeleitet(java.lang.String svNummerAbgeleitet) {
        this.svNummerAbgeleitet = svNummerAbgeleitet;
    }


    /**
     * Gets the svtCode value for this VersichertendatenAbfrage.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this VersichertendatenAbfrage.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VersichertendatenAbfrage)) return false;
        VersichertendatenAbfrage other = (VersichertendatenAbfrage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abteilungsFunktionsCode==null && other.getAbteilungsFunktionsCode()==null) || 
             (this.abteilungsFunktionsCode!=null &&
              this.abteilungsFunktionsCode.equals(other.getAbteilungsFunktionsCode()))) &&
            ((this.cin==null && other.getCin()==null) || 
             (this.cin!=null &&
              this.cin.equals(other.getCin()))) &&
            ((this.forceExecution==null && other.getForceExecution()==null) || 
             (this.forceExecution!=null &&
              this.forceExecution.equals(other.getForceExecution()))) &&
            ((this.svNummer==null && other.getSvNummer()==null) || 
             (this.svNummer!=null &&
              this.svNummer.equals(other.getSvNummer()))) &&
            ((this.svNummerAbgeleitet==null && other.getSvNummerAbgeleitet()==null) || 
             (this.svNummerAbgeleitet!=null &&
              this.svNummerAbgeleitet.equals(other.getSvNummerAbgeleitet()))) &&
            ((this.svtCode==null && other.getSvtCode()==null) || 
             (this.svtCode!=null &&
              this.svtCode.equals(other.getSvtCode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAbteilungsFunktionsCode() != null) {
            _hashCode += getAbteilungsFunktionsCode().hashCode();
        }
        if (getCin() != null) {
            _hashCode += getCin().hashCode();
        }
        if (getForceExecution() != null) {
            _hashCode += getForceExecution().hashCode();
        }
        if (getSvNummer() != null) {
            _hashCode += getSvNummer().hashCode();
        }
        if (getSvNummerAbgeleitet() != null) {
            _hashCode += getSvNummerAbgeleitet().hashCode();
        }
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VersichertendatenAbfrage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertendatenAbfrage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abteilungsFunktionsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "abteilungsFunktionsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "cin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forceExecution");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "forceExecution"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "svNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svNummerAbgeleitet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "svNummerAbgeleitet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "svtCode"));
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
