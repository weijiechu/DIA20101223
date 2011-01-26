/**
 * TrainTimeWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public interface TrainTimeWebService extends javax.xml.rpc.Service {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>火车时刻表 WEB 服务</strong>提供：站站查询；车次查询；车站所有车次查询。本火车时刻表 WEB 服务提供的列车时刻表数据仅供参考，如有异议以当地铁路部门颁布为准。</br>此火车时刻表Web
 * Services请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
 * target="_blank">联系我们</a>，欢迎技术交流。 QQ：8409035<br /><strong>使用本站 WEB
 * 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><br />&nbsp;
 */
    public java.lang.String getTrainTimeWebServiceSoap12Address();

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap12() throws javax.xml.rpc.ServiceException;

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getTrainTimeWebServiceSoapAddress();

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public cn.com.WebXml.TrainTimeWebServiceSoap getTrainTimeWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
