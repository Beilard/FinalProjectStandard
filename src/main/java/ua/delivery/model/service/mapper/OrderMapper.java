package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.Order;
import ua.delivery.model.domain.Route;
import ua.delivery.model.entity.OrderEntity;

public class OrderMapper {
    public Order mapEntityToOrder (OrderEntity orderEntity) {
        return Order.builder()
                .withId(orderEntity.getId())
                .withSenderId(orderEntity.getSenderId())
                .withRecipientName(orderEntity.getRecipientName())
                .withRecipientSurname(orderEntity.getRecipientSurname())
                .withPackageId(orderEntity.getPackageId())
                .withPaymentId(orderEntity.getPaymentId())
                .withRoute(orderEntity.getRoute())
                .build();
    }

    public OrderEntity mapOrderToEntity (Order order) {
        return OrderEntity.builder()
                .withId(order.getId())
                .withSenderId(order.getSenderId())
                .withRecipientName(order.getRecipientName())
                .withRecipientSurname(order.getRecipientSurname())
                .withPackageId(order.getPackageId())
                .withPaymentId(order.getPaymentId())
                .withRoute(order.getRouteId())
                .build();
    }
}
