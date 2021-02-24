package com.example.losefound.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;


public class JWToken {

    public static String createToken(String phone)throws Exception{
        Date iatDate = new Date();

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.DAY_OF_YEAR,7);
        Date expireDate = nowTime.getTime();

        String token = JWT
                .create()
                .withHeader(JWTConstants.DEFAULT_HEADER)
                .withClaim("iss", JWTConstants.ISS)
                .withClaim("name",phone)//payload
                .withExpiresAt(expireDate)//过期时间 要大于签发时间
                .withIssuedAt(iatDate)//设置签发时间
                .sign(Algorithm.HMAC256(JWTConstants.SECRET));//加密
        return token;
    }

    public static Map<String,Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWTConstants.SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims;
    }

}
