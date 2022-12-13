package com.itheima.util;
import io.jsonwebtoken.*;
import java.util.Date;
//jwt通用工具类
public class JwtUtil {
//     private static long time=1000*60*60*24;
private static long time=1000*60*3;
     private static String signature="admin";
    //创建token
    public static String createJwt(final String id){

        //借助第三方组件创建
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS512")
                .claim("username","admin")
                .claim("role","admin")
                .setSubject("用户登录")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(id)
                .signWith(SignatureAlgorithm.HS512,signature)
                .compact();
        return jwtToken;
    }

    public static boolean checkToken(String token){
        if (token==null)
            return false;
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
           return false;
        }
     return true;
    }

}
