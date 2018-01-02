# SpringBootDemo
使用springboot快速开发的一个小demo
### idea需要安装lombok插件
### 数据库文件在src/main/resources中
[-项目地址](http://120.24.5.178:8100/swagger-ui.html#/)
### 包含功能
- spring boot
- jpa
- 前台仅需一次验证无需后续请求附带凭证的登陆(解放前端双手，后端处理一切)
- 登陆拦截器
- session监听器
- 自定义注解
- 统一异常处理
- aop
- swagger
- 跨域处理

### 不足
- ThreadLocal不使用注解进行限制，退出后有一定几率还能获取到用户信息
- cookies被禁用时，将无法登陆


