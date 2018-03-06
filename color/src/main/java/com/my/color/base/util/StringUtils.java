package com.my.color.base.util;


import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 */
public class StringUtils {
    /**
     * 去掉字符前后的空格
     */
    public static String trim(String str) {
        return isNull(str) ? "" : str.trim();
    }

    /**
     * 判断字符串是否为空 return true 为空 return false 不为空
     */
    public static boolean isNull(String str) {
        return str == null ? true : false;
    }

    /**
     * 检查Object是否为空字符
     */
    public static boolean isObjectEmpty(Object str) {
        return (null == str) || "".equals(str) ? true : false;
    }

    /**
     * 检查字符串是否为空字符
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || "".equals(str) ? true : false;
    }

    /**
     * 检查空字符串，如果为null返回空字符
     */
    public static String nullToString(String str) {
        return isNull(str) ? "" : str;
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     *
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 验证字符串是否为日期格式
     *
     * @param args
     * @return true 是 false 否
     */
    public static boolean isDateType(String... args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        boolean isTag = true;
        try {
            for (int i = 0; i < args.length; i++) {
                df.format(df.parse(args[i]));
            }
        } catch (Exception e) {
            isTag = false;
        }
        return isTag;
    }

    /**
     * 获取指定字符串，指定字符 出现第N次所在的下标位置
     *
     * @param string  指定字符串
     * @param n       次
     * @param pattern 指定的字符
     * @return
     */
    public static int getCharacterPosition(String string, int n, String pattern) {
        //这里是获取pattern符号的位置
        Matcher slashMatcher = Pattern.compile(pattern).matcher(string);
        int mIdx = 0;
        while (slashMatcher.find()) {
            mIdx++;
            //当pattern符号第n次出现的位置
            if (mIdx == n) {
                break;
            }
        }
        return slashMatcher.start();
    }

    /**
     * 得到指定字符在 指定字符串 出现的次数
     *
     * @param s1    指定字符串
     * @param char1 指定字符
     * @return
     */
    public static int ciShu(String s1, String char1) {
        //定义一个int变量，用来计算s2在搜索s1中出现的次数；
        int num = 0;
        //遍历s1
        for (int i = 0; i < s1.length(); i++) {
            //调用方法indexOf,计算char1在s1字符串中出现的下标，
            int t = s1.indexOf(char1, i);
            //当用if判断，当遍历开始下标i与s2在s1中出现的下标位置相等时变量num自增1；
            if (i == t) {
                num++;
            }
        }
        return num;
    }

    //生成随机数字和字母,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    //生成指定位数的随机数
    public static char[] generateRandomArray(int num) {
        String chars = "0123456789";
        char[] rands = new char[num];
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

}
