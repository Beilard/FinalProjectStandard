package ua.delivery.model.service.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.PackageDao;
import ua.delivery.model.domain.Package;
import ua.delivery.model.entity.PackageEntity;
import ua.delivery.model.exception.ObjectNotFoundException;
import ua.delivery.model.service.PackageService;
import ua.delivery.model.service.mapper.PackageMapper;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

public class PackageServiceImpl implements PackageService {
    private static final Logger LOGGER = Logger.getLogger(PackageServiceImpl.class);

    private final PackageDao packageDao;
    private final PackageMapper packageMapper;

    public PackageServiceImpl(PackageDao packageDao, PackageMapper packageMapper) {
        this.packageDao = packageDao;
        this.packageMapper = packageMapper;
    }

    @Override
    public void create(Package pack) {
        if (Objects.isNull(pack)) {
            LOGGER.warn("Passed package is null");
            throw new ObjectNotFoundException("Passed object is null");
        }
        packageDao.save(packageMapper.mapPackageToEntity(pack));
    }

    @Override
    public void update(Package pack) {
        if (Objects.isNull(pack)) {
            LOGGER.warn("Passed package is null");
            throw new ObjectNotFoundException("Passed object is null");
        }
        packageDao.update(packageMapper.mapPackageToEntity(pack));
    }

    @Override
    public Optional<Package> findById(Long id) {
        if (Objects.isNull(id)) {
            LOGGER.warn("Passed id is null");
            throw new ObjectNotFoundException("Passed object is null");
        }
        return Optional.of(packageMapper.mapEntityToPackage(packageDao.findById(id).get()));
    }
}
