package p2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Food;
import p2.backend.Service.AnimalService;

@CrossOrigin
@RestController
@RequestMapping("/Animal")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Animal byAnimalName(@RequestParam(value = "name") String name){
        return animalService.byAnimal(name);
    }

    @GetMapping("/{id}")
    public Animal byAnimalID(@PathVariable Integer id){
        System.out.println(id);
        return animalService.byAnimalID(id);
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
