package org.flow.utils.common.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**     
  * 
  * @description:     
  * @author:         xx
  * @createDate:     date
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

    public static <T> T copy(Object poObj,final Class <T>voClass)
    {
        T voObj =null;
        try {
            voObj = voClass.newInstance();
            BeanUtils.copyProperties(poObj, voObj);
            return voObj;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> List<T> copyList(List <? extends Object> poList , final Class <T>voClass){

        List<T> voList=new ArrayList<T>();

        T voObj =null;
        for(Object poObj:poList){
            try {
                voObj = voClass.newInstance();
                BeanUtils.copyProperties(poObj, voObj);
                voList.add(voObj);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
            System.out.println(voObj);
        }
        return voList;
    }

}
