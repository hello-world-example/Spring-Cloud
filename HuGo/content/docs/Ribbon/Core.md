# 核心概念



- `com.netflix.client.config.IClientConfig`
  - `com.netflix.client.config.DefaultClientConfigImpl`



## IRule 路由规则

- `com.netflix.loadbalancer.IRule` 
  - `com.netflix.loadbalancer.AbstractLoadBalancerRule` 
    - `com.netflix.loadbalancer.RandomRule`
    - `com.netflix.loadbalancer.RetryRule`
    - `com.netflix.loadbalancer.ClientConfigEnabledRoundRobinRule`
      - `com.netflix.loadbalancer.PredicateBasedRule`
        - `com.netflix.loadbalancer.ZoneAvoidanceRule`
    - `com.netflix.loadbalancer.RoundRobinRule` 
      - `com.netflix.loadbalancer.WeightedResponseTimeRule` 
      - `com.netflix.loadbalancer.ResponseTimeWeightedRule` 



## IPing 可用性检查

- `com.netflix.loadbalancer.IPing` 
  - `com.netflix.loadbalancer.NoOpPing`



## ServerList 服务列表

- `com.netflix.loadbalancer.ServerList` 
  - `com.netflix.loadbalancer.AbstractServerList`
    - **ribbon-loadbalancer**: `com.netflix.loadbalancer.ConfigurationBasedServerList`
    - **ribbon-eureka**: `com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList` 
  - `org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList`
  - `org.springframework.cloud.netflix.ribbon.StaticServerList`



## ServerListFilter 服务列表过滤器

根据不同的规则，返回不同的服务列表

- `com.netflix.loadbalancer.ServerListFilter` 
  - `com.netflix.loadbalancer.AbstractServerListFilter`
    - `com.netflix.loadbalancer.ZoneAffinityServerListFilter`
      - `com.netflix.niws.loadbalancer.DefaultNIWSServerListFilter`
      - `com.netflix.loadbalancer.ServerListSubsetFilter`
      - `org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter`



## ILoadBalancer

- `com.netflix.loadbalancer.ILoadBalancer` 
  - `com.netflix.loadbalancer.AbstractLoadBalancer`
    - `com.netflix.loadbalancer.NoOpLoadBalancer`
    - `com.netflix.loadbalancer.BaseLoadBalancer`
      - `com.netflix.loadbalancer.DynamicServerListLoadBalancer`
        - `com.netflix.loadbalancer.ZoneAwareLoadBalancer`



## ServerListUpdater 更新本地服务列表

- `com.netflix.loadbalancer.ServerListUpdater` 
  - **ribbon-loadbalancer**: `com.netflix.loadbalancer.PollingServerListUpdater`
  - **ribbon-eureka**: `com.netflix.niws.loadbalancer.EurekaNotificationServerListUpdater`