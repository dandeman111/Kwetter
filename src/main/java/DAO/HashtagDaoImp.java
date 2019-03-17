package DAO;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Hashtag;
import models.Kweet;

@Stateless
public class HashtagDaoImp implements HashtagDaoInterface {

    @PersistenceContext
    EntityManager em;



    @Override
    public boolean create(Hashtag hashtag) {
        em.persist(hashtag);
        Hashtag createdKweet = em.find(Hashtag.class,hashtag.getName());
        return createdKweet != null;
    }

    @Override
    public ArrayList<Hashtag> findAll() {
        return null;

    }

    @Override
    public Hashtag find(String hashtagText) {
        return em.find(Hashtag.class, hashtagText);
    }

    @Override
    public void update(Hashtag hashtag) {
        em.merge(hashtag);
    }
}
