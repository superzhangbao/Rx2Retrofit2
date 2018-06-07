package com.hengsheng.netcoredemo.bean;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class H191_APP_SMSCODE_SND {
    public String code;
    public String message;
    /**
     * data : {"j1":"13","j2":"401104"}
     */

    public DataBean data;

    public static class DataBean {
        /**
         * j1 : 13
         * j2 : 401104
         */

        public String retCode;
        public String retDesc;
    }
}
