package com.csaraos.onepiece.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "nakama")
public class Nakama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String origin;
    private String lastname;
    private String position;
    private Integer age;
    private Integer height;
    @ManyToOne
    @JoinColumn(name = "tripulation_id")
    private Tripulation tripulation;
}
