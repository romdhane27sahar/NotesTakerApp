package com.epi.notestakerapp2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Notes {
@Id
@GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDate date;

    @ManyToOne
    private User user;

    public int getId(){
        return id;
    }

}
