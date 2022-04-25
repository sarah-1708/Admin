package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.util.Date;
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Absence extends EvenementDePresence {

    private Date dateDebut;
    private Date dateFin;

    public Absence(int id, Date dateEvaluation, String evaluation, Date dateDebut, Date dateFin) {
        super(id, dateEvaluation, evaluation);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }





}
