package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.Order;
import ua.delivery.model.domain.Route;
import ua.delivery.model.entity.OrderEntity;

public class OrderMapper {
    public static Order mapEntityToOrder (OrderEntity orderEntity) {
        return Order.builder()
                .withId(orderEntity.getId())
                .withSenderId(orderEntity.getSenderId())
                .withReceiverId(orderEntity.getReceiverId())
                .withPackageId(orderEntity.getPackageId())
                .withPaymentId(orderEntity.getPaymentId())
                .withRoute(orderEntity.getRoute())
                .build();
    }

    public static OrderEntity mapOrderToEntity (Order order) {
        return OrderEntity.builder()
                .withId(order.getId())
                .withSenderId(order.getSenderId())
                .withReceiverId(order.getReceiverId())
                .withPackageId(order.getPackageId())
                .withPaymentId(order.getPaymentId())
                .withRoute(order.getRouteId())
                .build();
    }
}
