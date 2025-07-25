package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.port.in.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;

public class UpdateOrderStatusUseCaseImpl implements UpdateOrderStatusUseCase {
    private final OrderGateway orderDataSource;

    public UpdateOrderStatusUseCaseImpl(OrderGateway orderGateway) {
        this.orderDataSource = orderGateway;
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        var order = orderDataSource.findById(orderId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.ORDER_NOT_FOUND));

        order.setStatus(status);
        orderDataSource.updateStatus(order);
    }
}
