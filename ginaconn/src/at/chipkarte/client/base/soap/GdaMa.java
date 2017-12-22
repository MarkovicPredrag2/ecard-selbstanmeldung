/**
 * GdaMa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class GdaMa  implements java.io.Serializable {
    private java.lang.String nachname;

    private java.lang.String titelHinten;

    private java.lang.String titelVorne;

    private java.lang.String vorname;

    private java.lang.String zusatzinfo;

    public GdaMa() {
    }

    public GdaMa(
           java.lang.String nachname,
           java.lang.String titelHinten,
           java.lang.String titelVorne,
           java.lang.String vorname,
           java.lang.String zusatzinfo) {
           this.nachname = nachname;
           this.titelHinten = titelHinten;
           this.titelVorne = titelVorne;
           this.vorname = vorname;
           this.zusatzinfo = zusatzinfo;
    }


    /**
     * Gets the nachname value for this GdaMa.
     * 
     * @return nachname
     */
    public java.lang.String getNachname() {
        return nachname;
    }


    /**
     * Sets the nachname value for this GdaMa.
     * 
     * @param nachname
     */
    public void setNachname(java.lang.String nachname) {
        this.nachname = nachname;
    }


    /**
     * Gets the titelHinten value for this GdaMa.
     * 
     * @return titelHinten
     */
    public java.lang.String getTitelHinten() {
        return titelHinten;
    }


    /**
     * Sets the titelHinten value for this GdaMa.
     * 
     * @param titelHinten
     */
    public void setTitelHinten(java.lang.String titelHinten) {
        this.titelHinten = titelHinten;
    }


    /**
     * Gets the titelVorne value for this GdaMa.
     * 
     * @return titelVorne
     */
    public java.lang.String getTitelVorne() {
        return titelVorne;
    }


    /**
     * Sets the titelVorne value for this GdaMa.
     * 
     * @param titelVorne
     */
    public void setTitelVorne(java.lang.String titelVorne) {
        this.titelVorne = titelVorne;
    }


    /**
     * Gets the vorname value for this GdaMa.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this GdaMa.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }


    /**
     * Gets the zusatzinfo value for this GdaMa.
     * 
     * @return zusatzinfo
     */
    public java.lang.String getZusatzinfo() {
        return zusatzinfo;
    }


    /**
     * Sets the zusatzinfo value for this GdaMa.
     * 
     * @param zusatzinfo
     */
    public void setZusatzinfo(java.lang.String zusatzinfo) {
        this.zusatzinfo = zusatzinfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GdaMa)) return false;
        GdaMa other = (GdaMa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nachname==null && other.getNachname()==null) || 
             (this.nachname!=null &&
              this.nachname.equals(other.getNachname()))) &&
            ((this.titelHinten==null && other.getTitelHinten()==null) || 
             (this.titelHinten!=null &&
              this.titelHinten.equals(other.getTitelHinten()))) &&
            ((this.titelVorne==null && other.getTitelVorne()==null) || 
             (this.titelVorne!=null &&
              this.titelVorne.equals(other.getTitelVorne()))) &&
            ((this.vorname==null && other.getVorname()==null) || 
             (this.vorname!=null &&
              this.vorname.equals(other.getVorname()))) &&
            ((this.zusatzinfo==null && other.getZusatzinfo()==null) || 
             (this.zusatzinfo!=null &&
              this.zusatzinfo.equals(other.getZusatzinfo())));
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
        if (getNachname() != null) {
            _hashCode += getNachname().hashCode();
        }
        if (getTitelHinten() != null) {
            _hashCode += getTitelHinten().hashCode();
        }
        if (getTitelVorne() != null) {
            _hashCode += getTitelVorne().hashCode();
        }
        if (getVorname() != null) {
            _hashCode += getVorname().hashCode();
        }
        if (getZusatzinfo() != null) {
            _hashCode += getZusatzinfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GdaMa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "gdaMa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nachname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "nachname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titelHinten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titelHinten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titelVorne");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titelVorne"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vorname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zusatzinfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "zusatzinfo"));
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
