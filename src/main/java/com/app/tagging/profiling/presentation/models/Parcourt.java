package com.app.tagging.profiling.presentation.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parcourt  implements  Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private  String code_parcout;


    @OneToMany(mappedBy = "parcourt",cascade = {CascadeType.ALL})
    private Set<EventDescription> eventDescriptionList=new HashSet<>();



    @Override
    public int compareTo(Object o) {
        Parcourt parcourt1=(Parcourt) o;
        if(parcourt1.getName().equals(this.name) || parcourt1.getCode_parcout().equals(this.code_parcout) ){
            return  1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcourt parcourt = (Parcourt) o;
        return name.equals(parcourt.name) && code_parcout.equals(parcourt.code_parcout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code_parcout);
    }
}
