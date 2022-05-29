package com.app.tagging.profiling.presentation.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class EventDescription  implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String name;
    private String description;
    private String code;
    private  String nameWidget;
    private String  elementToSend="";



    @OneToMany(mappedBy = "eventDescription",cascade = CascadeType.ALL)
    private List<EventToSend> eventToSends=new ArrayList<>();



    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "parcout_id")
    @JsonIgnore
    private  Parcourt parcourt;

    @Override
    public int compareTo(Object o) {
        EventDescription parcourt1=(EventDescription) o;
        if(parcourt1.getName().equals(this.name) || parcourt1.getCode().equals(this.code) ){
            return  1;
        }
        return 0;
    }
}
