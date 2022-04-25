package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidat extends Utilisateur {

    public Candidat(int id, String nom, String prenom, String email, String identifiant, String mdp) {
        super(id, nom, prenom, email, identifiant, mdp);
    }

    @OneToMany(mappedBy = "candidat")
    List<DemandeInscription> demandeInscriptions = new ArrayList<>();
}
