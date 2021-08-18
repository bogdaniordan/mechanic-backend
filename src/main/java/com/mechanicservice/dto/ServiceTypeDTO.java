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
    private int durationInDays;

    public ServiceTypeDTO(ServiceType serviceType) {
        serviceTypeToDTO(serviceType);
    }

    public void serviceTypeToDTO(ServiceType serviceType) {
        name = serviceType.getName();
        pictureURL = serviceType.getPictureURL();
        price = serviceType.getPrice();
        description = serviceType.getDescription();
        upperCaseName = serviceType.getUpperCaseName();
        durationInDays = serviceType.getDurationInDays();
    }
}
