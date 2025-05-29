package vn.group27.buildingManagement.Entity;


import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    Collection<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
