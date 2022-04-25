package admin.mns.admin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy =InheritanceType.JOINED)
@Getter
@Setter
public class Utilisateur {
//----------------------PROPRIETES---------------------------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String identifiant;
    private String mdp;

    //-------------------------CONSTRUCTEUR-----------------------------------//
    public Utilisateur(int id, String nom, String prenom, String email, String identifiant, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

        this.email = email;
        this.identifiant = identifiant;
        this.mdp = mdp;
    }

    public Utilisateur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @ManyToMany
    private List<Role> listeRole= new ArrayList<>();



}
