/**
 * Adressdaten.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class Adressdaten  implements java.io.Serializable {
    private java.lang.String abgabestelle;

    private java.lang.String anschriftszusatz;

    private java.lang.String hausnummer;

    private java.lang.String ort;

    private java.lang.String plz;

    private java.lang.String postfachNummer;

    private java.lang.String postfachText;

    private java.lang.String staatscode;

    private java.lang.String stockTuerNummer;

    private java.lang.String strasse;

    public Adressdaten() {
    }

    public Adressdaten(
           java.lang.String abgabestelle,
           java.lang.String anschriftszusatz,
           java.lang.String hausnummer,
           java.lang.String ort,
           java.lang.String plz,
           java.lang.String postfachNummer,
           java.lang.String postfachText,
           java.lang.String staatscode,
           java.lang.String stockTuerNummer,
           java.lang.String strasse) {
           this.abgabestelle = abgabestelle;
           this.anschriftszusatz = anschriftszusatz;
           this.hausnummer = hausnummer;
           this.ort = ort;
           this.plz = plz;
           this.postfachNummer = postfachNummer;
           this.postfachText = postfachText;
           this.staatscode = staatscode;
           this.stockTuerNummer = stockTuerNummer;
           this.strasse = strasse;
    }


    /**
     * Gets the abgabestelle value for this Adressdaten.
     * 
     * @return abgabestelle
     */
    public java.lang.String getAbgabestelle() {
        return abgabestelle;
    }


    /**
     * Sets the abgabestelle value for this Adressdaten.
     * 
     * @param abgabestelle
     */
    public void setAbgabestelle(java.lang.String abgabestelle) {
        this.abgabestelle = abgabestelle;
    }


    /**
     * Gets the anschriftszusatz value for this Adressdaten.
     * 
     * @return anschriftszusatz
     */
    public java.lang.String getAnschriftszusatz() {
        return anschriftszusatz;
    }


    /**
     * Sets the anschriftszusatz value for this Adressdaten.
     * 
     * @param anschriftszusatz
     */
    public void setAnschriftszusatz(java.lang.String anschriftszusatz) {
        this.anschriftszusatz = anschriftszusatz;
    }


    /**
     * Gets the hausnummer value for this Adressdaten.
     * 
     * @return hausnummer
     */
    public java.lang.String getHausnummer() {
        return hausnummer;
    }


    /**
     * Sets the hausnummer value for this Adressdaten.
     * 
     * @param hausnummer
     */
    public void setHausnummer(java.lang.String hausnummer) {
        this.hausnummer = hausnummer;
    }


    /**
     * Gets the ort value for this Adressdaten.
     * 
     * @return ort
     */
    public java.lang.String getOrt() {
        return ort;
    }


    /**
     * Sets the ort value for this Adressdaten.
     * 
     * @param ort
     */
    public void setOrt(java.lang.String ort) {
        this.ort = ort;
    }


    /**
     * Gets the plz value for this Adressdaten.
     * 
     * @return plz
     */
    public java.lang.String getPlz() {
        return plz;
    }


    /**
     * Sets the plz value for this Adressdaten.
     * 
     * @param plz
     */
    public void setPlz(java.lang.String plz) {
        this.plz = plz;
    }


    /**
     * Gets the postfachNummer value for this Adressdaten.
     * 
     * @return postfachNummer
     */
    public java.lang.String getPostfachNummer() {
        return postfachNummer;
    }


    /**
     * Sets the postfachNummer value for this Adressdaten.
     * 
     * @param postfachNummer
     */
    public void setPostfachNummer(java.lang.String postfachNummer) {
        this.postfachNummer = postfachNummer;
    }


    /**
     * Gets the postfachText value for this Adressdaten.
     * 
     * @return postfachText
     */
    public java.lang.String getPostfachText() {
        return postfachText;
    }


    /**
     * Sets the postfachText value for this Adressdaten.
     * 
     * @param postfachText
     */
    public void setPostfachText(java.lang.String postfachText) {
        this.postfachText = postfachText;
    }


    /**
     * Gets the staatscode value for this Adressdaten.
     * 
     * @return staatscode
     */
    public java.lang.String getStaatscode() {
        return staatscode;
    }


    /**
     * Sets the staatscode value for this Adressdaten.
     * 
     * @param staatscode
     */
    public void setStaatscode(java.lang.String staatscode) {
        this.staatscode = staatscode;
    }


    /**
     * Gets the stockTuerNummer value for this Adressdaten.
     * 
     * @return stockTuerNummer
     */
    public java.lang.String getStockTuerNummer() {
        return stockTuerNummer;
    }


    /**
     * Sets the stockTuerNummer value for this Adressdaten.
     * 
     * @param stockTuerNummer
     */
    public void setStockTuerNummer(java.lang.String stockTuerNummer) {
        this.stockTuerNummer = stockTuerNummer;
    }


    /**
     * Gets the strasse value for this Adressdaten.
     * 
     * @return strasse
     */
    public java.lang.String getStrasse() {
        return strasse;
    }


    /**
     * Sets the strasse value for this Adressdaten.
     * 
     * @param strasse
     */
    public void setStrasse(java.lang.String strasse) {
        this.strasse = strasse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Adressdaten)) return false;
        Adressdaten other = (Adressdaten) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abgabestelle==null && other.getAbgabestelle()==null) || 
             (this.abgabestelle!=null &&
              this.abgabestelle.equals(other.getAbgabestelle()))) &&
            ((this.anschriftszusatz==null && other.getAnschriftszusatz()==null) || 
             (this.anschriftszusatz!=null &&
              this.anschriftszusatz.equals(other.getAnschriftszusatz()))) &&
            ((this.hausnummer==null && other.getHausnummer()==null) || 
             (this.hausnummer!=null &&
              this.hausnummer.equals(other.getHausnummer()))) &&
            ((this.ort==null && other.getOrt()==null) || 
             (this.ort!=null &&
              this.ort.equals(other.getOrt()))) &&
            ((this.plz==null && other.getPlz()==null) || 
             (this.plz!=null &&
              this.plz.equals(other.getPlz()))) &&
            ((this.postfachNummer==null && other.getPostfachNummer()==null) || 
             (this.postfachNummer!=null &&
              this.postfachNummer.equals(other.getPostfachNummer()))) &&
            ((this.postfachText==null && other.getPostfachText()==null) || 
             (this.postfachText!=null &&
              this.postfachText.equals(other.getPostfachText()))) &&
            ((this.staatscode==null && other.getStaatscode()==null) || 
             (this.staatscode!=null &&
              this.staatscode.equals(other.getStaatscode()))) &&
            ((this.stockTuerNummer==null && other.getStockTuerNummer()==null) || 
             (this.stockTuerNummer!=null &&
              this.stockTuerNummer.equals(other.getStockTuerNummer()))) &&
            ((this.strasse==null && other.getStrasse()==null) || 
             (this.strasse!=null &&
              this.strasse.equals(other.getStrasse())));
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
        if (getAbgabestelle() != null) {
            _hashCode += getAbgabestelle().hashCode();
        }
        if (getAnschriftszusatz() != null) {
            _hashCode += getAnschriftszusatz().hashCode();
        }
        if (getHausnummer() != null) {
            _hashCode += getHausnummer().hashCode();
        }
        if (getOrt() != null) {
            _hashCode += getOrt().hashCode();
        }
        if (getPlz() != null) {
            _hashCode += getPlz().hashCode();
        }
        if (getPostfachNummer() != null) {
            _hashCode += getPostfachNummer().hashCode();
        }
        if (getPostfachText() != null) {
            _hashCode += getPostfachText().hashCode();
        }
        if (getStaatscode() != null) {
            _hashCode += getStaatscode().hashCode();
        }
        if (getStockTuerNummer() != null) {
            _hashCode += getStockTuerNummer().hashCode();
        }
        if (getStrasse() != null) {
            _hashCode += getStrasse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Adressdaten.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "adressdaten"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abgabestelle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "abgabestelle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anschriftszusatz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "anschriftszusatz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hausnummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "hausnummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ort");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "ort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "plz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postfachNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "postfachNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postfachText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "postfachText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staatscode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "staatscode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockTuerNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "stockTuerNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strasse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "strasse"));
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
