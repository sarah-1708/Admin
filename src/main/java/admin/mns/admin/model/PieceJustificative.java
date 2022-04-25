package admin.mns.admin.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class PieceJustificative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateDepot;
    private String message;
    private String statut;


    public PieceJustificative(int id, Date dateDepot, String message, String statut) {
        this.id = id;
        this.dateDepot = dateDepot;
        this.message = message;
        this.statut = statut;
    }

    @ManyToOne
    @MapsId("pieceJustificative_id")
    private  EvenementDePresence evenementDePresence;

    @ManyToOne
    @MapsId("pieceJustificative_id")
    private  GestionnaireDePresence gestionnaireDePresence;

    @ManyToOne
    @MapsId("pieceJustificative_id")
    private GestionnaireDossier gestionnaireDossier;

    @OneToMany(mappedBy = "pieceJustificative")
    List<NecessitePiece> necessitePieces = new ArrayList<>();


}
