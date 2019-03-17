package controller;

import DAO.HashtagDaoInterface;
import javax.inject.Inject;
import models.Hashtag;
import models.Kweet;

public class HashtagController {

  @Inject
  HashtagDaoInterface hashtagDao;

  public boolean createHashTag(String hashtagText, Kweet kweet) {

    Hashtag existingHash = hashtagDao.find(hashtagText);
    if (existingHash != null) {
      existingHash.addKweet(kweet);
      hashtagDao.update(existingHash);
    }else {
      Hashtag hashtag = new Hashtag();
      hashtag.setName(hashtagText);
      hashtag.addKweet(kweet);
      hashtagDao.create(hashtag);
    }
    //tot check if hastag was persisted
    return true;
  }

}
