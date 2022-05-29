package com.app.tagging.profiling.presentation.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Application implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String application_name;
    private String application_code;


    @JsonIgnore
    @OneToMany(mappedBy = "application",cascade = CascadeType.ALL)
    private Set<Parcourt> parcourts=new HashSet<>();

    @Override
    public int compareTo(Object o) {
        Application app=(Application) o;
        if(app.application_code.equals(this.application_code)&&app.application_name.equals(this.application_name)){
            return  1;
        }
        return  0;
    }
}
