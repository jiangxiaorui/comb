//package com.qhz.comb.framework.oauth2.token;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedPrincipalExtractor;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
//import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
//
//import java.util.Map;
//
///**
// * @author jiangting
// * @since 1.0, 2018/6/1
// */
//public class UserPrincipalExtractor implements PrincipalExtractor {
//
//    private FixedPrincipalExtractor fixedPrincipalExtractor = new FixedPrincipalExtractor();
//
//    @Override
//    public Object extractPrincipal(Map<String, Object> map) {
//        Map<String, Object> authentication = (Map<String, Object>) map.get("userAuthentication");
//        if (authentication != null) {
//            Object principal =authentication.get("principal");
////            User user = new User();
//            try {
////                BeanUtils.populate(user,  (Map<String, Object>) principal);
//            } catch (Exception e) {
//                throw new InvalidTokenException("");
//            }
//            return null;
//        } else {
//            Object principal = this.fixedPrincipalExtractor.extractPrincipal(map);
//            return (principal == null ? "unknown" : principal);
//        }
//    }
//}
