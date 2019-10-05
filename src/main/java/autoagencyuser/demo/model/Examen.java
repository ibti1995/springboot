package autoagencyuser.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "examen")
public class Examen {


    @Column(columnDefinition = "text")
    @Id
    @GeneratedValue(generator = "examen_generator")
    @SequenceGenerator(
            name = "examen_generator",
            sequenceName = "examen_sequence",
            initialValue = 1000
    )
    private Long idExam;

    @NotBlank
    @Size(min = 3, max = 100)
    private String titre;

    @Column(columnDefinition = "text")
    private String statut;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "date")
    private Date dateExam;

    @ManyToOne
    @JoinColumn
    private User idUser;

    public Long getIdExam() {
        return idExam;
    }

    public void setIdExam(Long idExam) {
        this.idExam = idExam;
    }

    public String getTitre() {
        return titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return idUser;
    }

    public void setUser(User user) {
        this.idUser = user;
    }
}
