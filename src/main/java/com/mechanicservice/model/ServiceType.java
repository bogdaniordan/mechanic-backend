package com.mechanicservice.model;

public enum ServiceType {
    OIL_CHANGE("https://cdn11.bigcommerce.com/s-ycu4zkmhpl/images/stencil/830x518/uploaded_images/oil-change-101.jpg?t=1561563671", 100, "Changing old oil with a new high quality oil car."),
    ENGINE_REPAIR("https://www.indoormedia.com/wp-content/uploads/2019/10/marketing-ideas-for-auto-repair.jpg", 1200, "Replacing all broken engine parts."),
    BUMPER_REPLACEMENT("https://miro.medium.com/max/1094/1*_7Pa-1dcnfDAoTscDPmRIw.png", 299, "Replacing front or back bumpers."),
    SAFETY_CHECK("https://oldmillautos.com/wp-content/uploads/2020/03/Vehicle-Servicing.jpg", 150, "General car safety check.");

    public String pictureURL;

    public int price;

    public String description;

    ServiceType(String pictureURL, int price, String description) {
        this.pictureURL = pictureURL;
        this.price = price;
        this.description = description;
    }
}
