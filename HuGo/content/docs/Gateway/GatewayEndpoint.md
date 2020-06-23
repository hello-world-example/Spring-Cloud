# GatewayEndpoint



```properties
# 开启 GatewayEndpoint
management.endpoints.web.exposure.include=gateway,mappings
```



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

- [Spring Cloud Gateway 管理API](https://www.cnblogs.com/wgslucky/p/11758958.html)