package com.qhz.comb.framework.util;


import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Collection工具类
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
public class CollectionUtils {

    public static List extractToList(Collection collection, String propertyName) {
        ArrayList list = new ArrayList(collection.size());
        try {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }

            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
