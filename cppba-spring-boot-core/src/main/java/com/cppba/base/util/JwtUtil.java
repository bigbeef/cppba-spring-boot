package com.cppba.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.cppba.base.bean.CurrentUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtUtil {

    private static String secret = "com.cppba";

    /**
     * 创建一个jwt字符串
     * @param userJwt
     * @return
     * @throws Exception
     */
    public static String createJwt(CurrentUser currentUser) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String jwtString = objectMapper.writeValueAsString(currentUser);
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("user",jwtString);
        return builder.sign(Algorithm.HMAC256(secret));
    }

    /**
     * 解码jwt token
     * @param token
     * @return
     * @throws Exception
     */
    public static CurrentUser decodeJwt(String token) throws Exception{
        JWT decode = JWT.decode(token);
        Claim user = decode.getClaim("user");
        String userString = user.as(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        CurrentUser userJwt = objectMapper.readValue(userString,CurrentUser.class);
        return userJwt;
    }

    /**
     * 验证token签名是否合法
     * @param token
     * @return
     * @throws Exception
     */
    public static boolean verify(String token) throws Exception {
        try {
            JWT decode = JWT.decode(token);
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .build();
            verifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
