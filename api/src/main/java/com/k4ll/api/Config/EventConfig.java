package com.k4ll.api.Config;

import com.k4ll.api.Model.Enums.AudienceEnum;
import com.k4ll.api.Model.Enums.AuthorEnum;
import com.k4ll.api.Model.Event;
import com.k4ll.api.Repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Configuration
public class EventConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository eventRepository) {
        return args -> {
            Event event1 = new Event(
                    null,
                    "Tech Innovation Seminar",
                    "A seminar about the latest trends in technology and innovation.",
                    LocalDateTime.of(2025, 3, 29, 15, 0),
                    "Auditorium A",
                    AuthorEnum.BLUG,
                    AudienceEnum.PUBLIC
            );

            Event event2 = new Event(
                    null,
                    "AI for Future",
                    "A seminar about AI.",
                    LocalDateTime.of(2025, 3, 29, 10, 0),
                    "Auditorium A",
                    AuthorEnum.BLUG,
                    AudienceEnum.PUBLIC
            );

            eventRepository.saveAll(
                    List.of(event1, event2)
            );
        };
    }

}
