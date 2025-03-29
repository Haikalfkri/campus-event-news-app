package com.k4ll.api.Controller;

import com.k4ll.api.Model.Event;
import com.k4ll.api.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/event/")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public List<Event> getAllEvent() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") UUID eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping("/create")
    public void createNewEvent(@RequestBody Event event) {
        eventService.createNewEvent(event);
    }

    @PutMapping("/{eventId}")
    public void updateEventById(@PathVariable("eventId") UUID eventId, @RequestBody Event event) {
        eventService.updateEventById(eventId, event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEventById(@PathVariable("eventId") UUID eventId) {
        eventService.deleteEventById(eventId);
    }

}
