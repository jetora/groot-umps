
Base on:  
    spring-boot 2.0.1.RELEASE  
    spring-security-oauth2 2.3.2.RELEASE  
    spring-boot-starter-data-jpa 2.0.1.RELEASE  
    spring-security-jwt 1.0.9.RELEASE

用到的  
    JDK8.0  
    Spring 5  
    Oauth2.0  
    Redis  
    Mysql   
    JWT   
    
实现功能  
    access token  
    refresh token  
    接口权限控制  
    token信息存redis  
    其他数据存mysql  

grant_type  
    说明OAuth2支持的grant_type(授权方式)与功能  

    authorization_code -- 授权码模式(即先登录获取code,再获取token)    --已实现  
    password -- 密码模式(将用户名,密码传过去,直接获取token)      --已实现  
    refresh_token -- 刷新access_token         --已实现  
    client_credentials -- 客户端模式(无用户,用户向客户端注册,然后客户端以自己的名义向'服务端'获取资源)     --已实现  
    implicit -- 简化模式(在redirect_uri 的Hash传递token; Auth客户端运行在浏览器中,如JS,Flash)  

获取token  
    <img src="./img/jwtaccesstoken.jpg" width="60%" height="60%" />  

解析token  
    https://jwt.io/  
    <img src="./img/decodetoken.jpg" width="60%" height="60%" />   
    
刷新token  
    <img src="./img/refresh_token.jpg" width="60%" height="60%" />  
客户端模式  
    <img src="./img/client_credentials.jpg" width="60%" height="60%" />  
访问资源  
    <img src="./img/privilege.jpg" width="60%" height="60%" />  

授权码模式  
    http://localhost:8080/oauth/authorize?response_type=code&client_id=code-utity&redirect_uri=https://www.jd.com  
    <img src="./img/login.jpg" width="60%" height="60%" />  
    <img src="./img/approval.jpg" width="60%" height="60%" />  

授权之后，从回调地址中获取到授权码  
    https://www.jd.com/?code=9Ix32I 

携带授权码获取对应的token  
    <img src="./img/authorization_code.jpg" width="60%" height="60%" />  

authorization_code模式对应的client数据处理上需要注意client_secret为空  
    <img src="./img/oauth_client_details.jpg" width="60%" height="60%" />  

通过得到的access_token访问资源  
    <img src="./img/resource_access.jpg" width="60%" height="60%" />  
    
删除token  
    <img src="./img/deletetoken.jpg" width="60%" height="60%" />      

关于resource_ids  
    Spring Security OAuth2 架构上分为Authorization Server和Resource Server。  
    我们可以为每一个Resource Server（一个微服务实例）设置一个resourceid。  
    再给client授权的时候，可以设置这个client可以访问哪一些微服务实例，  
    如果没设置，就是对所有的resource都有访问权限。  
