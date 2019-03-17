package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Kweet;
import models.User;

@Stateless
public class UserDaoImp implements UserDaoInterface {

  @PersistenceContext EntityManager em;

  @Override
  public boolean create(User user) {
    em.persist(user);
    User createdUser = em.find(User.class, user.getId());
    return createdUser != null;
  }

  @Override
  public List<User> findAll() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<User> rootEntry = cq.from(User.class);
    CriteriaQuery<User> all = cq.select(rootEntry);
    TypedQuery<User> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public User find(int id) {
    return em.find(User.class, id);
  }

  @Override
  public User updateUser(User user) {
    em.merge(user);
    return em.find(User.class, user.getId());
  }


}
