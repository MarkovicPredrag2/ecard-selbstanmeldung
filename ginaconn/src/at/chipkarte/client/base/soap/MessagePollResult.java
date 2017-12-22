/**
 * MessagePollResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class MessagePollResult  implements java.io.Serializable {
    private at.chipkarte.client.base.soap.Message[] nachrichten;

    private java.lang.Boolean nachrichtenVerfuegbar;

    private java.lang.String naechsterSuchzeitpunkt;

    public MessagePollResult() {
    }

    public MessagePollResult(
           at.chipkarte.client.base.soap.Message[] nachrichten,
           java.lang.Boolean nachrichtenVerfuegbar,
           java.lang.String naechsterSuchzeitpunkt) {
           this.nachrichten = nachrichten;
           this.nachrichtenVerfuegbar = nachrichtenVerfuegbar;
           this.naechsterSuchzeitpunkt = naechsterSuchzeitpunkt;
    }


    /**
     * Gets the nachrichten value for this MessagePollResult.
     * 
     * @return nachrichten
     */
    public at.chipkarte.client.base.soap.Message[] getNachrichten() {
        return nachrichten;
    }


    /**
     * Sets the nachrichten value for this MessagePollResult.
     * 
     * @param nachrichten
     */
    public void setNachrichten(at.chipkarte.client.base.soap.Message[] nachrichten) {
        this.nachrichten = nachrichten;
    }

    public at.chipkarte.client.base.soap.Message getNachrichten(int i) {
        return this.nachrichten[i];
    }

    public void setNachrichten(int i, at.chipkarte.client.base.soap.Message _value) {
        this.nachrichten[i] = _value;
    }


    /**
     * Gets the nachrichtenVerfuegbar value for this MessagePollResult.
     * 
     * @return nachrichtenVerfuegbar
     */
    public java.lang.Boolean getNachrichtenVerfuegbar() {
        return nachrichtenVerfuegbar;
    }


    /**
     * Sets the nachrichtenVerfuegbar value for this MessagePollResult.
     * 
     * @param nachrichtenVerfuegbar
     */
    public void setNachrichtenVerfuegbar(java.lang.Boolean nachrichtenVerfuegbar) {
        this.nachrichtenVerfuegbar = nachrichtenVerfuegbar;
    }


    /**
     * Gets the naechsterSuchzeitpunkt value for this MessagePollResult.
     * 
     * @return naechsterSuchzeitpunkt
     */
    public java.lang.String getNaechsterSuchzeitpunkt() {
        return naechsterSuchzeitpunkt;
    }


    /**
     * Sets the naechsterSuchzeitpunkt value for this MessagePollResult.
     * 
     * @param naechsterSuchzeitpunkt
     */
    public void setNaechsterSuchzeitpunkt(java.lang.String naechsterSuchzeitpunkt) {
        this.naechsterSuchzeitpunkt = naechsterSuchzeitpunkt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessagePollResult)) return false;
        MessagePollResult other = (MessagePollResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nachrichten==null && other.getNachrichten()==null) || 
             (this.nachrichten!=null &&
              java.util.Arrays.equals(this.nachrichten, other.getNachrichten()))) &&
            ((this.nachrichtenVerfuegbar==null && other.getNachrichtenVerfuegbar()==null) || 
             (this.nachrichtenVerfuegbar!=null &&
              this.nachrichtenVerfuegbar.equals(other.getNachrichtenVerfuegbar()))) &&
            ((this.naechsterSuchzeitpunkt==null && other.getNaechsterSuchzeitpunkt()==null) || 
             (this.naechsterSuchzeitpunkt!=null &&
              this.naechsterSuchzeitpunkt.equals(other.getNaechsterSuchzeitpunkt())));
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
        if (getNachrichten() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNachrichten());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNachrichten(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNachrichtenVerfuegbar() != null) {
            _hashCode += getNachrichtenVerfuegbar().hashCode();
        }
        if (getNaechsterSuchzeitpunkt() != null) {
            _hashCode += getNaechsterSuchzeitpunkt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MessagePollResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "messagePollResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nachrichten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "nachrichten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "message"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nachrichtenVerfuegbar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "nachrichtenVerfuegbar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naechsterSuchzeitpunkt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "naechsterSuchzeitpunkt"));
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
