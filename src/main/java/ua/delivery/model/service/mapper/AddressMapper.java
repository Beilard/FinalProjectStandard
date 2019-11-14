package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.Address;
import ua.delivery.model.entity.AddressEntity;

public class AddressMapper {
    public AddressEntity mapAddressToEntity(Address address) {
        return new AddressEntity(address.getId(), address.getCity(), address.getStreet(), address.getBuildingNumber());
    }

    public Address mapEntityToAddress(AddressEntity addressEntity) {
        return new Address(addressEntity.getId(), addressEntity.getCity(), addressEntity.getStreet(), addressEntity.getBuildingNumber());
    }
}
