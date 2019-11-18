package ua.delivery.model.service.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.OrderDao;
import ua.delivery.model.domain.Order;
import ua.delivery.model.exception.ObjectNotFoundException;
import ua.delivery.model.service.OrderService;
import ua.delivery.model.service.mapper.OrderMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    private final OrderDao orderDao;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderDao orderDao, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.orderMapper = orderMapper;
    }

    @Override
    public void createOrder(Order order) {
        if (Objects.isNull(order)){
            LOGGER.warn("Failed to create order");
            throw new ObjectNotFoundException("Null order provided");
        }
        orderDao.save(orderMapper.mapOrderToEntity(order));
    }

    @Override
    public List<Order> displayAllBySender(Long id) {
        if (Objects.isNull(id)) {
            LOGGER.warn("Null ID passed to displayAllBySender");
            throw new ObjectNotFoundException("Null ID passed to displayAllBySender");
        }
        return orderDao.findAllBySender(id).stream()
                .map(orderMapper::mapEntityToOrder)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> displayAll() {
        return orderDao.findAll().stream()
                .map(orderMapper::mapEntityToOrder)
                .collect(Collectors.toList());
    }
}
