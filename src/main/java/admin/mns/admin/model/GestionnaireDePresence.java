package admin.mns.admin.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class GestionnaireDePresence extends Utilisateur {

    public GestionnaireDePresence(int id, String nom, String prenom, String email, String identifiant, String mdp) {
        super(id, nom, prenom, email, identifiant, mdp);
    }

    @OneToMany(mappedBy = "gestionnaireDePresence")
    List<PieceJustificative> pieceJustificatives = new ArrayList<>();

    @OneToMany(mappedBy = "gestionnaireDePresence")
    List<EvenementDePresence> evenementDePresences = new ArrayList<>();
}
