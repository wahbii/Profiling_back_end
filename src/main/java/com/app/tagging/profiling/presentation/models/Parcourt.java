package com.app.tagging.profiling.presentation.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parcourt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private  String code_parcout;


    @OneToMany(mappedBy = "parcourt")
    private List<EventDescription> eventDescriptionList=new ArrayList<EventDescription>();
}
