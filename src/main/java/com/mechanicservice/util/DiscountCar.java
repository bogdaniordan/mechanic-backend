package com.mechanicservice.util;

import java.util.List;
import java.util.Random;

public class DiscountCar {
    private static final Random RANDOM = new Random();

    private static final List<String> carBrands = List.of("Dacia", "Rolls Royce", "Lamborghini");

    private static final String randomCarBrand = carBrands.get(RANDOM.nextInt(carBrands.size()));

    public static String getRandomCarBrand () {
        return randomCarBrand;
    }
}
