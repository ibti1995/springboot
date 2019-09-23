//package com.autoa.demo.model;
package autoagencyuser.demo.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="auth_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator( name = "role_generator",
            sequenceName = "role_sequence",
            initialValue = 1000)
    private int auth_role_id;

    @Column(columnDefinition = "text")
    private String role_name;

    @Column (columnDefinition = "text")
    private String role_desc;

    @ManyToMany(mappedBy = "roles")
    Set<User> projects = new HashSet<>();

    public int getAuth_role_id() {
        return auth_role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setAuth_role_id(int auth_role_id) {
        this.auth_role_id = auth_role_id;
    }

    public void setRole_name(Set<Role> roles) {
        this.role_name = role_name;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }
}
