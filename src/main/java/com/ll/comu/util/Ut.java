package com.ll.comu.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ut {
    public static class json{
        public static String toStr(Object obj,String defaultValue){
            ObjectMapper om=new ObjectMapper();
            try{
                return om.writeValueAsString(obj);
            }catch (JsonProcessingException e){
                return defaultValue;
            }

        }
    }
}
