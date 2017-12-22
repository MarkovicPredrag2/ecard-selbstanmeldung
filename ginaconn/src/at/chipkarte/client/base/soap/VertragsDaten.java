/**
 * VertragsDaten.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class VertragsDaten  implements java.io.Serializable {
    private java.lang.String bezBereich;

    private java.lang.String fachGebietsCode;

    private java.lang.Boolean konsultationsrecht;

    private java.lang.String leistungsSVT;

    private java.lang.String ordId;

    private java.lang.Boolean rezepturrecht;

    private java.lang.String verrechnungsSVT;

    private java.lang.String taetigkeitsBereichId;

    private java.lang.String vertragsTyp;

    public VertragsDaten() {
    }

    public VertragsDaten(
           java.lang.String bezBereich,
           java.lang.String fachGebietsCode,
           java.lang.Boolean konsultationsrecht,
           java.lang.String leistungsSVT,
           java.lang.String ordId,
           java.lang.Boolean rezepturrecht,
           java.lang.String verrechnungsSVT,
           java.lang.String taetigkeitsBereichId,
           java.lang.String vertragsTyp) {
           this.bezBereich = bezBereich;
           this.fachGebietsCode = fachGebietsCode;
           this.konsultationsrecht = konsultationsrecht;
           this.leistungsSVT = leistungsSVT;
           this.ordId = ordId;
           this.rezepturrecht = rezepturrecht;
           this.verrechnungsSVT = verrechnungsSVT;
           this.taetigkeitsBereichId = taetigkeitsBereichId;
           this.vertragsTyp = vertragsTyp;
    }


    /**
     * Gets the bezBereich value for this VertragsDaten.
     * 
     * @return bezBereich
     */
    public java.lang.String getBezBereich() {
        return bezBereich;
    }


    /**
     * Sets the bezBereich value for this VertragsDaten.
     * 
     * @param bezBereich
     */
    public void setBezBereich(java.lang.String bezBereich) {
        this.bezBereich = bezBereich;
    }


    /**
     * Gets the fachGebietsCode value for this VertragsDaten.
     * 
     * @return fachGebietsCode
     */
    public java.lang.String getFachGebietsCode() {
        return fachGebietsCode;
    }


    /**
     * Sets the fachGebietsCode value for this VertragsDaten.
     * 
     * @param fachGebietsCode
     */
    public void setFachGebietsCode(java.lang.String fachGebietsCode) {
        this.fachGebietsCode = fachGebietsCode;
    }


    /**
     * Gets the konsultationsrecht value for this VertragsDaten.
     * 
     * @return konsultationsrecht
     */
    public java.lang.Boolean getKonsultationsrecht() {
        return konsultationsrecht;
    }


    /**
     * Sets the konsultationsrecht value for this VertragsDaten.
     * 
     * @param konsultationsrecht
     */
    public void setKonsultationsrecht(java.lang.Boolean konsultationsrecht) {
        this.konsultationsrecht = konsultationsrecht;
    }


    /**
     * Gets the leistungsSVT value for this VertragsDaten.
     * 
     * @return leistungsSVT
     */
    public java.lang.String getLeistungsSVT() {
        return leistungsSVT;
    }


    /**
     * Sets the leistungsSVT value for this VertragsDaten.
     * 
     * @param leistungsSVT
     */
    public void setLeistungsSVT(java.lang.String leistungsSVT) {
        this.leistungsSVT = leistungsSVT;
    }


    /**
     * Gets the ordId value for this VertragsDaten.
     * 
     * @return ordId
     */
    public java.lang.String getOrdId() {
        return ordId;
    }


    /**
     * Sets the ordId value for this VertragsDaten.
     * 
     * @param ordId
     */
    public void setOrdId(java.lang.String ordId) {
        this.ordId = ordId;
    }


    /**
     * Gets the rezepturrecht value for this VertragsDaten.
     * 
     * @return rezepturrecht
     */
    public java.lang.Boolean getRezepturrecht() {
        return rezepturrecht;
    }


    /**
     * Sets the rezepturrecht value for this VertragsDaten.
     * 
     * @param rezepturrecht
     */
    public void setRezepturrecht(java.lang.Boolean rezepturrecht) {
        this.rezepturrecht = rezepturrecht;
    }


    /**
     * Gets the verrechnungsSVT value for this VertragsDaten.
     * 
     * @return verrechnungsSVT
     */
    public java.lang.String getVerrechnungsSVT() {
        return verrechnungsSVT;
    }


    /**
     * Sets the verrechnungsSVT value for this VertragsDaten.
     * 
     * @param verrechnungsSVT
     */
    public void setVerrechnungsSVT(java.lang.String verrechnungsSVT) {
        this.verrechnungsSVT = verrechnungsSVT;
    }


    /**
     * Gets the taetigkeitsBereichId value for this VertragsDaten.
     * 
     * @return taetigkeitsBereichId
     */
    public java.lang.String getTaetigkeitsBereichId() {
        return taetigkeitsBereichId;
    }


    /**
     * Sets the taetigkeitsBereichId value for this VertragsDaten.
     * 
     * @param taetigkeitsBereichId
     */
    public void setTaetigkeitsBereichId(java.lang.String taetigkeitsBereichId) {
        this.taetigkeitsBereichId = taetigkeitsBereichId;
    }


    /**
     * Gets the vertragsTyp value for this VertragsDaten.
     * 
     * @return vertragsTyp
     */
    public java.lang.String getVertragsTyp() {
        return vertragsTyp;
    }


    /**
     * Sets the vertragsTyp value for this VertragsDaten.
     * 
     * @param vertragsTyp
     */
    public void setVertragsTyp(java.lang.String vertragsTyp) {
        this.vertragsTyp = vertragsTyp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VertragsDaten)) return false;
        VertragsDaten other = (VertragsDaten) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bezBereich==null && other.getBezBereich()==null) || 
             (this.bezBereich!=null &&
              this.bezBereich.equals(other.getBezBereich()))) &&
            ((this.fachGebietsCode==null && other.getFachGebietsCode()==null) || 
             (this.fachGebietsCode!=null &&
              this.fachGebietsCode.equals(other.getFachGebietsCode()))) &&
            ((this.konsultationsrecht==null && other.getKonsultationsrecht()==null) || 
             (this.konsultationsrecht!=null &&
              this.konsultationsrecht.equals(other.getKonsultationsrecht()))) &&
            ((this.leistungsSVT==null && other.getLeistungsSVT()==null) || 
             (this.leistungsSVT!=null &&
              this.leistungsSVT.equals(other.getLeistungsSVT()))) &&
            ((this.ordId==null && other.getOrdId()==null) || 
             (this.ordId!=null &&
              this.ordId.equals(other.getOrdId()))) &&
            ((this.rezepturrecht==null && other.getRezepturrecht()==null) || 
             (this.rezepturrecht!=null &&
              this.rezepturrecht.equals(other.getRezepturrecht()))) &&
            ((this.verrechnungsSVT==null && other.getVerrechnungsSVT()==null) || 
             (this.verrechnungsSVT!=null &&
              this.verrechnungsSVT.equals(other.getVerrechnungsSVT()))) &&
            ((this.taetigkeitsBereichId==null && other.getTaetigkeitsBereichId()==null) || 
             (this.taetigkeitsBereichId!=null &&
              this.taetigkeitsBereichId.equals(other.getTaetigkeitsBereichId()))) &&
            ((this.vertragsTyp==null && other.getVertragsTyp()==null) || 
             (this.vertragsTyp!=null &&
              this.vertragsTyp.equals(other.getVertragsTyp())));
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
        if (getBezBereich() != null) {
            _hashCode += getBezBereich().hashCode();
        }
        if (getFachGebietsCode() != null) {
            _hashCode += getFachGebietsCode().hashCode();
        }
        if (getKonsultationsrecht() != null) {
            _hashCode += getKonsultationsrecht().hashCode();
        }
        if (getLeistungsSVT() != null) {
            _hashCode += getLeistungsSVT().hashCode();
        }
        if (getOrdId() != null) {
            _hashCode += getOrdId().hashCode();
        }
        if (getRezepturrecht() != null) {
            _hashCode += getRezepturrecht().hashCode();
        }
        if (getVerrechnungsSVT() != null) {
            _hashCode += getVerrechnungsSVT().hashCode();
        }
        if (getTaetigkeitsBereichId() != null) {
            _hashCode += getTaetigkeitsBereichId().hashCode();
        }
        if (getVertragsTyp() != null) {
            _hashCode += getVertragsTyp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VertragsDaten.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragsDaten"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bezBereich");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "bezBereich"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fachGebietsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "fachGebietsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("konsultationsrecht");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "konsultationsrecht"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leistungsSVT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "leistungsSVT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rezepturrecht");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "rezepturrecht"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verrechnungsSVT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "verrechnungsSVT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taetigkeitsBereichId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "taetigkeitsBereichId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vertragsTyp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vertragsTyp"));
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
