package DAO;

import models.Kweet;

import java.util.ArrayList;

public interface KweetDaoInterface {

    boolean create(Kweet kweet);

    ArrayList<Kweet> findAll();

    Kweet find(int id);

    void update(Kweet kweet);

}
