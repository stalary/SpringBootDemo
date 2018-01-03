# SpringBootDemo
使用springboot快速开发的一个小demo
### idea需要安装lombok插件
### 数据库文件在src/main/resources中
[-项目地址](http://login.stalary.com)
[-前端地址](https://github.com/Clairezyw/Vue-project)
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
- 使用thymeleaf模版引擎，引入LEGACYHTML5(解决vue编译后需要/的问题)
- 使用spring-boot缓存存储用户信息

### 不足
- ThreadLocal不使用注解进行限制，退出后有一定几率还能获取到用户信息
- cookies被禁用时，将无法登陆

### 遇到的坑
- 跨域问题
- ThreadLocal的生命周期
- cookies丢失
- thymeleaf模版引起默认mode必须要加/
- 拦截器需要配置


