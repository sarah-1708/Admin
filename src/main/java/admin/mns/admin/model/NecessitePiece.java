package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class NecessitePiece {
    @Id
    private Integer pieceJustificative;

    @Id
    private Integer pieceDemandable;

    @Id
    private Integer demandeDInscription;
}
