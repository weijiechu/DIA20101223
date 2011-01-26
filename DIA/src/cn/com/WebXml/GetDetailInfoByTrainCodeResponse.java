/**
 * GetDetailInfoByTrainCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class GetDetailInfoByTrainCodeResponse  implements java.io.Serializable {
    private cn.com.WebXml.GetDetailInfoByTrainCodeResponseGetDetailInfoByTrainCodeResult getDetailInfoByTrainCodeResult;

    public GetDetailInfoByTrainCodeResponse() {
    }

    public GetDetailInfoByTrainCodeResponse(
           cn.com.WebXml.GetDetailInfoByTrainCodeResponseGetDetailInfoByTrainCodeResult getDetailInfoByTrainCodeResult) {
           this.getDetailInfoByTrainCodeResult = getDetailInfoByTrainCodeResult;
    }


    /**
     * Gets the getDetailInfoByTrainCodeResult value for this GetDetailInfoByTrainCodeResponse.
     * 
     * @return getDetailInfoByTrainCodeResult
     */
    public cn.com.WebXml.GetDetailInfoByTrainCodeResponseGetDetailInfoByTrainCodeResult getGetDetailInfoByTrainCodeResult() {
        return getDetailInfoByTrainCodeResult;
    }


    /**
     * Sets the getDetailInfoByTrainCodeResult value for this GetDetailInfoByTrainCodeResponse.
     * 
     * @param getDetailInfoByTrainCodeResult
     */
    public void setGetDetailInfoByTrainCodeResult(cn.com.WebXml.GetDetailInfoByTrainCodeResponseGetDetailInfoByTrainCodeResult getDetailInfoByTrainCodeResult) {
        this.getDetailInfoByTrainCodeResult = getDetailInfoByTrainCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDetailInfoByTrainCodeResponse)) return false;
        GetDetailInfoByTrainCodeResponse other = (GetDetailInfoByTrainCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDetailInfoByTrainCodeResult==null && other.getGetDetailInfoByTrainCodeResult()==null) || 
             (this.getDetailInfoByTrainCodeResult!=null &&
              this.getDetailInfoByTrainCodeResult.equals(other.getGetDetailInfoByTrainCodeResult())));
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
        if (getGetDetailInfoByTrainCodeResult() != null) {
            _hashCode += getGetDetailInfoByTrainCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDetailInfoByTrainCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">getDetailInfoByTrainCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDetailInfoByTrainCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "getDetailInfoByTrainCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">>getDetailInfoByTrainCodeResponse>getDetailInfoByTrainCodeResult"));
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
