package com.mechanicservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceTypeDTO {

    private String name;
    private String pictureURL;
    private int price;
    private String description;

    public ServiceTypeDTO(ServiceType serviceType) {
        serviceTypeToDTO(serviceType);
    }

    public void serviceTypeToDTO(ServiceType serviceType) {
        name = serviceType.name;
        pictureURL = serviceType.pictureURL;
        price = serviceType.price;
        description = serviceType.description;
    }
}
