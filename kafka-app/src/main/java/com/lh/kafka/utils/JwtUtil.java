package com.lh.kafka.utils;

import com.alibaba.fastjson.util.TypeUtils;
import com.lh.kafka.error.BaseErrorCodeEnum;
import com.lh.kafka.exception.AppException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqinghe
 * jwt工具类
 */
@Slf4j
public class JwtUtil {
    public static final String USERID = "userid";
    //修改了盐的长度，改为32位
    private static final String SECRET = "wgtqat1hntzpznmdju3k2ytfvdsa3c";
    //jwt时间一个月
    private static final long EXPIRE = 30 * 24 * 60 * 60 * 1000L;
//    private static final long EXPIRE = 1;

    /**
     * 生成token
     *
     * @param uid
     * @return
     */
    public static String generate(Long uid) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + EXPIRE);
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(USERID, uid);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 解析Claims
     *
     * @param token
     * @return
     */
    public static Claims getClaim(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            //e.printStackTrace();
            throw new AppException(BaseErrorCodeEnum.ERROR_SYS_1001);
        }
        return claims;
    }

    public static void main(String[] args)throws Exception{
        Long userId = 1150L;
        String token = generate(userId);
        System.out.println(token);
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAt(String token) {
        return getClaim(token).getIssuedAt();
    }

    /**
     * 获取UID
     */
    public static Long getUid(String token) {
        return TypeUtils.castToLong(getClaim(token).get(USERID));
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpiration(String token) {
        return getClaim(token).getExpiration();
    }

    /**
     * 验证token是否失效
     *
     * @param token
     * @return true:过期   false:没过期
     */
    public static boolean isExpired(String token) {
        try {
            final Date expiration = getExpiration(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

//    public static Long getUserIdForRequest(HttpServletRequest request){
//        String jwt = request.getHeader(BaseConstant.USER_TOKEN);
//        return JwtUtil.getUid(jwt);
//    }
}
