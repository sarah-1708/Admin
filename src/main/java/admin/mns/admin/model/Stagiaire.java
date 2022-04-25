package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Stagiaire extends Utilisateur{
    private String adresse;
    private String divisionRan;
    private String divisionParcours;
    private Long numeroTelephone;


    public Stagiaire(int id, String nom, String prenom, String email, String identifiant, String mdp, String adresse, String divisionRan, String divisionParcours, Long numeroTelephone) {
        super(id, nom, prenom, email, identifiant, mdp);
        this.adresse = adresse;
        this.divisionRan = divisionRan;
        this.divisionParcours = divisionParcours;
        this.numeroTelephone = numeroTelephone;
    }

    @OneToMany(mappedBy = "stagiaire")
    private List<EvenementDePresence> evenementDePresences= new ArrayList<>();

    @ManyToMany
    private List<Classe> classes= new ArrayList<>();

}
