package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByIdUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {
    @Bean
    public FindOrderByIdUseCase findOrderByIdUseCase(OrderGateway orderGateway) {
        return new FindOrderByIdUseCaseImpl(orderGateway);
    }
}
