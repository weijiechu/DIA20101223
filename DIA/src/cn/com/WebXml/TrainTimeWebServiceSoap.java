/**
 * TrainTimeWebServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public interface TrainTimeWebServiceSoap extends java.rmi.Remote {

    /**
     * <br /><h3>获得本火车时刻表Web Services支持的全部站台名称和拼音缩写 DataSet</h3><p>输入参数：无；返回数据：结构为
     * 站台名称、拼音缩写，按拼音缩写升序排列</p><br />
     */
    public cn.com.WebXml.GetStationNameDataSetResponseGetStationNameDataSetResult getStationNameDataSet() throws java.rmi.RemoteException;

    /**
     * <br /><h3>通过火车车次查询火车时刻表 String()</h3><p>输入参数：车次代号字符串，空字符串默认上海到北京D32次，UserID
     * = 商业用户ID（普通用户不需要）；返回数据：一个一维字符串数组 String(9)，String(0)=车次、String(1)=始发站、String(2)=终点站、String(3)=发车站、String(4)=发车时间、String(5)=到达站、String(6)=到达时间、String(7)=里程(KM)、String(8)=历时、String(9)=空字符串(备用)</p><br
     * />
     */
    public java.lang.String[] getStationAndTimeByTrainCode(java.lang.String trainCode, java.lang.String userID) throws java.rmi.RemoteException;

    /**
     * <br /><h3>获得本火车时刻表Web Services的数据库版本更新时间</h3><p>输入参数：无，输出参数
     * String</p><br />
     */
    public java.lang.String getVersionTime() throws java.rmi.RemoteException;

    /**
     * <br /><h3>通过火车车次查询本火车时刻表 DataSet</h3><p>输入参数：车次代号字符串，空字符串默认上海到北京D32次，UserID
     * = 商业用户ID（普通用户不需要）；返回数据：DataSet，Item.(TrainCode)=车次、Item.(FirstStation)=始发站、Item.(LastStation)=终点站、Item.(StartStation)=发车站、Item.(StartTime)=发车时间、Item.(ArriveStation)=到达站、Item.(ArriveTime)=到达时间、Item.(KM)=里程(KM)、Item.(UseDate)=历时</p><br
     * />
     */
    public cn.com.WebXml.GetStationAndTimeDataSetByTrainCodeResponseGetStationAndTimeDataSetByTrainCodeResult getStationAndTimeDataSetByTrainCode(java.lang.String trainCode, java.lang.String userID) throws java.rmi.RemoteException;

    /**
     * <br /><h3>通过火车车次查询本火车时刻表（支持模糊查询） DataSet</h3><p>输入参数：车次代号字符串（支持模糊查询），空字符串默认上海到北京D32次，UserID
     * = 商业用户ID（普通用户不需要）；返回数据：DataSet，Item.(TrainCode)=车次、Item.(FirstStation)=始发站、Item.(LastStation)=终点站、Item.(StartStation)=发车站、Item.(StartTime)=发车时间、Item.(ArriveStation)=到达站、Item.(ArriveTime)=到达时间、Item.(KM)=里程(KM)、Item.(UseDate)=历时</p><br
     * />
     */
    public cn.com.WebXml.GetStationAndTimeDataSetByLikeTrainCodeResponseGetStationAndTimeDataSetByLikeTrainCodeResult getStationAndTimeDataSetByLikeTrainCode(java.lang.String trainCode, java.lang.String userID) throws java.rmi.RemoteException;

    /**
     * <br /><h3>通过火车车次查询列车经由车站明细 DataSet</h3><p>输入参数：车次代号字符串，空字符串默认上海到北京D32次，UserID
     * = 商业用户ID（普通用户不需要）；返回数据：DataSet，Item.(TrainStation)=车站名称、Item.(ArriveTime)=到站时间、Item.(StartTime)=发车时间、Item.(KM)=里程(KM)</p><br
     * />
     */
    public cn.com.WebXml.GetDetailInfoByTrainCodeResponseGetDetailInfoByTrainCodeResult getDetailInfoByTrainCode(java.lang.String trainCode, java.lang.String userID) throws java.rmi.RemoteException;

    /**
     * <br /><h3>获得本火车时刻表Web Services的全部始发站名称</h3><p>输入参数：无，输出参数 String()</p><br
     * />
     */
    public java.lang.String[] getStationName() throws java.rmi.RemoteException;

    /**
     * <br /><h3>通过发车站和到达站查询火车时刻表 DataSet</h3><p>输入参数：StartStation
     * = 发车站，ArriveStation = 到达站（支持第一个字匹配模糊查询），空字符串默认发车站上海和到达站北京，UserID =
     * 商业用户ID（普通用户不需要）；返回数据：DataSet，Item.(TrainCode)=车次、Item.(FirstStation)=始发站、Item.(LastStation)=终点站、Item.(StartStation)=发车站、Item.(StartTime)=发车时间、Item.(ArriveStation)=到达站、Item.(ArriveTime)=到达时间、Item.(KM)=里程(KM)、Item.(UseDate)=历时</p><br
     * />
     */
    public cn.com.WebXml.GetStationAndTimeByStationNameResponseGetStationAndTimeByStationNameResult getStationAndTimeByStationName(java.lang.String startStation, java.lang.String arriveStation, java.lang.String userID) throws java.rmi.RemoteException;
}
