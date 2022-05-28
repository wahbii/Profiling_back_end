package com.app.tagging.profiling.presentation.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String name;
    private String description;
    private String code;
    private  String nameWidget;


    @ManyToOne
    @JoinColumn(name = "parcout_id",nullable = false)
    private  Parcourt parcourt;
}
