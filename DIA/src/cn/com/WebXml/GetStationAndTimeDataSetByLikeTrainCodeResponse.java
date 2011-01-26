/**
 * GetStationAndTimeDataSetByLikeTrainCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class GetStationAndTimeDataSetByLikeTrainCodeResponse  implements java.io.Serializable {
    private cn.com.WebXml.GetStationAndTimeDataSetByLikeTrainCodeResponseGetStationAndTimeDataSetByLikeTrainCodeResult getStationAndTimeDataSetByLikeTrainCodeResult;

    public GetStationAndTimeDataSetByLikeTrainCodeResponse() {
    }

    public GetStationAndTimeDataSetByLikeTrainCodeResponse(
           cn.com.WebXml.GetStationAndTimeDataSetByLikeTrainCodeResponseGetStationAndTimeDataSetByLikeTrainCodeResult getStationAndTimeDataSetByLikeTrainCodeResult) {
           this.getStationAndTimeDataSetByLikeTrainCodeResult = getStationAndTimeDataSetByLikeTrainCodeResult;
    }


    /**
     * Gets the getStationAndTimeDataSetByLikeTrainCodeResult value for this GetStationAndTimeDataSetByLikeTrainCodeResponse.
     * 
     * @return getStationAndTimeDataSetByLikeTrainCodeResult
     */
    public cn.com.WebXml.GetStationAndTimeDataSetByLikeTrainCodeResponseGetStationAndTimeDataSetByLikeTrainCodeResult getGetStationAndTimeDataSetByLikeTrainCodeResult() {
        return getStationAndTimeDataSetByLikeTrainCodeResult;
    }


    /**
     * Sets the getStationAndTimeDataSetByLikeTrainCodeResult value for this GetStationAndTimeDataSetByLikeTrainCodeResponse.
     * 
     * @param getStationAndTimeDataSetByLikeTrainCodeResult
     */
    public void setGetStationAndTimeDataSetByLikeTrainCodeResult(cn.com.WebXml.GetStationAndTimeDataSetByLikeTrainCodeResponseGetStationAndTimeDataSetByLikeTrainCodeResult getStationAndTimeDataSetByLikeTrainCodeResult) {
        this.getStationAndTimeDataSetByLikeTrainCodeResult = getStationAndTimeDataSetByLikeTrainCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStationAndTimeDataSetByLikeTrainCodeResponse)) return false;
        GetStationAndTimeDataSetByLikeTrainCodeResponse other = (GetStationAndTimeDataSetByLikeTrainCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getStationAndTimeDataSetByLikeTrainCodeResult==null && other.getGetStationAndTimeDataSetByLikeTrainCodeResult()==null) || 
             (this.getStationAndTimeDataSetByLikeTrainCodeResult!=null &&
              this.getStationAndTimeDataSetByLikeTrainCodeResult.equals(other.getGetStationAndTimeDataSetByLikeTrainCodeResult())));
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
        if (getGetStationAndTimeDataSetByLikeTrainCodeResult() != null) {
            _hashCode += getGetStationAndTimeDataSetByLikeTrainCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStationAndTimeDataSetByLikeTrainCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">getStationAndTimeDataSetByLikeTrainCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getStationAndTimeDataSetByLikeTrainCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "getStationAndTimeDataSetByLikeTrainCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">>getStationAndTimeDataSetByLikeTrainCodeResponse>getStationAndTimeDataSetByLikeTrainCodeResult"));
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
