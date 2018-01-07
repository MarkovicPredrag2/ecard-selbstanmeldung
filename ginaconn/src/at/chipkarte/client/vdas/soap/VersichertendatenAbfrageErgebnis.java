/**
 * VersichertendatenAbfrageErgebnis.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.vdas.soap;

public class VersichertendatenAbfrageErgebnis  implements java.io.Serializable {
    private at.chipkarte.client.vdas.soap.Anspruchsdaten[] anspruchsDaten;

    private java.lang.String vdasId;

    private java.lang.Integer[] vdasMessageCodes;

    private at.chipkarte.client.vdas.soap.VersichertendatenSvPerson versichertenDaten;

    public VersichertendatenAbfrageErgebnis() {
    }

    public VersichertendatenAbfrageErgebnis(
           at.chipkarte.client.vdas.soap.Anspruchsdaten[] anspruchsDaten,
           java.lang.String vdasId,
           java.lang.Integer[] vdasMessageCodes,
           at.chipkarte.client.vdas.soap.VersichertendatenSvPerson versichertenDaten) {
           this.anspruchsDaten = anspruchsDaten;
           this.vdasId = vdasId;
           this.vdasMessageCodes = vdasMessageCodes;
           this.versichertenDaten = versichertenDaten;
    }


    /**
     * Gets the anspruchsDaten value for this VersichertendatenAbfrageErgebnis.
     * 
     * @return anspruchsDaten
     */
    public at.chipkarte.client.vdas.soap.Anspruchsdaten[] getAnspruchsDaten() {
        return anspruchsDaten;
    }


    /**
     * Sets the anspruchsDaten value for this VersichertendatenAbfrageErgebnis.
     * 
     * @param anspruchsDaten
     */
    public void setAnspruchsDaten(at.chipkarte.client.vdas.soap.Anspruchsdaten[] anspruchsDaten) {
        this.anspruchsDaten = anspruchsDaten;
    }

    public at.chipkarte.client.vdas.soap.Anspruchsdaten getAnspruchsDaten(int i) {
        return this.anspruchsDaten[i];
    }

    public void setAnspruchsDaten(int i, at.chipkarte.client.vdas.soap.Anspruchsdaten _value) {
        this.anspruchsDaten[i] = _value;
    }


    /**
     * Gets the vdasId value for this VersichertendatenAbfrageErgebnis.
     * 
     * @return vdasId
     */
    public java.lang.String getVdasId() {
        return vdasId;
    }


    /**
     * Sets the vdasId value for this VersichertendatenAbfrageErgebnis.
     * 
     * @param vdasId
     */
    public void setVdasId(java.lang.String vdasId) {
        this.vdasId = vdasId;
    }


    /**
     * Gets the vdasMessageCodes value for this VersichertendatenAbfrageErgebnis.
     * 
     * @return vdasMessageCodes
     */
    public java.lang.Integer[] getVdasMessageCodes() {
        return vdasMessageCodes;
    }


    /**
     * Sets the vdasMessageCodes value for this VersichertendatenAbfrageErgebnis.
     * 
     * @param vdasMessageCodes
     */
    public void setVdasMessageCodes(java.lang.Integer[] vdasMessageCodes) {
        this.vdasMessageCodes = vdasMessageCodes;
    }

    public java.lang.Integer getVdasMessageCodes(int i) {
        return this.vdasMessageCodes[i];
    }

    public void setVdasMessageCodes(int i, java.lang.Integer _value) {
        this.vdasMessageCodes[i] = _value;
    }


    /**
     * Gets the versichertenDaten value for this VersichertendatenAbfrageErgebnis.
     * 
     * @return versichertenDaten
     */
    public at.chipkarte.client.vdas.soap.VersichertendatenSvPerson getVersichertenDaten() {
        return versichertenDaten;
    }


    /**
     * Sets the versichertenDaten value for this VersichertendatenAbfrageErgebnis.
     * 
     * @param versichertenDaten
     */
    public void setVersichertenDaten(at.chipkarte.client.vdas.soap.VersichertendatenSvPerson versichertenDaten) {
        this.versichertenDaten = versichertenDaten;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VersichertendatenAbfrageErgebnis)) return false;
        VersichertendatenAbfrageErgebnis other = (VersichertendatenAbfrageErgebnis) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anspruchsDaten==null && other.getAnspruchsDaten()==null) || 
             (this.anspruchsDaten!=null &&
              java.util.Arrays.equals(this.anspruchsDaten, other.getAnspruchsDaten()))) &&
            ((this.vdasId==null && other.getVdasId()==null) || 
             (this.vdasId!=null &&
              this.vdasId.equals(other.getVdasId()))) &&
            ((this.vdasMessageCodes==null && other.getVdasMessageCodes()==null) || 
             (this.vdasMessageCodes!=null &&
              java.util.Arrays.equals(this.vdasMessageCodes, other.getVdasMessageCodes()))) &&
            ((this.versichertenDaten==null && other.getVersichertenDaten()==null) || 
             (this.versichertenDaten!=null &&
              this.versichertenDaten.equals(other.getVersichertenDaten())));
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
        if (getAnspruchsDaten() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnspruchsDaten());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnspruchsDaten(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVdasId() != null) {
            _hashCode += getVdasId().hashCode();
        }
        if (getVdasMessageCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVdasMessageCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVdasMessageCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVersichertenDaten() != null) {
            _hashCode += getVersichertenDaten().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VersichertendatenAbfrageErgebnis.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertendatenAbfrageErgebnis"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anspruchsDaten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "anspruchsDaten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "anspruchsdaten"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vdasId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "vdasId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vdasMessageCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "vdasMessageCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versichertenDaten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertenDaten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertendatenSvPerson"));
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
