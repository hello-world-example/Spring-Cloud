# GatewayEndpoint



## 添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```



## 开启 gateway endpoint

```properties
# 开启 GatewayEndpoint
management.endpoints.web.exposure.include=gateway,mappings
```



##  All endpoints

| Class                             | Endpoint                                              | 简介                         |
| --------------------------------- | ----------------------------------------------------- | ---------------------------- |
| AbstractGatewayControllerEndpoint | **GET** /actuator/gateway/refresh                     | 发送 RefreshRoutesEvent 事件 |
| AbstractGatewayControllerEndpoint | **GET**/actuator/gateway/globalfilters                | 查看 GlobalFilter            |
| AbstractGatewayControllerEndpoint | **GET**/actuator/gateway/routefilters                 | 查看 GatewayFilterFactory    |
| AbstractGatewayControllerEndpoint | **GET**/actuator/gateway/routepredicates              | 查看 RoutePredicateFactory   |
| GatewayControllerEndpoint         | **GET** /actuator/gateway/routes                      | 查看 所有 Route              |
| GatewayControllerEndpoint         | **GET** /actuator/gateway/routes/{id}                 | 查看 指定 Route              |
| AbstractGatewayControllerEndpoint | **POST** /actuator/gateway/routes/{id}                | 修改 Route                   |
| AbstractGatewayControllerEndpoint | **DELETE** /actuator/gateway/routes/{id}              | 删除 Route                   |
| AbstractGatewayControllerEndpoint | **GET** /actuator/gateway/routes/{id}/combinedfilters |                              |



## Read More

- [15. Actuator API](https://cloud.spring.io/spring-cloud-gateway/reference/html/#actuator-api)