# cppba-spring-boot
cppba-spring-boot教程

## 1.技术选型
spring-boot、spring-data-jpa（后期会加入新技术）

## 2.项目结构
cppba-spring-boot-core 通用的工具类、entity、dao

cppba-spring-boot-api  提供服务接口api

cppba-spring-boot-service  提供服务实现

cppba-spring-boot-web  web项目代码

## 3.不同环境打包
application.properties 中定义当前环境(dev-开发,test-测试,prod-生产)

application-dev.properties 开发环境配置

application-test.properties 测试环境配置

application-prod.properties 生产环境配置

其中application.properties的配置如下：
```xml
###打包时只需要修改spring.profiles.active参数，决定环境

#表示当前是开发环境，读取application-dev.properties配置文件
spring.profiles.active=dev

#表示当前是测试环境，读取application-test.properties配置文件
spring.profiles.active=test

#表示当前是生产环境，读取application-prod.properties配置文件
spring.profiles.active=prod
```
