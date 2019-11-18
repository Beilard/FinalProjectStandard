package ua.delivery.model.service.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.AddressDao;
import ua.delivery.model.domain.Address;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.service.AddressService;
import ua.delivery.model.service.mapper.AddressMapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private static final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class);

    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressDao addressDao, AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }

    @Override
    public Set<String> findAllCities() {
        Set<String> result = addressDao.findAllCities();
        if (Objects.isNull(result)) {
            LOGGER.fatal("findAllCities method returns null");
            throw new EntityNotFoundException("The string set was null");
        }
        return result;
    }

    @Override
    public List<Address> findAllByCity(String city) {
        return addressDao.findAllByCity(city).stream()
                .map(addressMapper::mapEntityToAddress)
                .collect(Collectors.toList());
    }
}
