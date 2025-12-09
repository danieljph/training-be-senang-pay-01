package com.doku.my.trainingbesenangpay01.generic.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class CollectionExample
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        System.out.println("List: " + list);

        Map<String, Object> map = new HashMap<>();
        map.put("int", "value");
        map.put("double", 1.2);
        map.put("boolean", true);
        System.out.println("Map: " + map);
    }
}
