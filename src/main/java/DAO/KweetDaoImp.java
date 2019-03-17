package DAO;

import models.Kweet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
public class KweetDaoImp implements KweetDaoInterface {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean create(Kweet kweet) {
        em.persist(kweet);
        Kweet createdKweet = em.find(Kweet.class,kweet.getId());
        return createdKweet != null;
    }

    @Override
    public ArrayList<Kweet> findAll() {
        return null;

    }

    @Override
    public Kweet find(int id) {
        return em.find(Kweet.class, id);
    }

    @Override
    public void update(Kweet kweet) {
        em.merge(kweet);
    }
}
