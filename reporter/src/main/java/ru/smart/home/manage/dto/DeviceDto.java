package ru.smart.home.manage.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class DeviceDto {
    @NonNull
    private Integer typeId;
    @NonNull
    private Integer houseId;
    @NonNull
    private Integer modulesId;
    @NonNull
    private String serialNumber;
    @NonNull
    private String name;
}