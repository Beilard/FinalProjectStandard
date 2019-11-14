package ua.delivery.model.service;

import ua.delivery.model.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllByCity(String city);
}
