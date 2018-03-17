package p2.backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p2.backend.Beans.Events;
import p2.backend.Service.EventsService;

@RestController
@RequestMapping("/Event")
public class EventsController {

    private EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService){
        this.eventsService = eventsService;
    }
    @RequestMapping("/Events")
    public Iterable<Events> EventList(){
        return eventsService.listOfEvents();
    }

    @PostMapping("/save")
    public void saveEvent(@RequestBody Events save){
        eventsService.saveEvent(save);
    }

    @PostMapping("/delete")
    public void deleteEvent(@RequestBody Events delete){
        eventsService.deleteEvent(delete);
    }
}
