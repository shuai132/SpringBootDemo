SpringBootDemo
====

SpringBoot RESTful API的例子，组织工程架构，作为基础工程使用。

# 主要技术方案
* SpringBoot 2.x
* MySQL 8.0
* JPA
* Swagger

# 开发构建环境
* OpenJDK 11
* Gradle 5.0
* Docker

# 开发环境配置
首先创建docker环境变量:
```bash
cp .example.env .env
```
## 1. 配置数据库和Redis
```bash
docker-compose up -d mysql redis
```
## 2. IDE插件
* IDE需配置Lombok相关插件，并开启Java注解处理器(Enable annotation processors)。
## 3. 运行
使用IDE或直接执行:
```bash
./gradlew bootRun
```

## 3. 查看API
* <http://localhost:8080/swagger-ui.html>
* <http://localhost:8080/api-docs>

# 使用Docker部署
为了充分利用gradle缓存，分为编译和构建镜像两步。
## 1. 编译
方式一：使用Docker
```bash
docker-compose -f docker-compose-gradle.yml up
```
方式二：本地有JDK11环境
```bash
./gradlew assemble
```
## 2. 构建运行
```bash
docker-compose up -d --build
```
映射的端口：API:8080，MySQL:3406，Redis:6479。

# 默认配置说明
在项目同级目录下会创建"SpringBootDemo_DATA"文件夹，用于存放日志和相关docker宿主目录绑定。

# 其他
* 与项目名称有关的配置都以"SpringBootDemo"开头，所以修改项目名称时，替换成自己想要的名称即可。
* IDE需配置Lombok相关插件，并开启Java注解处理器(Enable annotation processors)。

# Links
* [官方API](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/api/)
* [官方文档](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/)
* [官方文档 PDF](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/pdf/spring-boot-reference.pdf)
