package p2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import p2.backend.Beans.Animal;
import p2.backend.Service.AnimalService;

@RestController
@RequestMapping("/Animal")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @RequestMapping("/{name}")
    public Animal byAnimal(@PathVariable(value = "name") String name){
        return animalService.byAnimal(name);
    }

    @RequestMapping("/{id}")
    public Animal byAnimal(@PathVariable(value = "id") int id){
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
