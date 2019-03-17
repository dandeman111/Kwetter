package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hashtag implements Serializable {

    public void setKweets(List<Kweet> kweets) {
        this.kweets = kweets;
    }

    @Id
    private String name;
    @ManyToMany
    private List<Kweet> kweets;

    public String getName() {
        return name;
    }

    public List<Kweet> getKweets() {
        return kweets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addKweet(Kweet kweet)   {
        kweets.add(kweet);
    }

    public void removeKweet(Kweet kweet)    {
        kweets.remove(kweet);
    }
}
