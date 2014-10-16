package com.lenovo.leoss.utils;

/**
 * Created by zhangyl27 on 2014/10/16.
 */
public class HSqls {

    public static final String USER_BASE_INFO_UPDATE =
            "update User set " +
                    "contact_name=?," +
                    "phone=?," +
                    "company_type=?," +
                    "company_name=?," +
                    "company_site=? " +
                    "where id=?";

}
