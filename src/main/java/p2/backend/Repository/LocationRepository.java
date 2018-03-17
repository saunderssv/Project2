package p2.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
