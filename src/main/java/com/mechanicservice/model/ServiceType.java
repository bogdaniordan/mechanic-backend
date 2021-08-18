package com.mechanicservice.model;

import java.util.Random;

public enum ServiceType {
    OIL_CHANGE("Oil change, filters and lube", "https://cdn11.bigcommerce.com/s-ycu4zkmhpl/images/stencil/830x518/uploaded_images/oil-change-101.jpg?t=1561563671", 100, "An engine consists of many moving parts such as pistons and valves. Your engine oil’s lubricating properties help to protect these parts by reducing friction. After the recommended oil change interval, engine oil will deteriorate and will not be able to fully protect the components from friction which will lead to wear and damage.", "OIL_CHANGE", 1),
    ENGINE_REPAIR("Engine repair", "https://www.indoormedia.com/wp-content/uploads/2019/10/marketing-ideas-for-auto-repair.jpg", 1200, "The engine is a sensitive piece of machinery, powering your vehicle to get you from point A to point B. Modern engines are also referred to as internal combustion engines; they work by heating and combusting fuel inside to move your vehicle by powering pistons. The main outer portion of the engine is called the engine block, it is a large structure with large cylinders where the pistons can move inside as the engine is powered. Cylinders, and other passages built into the engine, allow coolant to flow, which in turn, cools the engine as it works.", "ENGINE_REPAIR", 5),
    AIR_CONDITIONING_SYSTEM("Air conditioning systems", "https://miro.medium.com/max/1094/1*_7Pa-1dcnfDAoTscDPmRIw.png", 299, "Air conditioning like it says 'conditions' the air. It not only cools it down, but also reduces the moisture content, or humidity. All air conditioners work the same way whether they are installed in a building, or in a car. The fridge or freezer is in a way an air conditioner as well. Air conditioning is a field in it's own right, but we'll stick to the main points or a car's air conditioning and the main parts used and a few hints to keep the air-con system running properly.", "AIR_CONDITIONING_SYSTEM", 2),
    POWER_STEERING_SYSTEM("Power steering system", "https://oldmillautos.com/wp-content/uploads/2020/03/Vehicle-Servicing.jpg", 150, "Power steering helps the driver of a vehicle to steer by directing some of the its power to assist in swivelling the steered roadwheels about their steering axes. As vehicles have become heavier and switched to front wheel drive, particularly using negative offset geometry, along with increases in tire width and diameter, the effort needed to turn the wheels about their steering axis has increased, often to the point where major physical exertion would be needed were it not for power assistance.", "POWER_STEERING_SYSTEM", 4);

    private String name;
    private String pictureURL;
    private int price;
    private String description;
    private String upperCaseName;
    private int durationInDays;

    private static final Random RANDOM = new Random();

    ServiceType(String name, String pictureURL, int price, String description, String upperCaseName, int durationInDays) {
        this.name = name;
        this.pictureURL = pictureURL;
        this.price = price;
        this.description = description;
        this.upperCaseName = upperCaseName;
        this.durationInDays = durationInDays;
    }

    public static ServiceType getRandomServiceType() {
        var values = ServiceType.values();
        return values[RANDOM.nextInt(values.length)];
    }

    public String getName() {
        return name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getUpperCaseName() {
        return upperCaseName;
    }

    public int getDurationInDays() {
        return durationInDays;
    }
}
