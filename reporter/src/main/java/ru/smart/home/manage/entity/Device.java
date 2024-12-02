package ru.smart.home.manage.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "device")
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer typeId;
    @Column
    private Integer houseId;
    @Column
    private Integer modulesId;
    @Column
    private String serialNumber;
    @Column
    private String name;

}