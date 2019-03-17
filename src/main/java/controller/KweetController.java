package controller;

import DAO.KweetDaoInterface;
import DAO.UserDaoInterface;
import java.util.List;
import javax.inject.Inject;
import models.Kweet;
import models.User;

public class KweetController {

  @Inject
  KweetDaoInterface kweetDaoImp;

  @Inject
  UserDaoInterface userDaoImp;

  public Kweet getKweetById(int id) {
    return kweetDaoImp.find(id);
  }

  public boolean createKweet(String kweetText, User kweetCreator){
    Kweet kweet = new Kweet();
    kweet.setText(kweetText);
    User user = userDaoImp.find(kweetCreator.getId());
    kweet.setCreator(user);
    return kweetDaoImp.create(kweet);
  }

  public boolean replyToKweet(String replyKweetText, int replyKweetCreatorId, int repliedToKweetId) {
    Kweet reply = new Kweet();
    Kweet replyTargetKweet = kweetDaoImp.find(repliedToKweetId);
    reply.setText(replyKweetText);
    User replier = userDaoImp.find(replyKweetCreatorId);
    reply.setCreator(replier);
    reply.setReplyFor(replyTargetKweet);

    kweetDaoImp.create(reply);



    replyTargetKweet.reply(reply);

    kweetDaoImp.update(replyTargetKweet);
    return true;
  }

  public List<Kweet> getKweetsForUser(int userId) {
    return userDaoImp.find(userId).getKweets();
  }
}
