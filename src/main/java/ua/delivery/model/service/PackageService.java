package ua.delivery.model.service;

import ua.delivery.model.domain.Package;

import java.util.Optional;

public interface PackageService {
    void create(Package pack);

    Optional<Package> findById(Long id);

    void update(Package pack);
}
