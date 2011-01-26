/**
 * GetStationAndTimeDataSetByTrainCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class GetStationAndTimeDataSetByTrainCode  implements java.io.Serializable {
    private java.lang.String trainCode;

    private java.lang.String userID;

    public GetStationAndTimeDataSetByTrainCode() {
    }

    public GetStationAndTimeDataSetByTrainCode(
           java.lang.String trainCode,
           java.lang.String userID) {
           this.trainCode = trainCode;
           this.userID = userID;
    }


    /**
     * Gets the trainCode value for this GetStationAndTimeDataSetByTrainCode.
     * 
     * @return trainCode
     */
    public java.lang.String getTrainCode() {
        return trainCode;
    }


    /**
     * Sets the trainCode value for this GetStationAndTimeDataSetByTrainCode.
     * 
     * @param trainCode
     */
    public void setTrainCode(java.lang.String trainCode) {
        this.trainCode = trainCode;
    }


    /**
     * Gets the userID value for this GetStationAndTimeDataSetByTrainCode.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this GetStationAndTimeDataSetByTrainCode.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStationAndTimeDataSetByTrainCode)) return false;
        GetStationAndTimeDataSetByTrainCode other = (GetStationAndTimeDataSetByTrainCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.trainCode==null && other.getTrainCode()==null) || 
             (this.trainCode!=null &&
              this.trainCode.equals(other.getTrainCode()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID())));
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
        if (getTrainCode() != null) {
            _hashCode += getTrainCode().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStationAndTimeDataSetByTrainCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">getStationAndTimeDataSetByTrainCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trainCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "TrainCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "UserID"));
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
