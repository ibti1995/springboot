package autoagencyuser.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personne")
public class User extends AuditModel {
    @Id
    @GeneratedValue(generator = "personne_generator")
    @SequenceGenerator(
            name = "personne_generator",
            sequenceName = "personne_sequence",
            initialValue = 1000
    )
    private Long id;
    @NotBlank
    @Size(min = 3, max = 100)


    @Column(columnDefinition = "text")
    private String nom;

    @Column(columnDefinition = "text")
    private String prenom;

    @Column(columnDefinition = "text")
    private String email;

    @Column(columnDefinition = "text")
    private String dateNaiss ;

    @Column(columnDefinition = "text")
    private String password ;

    @Column(columnDefinition = "text")
    private String role ;

    @Column(columnDefinition = "text")
    private String status ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="auth_user_role",
            joinColumns ={@JoinColumn(name ="id")},
            inverseJoinColumns={@JoinColumn(name ="auth_role_id")} )

    Set<Role> roles = new HashSet<>();

// Getters and Setters (Omitted for brevity)


    public Long getId() {
        return id;
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> role) {
        this.roles = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
