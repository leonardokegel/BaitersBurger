package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.DeleteProductUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.DeleteProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.interfaceadapters.gateway.ProductGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductConfig {
    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductGateway productGateway){
        return new DeleteProductUseCaseImpl(productGateway);
    }
}
