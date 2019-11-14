package ua.delivery.model.dao;

import ua.delivery.model.domain.Address;
import ua.delivery.model.entity.AddressEntity;

import java.util.List;

public interface AddressDao extends CrudDao<AddressEntity, Long> {
    List<AddressEntity> findAllByCity(String city);
}
