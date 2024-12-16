package ma.enset.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.conferenceservice.enums.Type;
import ma.enset.conferenceservice.model.Keynote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter @Builder @ToString
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Type type;
    private LocalDate date;
    private int duree;
    private int nombreInscrits;
    private double score;
    @Transient
    private List<Keynote> keynotes;
}