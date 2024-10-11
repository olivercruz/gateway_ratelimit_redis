package api.com.gateway.config.limit;

import java.net.InetSocketAddress;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class IpKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        InetSocketAddress remoteAddress = exchange.getRequest().getRemoteAddress();
        if (remoteAddress != null) {
            String ipAddress = remoteAddress.getAddress().getHostAddress();
            System.out.println("IP Address: " + ipAddress);
            return Mono.just(ipAddress);
        } else {
            System.out.println("Remote address is null");
            return Mono.empty();
        }
    }

}
