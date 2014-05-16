package com.learning.myapp.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 * Implements the PersistenceManagerFactory singleton and controlling methods.
 * Date: 8/14/12
 *
 * @author jjacobs
 */

public final class PersistenceManager {
    
    private static final PersistenceManager singleton = new PersistenceManager();

    protected EntityManagerFactory emf;

    public static PersistenceManager getInstance() {
        return singleton;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }
    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;           
        }
    }
    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("design");         
    }
}


