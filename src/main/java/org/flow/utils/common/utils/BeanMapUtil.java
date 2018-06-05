package org.flow.utils.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
*PO到Map的转换方法，基于类反射技术
*/
public class BeanMapUtil {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map convertBean2MapWithUnderscoreName(Object bean) throws Exception {
        Map returnMap = null;
        try {
            Class type = bean.getClass();
            returnMap = new HashMap();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo
                    .getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equalsIgnoreCase("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    returnMap.put(StringUtils.underscoreName(propertyName), result);
                }
            }
        } catch (Exception e) {
            // 解析错误时抛出服务器异常 记录日志
            throw new Exception("从bean转换为map时异常!", e);
        }
        return returnMap;
    }
}
