package p2.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import p2.backend.Beans.*;
import p2.backend.Repository.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder(15);
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    LocationRepository locationRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        //Create all the Animals
        Animal lion = new Animal("Lion","Panthera leo","A lion may sleep up to 20 hours a day.","Lions are Cool",9,0);
        Animal panda = new Animal("Giant Panda","Ailuropoda melanoleuca","Pandas are known to have an excellent sense of smell and night vision.","Pandas are Cool",6,0);
        Animal meerkat = new Animal("Meerkat","Suricata suricatta","Meerkats live in big groups called mobs, gangs or clans.","Meerkats are Cool",33,0);
        Animal manedWolf = new Animal("Maned wolf","Chrysocyon brachyurus","The maned wolf is the largest canid of South America.","Maned wolfs are Cool",12,0);
        Animal asianOtter = new Animal("Asian Otter","Amblonyx cinereus","Smallest of all the Otter species.","Asian Otters are Cool",15,0);

        //Create all the Employee
        String password = bCryptPasswordEncoder().encode("admin");
        Employee noop = new Employee("Navroop","Hundal","NoopDog",password,0);
        Employee spencer = new Employee("Spencer","Saunders","SSaunders",password,0);
        Employee brenton = new Employee("Brenton","Poke","Bpoke",password,0);
        Employee jose = new Employee("Jose", "Soria","Jsoria",password,0);
        Employee semeon = new Employee("Semeon","Barros","A R De",password,0);
        Employee terrell = new Employee("Terrell","Moses","Tmoses",password,0);
        Employee florina= new Employee("Florina","Singson","Fsingson",password,0);

        // Create all the Events
        Events one = new Events("Breakfast with Orangutan", "Kampung Sumatra","8:00 AM - 9:30 AM");
        Events two = new Events("Elephants Bathing", "Elephant Pool", "8:45 AM - 9:00 AM");
        Events three = new Events("Short Animal Presenation", "Gaya Restaurant", "9:00 AM - 9:15 AM");
        Events four = new Events("Animal Presentation", "Kampung Sumatra Stage", "10:00 AM - 10:20 AM");
        Events five = new Events("The Exotica Wildlife Education", "Green Stage", "11:15 AM - 11:45 AM");
        Events six = new Events("Tiger Keeper Talk", "Tiger Exhibit", "11:45 AM - 12:00 PM");
        Events seven = new Events("Lemur Keeper Talk", "Aviary", "12:15 PM - 12:30 PM");
        Events eight = new Events("Animal Encounter", "Elephant View Restaurant", "1:00 PM - 2:00 PM");

        // Create all the Food
        Food rawFish = new Food("Raw Fish",300);
        Food rawMeat = new Food("Raw Meat",400);
        Food carrots = new Food("carrots",200);

        // Create all the Locations
        Location lLion = new Location(10.21,12.12,lion);
        Location lPanda = new Location(20.12,30.13,panda);
        Location lMeerkat = new Location(30.12,21.12,meerkat);
        Location lManedWolf = new Location(12.20,12.20,manedWolf);
        Location lAsianOtter = new Location(12.23,2.12,asianOtter);


        //save them all
        animalRepository.save(lion);
        animalRepository.save(panda);
        animalRepository.save(meerkat);
        animalRepository.save(manedWolf);
        animalRepository.save(asianOtter);

        employeeRepository.save(noop);
        employeeRepository.save(spencer);
        employeeRepository.save(brenton);
        employeeRepository.save(jose);
        employeeRepository.save(semeon);
        employeeRepository.save(terrell);
        employeeRepository.save(florina);

        eventsRepository.save(one);
        eventsRepository.save(two);
        eventsRepository.save(three);
        eventsRepository.save(four);
        eventsRepository.save(five);
        eventsRepository.save(six);
        eventsRepository.save(seven);
        eventsRepository.save(eight);

        foodRepository.save(rawFish);
        foodRepository.save(rawMeat);
        foodRepository.save(carrots);

        locationRepository.save(lLion);
        locationRepository.save(lPanda);
        locationRepository.save(lMeerkat);
        locationRepository.save(lManedWolf);
        locationRepository.save(lAsianOtter);

        //Create links between everything
        // food animal link
        Set<Food> food = new HashSet<>();
        food.add(rawFish);
        food.add(rawMeat);

        lion.setFood(food);

        Set<Animal> animals = new HashSet<>();
        animals.add(lion);

        rawFish.setAnimalFood(animals);
        rawMeat.setAnimalFood(animals);

        animalRepository.save(lion);
        foodRepository.save(rawFish);
        foodRepository.save(rawMeat);

        // Animal to Employee
        Set<Animal> animalsToEmployee = new HashSet<>();
        Set<Employee> employeetoAnimals = new HashSet<>();

        animalsToEmployee.add(panda);
        employeetoAnimals.add(jose);
        employeetoAnimals.add(florina);

        jose.setAnimals(animalsToEmployee);
        florina.setAnimals(animalsToEmployee);

        panda.setEmployees(employeetoAnimals);

        employeeRepository.save(jose);
        employeeRepository.save(florina);
        animalRepository.save(panda);
    }
}


