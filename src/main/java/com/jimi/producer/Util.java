package com.jimi.producer;

import com.jimi.mode.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Util {
    private static List<String> trackList = new ArrayList();
    private static List<String> stopList = new ArrayList();
    private static List<String> accList = new ArrayList();
    private static List<String> disList = new ArrayList();
    private static List<String> alarmList = new ArrayList();
    private static final long BASE = 800000000000000l;

    static {
        trackList.add("2019-01-29 23:46:102019-01-29 23:49:55107.42348440.746862内蒙古自治区巴彦淖尔市临河区曙光东街,巴彦淖尔临河站北526米107.42642740.758991内蒙古自治区巴彦淖尔市临河区新华东街,中国人民银行(巴彦淖尔中心支行)东北119米200722532.11TIMEOUT002019-01-30 00:00:000026000");
        trackList.add("2019-01-29 23:21:562019-01-29 23:59:56113.77052434.758678河南省郑州市金水区心怡路,郑州东站-进站口c3西南105米113.5972834.73198河南省郑州市中原区秦岭路307号,郑州市妇幼保健院秦岭路院区西北58米22529227935.59ACC002019-01-30 00:00:0000108000");
        trackList.add("2019-01-29 23:30:242019-01-29 23:49:58120.85814232.036282江苏省南通市崇川区北城大桥引道,五洲御锦城西南23米120.93008932.020618江苏省南通市崇川区通富北路,骏和棕榈湾西南95米10851117433.27TIMEOUT002019-01-30 00:00:0000110000");
        trackList.add("2019-01-29 23:55:392019-01-29 23:58:47106.61304929.7016重庆市渝北区凯歌路14-4号,工贸综合楼东南17米106.62382229.703756重庆市渝北区机场路,艾福汽车修理厂东南191米229318843.93ACC002019-01-30 00:00:000010000");
        trackList.add("2019-01-29 23:34:582019-01-29 23:49:58107.74165331.618424四川省达州市宣汉县迎宾路,毛坝站东118米107.7415231.618364四川省达州市宣汉县迎宾路,毛坝站东南106米238990.09TIMEOUT002019-01-30 00:00:00003000");
        trackList.add("2019-01-29 21:27:392019-01-29 23:49:58104.04301330.646158四川省成都市武侯区一环路西1段-132号-附24号,四川省骨科医院东南980米104.22749330.785982四川省成都市新都区先凉路,多实惠超市美泉分店西南111米50974853821.49TIMEOUT002019-01-30 00:00:0000630000");
        trackList.add("2019-01-29 23:52:092019-01-29 23:59:56115.47119136.870953河北省邢台市临西县S311,国泰·温泉城(东门)西40米115.45493336.877591河北省邢台市临西县平安路,北蔡辛庄村南183米201846715.56ACC002019-01-30 00:00:000023000");
        trackList.add("2019-01-29 23:28:032019-01-29 23:59:58112.47375134.690158河南省洛阳市老城区治安南街12号,洛阳市红星消防器材修配厂西北83米112.47363634.690044河南省洛阳市瀍河回族区环城北路34号,正安园南72米4919150.09TIME002019-01-30 00:00:00003000");
        trackList.add("2019-01-29 23:45:042019-01-29 23:49:58112.505637.870884山西省太原市万柏林区漪汾街96号,大唐世家惠泽苑东南38米112.50440937.866436山西省太原市万柏林区瓦窑街,金域阅山北157米110829313.61TIMEOUT002019-01-30 00:00:000025000");
        trackList.add("2019-01-29 23:54:412019-01-29 23:59:57100.44308421.959684云南省西双版纳傣族自治州勐海县嘎海路,温馨窗帘东南63米100.45150221.955387云南省西双版纳傣族自治州勐海县沿河路78号,勐海县检察院南148米337431538.56ACC002019-01-30 00:00:000024000");


        stopList.add("2019-01-30 22:56:192019-01-30 23:59:573818104.99407125.515624贵州省黔西南布依族苗族自治州普安县S313,新世纪大酒店西77米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 22:19:402019-01-30 23:59:586018120.51531630.593204浙江省嘉兴市桐乡市G320(二环东路),新兴桥东50米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 08:12:472019-01-30 23:59:5756830114.69399136.443564河北省邯郸市成安县瑞华路,成安县成安镇东街张民生卫生室西南92米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 19:00:282019-01-30 23:59:5717968112.42270234.40368河南省洛阳市伊川县新鹏北路,伊川华美家居建材城西南511米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 23:39:172019-01-30 23:59:581241104.03805330.710718四川省成都市金牛区交大路221号-附14号,锦西花园西南40米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 23:35:372019-01-30 23:59:571460104.2898429.657018四川省内江市威远县X087,兄弟饭店江湖火锅西北21米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 23:46:462019-01-30 23:59:57791113.85051635.356396河南省新乡市牧野区S229(环宇大道),金摇篮实验幼儿园(西门)西南105米1TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 23:44:092019-01-30 23:59:58949125.89395647.182236黑龙江省绥化市明水县政府路205号,劳动保障大厦东47米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 23:46:462019-01-30 23:59:57791113.85051635.356396河南省新乡市牧野区S229(环宇大道),金摇篮实验幼儿园(西门)西南105米0TIME2019-01-31 00:00:000NULL");
        stopList.add("2019-01-30 21:31:222019-01-30 23:59:578915117.27428431.805331安徽省合肥市包河区潜口路,淝南家园东南266米0TIME2019-01-31 00:00:000NULL");

        accList.add("02019-01-24 00:00:212019-02-03 23:59:5895037700HB2019-02-04 00:00:00");
        accList.add("02019-02-03 23:55:112019-02-03 23:59:5828700HB2019-02-04 00:00:00");
        accList.add("02019-02-02 23:59:592019-02-03 23:59:588639900HB2019-02-04 00:00:00");
        accList.add("02019-02-03 00:00:012019-02-03 23:59:588639700HB2019-02-04 00:00:00");
        accList.add("02019-02-03 23:49:102019-02-03 23:59:5864800HB2019-02-04 00:00:00");
        accList.add("12019-02-03 23:28:482019-02-03 23:59:58187000HB2019-02-04 00:00:00");
        accList.add("12019-02-03 23:59:562019-02-03 23:59:58200HB2019-02-04 00:00:00");
        accList.add("02019-02-03 23:59:512019-02-03 23:59:58700HB2019-02-04 00:00:00");
        accList.add("02019-02-01 00:00:032019-02-03 23:59:5825919500HB2019-02-04 00:00:00");
        accList.add("12019-02-03 23:54:472019-02-03 23:59:5831100HB2019-02-04 00:00:00");

        disList.add("2019-01-30 11:30:0015915.3446242004942019-01-30 11:31:162019-01-30 11:03:432019-01-30 11:29:53");
        disList.add("2019-01-30 11:30:0077.512759742383342019-01-30 11:31:162019-01-30 11:09:292019-01-30 11:19:57");
        disList.add("2019-01-30 11:30:0039449.0853910243242019-01-30 11:31:162019-01-30 11:00:042019-01-30 11:29:54");
        disList.add("2019-01-30 11:30:005563.562863731932019-01-30 11:31:162019-01-30 11:00:042019-01-30 11:29:51");
        disList.add("2019-01-30 11:30:006653.8669930708822019-01-30 11:31:162019-01-30 11:00:262019-01-30 11:29:50");
        disList.add("2019-01-30 11:30:007476.3288545428332019-01-30 11:31:162019-01-30 11:18:362019-01-30 11:29:38");
        disList.add("2019-01-30 11:30:005284.3966352646312019-01-30 11:31:162019-01-30 11:00:072019-01-30 11:08:51");
        disList.add("2019-01-30 11:30:001354.69970605411252019-01-30 11:31:162019-01-30 11:26:122019-01-30 11:29:58");
        disList.add("2019-01-30 11:30:003359.56604791766952019-01-30 11:31:172019-01-30 11:16:522019-01-30 11:29:42");
        disList.add("2019-01-30 11:30:00251.550019745948822019-01-30 11:31:172019-01-30 11:28:322019-01-30 11:29:59");

        alarmList.add("stayAlert2019-01-29 23:45:01NULL46.795862134.0115382019-01-30 00:00:00NULLDEVICENULLNULLNULLNULL");
        alarmList.add("192NULLNULL22.003378106.6964872019-01-30 20:32:36NULLDEVICENULLNULLNULLNULL");
        alarmList.add("stayAlert2019-01-29 00:00:00NULL27.876416113.1414762019-01-30 00:00:00NULLDEVICENULLNULLNULLNULL");
        alarmList.add("19NULLNULL27.302881303087513116.84126511924992019-01-30 20:32:36NULLDEVICENULLNULLNULLNULL");
        alarmList.add("stayAlert2019-01-29 23:49:58NULL30.290198120.2372712019-01-30 00:00:00NULLDEVICENULLNULLNULLNULL");
        alarmList.add("3NULLNULL39.868658116.4548362019-01-30 20:32:33NULLDEVICENULLNULLNULLNULL");
        alarmList.add("offline2019-01-29 20:04:59NULLNULLNULL2019-01-30 00:00:002019-01-29 23:50:01DEVICENULLNULLNULLNULL");
        alarmList.add("NULLNULLNULLNULLNULL2019-01-30 20:32:37NULLICCID89860419151790255699460043907405697NULLNULL");
        alarmList.add("NULLNULLNULLNULLNULL2019-01-30 00:00:00NULLICCID89860429161870542051460044936402051NULLNULL");
        alarmList.add("192NULLNULL24.051083109.4084632019-01-30 20:32:36NULLDEVICENULLNULLNULLNULL");


    }

    public static List<String> getGpsHis(){
        List<String> list = new ArrayList<>();
        list.add("{'imei':'358735074177667','gps_time':'2019-08-06 03:53:31','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:53:31','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':6.44,'latitude':23.727173,'login_times':'2019-08-06 03:57:01','longitude':90.415573,'pos_method':'TIMEOUT','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'358735073643982','gps_time':'2019-08-06 03:48:55','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:48:55','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':22.01,'latitude':0.317266,'login_times':'2019-08-06 03:59:25','longitude':32.593933,'pos_method':'ACC','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'353701092141122','gps_time':'2019-08-06 03:58:36','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:58:36','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':3.54,'latitude':1.749229,'login_times':'2019-08-06 04:00:01','longitude':100.930338,'pos_method':'ACC','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'353701094005077','gps_time':'2019-08-06 03:58:50','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:58:50','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':0.98,'latitude':11.2374,'login_times':'2019-08-06 04:00:03','longitude':104.693067,'pos_method':'ACC','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'352503090840171','gps_time':'2019-08-06 03:27:14','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:27:14','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':35.47,'latitude':26.15146,'login_times':'2019-08-06 03:57:03','longitude':85.341716,'pos_method':'TIMEOUT','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'353701093601405','gps_time':'2019-08-06 03:49:15','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:49:15','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':23.54,'latitude':-6.7401,'login_times':'2019-08-06 03:57:02','longitude':39.284284,'pos_method':'TIMEOUT','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'353701094012263','gps_time':'2019-08-06 03:42:49','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:42:49','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':7.43,'latitude':11.537877,'login_times':'2019-08-06 04:00:03','longitude':104.859173,'pos_method':'ACC','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'351777090372812','gps_time':'2019-08-06 03:55:07','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:55:07','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':3.77,'latitude':23.780396,'login_times':'2019-08-06 04:00:00','longitude':90.420942,'pos_method':'ACC','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'353701090200631','gps_time':'2019-08-06 03:32:51','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:32:51','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':36.43,'latitude':-2.141098,'login_times':'2019-08-06 03:55:28','longitude':112.766764,'pos_method':'TIMEOUT','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        list.add("{'imei':'351777090457449','gps_time':'2019-08-06 03:57:46','acc':'1','column2':'','device_status':'0','direction':'58','extension_module':'','gate_time':'2019-08-06 03:57:46','gps_dev_time':'2019-08-06 04:00:04','gps_info':'13','gps_mode':'0','gps_speed':0.6,'latitude':4.638017,'login_times':'2019-08-06 04:00:02','longitude':101.147129,'pos_method':'ACC','pos_type':'1','precision':'0','record_time':'2019-08-06 04:00:04','source_id':''}");
        return list;
    }

    public static List<ReportAlarm> getAlarmInfo()  {

        List<ReportAlarm> list = new ArrayList<>();

        for (String s : alarmList) {
            String[] split = s.split("\001");
            list.add(new ReportAlarm("", "", split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9], split[10], split[11]));
        }

        return list;
    }

    public static List<ReportStop> getReportStop() {

        List<ReportStop> list = new ArrayList<>();

        for (String s : stopList) {
            String[] split = s.split("\001");
            list.add(new ReportStop("", split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9], split[10], split[11]));
        }

        return list;
    }

    public static List<ReportAcc> getReportAcc()  {

        List<ReportAcc> list = new ArrayList<>();

        for (String s : accList) {
            String[] split = s.split("\001");
            list.add(new ReportAcc("", split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7]));
        }

        return list;

    }

    public static List<ReportTrack> getReportTrack() {

        List<ReportTrack> list = new ArrayList<>();

        for (String s : trackList) {
            String[] split = s.split("\001");
            list.add(new ReportTrack("", split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9], split[10], split[11], split[12], split[13], split[14], split[15], split[16], split[17], split[18], split[19], split[20]));

        }
        return list;
    }


    public static List<ReportDistance> getReportDistance()  {

        List<ReportDistance> list = new ArrayList<>();

        for (String s : disList) {
            String[] split = s.split("\001");
            list.add(new ReportDistance("", split[0], split[1], split[2], split[3], split[4]));
        }

        return list;
    }
}