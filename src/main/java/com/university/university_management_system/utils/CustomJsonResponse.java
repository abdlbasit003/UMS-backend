package com.university.university_management_system.utils;

import java.util.Collections;
import java.util.Map;

public class CustomJsonResponse {
    public static Map<String,String> sendCustom(String key, String value){
        return Collections.singletonMap(key,value);
    }

}
