package com.example.tianan.gaorui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class Judge {
    /**
     * 判断手机是否合法
     * @return
     */

    public static boolean isMobileNO(String mobiles){
      //if (null==mobiles || "".equals(mobiles)) return false;
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();

    }
    /**
     * 判断邮箱是否合法
     */
    public static boolean isEmail(String email){
      //if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }
    /**
     * 判断密码是否正确
     * 密码格式:要求是密码大于6位，并仅允许字母及数字组合 且必须含一位以上大写字母！！！
     */
    public static boolean isPassword(String password){
      //if (null==password || "".equals(password)) return false;
        Pattern p =  Pattern.compile("^(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{7,}$");//复杂匹配
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
