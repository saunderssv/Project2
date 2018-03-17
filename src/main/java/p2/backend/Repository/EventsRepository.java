package p2.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Events;

@Repository
public interface EventsRepository extends CrudRepository<Events, Integer> {

}
