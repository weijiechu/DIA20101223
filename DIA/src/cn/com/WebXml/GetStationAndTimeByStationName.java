/**
 * GetStationAndTimeByStationName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class GetStationAndTimeByStationName  implements java.io.Serializable {
    private java.lang.String startStation;

    private java.lang.String arriveStation;

    private java.lang.String userID;

    public GetStationAndTimeByStationName() {
    }

    public GetStationAndTimeByStationName(
           java.lang.String startStation,
           java.lang.String arriveStation,
           java.lang.String userID) {
           this.startStation = startStation;
           this.arriveStation = arriveStation;
           this.userID = userID;
    }


    /**
     * Gets the startStation value for this GetStationAndTimeByStationName.
     * 
     * @return startStation
     */
    public java.lang.String getStartStation() {
        return startStation;
    }


    /**
     * Sets the startStation value for this GetStationAndTimeByStationName.
     * 
     * @param startStation
     */
    public void setStartStation(java.lang.String startStation) {
        this.startStation = startStation;
    }


    /**
     * Gets the arriveStation value for this GetStationAndTimeByStationName.
     * 
     * @return arriveStation
     */
    public java.lang.String getArriveStation() {
        return arriveStation;
    }


    /**
     * Sets the arriveStation value for this GetStationAndTimeByStationName.
     * 
     * @param arriveStation
     */
    public void setArriveStation(java.lang.String arriveStation) {
        this.arriveStation = arriveStation;
    }


    /**
     * Gets the userID value for this GetStationAndTimeByStationName.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this GetStationAndTimeByStationName.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStationAndTimeByStationName)) return false;
        GetStationAndTimeByStationName other = (GetStationAndTimeByStationName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.startStation==null && other.getStartStation()==null) || 
             (this.startStation!=null &&
              this.startStation.equals(other.getStartStation()))) &&
            ((this.arriveStation==null && other.getArriveStation()==null) || 
             (this.arriveStation!=null &&
              this.arriveStation.equals(other.getArriveStation()))) &&
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
        if (getStartStation() != null) {
            _hashCode += getStartStation().hashCode();
        }
        if (getArriveStation() != null) {
            _hashCode += getArriveStation().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStationAndTimeByStationName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">getStationAndTimeByStationName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startStation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "StartStation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arriveStation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "ArriveStation"));
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
