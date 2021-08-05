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
        Mechanic mechanic =  new Mechanic("Nea Marin", ServiceType.ENGINE_REPAIR, "Best diesel engine mechanic. He has been repairing diesel since he was 2 days old and he drives like a retard.");
        Mechanic mechanic1 =  new Mechanic("Nea Bebe", ServiceType.ENGINE_REPAIR, "A mechanic is responsible for inspecting and repairing vehicles, machinery, and light trucks.Conducting routine maintenance work aiming to vehicle functionality and longevity.");
        Mechanic mechanic2 =  new Mechanic("Nea Mircea", ServiceType.OIL_CHANGE, "An excellent auto mechanic has good eye-hand coordination and manual dexterity. They are well-versed in complex mechanical or electronical systems of vehicles and have excellent problem-solving abilities.");
        Mechanic mechanic3 =  new Mechanic("Nea Dani", ServiceType.AIR_CONDITIONING_SYSTEM, "Keeps equipment available for use by inspecting and testing vehicles; completing preventive maintenance such as, engine tune-ups, oil changes, tire rotation and changes, wheel balancing, replacing filters.");
        Car car = new Car("dacia", RepairedStatus.BROKEN, ServiceType.ENGINE_REPAIR, FuelType.DIESEL, "http://simplybucharest.ro/wp-content/uploads/2011/10/1300.jpg");
        car.assignMechanic(mechanic);
        Customer customer = new Customer("Bodgan Iordan", "bogdan.iordan@yahoo.com", "0224342325", "Plutasilor", "Bucale", "https://asport.ro/wp-content/uploads/2021/01/gigi-becali.jpg", "software dev", "Male");
        Customer otherCustomer = new Customer("Gigi Becali", "becali@gmail","928329", "Antareestrat", "4343", "https://asport.ro/wp-content/uploads/2021/01/gigi-becali.jpg", "software dev", "Not sure");
        Car secondCar = new Car("renault", RepairedStatus.BROKEN, ServiceType.POWER_STEERING_SYSTEM, FuelType.ELECTRIC, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-lamborghini-urus-mmp-1-1592423712.jpg?crop=1xw:0.84375xh;center,top&resize=480:*");
        Car thirdCar = new Car("Audi Q8", RepairedStatus.REPAIRED, ServiceType.OIL_CHANGE, FuelType.DIESEL, "https://www.auto-bild.ro/wp-content/uploads/2020/10/Audi-Q8-plug-in-hybrid-9.jpg");
        customer.setCars(List.of(car, secondCar, thirdCar));
        // trebuia sa pun list of si nu add car pt ca nu era initalizata la inceput lista cu un list of
//        CarService carService = new CarService(ServiceType.ENGINE_REPAIR, new Date());
//        carService.assignCar(car);
        mechanic.addPicture("https://thumbor.unica.ro/unsafe/980x600/smart/filters:contrast(1):quality(80)/https://tvmania.ro/wp-content/uploads/2020/12/Nea-Marin-1.jpg");
        mechanic1.addPicture("https://agrointel.ro/wp-content/uploads/2016/07/Adrian-Porumboiu-a-vandut-Comcereal.jpg");
        mechanic2.addPicture("https://static.playtech.ro/stiri/wp-content/uploads/2020/10/florin-salam-840x500.jpg");
        mechanic3.addPicture("https://media.bzi.ro/unsafe/1060x600/smart/filters:contrast(3):format(jpeg):blur(1):quality(80)/http://www.bzi.ro/wp-content/uploads/1/257/Nicolae_Gutas.jpg");
//        carService.assignMechanic(mechanic);
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
        carRepository.save(thirdCar);
        customerRepository.save(customer);
        customerRepository.save(otherCustomer);
//        serviceRepository.save(carService);

        testimonialRepository.save(testimonial1);
        testimonialRepository.save(testimonial);



    }
}
