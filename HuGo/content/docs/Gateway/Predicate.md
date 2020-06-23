# Predicate 谓词/断言

`Predicate` 用来匹配请求来源中的内容，如：Path、Header、Cookie 等，如果匹配，则执行后续的过滤规则。

## 实现

- **`RoutePredicateFactory`** (cloud.gateway.handler.predicate)
  - AbstractRoutePredicateFactory (cloud.gateway.handler.predicate)
    - `HeaderRoutePredicateFactory` (cloud.gateway.handler.predicate)
    - `PathRoutePredicateFactory` (cloud.gateway.handler.predicate)
    - BeforeRoutePredicateFactory (cloud.gateway.handler.predicate)
    - CloudFoundryRouteServiceRoutePredicateFactory 
    - `QueryRoutePredicateFactory` (cloud.gateway.handler.predicate)
    - `RemoteAddrRoutePredicateFactory` (cloud.gateway.handler.predicate)
    - MethodRoutePredicateFactory (cloud.gateway.handler.predicate)
    - `CookieRoutePredicateFactory` (cloud.gateway.handler.predicate)
    - WeightRoutePredicateFactory (cloud.gateway.handler.predicate)
    - AfterRoutePredicateFactory (cloud.gateway.handler.predicate)
    - BetweenRoutePredicateFactory (cloud.gateway.handler.predicate)
    - `HostRoutePredicateFactory` (cloud.gateway.handler.predicate)
    - ReadBodyPredicateFactory (cloud.gateway.handler.predicate)

## 编码方式

```java
// PredicateSpec 对 Predicate 的构造进行了封装
PredicateSpec predicateSpec = ...;

// 对应 HostRoutePredicateFactory
booleanSpec = predicateSpec.host("");
// 对应 PathRoutePredicateFactory
booleanSpec = predicateSpec.path("");
// 对应 CookieRoutePredicateFactory
booleanSpec = predicateSpec.cookie("");
```

这里可以看以看出一个规律， **PredicateName** + **RoutePredicateFactory**，接下的配置文件的方式，同样遵循



## 配置方式

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: http://example.org
        predicates:
        # Host 对用 HostRoutePredicateFactory
        - Host=**.somehost.org,**.anotherhost.org
      - id: host_route
        uri: http://example.org
        predicates:
        # Path 对用 PathRoutePredicateFactory
        - Path=/foo/{segment},/bar/{segment}
```

## 配置解析

### GatewayProperties

```java
package org.springframework.cloud.gateway.config;


@ConfigurationProperties("spring.cloud.gateway")
public class GatewayProperties {

	/**
	 * 路由配置
	 */
	private List<RouteDefinition> routes = new ArrayList<>();

	/**
	 * 针对所有路由的 过滤器
	 */
	private List<FilterDefinition> defaultFilters = new ArrayList<>();
  
  // ...
}
```

### RouteDefinition

```java
package org.springframework.cloud.gateway.route;

public class RouteDefinition {

	private String id;
  
  private URI uri;

  // 断言
	private List<PredicateDefinition> predicates = new ArrayList<>();

  // 过滤器
	private List<FilterDefinition> filters = new ArrayList<>();

	private Map<String, Object> metadata = new HashMap<>();

	private int order = 0;
}
```

### PredicateDefinition

```java
package org.springframework.cloud.gateway.handler.predicate;

public class PredicateDefinition {

	private String name;

	private Map<String, String> args = new LinkedHashMap<>();
  
  // ...

  // 对比: Path=/foo/{segment},/bar/{segment}
	public PredicateDefinition(String text) {
		int eqIdx = text.indexOf('=');
		if (eqIdx <= 0) {
			throw new ValidationException("Unable to parse PredicateDefinition text '"
					+ text + "'" + ", must be of the form name=value");
		}
    
    // Path
		setName(text.substring(0, eqIdx));

    // [ /foo/{segment} , /bar/{segment} ]
		String[] args = tokenizeToStringArray(text.substring(eqIdx + 1), ",");

    // _genkey_0 -> /foo/{segment}
    // _genkey_0 -> /bar/{segment}
		for (int i = 0; i < args.length; i++) {
			this.args.put(NameUtils.generateName(i), args[i]);
		}
	}
}
```

