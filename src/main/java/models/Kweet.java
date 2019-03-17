package models;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;

@Entity
public class Kweet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private User creator;

    /*@OneToMany
    private ArrayList<User> mentions;*/

    @ManyToMany
    private List<Kweet> replies;

    @OneToMany
    private List<Hashtag> hashtags;

    @OneToOne
    private Kweet replyFor;

    public Kweet(String text, User creator) {
        this.text = text;
        this.creator = creator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReplies(List<Kweet> replies) {
        this.replies = replies;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public Kweet getReplyFor() {
        return replyFor;
    }

    public void setReplyFor(Kweet replyFor) {
        this.replyFor = replyFor;
    }

    public Kweet() {
    }

    public void setText(String text) {
        /*//This setter should also extract the hastags and set them in the hashtags colletion
        Pattern patternForExtractingHahstagWords = Pattern.compile("#(\\S+)");
        Matcher matcher = patternForExtractingHahstagWords.matcher(text);
        List<String> strings = new ArrayList<String>();
        while (matcher.find()) {
            strings.add(matcher.group(1));
        }
        this.hashtags*/
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Kweet> getReplies() {
        return replies;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getCreator() {
        return creator;
    }

    public boolean reply(Kweet kweet) {
        replies.add(kweet);
        return true;
    }
}
