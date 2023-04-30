package com.herring.invent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
@Getter @Setter @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Category parent;

    @Transient
    private List<Category> children = new ArrayList<>();

    public void addChildren(Category child) {
        children.add(child);
    }

}
