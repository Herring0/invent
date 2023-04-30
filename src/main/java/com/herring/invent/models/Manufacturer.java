package com.herring.invent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="manufacturer")
@Getter
@Setter
@NoArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int country;
}
