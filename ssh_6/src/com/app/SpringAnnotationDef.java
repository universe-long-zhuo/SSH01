package com.app;
/**
 * ���峣��
 * @author lbz
 *
 */
public interface SpringAnnotationDef {

    //������
    String SCOPE_PROTOTYPE = "prototype";
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_SESSION   = "session";
    String SCOPE_REQUEST   = "request";
    
    
    //����DAO
    String BASE_DAO = "baseDao";
    String USER_DAO = "userDao";
    
    //����service
    String USER_SERVICE = "userService";
    
}
