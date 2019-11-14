package ua.delivery.model.service.implementation;

import ua.delivery.model.dao.AddressDao;
import ua.delivery.model.domain.Address;
import ua.delivery.model.service.AddressService;
import ua.delivery.model.service.mapper.AddressMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressDao addressDao, AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<Address> findAllByCity(String city) {
        return addressDao.findAllByCity(city).stream()
                .map(addressMapper::mapEntityToAddress)
                .collect(Collectors.toList());
    }
}
