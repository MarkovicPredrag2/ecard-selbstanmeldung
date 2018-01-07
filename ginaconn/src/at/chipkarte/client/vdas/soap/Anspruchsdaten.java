/**
 * Anspruchsdaten.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.vdas.soap;

public class Anspruchsdaten  implements java.io.Serializable {
    private at.chipkarte.client.base.soap.SvPersonV2 abgeleiteteDaten;

    private java.lang.String anspruchsart;

    private java.lang.Boolean kostenanteilbefreit;

    private java.lang.Boolean rezeptgebbefreit;

    private java.lang.String svtCode;

    private java.lang.String versichertenKategorie;

    private java.lang.String versichertenartCode;

    public Anspruchsdaten() {
    }

    public Anspruchsdaten(
           at.chipkarte.client.base.soap.SvPersonV2 abgeleiteteDaten,
           java.lang.String anspruchsart,
           java.lang.Boolean kostenanteilbefreit,
           java.lang.Boolean rezeptgebbefreit,
           java.lang.String svtCode,
           java.lang.String versichertenKategorie,
           java.lang.String versichertenartCode) {
           this.abgeleiteteDaten = abgeleiteteDaten;
           this.anspruchsart = anspruchsart;
           this.kostenanteilbefreit = kostenanteilbefreit;
           this.rezeptgebbefreit = rezeptgebbefreit;
           this.svtCode = svtCode;
           this.versichertenKategorie = versichertenKategorie;
           this.versichertenartCode = versichertenartCode;
    }


    /**
     * Gets the abgeleiteteDaten value for this Anspruchsdaten.
     * 
     * @return abgeleiteteDaten
     */
    public at.chipkarte.client.base.soap.SvPersonV2 getAbgeleiteteDaten() {
        return abgeleiteteDaten;
    }


    /**
     * Sets the abgeleiteteDaten value for this Anspruchsdaten.
     * 
     * @param abgeleiteteDaten
     */
    public void setAbgeleiteteDaten(at.chipkarte.client.base.soap.SvPersonV2 abgeleiteteDaten) {
        this.abgeleiteteDaten = abgeleiteteDaten;
    }


    /**
     * Gets the anspruchsart value for this Anspruchsdaten.
     * 
     * @return anspruchsart
     */
    public java.lang.String getAnspruchsart() {
        return anspruchsart;
    }


    /**
     * Sets the anspruchsart value for this Anspruchsdaten.
     * 
     * @param anspruchsart
     */
    public void setAnspruchsart(java.lang.String anspruchsart) {
        this.anspruchsart = anspruchsart;
    }


    /**
     * Gets the kostenanteilbefreit value for this Anspruchsdaten.
     * 
     * @return kostenanteilbefreit
     */
    public java.lang.Boolean getKostenanteilbefreit() {
        return kostenanteilbefreit;
    }


    /**
     * Sets the kostenanteilbefreit value for this Anspruchsdaten.
     * 
     * @param kostenanteilbefreit
     */
    public void setKostenanteilbefreit(java.lang.Boolean kostenanteilbefreit) {
        this.kostenanteilbefreit = kostenanteilbefreit;
    }


    /**
     * Gets the rezeptgebbefreit value for this Anspruchsdaten.
     * 
     * @return rezeptgebbefreit
     */
    public java.lang.Boolean getRezeptgebbefreit() {
        return rezeptgebbefreit;
    }


    /**
     * Sets the rezeptgebbefreit value for this Anspruchsdaten.
     * 
     * @param rezeptgebbefreit
     */
    public void setRezeptgebbefreit(java.lang.Boolean rezeptgebbefreit) {
        this.rezeptgebbefreit = rezeptgebbefreit;
    }


    /**
     * Gets the svtCode value for this Anspruchsdaten.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this Anspruchsdaten.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }


    /**
     * Gets the versichertenKategorie value for this Anspruchsdaten.
     * 
     * @return versichertenKategorie
     */
    public java.lang.String getVersichertenKategorie() {
        return versichertenKategorie;
    }


    /**
     * Sets the versichertenKategorie value for this Anspruchsdaten.
     * 
     * @param versichertenKategorie
     */
    public void setVersichertenKategorie(java.lang.String versichertenKategorie) {
        this.versichertenKategorie = versichertenKategorie;
    }


    /**
     * Gets the versichertenartCode value for this Anspruchsdaten.
     * 
     * @return versichertenartCode
     */
    public java.lang.String getVersichertenartCode() {
        return versichertenartCode;
    }


    /**
     * Sets the versichertenartCode value for this Anspruchsdaten.
     * 
     * @param versichertenartCode
     */
    public void setVersichertenartCode(java.lang.String versichertenartCode) {
        this.versichertenartCode = versichertenartCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Anspruchsdaten)) return false;
        Anspruchsdaten other = (Anspruchsdaten) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abgeleiteteDaten==null && other.getAbgeleiteteDaten()==null) || 
             (this.abgeleiteteDaten!=null &&
              this.abgeleiteteDaten.equals(other.getAbgeleiteteDaten()))) &&
            ((this.anspruchsart==null && other.getAnspruchsart()==null) || 
             (this.anspruchsart!=null &&
              this.anspruchsart.equals(other.getAnspruchsart()))) &&
            ((this.kostenanteilbefreit==null && other.getKostenanteilbefreit()==null) || 
             (this.kostenanteilbefreit!=null &&
              this.kostenanteilbefreit.equals(other.getKostenanteilbefreit()))) &&
            ((this.rezeptgebbefreit==null && other.getRezeptgebbefreit()==null) || 
             (this.rezeptgebbefreit!=null &&
              this.rezeptgebbefreit.equals(other.getRezeptgebbefreit()))) &&
            ((this.svtCode==null && other.getSvtCode()==null) || 
             (this.svtCode!=null &&
              this.svtCode.equals(other.getSvtCode()))) &&
            ((this.versichertenKategorie==null && other.getVersichertenKategorie()==null) || 
             (this.versichertenKategorie!=null &&
              this.versichertenKategorie.equals(other.getVersichertenKategorie()))) &&
            ((this.versichertenartCode==null && other.getVersichertenartCode()==null) || 
             (this.versichertenartCode!=null &&
              this.versichertenartCode.equals(other.getVersichertenartCode())));
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
        if (getAbgeleiteteDaten() != null) {
            _hashCode += getAbgeleiteteDaten().hashCode();
        }
        if (getAnspruchsart() != null) {
            _hashCode += getAnspruchsart().hashCode();
        }
        if (getKostenanteilbefreit() != null) {
            _hashCode += getKostenanteilbefreit().hashCode();
        }
        if (getRezeptgebbefreit() != null) {
            _hashCode += getRezeptgebbefreit().hashCode();
        }
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        if (getVersichertenKategorie() != null) {
            _hashCode += getVersichertenKategorie().hashCode();
        }
        if (getVersichertenartCode() != null) {
            _hashCode += getVersichertenartCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Anspruchsdaten.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "anspruchsdaten"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abgeleiteteDaten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "abgeleiteteDaten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "svPersonV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anspruchsart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "anspruchsart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kostenanteilbefreit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "kostenanteilbefreit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rezeptgebbefreit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "rezeptgebbefreit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versichertenKategorie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertenKategorie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versichertenartCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.vdas.client.chipkarte.at", "versichertenartCode"));
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
