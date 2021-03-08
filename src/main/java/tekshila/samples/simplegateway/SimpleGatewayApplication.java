package tekshila.samples.simplegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleGatewayApplication.class, args);
    }

    /*
     * Define a bean for route location
     * Builder pattern to create routes
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Add a simple re-route from: /get to: http://httpbin.org:80
                // Add a simple "Hello:World" HTTP Header
                .route(p -> p
                        .path("/tekshila") // intercept calls to the /get path
                        .filters(f -> f.addRequestHeader("Hello", "World")) // add header
                        .uri("http://www.tekshila.com")) // forward to httpbin
                .build();
    }

}
