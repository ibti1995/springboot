package autoagencyuser.demo.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table (name ="PermisAuto")
public class PermisAuto {



    @Column(columnDefinition = "text")
    @Id
    @GeneratedValue(generator = "permis_generator")
    @SequenceGenerator(
            name = "permis_generator",
            sequenceName = "permis_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String titre;

    @Column(columnDefinition = "text")
    private String description;


    @Column(columnDefinition = "int")
    private int prix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
