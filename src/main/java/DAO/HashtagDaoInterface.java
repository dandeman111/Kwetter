package DAO;

import java.util.List;
import models.Hashtag;
import models.User;

public interface HashtagDaoInterface {

    boolean create(Hashtag hashtag);

    List<Hashtag> findAll();

    Hashtag find(String hashtagText);

    void update(Hashtag hashtag);

}
