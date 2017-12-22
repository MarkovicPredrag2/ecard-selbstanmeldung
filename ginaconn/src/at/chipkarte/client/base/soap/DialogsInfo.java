/**
 * DialogsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class DialogsInfo  implements java.io.Serializable {
    private java.lang.Integer currentDialogsCount;

    private java.lang.Integer maxDialogsCount;

    public DialogsInfo() {
    }

    public DialogsInfo(
           java.lang.Integer currentDialogsCount,
           java.lang.Integer maxDialogsCount) {
           this.currentDialogsCount = currentDialogsCount;
           this.maxDialogsCount = maxDialogsCount;
    }


    /**
     * Gets the currentDialogsCount value for this DialogsInfo.
     * 
     * @return currentDialogsCount
     */
    public java.lang.Integer getCurrentDialogsCount() {
        return currentDialogsCount;
    }


    /**
     * Sets the currentDialogsCount value for this DialogsInfo.
     * 
     * @param currentDialogsCount
     */
    public void setCurrentDialogsCount(java.lang.Integer currentDialogsCount) {
        this.currentDialogsCount = currentDialogsCount;
    }


    /**
     * Gets the maxDialogsCount value for this DialogsInfo.
     * 
     * @return maxDialogsCount
     */
    public java.lang.Integer getMaxDialogsCount() {
        return maxDialogsCount;
    }


    /**
     * Sets the maxDialogsCount value for this DialogsInfo.
     * 
     * @param maxDialogsCount
     */
    public void setMaxDialogsCount(java.lang.Integer maxDialogsCount) {
        this.maxDialogsCount = maxDialogsCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DialogsInfo)) return false;
        DialogsInfo other = (DialogsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.currentDialogsCount==null && other.getCurrentDialogsCount()==null) || 
             (this.currentDialogsCount!=null &&
              this.currentDialogsCount.equals(other.getCurrentDialogsCount()))) &&
            ((this.maxDialogsCount==null && other.getMaxDialogsCount()==null) || 
             (this.maxDialogsCount!=null &&
              this.maxDialogsCount.equals(other.getMaxDialogsCount())));
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
        if (getCurrentDialogsCount() != null) {
            _hashCode += getCurrentDialogsCount().hashCode();
        }
        if (getMaxDialogsCount() != null) {
            _hashCode += getMaxDialogsCount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DialogsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dialogsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentDialogsCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "currentDialogsCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxDialogsCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "maxDialogsCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
