package p2.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal,Integer> {

    Animal findAnimalByAnimalName(String name);

    Animal findAnimalByAnimalId(int id);

}
