package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.Package;
import ua.delivery.model.entity.PackageEntity;

public class PackageMapper {
    public PackageEntity mapPackageToEntity(Package packageObj) {
        return new PackageEntity(packageObj.getId(), packageObj.getType(), packageObj.getWeight());
    }

    public Package mapEntityToPackage (PackageEntity packageObj) {
        return new Package(packageObj.getId(), packageObj.getType(), packageObj.getWeight());
    }
}
