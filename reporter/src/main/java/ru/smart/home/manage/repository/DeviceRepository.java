package ru.smart.home.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smart.home.manage.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
