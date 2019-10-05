package autoagencyuser.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "entrainement")
public class Entrainement {

    @Column(columnDefinition = "text")
    @Id
    @GeneratedValue(generator = "entrainement_generator")
    @SequenceGenerator(
            name = "entrainement_generator",
            sequenceName = "entrainement_sequence",
            initialValue = 1000
    )
    private Long idEntrainement;

    @NotBlank
    @Size(min = 3, max = 100)
    private String titreEntrainement;

    @Column(columnDefinition = "text")
    private String url;

    @Column(columnDefinition = "text")
    private String descEntrainement;

    @Column(columnDefinition = "text")
    private String typeEntrainement;

    @ManyToOne
    @JoinColumn
    private User idUser;

    public Long getIdEntrainement() {
        return idEntrainement;
    }

    public void setIdEntrainement(Long idEntrainement) {
        this.idEntrainement = idEntrainement;
    }

    public String getTitreEntrainement() {
        return titreEntrainement;
    }

    public void setTitreEntrainement(String titreEntrainement) {
        this.titreEntrainement = titreEntrainement;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescEntrainement() {
        return descEntrainement;
    }

    public void setDescEntrainement(String descEntrainement) {
        this.descEntrainement = descEntrainement;
    }

    public String getTypeEntrainement() {
        return typeEntrainement;
    }

    public void setTypeEntrainement(String typeEntrainement) {
        this.typeEntrainement = typeEntrainement;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
