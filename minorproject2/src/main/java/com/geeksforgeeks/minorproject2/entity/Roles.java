package com.geeksforgeeks.minorproject2.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"
            )
    )
    private Collection<Permissions> permissions;

    public Roles() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permissions> permissions) {
        this.permissions = permissions;
    }
}
