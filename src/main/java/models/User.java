package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String userName;

  public void setId(int id) {
    this.id = id;
  }

  public void setKweets(List<Kweet> kweets) {
    this.kweets = kweets;
  }

  public List<Kweet> getLikedKweets() {
    return likedKweets;
  }

  public void setLikedKweets(List<Kweet> likedKweets) {
    this.likedKweets = likedKweets;
  }

  public void setMentions(List<Kweet> mentions) {
    this.mentions = mentions;
  }

  @OneToMany(mappedBy = "creator")
  private List<Kweet> kweets;

  @OneToMany
  private List<Kweet> likedKweets;

  @OneToMany
  private List<Kweet> mentions;

  @OneToOne
  private KwetterRole role;

  public User(String userName) {
    this.userName = userName;
  }

  public User(int id, String userName) {
    this.userName = userName;
    this.id = id;
  }

  public User() {
  }

  public void setRole(KwetterRole role) {
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public List<Kweet> getKweets() {
    return kweets;
  }

  public List<Kweet> getMentions() {
    return mentions;
  }

  public KwetterRole getRole() {
    return role;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
