SpringBootDemo
====

SpringBoot RESTful API的例子，组织工程架构，作为基础工程使用。

# 主要技术方案
* SpringBoot 2.1.1.RELEASE
* MySQL 8.0
* JPA
* Swagger

# 开发构建环境
* OpenJDK 11
* Gradle 5.0

# 使用说明
## 1. 配置数据库
* 方法一: 使用Docker(推荐)
```bash
cd docker/mysql
docker-compose up -d
```
* 方法二: 使用已有数据库
1. 修改application.yml中`spring.datasource`的数据库配置
2. 创建数据库
```mysql
CREATE DATABASE IF NOT EXISTS SpringBootDemo CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
```
## 2. 运行
```bash
./gradlew bootRun
```

## 3. 查看API
* <http://localhost:8081/swagger-ui.html>
* <http://localhost:8081/api-docs>

# 默认配置说明
在项目同级目录下会创建"SpringBootDemo_DATA"文件夹，用于存放日志和相关docker宿主目录绑定。

# 其他
与项目名称有关的配置都以"SpringBootDemo"开头，所以修改项目名称时，替换成自己想要的名称即可。

# Links
* [官方API](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/api/)
* [官方文档](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/)
* [官方文档 PDF](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/pdf/spring-boot-reference.pdf)
