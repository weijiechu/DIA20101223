/**
 * GetStationAndTimeByStationNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class GetStationAndTimeByStationNameResponse  implements java.io.Serializable {
    private cn.com.WebXml.GetStationAndTimeByStationNameResponseGetStationAndTimeByStationNameResult getStationAndTimeByStationNameResult;

    public GetStationAndTimeByStationNameResponse() {
    }

    public GetStationAndTimeByStationNameResponse(
           cn.com.WebXml.GetStationAndTimeByStationNameResponseGetStationAndTimeByStationNameResult getStationAndTimeByStationNameResult) {
           this.getStationAndTimeByStationNameResult = getStationAndTimeByStationNameResult;
    }


    /**
     * Gets the getStationAndTimeByStationNameResult value for this GetStationAndTimeByStationNameResponse.
     * 
     * @return getStationAndTimeByStationNameResult
     */
    public cn.com.WebXml.GetStationAndTimeByStationNameResponseGetStationAndTimeByStationNameResult getGetStationAndTimeByStationNameResult() {
        return getStationAndTimeByStationNameResult;
    }


    /**
     * Sets the getStationAndTimeByStationNameResult value for this GetStationAndTimeByStationNameResponse.
     * 
     * @param getStationAndTimeByStationNameResult
     */
    public void setGetStationAndTimeByStationNameResult(cn.com.WebXml.GetStationAndTimeByStationNameResponseGetStationAndTimeByStationNameResult getStationAndTimeByStationNameResult) {
        this.getStationAndTimeByStationNameResult = getStationAndTimeByStationNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStationAndTimeByStationNameResponse)) return false;
        GetStationAndTimeByStationNameResponse other = (GetStationAndTimeByStationNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getStationAndTimeByStationNameResult==null && other.getGetStationAndTimeByStationNameResult()==null) || 
             (this.getStationAndTimeByStationNameResult!=null &&
              this.getStationAndTimeByStationNameResult.equals(other.getGetStationAndTimeByStationNameResult())));
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
        if (getGetStationAndTimeByStationNameResult() != null) {
            _hashCode += getGetStationAndTimeByStationNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStationAndTimeByStationNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">getStationAndTimeByStationNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getStationAndTimeByStationNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "getStationAndTimeByStationNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">>getStationAndTimeByStationNameResponse>getStationAndTimeByStationNameResult"));
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
