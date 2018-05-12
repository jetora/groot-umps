package org.flow.utils.common.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**     
  * 
  * @description:     
  * @author:         WANGHUI
  * @createDate:     2018/4/4 17:58
  * @version:        1.0
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    public static void copyProperties(Map source, Object target){
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(target);
        bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.addPropertyValues(source);
        bw.setPropertyValues(pvs, true);
	}

}
