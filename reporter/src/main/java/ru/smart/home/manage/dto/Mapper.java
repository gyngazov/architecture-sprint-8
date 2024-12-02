package ru.smart.home.manage.dto;

import ru.smart.home.manage.entity.Device;

public class Mapper {

    public static Device map(DeviceDto dto) {
        Device d = new Device();
        d.setTypeId(dto.getTypeId());
        d.setHouseId(dto.getHouseId());
        d.setModulesId(dto.getModulesId());
        d.setSerialNumber(dto.getSerialNumber());
        d.setName(dto.getName());
        return d;
    }
}
