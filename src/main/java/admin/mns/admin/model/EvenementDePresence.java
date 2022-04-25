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
@Inheritance(strategy =InheritanceType.JOINED)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EvenementDePresence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date dateEvaluation;
    private String evaluation;


    public EvenementDePresence(int id, Date dateEvaluation, String evaluation) {
        this.id = id;
        this.dateEvaluation = dateEvaluation;
        this.evaluation= evaluation;

    }

    @ManyToOne
    @MapsId("evenementDePresence_id")
    private Stagiaire stagiaire;

    @OneToMany(mappedBy = "evenementDePresence")
    List<PieceJustificative> pieceJustificative = new ArrayList<>();

    @ManyToOne
    @MapsId("evenementDePresence_id")
    private Motif motif;

    @ManyToOne
    @MapsId("evenementDePresence_id")
    private GestionnaireDePresence gestionnaireDePresence;
}
