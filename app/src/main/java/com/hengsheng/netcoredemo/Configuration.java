package com.hengsheng.netcoredemo;

/**
 * Created by zhangb on 2018/4/13/013
 */

public class Configuration {
    //接口URL
//    public static final String HOST = "http://172.16.30.191:1080/hspc_app/interface/public/pcom.php";

    public static final String HOST = "http://112.17.127.21:11080/hspc_app/interface/public/pcom.php";

    /******************************接口交易码宏定义*************************************************/

    //城市的线路
    public static final String H191_APP_ROUTE_LST = "H191_APP_ROUTE_LST";
    //线路班次
    public static final String H191_APP_LINE_LST = "H191_APP_LINE_LST";
    //当日选中的班次座位信息
    public static final String H191_APP_SEAT_LST = "H191_APP_SEAT_LST";
    //预约班次时间json
    public static final String H191_APP_FUTUTIME_LST = "H191_APP_FUTUTIME_LST";
    //预约班次座位
    public static final String H191_APP_FUTUSEAT_LST = "H191_APP_FUTUSEAT_LST";
    //班次发车时间
    public static final String H191_APP_LINETIME_LST = "H191_APP_LINETIME_LST";
    //开始拼车
    public static final String H191_APP_CARPOOL = "H191_APP_CARPOOL";
    //预约拼车
    public static final String H191_APP_FUTU_CARPOOL = "H191_APP_FUTU_CARPOOL";
    //余额支付
    public static final String H191_APP_ACCT_PAY = "H191_APP_ACCT_PAY";
    //拼乘支付宝支付
    public static final String H191_APP_PORDER_ALIPAY = "H191_APP_PORDER_ALIPAY";
    //拼乘微信支付
    public static final String H191_APP_PORDER_WXPAY = "H191_APP_PORDER_WXPAY";
    //以订单号查询上车联系信息
    public static final String H191_APP_TRIP_ORDER = "H191_APP_TRIP_ORDER";
    //以订单号取消行程
    public static final String H191_APP_ORDER_CANCEL = "H191_APP_ORDER_CANCEL";
    //评价
    public static final String H191_APP_COMPLAINT = "H191_APP_COMPLAINT";
    //投诉
    public static final String H191_APP_EVALUATE = "H191_APP_EVALUATE";
    //查询订单二维码
    public static final String H191_APP_QRCODE_LST = "H191_APP_QRCODE_LST";
    //创建支付宝充值余额预订单
    public static final String H191_APP_BALAN_PRE_ALIPAY = "H191_APP_BALAN_PRE_ALIPAY";
    //创建支付宝充值押金预订单
    public static final String H191_APP_DEPOS_PRE_ALIPAY = "H191_APP_DEPOS_PRE_ALIPAY";
    //创建微信充值余额预订单
    public static final String H191_APP_BALAN_PRE_WXPAY = "H191_APP_BALAN_PRE_WXPAY";
    //创建微信充值押金预订单
    public static final String H191_APP_DEPOS_PRE_WXPAY = "H191_APP_DEPOS_PRE_WXPAY";
    //登录
    public static final String H191_APP_LOGIN = "H191_APP_LOGIN";
    //发送验证码
    public static final String H191_APP_SMSCODE_SND = "H191_APP_SMSCODE_SND";
    //自动登录
    public static final String H191_APP_LOGIN_AUTO = "H191_APP_LOGIN_AUTO";
    //获取全部站点信息
    public static final String H191_APP_STAN_LST = "H191_APP_STAN_LST";
    //获取用户信息
    public static final String H191_APP_USRINFO_LST = "H191_APP_USRINFO_LST";
    //实名认证身份证
    public static final String H191_APP_SFZ_PHOTO = "H191_APP_SFZ_PHOTO";
    //实名认证驾驶证
    public static final String H191_APP_DRV_PHOTO = "H191_APP_DRV_PHOTO";
    //查询实名认证信息
    public static final String H191_APP_REAL_INFO = "H191_APP_REAL_INFO";
    //创建充值订单
    public static final String H191_APP_PAY_ORDER = "H191_APP_PAY_ORDER";
    //查询充值订单明细
    public static final String H191_APP_ORDERPAY_DTLLST = "H191_APP_ORDERPAY_DTLLST";
    //退押金申请
    public static final String H191_APP_RETU_DEPOS_APPLY = "H191_APP_RETU_DEPOS_APPLY";
    //查询退押金审批状态
    public static final String H191_APP_RETU_DEPOS_STAT = "H191_APP_RETU_DEPOS_STAT";
    //根据车牌号查询车辆信息
    public static final String H191_APP_CARSTAT_INFO = "H191_APP_CARSTAT_INFO";
    //上报车辆故障
    public static final String H191_APP_CARFAULT_SEND = "H191_APP_CARFAULT_SEND";
    //立即用车
    public static final String H191_APP_START_CAR = "H191_APP_START_CAR";
    //结束用车
    public static final String H191_APP_END_CAR = "H191_APP_END_CAR";
    //获取行程详情
    public static final String H191_APP_TRIPORDER_DTLLST = "H191_APP_TRIPORDER_DTLLST";
    //获取租车未付订单信息
    public static final String H191_APP_SCAR_WPAYORDER = "H191_APP_SCAR_WPAYORDER";
    //查询行程列表
    public static final String H191_APP_TRIPINFO_LST = "H191_APP_TRIPINFO_LST";
    //共享车余额支付
    public static final String H191_APP_TRIPORDER_PAY = "H191_APP_TRIPORDER_PAY";
    //微信共享车支付
    public static final String H191_APP_ORDER_WXPAY = "H191_APP_ORDER_WXPAY";
    //支付宝共享车支付
    public static final String H191_APP_ORDER_ALIPAY = "H191_APP_ORDER_ALIPAY";
    //上传头像
    public static final String H191_APP_USRINFO_SHORT_MOD = "H191_APP_USRINFO_SHORT_MOD";
    //修改个人信息
    public static final String H191_APP_USRINFO_MOD = "H191_APP_USRINFO_MOD";
    //保存紧急联系人
    public static final String H191_APP_EMERG_MOD = "H191_APP_EMERG_MOD";
    //订单清单
    public static final String H191_APP_TRIPORDER_LST = "H191_APP_TRIPORDER_LST";
    //钱包
    public static final String H191_APP_ACCT_INFO = "H191_APP_ACCT_INFO";
    //账单
    public static final String H191_APP_PAYINFO_LST = "H191_APP_PAYINFO_LST";
    //消费明细列表
    public static final String H191_APP_ORDERPAY_LIST = "H191_APP_ORDERPAY_LIST";
    //充值明细列表
    public static final String H191_APP_PAY_LST = "H191_APP_PAY_LST";
//    //充值明细
//    public static final String H191_APP_INCOME_LST = "H191_APP_INCOME_LST";
    //APP退出
    public static final String H191_APP_LOGOUT = "H191_APP_LOGOUT";
    //版本核查
    public static final String H191_APP_VER_CHK = "H191_APP_VER_CHK";

    //查询订单支付状态   入参 J1 订单号
    public static final String H191_APP_ORDER_PAYSTATUS = "H191_APP_ORDER_PAYSTATUS";


    //tbox控制
    //开锁
    public static final String H191_APP_REPCTRL_CARLOCK_OPEN = "H191_APP_REPCTRL_CARLOCK_OPEN";
    //关锁
    public static final String H191_APP_REPCTRL_CARLOCK_CLOSE = "H191_APP_REPCTRL_CARLOCK_CLOSE";
    //降窗
    public static final String H191_APP_REPCTRL_CARWIN_DOWN = "H191_APP_REPCTRL_CARWIN_DOWN";
    //升窗
    public static final String H191_APP_REPCTRL_CARWIN_UP = "H191_APP_REPCTRL_CARWIN_UP";
    //寻车
    public static final String H191_APP_REPCTRL_SEARCH_CAR = "H191_APP_REPCTRL_SEARCH_CAR";
    public static final String H191_APP_REPCTRL_BACKBOX_OPEN = "H191_APP_REPCTRL_BACKBOX_OPEN";



    /********************************webview地址*********************************************/

    //用户指南
    public static final String USER_GUIDE = "http://112.17.127.21:41080/hhycCMS/Index.html";
    //关于我们
    public static final String ABOUT_US = "http://112.17.127.21:41080/hhycCMS/AboutUs.html";
    //押金说明
    public static final String DEPOSIT_EXPLAIN = "http://112.17.127.21:41080/hhycCMS/Deposit.html";
    //推荐
    public static final String RECOMMEND = "http://112.17.127.21:41080/hhycCMS/Recommended.html";
    //充值说明
    public static final String RECHARGE_EXPLAIN = "http://112.17.127.21:41080/hhycCMS/TopUpIn.html";
    //充值协议
    public static final String RECHARGE_AGREEMENT = "http://112.17.127.21:41080/hhycCMS/TopUpRe.html";
    //用车协议
    public static final String USERCAR_AGREEMENT = "http://112.17.127.21:41080/hhycCMS/UseCar.html";
    //会员注册
    public static final String VIP_REGISTER = "http://112.17.127.21:41080/hhycCMS/VipRegister.html";

    /*****************************************微信支付********************************************/

    //押金充值
    public static final String CASHPLEDGERECHARGE = "CASHPLEDGERECHARGE";

    //余额充值
    public static final String RECHARGE = "RECHARGE";

    //共享车微信支付
    public static final String GXWXPAY = "GXWXPAY";

    //平层微信支付
    public static final String PCWXPAY = "PCWXPAY";



    /*****************************************sp定义码**********************************************/

    //SessionId
    public static final String SESSION_ID = "SESSION_ID";

    //是否已经登录
    public static final String ISLOGIN = "ISLOGIN";

    //是否是第一次登录
    public static final String FIRST_OPEN = "FIRST_OPEN";

    //手机号
    public static final String AVATAR = "AVATAR";

    //定义押金金额
    public static final String  DEPOSIT_AMOUNT = "DEPOSIT_AMOUNT";

    //手机号
    public static final String PHONE = "PHONE";

    public static final String UPDATE_AVATAR = "UPDATE_AVATAR";

    //姓名
    public static final String NAME = "NAME";

    //性别
    public static final String SEX = "SEX";

    //生日
    public static final String BIRTHDAY = "BIRTHDAY";

    //紧急联系人姓名
    public static final String USER_EMCONTACT = "USER_EMCONTACT";

    //紧急联系人电话
    public static final String USER_EMTEL = "USER_EMTEL";

    //userid
    public static final String USER_ID = "USER_ID";

    //唯一识别码
    public static final String UNIQUEID = "UNIQUE_ID";

    //登录账号
    public static final String LOGINCODE = "LOGIN_CODE";

    //行程id
    public static final String JOURNEYID = "JOURNEY_ID";

    //拼乘订单id
    public static final String POOLING_JOURNEYID = "POOLING_JOURNEYID";

    //家的地址
    public static final String HOME_ADDR = "HOME_ADDR";

    //家的坐标
    public static final String HOME_LOCATION_LAT = "HOME_LOCATION_LAT";
    public static final String HOME_LOCATION_LON = "HOME_LOCATION_LON";

    //家的地址
    public static final String COMPANY_ADDR = "COMPANY_ADDR";

    /********************************************activityResult***********************************/

    public static final int EMCONTACT = 6666;

    /********************************************一般常量***********************************/
    //分页每页的数据量
    public static final int PAGE_NUM = 15;
    //定义押金金额
    public static final double CASH_PLEDGE = 899;
    //定义押金金额
    public static final double CASH_PLEDGE_FLOAT = 899.00f;
    //身份证标志
    public static final String IDCARD = "IDCARD";
    //驾驶证标志
    public static final String DRIVING = "DRIVING";
    //
    public static final String BASE64_HEAD = "data:image/png;base64,";
    //下拉刷新头部颜色
    public static final String SCHEME_COLORS = "#52C77C";



    /********************************************微信支付******************************************/
    public static final String APP_ID = "wx773e639c6f6fa63f";

    /********************************************数据库表名*****************************************/

    //用户保存家庭住址和公司地址
    public static final String ADDRESS_DB = "useraddress.db";
}
