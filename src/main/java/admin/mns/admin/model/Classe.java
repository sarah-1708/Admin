package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClasse;
    private String parcours;
    private String nom;
    private String description;

    public Classe(int idClasse, String parcours,String nom, String description) {
        this.idClasse = idClasse;
        this.parcours = parcours;
        this.nom = nom;
        this.description = description;
    }

    @ManyToMany
    @JoinTable(
            name = "stagiaire_classe",
            joinColumns = @JoinColumn(name = "stagiaire_id"),
            inverseJoinColumns = @JoinColumn(name = "classe_id"))
    private List<DemandeInscription> inscription = new ArrayList<>();

}
