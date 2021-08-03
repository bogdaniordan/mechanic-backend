package com.mechanicservice.data;

import com.mechanicservice.model.*;
import com.mechanicservice.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final MechanicRepository mechanicRepository;
    private final ServiceRepository serviceRepository;
    private final TestimonialRepository testimonialRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Mechanic mechanic =  new Mechanic("Nea Marin", ServiceType.ENGINE_REPAIR);
        Mechanic mechanic1 =  new Mechanic("Nea Bebe", ServiceType.ENGINE_REPAIR);
        Mechanic mechanic2 =  new Mechanic("Nea Mircea", ServiceType.OIL_CHANGE);
        Mechanic mechanic3 =  new Mechanic("Nea Dani", ServiceType.AIR_CONDITIONING_SYSTEM);
        Car car = new Car("dacia", RepairedStatus.BROKEN, ServiceType.ENGINE_REPAIR, FuelType.DIESEL);
        car.assignMechanic(mechanic);
        Customer customer = new Customer("Bodgan Iordan", "bogdan.iordan@yahoo.com", "0224342325", "Plutasilor", "Bucale", "https://asport.ro/wp-content/uploads/2021/01/gigi-becali.jpg");
        Customer otherCustomer = new Customer("Gigi Becali", "becali@gmail","928329", "Antareestrat", "4343", "https://asport.ro/wp-content/uploads/2021/01/gigi-becali.jpg");
        Car secondCar = new Car("renault", RepairedStatus.BROKEN, ServiceType.POWER_STEERING_SYSTEM, FuelType.ELECTRIC);
        customer.setCars(List.of(car, secondCar));
        // trebuia sa pun list of si nu add car pt ca nu era initalizata la inceput lista cu un list of
        CarService carService = new CarService(ServiceType.ENGINE_REPAIR, new Date());
        carService.assignCar(car);
        mechanic.addPicture("https://thumbor.unica.ro/unsafe/980x600/smart/filters:contrast(1):quality(80)/https://tvmania.ro/wp-content/uploads/2020/12/Nea-Marin-1.jpg");
        mechanic1.addPicture("https://agrointel.ro/wp-content/uploads/2016/07/Adrian-Porumboiu-a-vandut-Comcereal.jpg");
        carService.assignMechanic(mechanic);
        List<String> lst = List.of("ROLE_USER");
        User user = new User("bogdan", "iordan" , "bogdan", BCrypt.hashpw("1234", BCrypt.gensalt(12)), lst);
        User otherUser = new User("becali", "gigi", "becali", BCrypt.hashpw("steaua", BCrypt.gensalt(12)), lst);
        customer.setUser(user);
        otherCustomer.setUser(otherUser);
        Testimonial testimonial = new Testimonial(Rating.VERY_SATISFIED, "Nu bate nu troncane sa moaara mama", ServiceType.OIL_CHANGE);
        Testimonial testimonial1 = new Testimonial(Rating.BAD, "A spart toba sa moara bibi", ServiceType.AIR_CONDITIONING_SYSTEM);

        testimonial1.setCar(car);
        testimonial1.setCustomer(customer);
        testimonial1.setMechanic(mechanic3);

        testimonial.setCar(car);
        testimonial.setCustomer(customer);
        testimonial.setMechanic(mechanic3);



        userRepository.save(user);
        userRepository.save(otherUser);
        mechanicRepository.save(mechanic);
        mechanicRepository.save(mechanic1);
        mechanicRepository.save(mechanic2);
        mechanicRepository.save(mechanic3);

        carRepository.save(car);
        carRepository.save(secondCar);
        customerRepository.save(customer);
        customerRepository.save(otherCustomer);
        serviceRepository.save(carService);

        testimonialRepository.save(testimonial1);
        testimonialRepository.save(testimonial);



    }
}
