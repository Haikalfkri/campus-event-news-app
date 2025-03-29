package com.k4ll.api.Service;

import com.k4ll.api.Model.Event;
import com.k4ll.api.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // helper event id not found message
    private String eventIdNotFoundMessage(UUID eventId) {
        return "Event with id " + eventId + " does not exists";
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(UUID eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException(eventIdNotFoundMessage(eventId)));
    }

    public void createNewEvent(Event newEvent) {
        eventRepository.save(newEvent);
    }

    public void updateEventById(UUID eventId, Event updateEvent) {
        Event existingEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException(eventIdNotFoundMessage(eventId)));

        if (updateEvent.getTitle() != null) {
           existingEvent.setTitle(updateEvent.getTitle());
        }
        if (updateEvent.getDescription() != null) {
            existingEvent.setDescription(updateEvent.getDescription());
        }
        if (updateEvent.getDateTime() != null) {
            existingEvent.setDateTime(updateEvent.getDateTime());
        }
        if (updateEvent.getLocation() != null) {
            existingEvent.setLocation(updateEvent.getLocation());
        }
        if (updateEvent.getAuthor() != null) {
            existingEvent.setAuthor(updateEvent.getAuthor());
        }
        if (updateEvent.getAudience() != null) {
            existingEvent.setAudience(updateEvent.getAudience());
        }

        eventRepository.save(existingEvent);
    }

    public void deleteEventById(UUID eventId) {
        boolean exists = eventRepository.existsById(eventId);
        if (!exists) {
            throw new IllegalStateException(eventIdNotFoundMessage(eventId));
        }
        eventRepository.deleteById(eventId);
    }

}
