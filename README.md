# SpringBootDemo
使用springboot快速开发的一个小demo
### idea需要安装lombok插件
### 数据库文件在src/main/resources中

- 目前仅完成简单的注册登陆以及获取用户信息，只需前台发送一次帐号密码，后续请求全部有服务端处理
- 添加基本的Session监听器，登陆过滤器
- 添加登陆验证注解，防止ThreadLocal泄漏用户信息
