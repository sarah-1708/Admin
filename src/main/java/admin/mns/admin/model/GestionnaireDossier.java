package admin.mns.admin.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class GestionnaireDossier extends Utilisateur{




    public GestionnaireDossier(int id, String nom, String prenom, String email, String identifiant, String mdp) {
        super(id, nom, prenom, email, identifiant, mdp);
    }



    @OneToMany(mappedBy = "gestionnaireDeDossier")
    List<PieceJustificative> pieceJustificatives = new ArrayList<>();


    @ManyToMany(mappedBy = "gestionnaireDeDossier")
    List<EvenementDePresence> evenementDePresencest = new ArrayList<>();
}
