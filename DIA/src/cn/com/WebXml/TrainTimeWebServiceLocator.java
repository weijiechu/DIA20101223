/**
 * TrainTimeWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class TrainTimeWebServiceLocator extends org.apache.axis.client.Service implements cn.com.WebXml.TrainTimeWebService {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>火车时刻表 WEB 服务</strong>提供：站站查询；车次查询；车站所有车次查询。本火车时刻表 WEB 服务提供的列车时刻表数据仅供参考，如有异议以当地铁路部门颁布为准。</br>此火车时刻表Web
 * Services请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
 * target="_blank">联系我们</a>，欢迎技术交流。 QQ：8409035<br /><strong>使用本站 WEB
 * 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><br />&nbsp;
 */

    public TrainTimeWebServiceLocator() {
    }


    public TrainTimeWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TrainTimeWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TrainTimeWebServiceSoap12
    private java.lang.String TrainTimeWebServiceSoap12_address = "http://webservice.webxml.com.cn/WebServices/TrainTimeWebService.asmx";

    public java.lang.String getTrainTimeWebServiceSoap12Address() {
        return TrainTimeWebServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TrainTimeWebServiceSoap12WSDDServiceName = "TrainTimeWebServiceSoap12";

    public java.lang.String getTrainTimeWebServiceSoap12WSDDServiceName() {
        return TrainTimeWebServiceSoap12WSDDServiceName;
    }

    public void setTrainTimeWebServiceSoap12WSDDServiceName(java.lang.String name) {
        TrainTimeWebServiceSoap12WSDDServiceName = name;
    }

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TrainTimeWebServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrainTimeWebServiceSoap12(endpoint);
    }

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.WebXml.TrainTimeWebServiceSoap12Stub _stub = new cn.com.WebXml.TrainTimeWebServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getTrainTimeWebServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrainTimeWebServiceSoap12EndpointAddress(java.lang.String address) {
        TrainTimeWebServiceSoap12_address = address;
    }


    // Use to get a proxy class for TrainTimeWebServiceSoap
    private java.lang.String TrainTimeWebServiceSoap_address = "http://webservice.webxml.com.cn/WebServices/TrainTimeWebService.asmx";

    public java.lang.String getTrainTimeWebServiceSoapAddress() {
        return TrainTimeWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TrainTimeWebServiceSoapWSDDServiceName = "TrainTimeWebServiceSoap";

    public java.lang.String getTrainTimeWebServiceSoapWSDDServiceName() {
        return TrainTimeWebServiceSoapWSDDServiceName;
    }

    public void setTrainTimeWebServiceSoapWSDDServiceName(java.lang.String name) {
        TrainTimeWebServiceSoapWSDDServiceName = name;
    }

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TrainTimeWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrainTimeWebServiceSoap(endpoint);
    }

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.WebXml.TrainTimeWebServiceSoapStub _stub = new cn.com.WebXml.TrainTimeWebServiceSoapStub(portAddress, this);
            _stub.setPortName(getTrainTimeWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrainTimeWebServiceSoapEndpointAddress(java.lang.String address) {
        TrainTimeWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.WebXml.TrainTimeWebServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.WebXml.TrainTimeWebServiceSoap12Stub _stub = new cn.com.WebXml.TrainTimeWebServiceSoap12Stub(new java.net.URL(TrainTimeWebServiceSoap12_address), this);
                _stub.setPortName(getTrainTimeWebServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (cn.com.WebXml.TrainTimeWebServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.WebXml.TrainTimeWebServiceSoapStub _stub = new cn.com.WebXml.TrainTimeWebServiceSoapStub(new java.net.URL(TrainTimeWebServiceSoap_address), this);
                _stub.setPortName(getTrainTimeWebServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TrainTimeWebServiceSoap12".equals(inputPortName)) {
            return getTrainTimeWebServiceSoap12();
        }
        else if ("TrainTimeWebServiceSoap".equals(inputPortName)) {
            return getTrainTimeWebServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebXml.com.cn/", "TrainTimeWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "TrainTimeWebServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "TrainTimeWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TrainTimeWebServiceSoap12".equals(portName)) {
            setTrainTimeWebServiceSoap12EndpointAddress(address);
        }
        else 
if ("TrainTimeWebServiceSoap".equals(portName)) {
            setTrainTimeWebServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
