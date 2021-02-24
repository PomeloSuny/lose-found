package com.example.losefound.common.security;

import java.util.HashMap;
import java.util.Map;


public class JWTConstants {

    public static String SECRET = "LOSE_AND_FOUND";
    public static String ALG = "HS256";
    public static String TYP = "JWT";
    public static String ISS = "www.lossFound.com";

    public static Map DEFAULT_HEADER = new HashMap();
    static {
        DEFAULT_HEADER.put("alg","HS256");
        DEFAULT_HEADER.put("typ","JWT");
    }



}
