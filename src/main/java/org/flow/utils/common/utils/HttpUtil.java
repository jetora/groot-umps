package org.flow.utils.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

        String queryString = request.getQueryString();
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
