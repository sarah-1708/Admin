package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.util.Date;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Retard extends EvenementDePresence{

    private DateTimeFormat dateHeureRetard;

    public Retard(int id, Date dateEvaluation, String evaluation, DateTimeFormat dateHeureRetard) {
        super(id, dateEvaluation, evaluation);
        this.dateHeureRetard = dateHeureRetard;
    }
}
