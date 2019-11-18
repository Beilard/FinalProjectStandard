package ua.delivery.model.dao;

import ua.delivery.model.entity.AddressEntity;

import java.util.List;
import java.util.Set;

public interface AddressDao extends CrudDao<AddressEntity, Long> {
    List<AddressEntity> findAllByCity(String city);
    Set<String> findAllCities();
}
