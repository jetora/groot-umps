package org.flow.utils.common.utils;

import java.util.Collection;
import java.util.List;

public class StringUtils extends org.springframework.util.StringUtils {

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String join(Object[] arr) {
        return arrayToCommaDelimitedString(arr);
    }

    public static String join(Collection<?> coll) {
        return collectionToDelimitedString(coll, ",");
    }

    public static String[] split(String str,String op) {
        return delimitedListToStringArray(str, op);
    }

    public static String clean(String in) {
        String out = in;
        if (in != null) {
            out = in.trim();
            if (out.equals("")) {
                out = null;
            }
        }

        return out;
    }


    public static boolean hasText(String str) {
        if (!hasLength(str)) {
            return false;
        } else {
            int strLen = str.length();

            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean hasLength(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str != null && prefix != null) {
            if (str.startsWith(prefix)) {
                return true;
            } else if (str.length() < prefix.length()) {
                return false;
            } else {
                String lcStr = str.substring(0, prefix.length()).toLowerCase();
                String lcPrefix = prefix.toLowerCase();
                return lcStr.equals(lcPrefix);
            }
        } else {
            return false;
        }
    }
    /**
     * 判断字符串是否为null
     * @param s 要判断字符串对象
     * @return true 表示不为null false 为空
     * @throws Exception
     */
    public static boolean notNull(String s) {
        if (s == null || s.trim().length() <= 0 || "".equals(s) || "null".equals(s)) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean notNull(Object obj) {
        if ( obj == null){
            return false;
        }
        if ((obj instanceof String)){
            if (obj == null || ((String) obj).trim().length() <= 0 || "".equals(obj) || "null".equals(obj)) {
                return false;
            } else {
                return true;
            }
        }
        if ((obj instanceof List)){
            if (((List) obj).size()!=0){
                return true;
            }
        }
        return false;
    }
    /**
     * @param stringArray  待处理字符串数组
     * @return longArray 处理后的Long数组
     */
    public static long[] str2long(String stringArray[]){
        if (stringArray == null || stringArray.length < 1) {
            return null;
        }
        long longArray[] = new long[stringArray.length];
        for (int i = 0; i < longArray.length; i++) {
            try {
                longArray[i] = Long.valueOf(stringArray[i]);
            } catch (NumberFormatException e) {
                longArray[i] = 0;
                continue;
            }
        }
        return longArray;
    }

    /**
     * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
     * 例如：HelloWorld->HELLO_WORLD
     *
     * @param name 转换前的驼峰式命名的字符串
     * @return 转换后下划线大写方式命名的字符串
     */
    public static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            result.append(name.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

}
