package org.flow.utils.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.google.common.collect.Multimap;

public class HttpUtil {

    public static Map<String, String> getParams(HttpServletRequest request)
    {
        String[] pairs;
        int i;
        Iterator iter;
        Map params = new HashMap();

        //String queryString = request.getQueryString();
        //String queryString = new String(request.getQueryString().getBytes("iso-8859-1"),"UTF-8");
        String queryString = "";
        try {
            queryString = URLDecoder.decode(request.getQueryString(),"utf-8");
        } catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }

        System.out.println("1111111111111111111111");
        System.out.println(queryString);
        if (StringUtils.notNull(queryString)) {
            pairs = StringUtils.split(queryString,"&");
            for (i = 0;i < pairs.length; ++i){
                String p = pairs[i];
                //page=NaN&sortOrder=asc&username=123&enabled=1&_=1526532288089
                int idx = p.indexOf(61);
                params.put(p.substring(0, idx), p.substring(idx + 1));
            }
        }
        return params;
    }
}
