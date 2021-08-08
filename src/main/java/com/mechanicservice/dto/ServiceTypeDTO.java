package com.mechanicservice.dto;

import com.mechanicservice.model.ServiceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceTypeDTO {

    private String name;
    private String pictureURL;
    private int price;
    private String description;
    private String upperCaseName;

    public ServiceTypeDTO(ServiceType serviceType) {
        serviceTypeToDTO(serviceType);
    }

    public void serviceTypeToDTO(ServiceType serviceType) {
        name = serviceType.name;
        pictureURL = serviceType.pictureURL;
        price = serviceType.price;
        description = serviceType.description;
        upperCaseName = serviceType.upperCaseName;
    }
}
