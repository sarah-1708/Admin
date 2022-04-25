package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class PieceDemandable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private String remarque;
    private String description;

    public PieceDemandable(int id, String libelle, String remarque, String description) {
        this.id = id;
        this.libelle = libelle;
        this.remarque = remarque;
        this.description = description;
    }

    @ManyToMany
            @JoinTable(
                    name="PieceDemandable_gestionnaireDeDossier",
                    joinColumns = @JoinColumn (name="pieceDemandable_id"),
                    inverseJoinColumns =  @JoinColumn (name="gestionnaireDeDossier_id")
            )
    List<PieceDemandable> pieceDemandable = new ArrayList<>();

    @ManyToMany
    List<Formation> formation = new ArrayList<>();

}
