package p2.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p2.backend.Beans.Events;
import p2.backend.Repository.EventsRepository;

@Service
public class EventsService {

    private EventsRepository eventsRepository;

    @Autowired
    public EventsService(EventsRepository eventsRepository){
        this.eventsRepository=eventsRepository;
    }

    public Iterable<Events> listOfEvents(){
        return eventsRepository.findAll();
    }

    public void saveEvent(Events save){
        eventsRepository.save(save);
    }

    public void deleteEvent(Events delete){
        eventsRepository.delete(delete);
    }


}
