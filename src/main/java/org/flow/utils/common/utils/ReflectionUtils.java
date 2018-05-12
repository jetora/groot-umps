package org.flow.utils.common.utils;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionUtils extends org.springframework.util.ReflectionUtils {
    private ReflectionUtils() {
    }

    private static ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    /**
     * Return parameter names for this method,
     * or {@code null} if they cannot be determined.
     *
     * @param method method to find parameter names for
     * @return an array of parameter names if the names can be resolved,
     * or {@code null} if they cannot
     */
    public static String[] getParameterNames(Method method) {
        return parameterNameDiscoverer.getParameterNames(method);
    }

    /**
     * Return parameter names for this constructor,
     * or {@code null} if they cannot be determined.
     *
     * @param ctor constructor to find parameter names for
     * @return an array of parameter names if the names can be resolved,
     * or {@code null} if they cannot
     */
    public static String[] getParameterNames(Constructor<?> ctor) {
        return parameterNameDiscoverer.getParameterNames(ctor);
    }

    public static Method findMethod(Class<?> clazz, String name) {
        return findMethod(clazz, name, null);
    }

    public static Class<?> forName(String name )   {
        try {
            return ClassUtils.forName(name, null);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
