package p2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Employee;
import p2.backend.Beans.Food;
import p2.backend.Service.AnimalService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/Animal")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/{name}")
    public Animal byAnimalName(@PathVariable String name){
        return animalService.byAnimal(name);
    }

    @GetMapping("/{id}")
    public Animal byAnimalID(@PathVariable Integer id){
        System.out.println(id);
        return animalService.byAnimalID(id);
    }
    @PostMapping("/empAnimals")
    public @ResponseBody ResponseEntity<Set<Animal>> animalsOfEmployees(@RequestBody Employee emp){
        Set<Animal> zoo = animalService.getAnimalsByEmployee(emp);
		/*ObjectMapper mapper = new ObjectMapper();
		Animal[] anArr = (Animal[]) zoo.toArray();
		*/
        return new ResponseEntity<Set<Animal>>(zoo,HttpStatus.OK);
    }

    @PostMapping("/topfive")
    public ResponseEntity<List<Animal>> topFive(){
        List<Animal> topFiveAnimals = new ArrayList<>();
        topFiveAnimals = animalService.getTopFiveAnimals();
        return new ResponseEntity<List<Animal>>(topFiveAnimals.subList(0,5),HttpStatus.FOUND);
    }

    @PostMapping("/increment")
    public void addAnimalLike(@RequestBody Integer id ){
        animalService.incrementCount(id);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<Set<Animal>> getAnimals(){
        return new ResponseEntity<Set<Animal>>(animalService.allAnimals(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public void saveAnimal(@RequestBody Animal save ){
        animalService.saveAnimal(save);
    }

    @PostMapping("/delete")
    public void deleteAnimal(@RequestBody Animal delete ){
        animalService.deleteAnimal(delete);
    }
}
