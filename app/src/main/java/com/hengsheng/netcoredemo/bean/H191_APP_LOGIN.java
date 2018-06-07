package com.hengsheng.netcoredemo.bean;

/**
 * Created by zhangb on 2018/6/7/007
 */

public class H191_APP_LOGIN {
    public String code;
    public String message;
    /**
     * data : {"j1":"","j2":"15","j3":"站点名称","j4":"登录账号","j5":"1234565","j6":"2018-04-17 20:38:30","j7":"","j8":"","j9":"2018-04-17 21:21:06.180861+08","j10":"","j11":"","j12":"2018-04-17","j13":"01","j14":"5000","j15":"02","j16":"1000","j17":"1","j18":"审核中","j19":"","j20":"","j21":"02","j22":"","j23":"1","j24":"浙A12345"}
     */

    public DataBean data;

    public static class DataBean {
        /**
         * j1 :
         * j2 : 15
         * j3 : 站点名称
         * j4 : 登录账号
         * j5 : 1234565
         * j6 : 2018-04-17 20:38:30
         * j7 :
         * j8 :
         * j9 : 2018-04-17 21:21:06.180861+08
         * j10 :
         * j11 :
         * j12 : 2018-04-17
         * j13 : 01
         * j14 : 5000
         * j15 : 02
         * j16 : 1000
         * j17 : 1
         * j18 : 审核中
         * j19 :
         * j20 :
         * j21 : 02
         * j22 :
         * j23 : 1
         * j24 : 浙A12345
         * j25 : 1
         * j26 : 浙A12345
         * j27 : 手机号
         */
        //sessionid
        public String j1;
        //唯一标识用户userid
        public String j2;
        //站点名称
        public String j3;
        //登录账号
        public String j4;
        //登录密码
        public String j5;
        //注册时间
        public String j6;
        //姓名
        public String j7;
        //性别01 男，02 女
        public String j8;
        //生日( yyyy-MM-dd )
        public String j9;
        //头像id
        public String j10;
        //用户头-像路径
        public String j11;
        //更新时间
        public String j12;
        //数据状态 01 正常 02 删除
        public String j13;
        //押金余额(元)
        public String j14;
        //押金状态：01未缴 02正常 03退款中
        public String j15;
        //账户余额(元)
        public String j16;
        //(身份证)实名认证状态：01未认证，02已认证，03认证中，04认证失败
        public String j17;
        //(身份证)审核消息
        public String j18;
        //紧急联系人姓名
        public String j19;
        //紧急联系人电话
        public String j20;
        //手机号归属省
        public String j21;
        //是否司机，01-是，02-否
        public String j22;
        //车辆id
        public String j23;
        //绑定的车牌号
        public String j24;
        //(驾驶证)实名认证状态：01未认证，02已认证，03认证中，04认证失败
        public String j25;
        //(驾驶证)审核消息
        public String j26;
        //手机号
        public String j27;
        public String retCode;
        public String retDesc;
    }
}
