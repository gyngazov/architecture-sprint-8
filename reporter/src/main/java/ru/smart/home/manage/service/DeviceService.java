package ru.smart.home.manage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smart.home.manage.dto.DeviceDto;
import ru.smart.home.manage.dto.Mapper;
import ru.smart.home.manage.entity.Device;
import ru.smart.home.manage.repository.DeviceRepository;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final HttpClient httpClient;

    public void save(DeviceDto data) {

        Device device = deviceRepository.save(Mapper.map(data));
        httpClient.post(device.getId(), data);
    }

}
