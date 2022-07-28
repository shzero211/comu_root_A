package com.ll.comu.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.comu.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class Ut {
    public static class json{
        private static final ObjectMapper om;
        static {
            om=new ObjectMapper();
        }
        public static String toStr(Object obj,String defaultValue){
            try{
                return om.writeValueAsString(obj);
            }catch (JsonProcessingException e){
                return defaultValue;
            }

        }
        public static <T> T toObject(String jsonStr,Class<T> cl,T defaultValue){
        try{
            return (T)om.readValue(jsonStr, cl);
        }catch (JsonProcessingException e){
            return defaultValue;

        }
        }
    }
}
