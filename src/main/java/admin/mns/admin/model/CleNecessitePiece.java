package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.io.Serializable;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CleNecessitePiece implements Serializable {

    @Column(name = "pieceJustificative_id")
    private Integer pieceJustificativeId;

    @Column(name = "pieceDemandable_id")
    private Integer pieceDemandableId;

    @Column(name = "demandeInscription_id")
    private Integer demandeInscriptionId;

}
