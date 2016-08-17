package com.app;
/**
 * 定义常量
 * @author lbz
 *
 */
public interface SpringAnnotationDef {

    //作用域
    String SCOPE_PROTOTYPE = "prototype";
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_SESSION   = "session";
    String SCOPE_REQUEST   = "request";
    
    
    //定义DAO
    String BASE_DAO = "baseDao";
    String USER_DAO = "userDao";
    
    //定义service
    String USER_SERVICE = "userService";
    
}
