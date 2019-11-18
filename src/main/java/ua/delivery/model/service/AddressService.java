package ua.delivery.model.service;

import ua.delivery.model.domain.Address;

import java.util.List;
import java.util.Set;

public interface AddressService {
    Set<String> findAllCities();

    List<Address> findAllByCity(String city);
}
