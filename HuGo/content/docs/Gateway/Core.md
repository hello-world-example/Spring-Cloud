# 核心概念



## 注意事项

- 基于 [Spring Boot 2.x](https://spring.io/projects/spring-boot#learn), [Spring WebFlux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html), 和 [Project Reactor](https://projectreactor.io/docs)，不支持同步模式的库
- 使用 Netty 库，所以不要构建成 war 包放到 Servlet 容器中，要使用 jar 的方式运行



## 关键词

- **Route 路由**：路由是网关的基本构建模块。它由**一个 ID**，**一个目标 URI**，**一组谓词**和**一个过滤器的集合**定义。如果聚合谓词为真，则路由匹配。
- **Predicate 断言**：使用  [Java 8 Function Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)，输入类型是 [Spring Framework `ServerWebExchange`](https://docs.spring.io/spring/docs/5.0.x/javadoc-api/org/springframework/web/server/ServerWebExchange.html)，允许开发人员匹配来自 HTTP 请求的任何内容，例如头部或参数。
- **Filter 过滤器**： [Spring Framework `GatewayFilter`](https://docs.spring.io/spring/docs/5.0.x/javadoc-api/org/springframework/web/server/GatewayFilter.html) 在特定工厂中构建的实例。这里，可以在发送下游请求之前或之后修改请求和响应
  - pre
  - post
- 



## Read More

- [Spring Cloud Gateway 2.1.0 中文官网文档](https://cloud.tencent.com/developer/article/1403887)