package com.ll.comu.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.comu.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        public static <T> T toObj(String jsonStr, TypeReference<T> typeReference, T defaultValue) {
            try {
                return om.readValue(jsonStr, typeReference);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
