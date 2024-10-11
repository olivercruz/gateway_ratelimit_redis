package api.com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SpringSecurityConfig {

    @Bean
    SecurityWebFilterChain webHttpSecurity(ServerHttpSecurity http) {                       
        http
            .authorizeExchange((exchanges) -> exchanges
                .pathMatchers("/todos/1").permitAll()
                .anyExchange().authenticated()
            )
            ;                                                     
        return http.build();
    }
}