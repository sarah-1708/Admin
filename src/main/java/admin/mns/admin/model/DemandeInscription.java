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
public class DemandeInscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateInscription;
    private String nationalite;
    private String statutDossier;

    public DemandeInscription(int id, Date dateInscription, String nationalite, String statutDossier) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.nationalite = nationalite;
        this.statutDossier = statutDossier;
    }

    @ManyToOne
    @MapsId("demandeInscription_id")
    private Candidat candidat;

    @ManyToOne
    @MapsId("demandeInscription_id")
    private Formation formation;

    @ManyToMany
    @JoinTable(name = "GestionnairetDossier_DemandeInscription",
            joinColumns = @JoinColumn(name = "gestionnaireDossier_id"),
            inverseJoinColumns = @JoinColumn(name = "demandeInscription_id")
    )
    List<GestionnaireDossier> gestionnaireDossiers = new ArrayList<>();
}
