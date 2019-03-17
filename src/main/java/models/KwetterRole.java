package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KwetterRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int name;

    @OneToMany
    private List<KwetterRight> kwetterRights;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<KwetterRight> getKwetterRights() {
        return kwetterRights;
    }

    public void setKwetterRights(List<KwetterRight> kwetterRights) {
        this.kwetterRights = kwetterRights;
    }
}
