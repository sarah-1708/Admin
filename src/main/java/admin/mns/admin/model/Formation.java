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
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private String description;
    private String statut;

    public Formation(int id, String libelle, String description, String statut) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.statut = statut;
    }

    @ManyToMany
    @JoinTable(name = "Formation_pieceDemandable",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "pieceDemandable_id")
    )
    List<PieceDemandable> pieceDemandables = new ArrayList<>();


    @OneToMany(mappedBy = "formation")
    List<DemandeInscription> demandeInscriptions = new ArrayList<>();

}
