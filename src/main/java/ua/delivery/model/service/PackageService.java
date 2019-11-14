package ua.delivery.model.service;

import ua.delivery.model.domain.Package;

import java.util.Optional;

public interface PackageService {
    void create();
    Optional<Package> update();
}
