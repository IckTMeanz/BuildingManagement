package vn.group27.buildingManagement.Entity;


import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinTable(
             name = "users_roles",
             joinColumns=@JoinColumn(name = "user_id"),
             inverseJoinColumns=@JoinColumn(name = "role_id")
     )

    Collection<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
