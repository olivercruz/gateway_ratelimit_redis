package api.com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import api.com.gateway.config.limit.IpKeyResolver;


@Configuration
public class GatewayConfig {

    @Bean
    public IpKeyResolver ipKeyResolver() {
        return new IpKeyResolver();
    }
}
