package com.mechanicservice.data;

import com.mechanicservice.enums.FuelType;
import com.mechanicservice.enums.Rating;
import com.mechanicservice.enums.RepairedStatus;
import com.mechanicservice.model.*;
import com.mechanicservice.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final MechanicRepository mechanicRepository;
    private final TestimonialRepository testimonialRepository;
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final MessageRepository messageRepository;

    @Override
    public void run(String... args) throws Exception {
        Mechanic mechanic =  new Mechanic("Nea Marin", ServiceType.ENGINE_REPAIR, "nea_marin.jpg","Best diesel engine mechanic. He has been repairing diesel since he was 2 days old and he drives like a retard.", 50, 35, 80, 40, 70, "07423929327", "Junior Mechanic");
//        mechanic.setEmail("nea_marin@gmail.com");
        mechanic.setPassword(BCrypt.hashpw("password", BCrypt.gensalt(12)));
        mechanic.setRoles(List.of("ROLE_USER", "ROLE_ADMIN"));
        Mechanic mechanic1 =  new Mechanic("Nea Bebe", ServiceType.ENGINE_REPAIR, "nea_bebe.jpg","A mechanic is responsible for inspecting and repairing vehicles, machinery, and light trucks.Conducting routine maintenance work aiming to vehicle functionality and longevity.", 90, 70, 50, 70, 90, "07232441244", "Senior Mechanic");
        Mechanic mechanic2 =  new Mechanic("Nea Pepe", ServiceType.OIL_CHANGE, "nea_pepe.jpg","An excellent auto mechanic has good eye-hand coordination and manual dexterity. They are well-versed in complex mechanical or electronical systems of vehicles and have excellent problem-solving abilities.", 50, 60, 44, 67, 39, "0726949494", "Mid-level Mechanic");
        Mechanic mechanic3 =  new Mechanic("Nea Smiley", ServiceType.AIR_CONDITIONING_SYSTEM, "nea_smiley.jpg", "Keeps equipment available for use by inspecting and testing vehicles; completing preventive maintenance such as, engine tune-ups, oil changes, tire rotation and changes, wheel balancing, replacing filters.", 60, 70, 80, 90, 99, "072129879", "DevOps Mechanic");
        Car car = new Car("Dacia", RepairedStatus.BROKEN, ServiceType.ENGINE_REPAIR, FuelType.DIESEL, "dacia.jpg");
        car.assignMechanic(mechanic);
        Customer customer = new Customer("Bodgan Iordan", "bogdan.iordan@yahoo.com", "0224342325", "Plutasilor", "Bucale", "sergei.jpg", "software dev", "Male", 25);
        Customer otherCustomer = new Customer("Gigi Becali", "becali@gmail","928329", "Antareestrat", "4343", "https://asport.ro/wp-content/uploads/2021/01/gigi-becali.jpg", "software dev", "Not sure", 25);
        Car secondCar = new Car("Rolls Royce", RepairedStatus.BROKEN, ServiceType.POWER_STEERING_SYSTEM, FuelType.ELECTRIC, "lambo.jpg");
        Car thirdCar = new Car("Audi Q8", RepairedStatus.REPAIRED, ServiceType.OIL_CHANGE, FuelType.DIESEL, "audi.jpg");
        customer.setCars(List.of(car, secondCar, thirdCar));
        // trebuia sa pun list of si nu add car pt ca nu era initalizata la inceput lista cu un list of
//        CarService carService = new CarService(ServiceType.ENGINE_REPAIR, new Date());
//        carService.assignCar(car);
//        mechanic.addPicture("https://thumbor.unica.ro/unsafe/980x600/smart/filters:contrast(1):quality(80)/https://tvmania.ro/wp-content/uploads/2020/12/Nea-Marin-1.jpg");
//        mechanic1.addPicture("https://agrointel.ro/wp-content/uploads/2016/07/Adrian-Porumboiu-a-vandut-Comcereal.jpg");
//        mechanic2.addPicture("https://static.playtech.ro/stiri/wp-content/uploads/2020/10/florin-salam-840x500.jpg");
//        mechanic3.addPicture("https://media.bzi.ro/unsafe/1060x600/smart/filters:contrast(3):format(jpeg):blur(1):quality(80)/http://www.bzi.ro/wp-content/uploads/1/257/Nicolae_Gutas.jpg");
//        carService.assignMechanic(mechanic);
        List<String> lst = List.of("ROLE_USER");
        User user = new User("bogdan", "iordan" , "bogdan", BCrypt.hashpw("1234", BCrypt.gensalt(12)), lst);
        User otherUser = new User("becali", "gigi", "becali", BCrypt.hashpw("steaua", BCrypt.gensalt(12)), lst);
        customer.setUser(user);
        otherCustomer.setUser(otherUser);
        Testimonial testimonial = new Testimonial(Rating.VERY_SATISFIED, "Nu bate nu troncane sa moaara mama", ServiceType.OIL_CHANGE);
        Testimonial testimonial1 = new Testimonial(Rating.BAD, "A spart toba sa moara bibi", ServiceType.AIR_CONDITIONING_SYSTEM);
        Testimonial testimonial2 = new Testimonial(Rating.BAD, "A rupt-on 2 beee", ServiceType.OIL_CHANGE);
        Testimonial testimonial3 = new Testimonial(Rating.GOOD, "A rupt-on 5 beee", ServiceType.AIR_CONDITIONING_SYSTEM);
        testimonial2.setMechanic(mechanic);
        testimonial3.setMechanic(mechanic);
        testimonial2.setCustomer(customer);
        testimonial3.setCustomer(customer);

        Appointment appointment = new Appointment(ServiceType.AIR_CONDITIONING_SYSTEM, LocalDate.now().toString(), "11:21", "N-o zgaria k te sparg!");
        appointment.setMechanic(mechanic);
        appointment.setCustomer(customer);
        appointment.setCar(car);

        Message message = new Message("customer", "Sa ii dai blana!", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        Message message1 = new Message("mechanic", "II dau blana sa moara frantzaaa!", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        messageRepository.save(message);
        messageRepository.save(message1);

        appointment.addMessage(message);
        appointment.addMessage(message1);


        Appointment appointment1 = new Appointment(ServiceType.OIL_CHANGE, LocalDate.now().toString(), "11:21", "Baga ulei k te sparg!");
        appointment1.setMechanic(mechanic);
        appointment1.setCustomer(customer);
        appointment1.setCar(car);


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
        testimonialRepository.save(testimonial2);
        testimonialRepository.save(testimonial3);


        appointmentRepository.save(appointment);
        appointmentRepository.save(appointment1);







    }
}
