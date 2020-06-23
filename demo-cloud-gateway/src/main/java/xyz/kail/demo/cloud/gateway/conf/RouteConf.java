package xyz.kail.demo.cloud.gateway.conf;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class RouteConf {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("baidu_route", new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                return predicateSpec.path("/baidu/**")
                        .filters(f -> f.rewritePath("/baidu/(?<segment>.*)", "/${segment}"))
                        .uri("https://www.baidu.com/");

            }
        });

        /**
         * 路径路由
         */
        routes.route("path_route", r -> r.path("/get").uri("http://httpbin.org"));

        /**
         * 域名路由
         */
        routes.route("host_route", r -> r.host("*.myhost.org").uri("http://httpbin.org"));

        /**
         * path 重写
         */
        routes.route("rewrite_route", r ->
                r.host("*.rewrite.org")
                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
                        .uri("http://httpbin.org"));

//        routes.route("hystrix_route", r -> r.host("*.hystrix.org")
//                .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
//                .uri("http://httpbin.org"));

//        routes.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
//                .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
//                .uri("http://httpbin.org"));

//				.route("limit_route", r -> r
//                        .host("*.limited.org").and().path("/anything/**")
//                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
//                        .uri("http://httpbin.org"))


        return routes.build();
    }
}