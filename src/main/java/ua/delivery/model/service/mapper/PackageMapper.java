package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.Package;
import ua.delivery.model.entity.PackageEntity;

public class PackageMapper {
    public static PackageEntity mapEntityToPackage(Package packageObj) {
        return new PackageEntity(packageObj.getId(), packageObj.getType(), packageObj.getWeight());
    }

    public static Package mapEntityToPackage (PackageEntity packageObj) {
        return new Package(packageObj.getId(), packageObj.getType(), packageObj.getWeight());
    }
}
