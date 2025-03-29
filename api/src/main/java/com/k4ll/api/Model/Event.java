package com.k4ll.api.Model;


import com.k4ll.api.Model.Enums.AudienceEnum;
import com.k4ll.api.Model.Enums.AuthorEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name="events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthorEnum author = AuthorEnum.BEM;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AudienceEnum audience = AudienceEnum.PUBLIC;

}
