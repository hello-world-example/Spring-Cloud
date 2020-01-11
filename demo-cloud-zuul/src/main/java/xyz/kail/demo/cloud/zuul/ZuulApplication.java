package xyz.kail.demo.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * `@EnableZuulProxy` 简单理解为 @EnableZuulServer 的增强版
 * 当 Zuul 与 Eureka、Ribbon 等组件配合使用时，我们使用 @EnableZuulProxy
 *
 * @link https://www.cnblogs.com/lexiaofei/p/7098702.html
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
