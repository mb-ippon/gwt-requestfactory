package com.ippon.formation.gwt.server.domain.dao;

import java.util.List;

import org.hibernate.Session;

import com.google.common.collect.Lists;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.server.util.HibernateUtil;

public class PlayerDaoImpl implements PlayerDao {

    @Override
    public List<PlayerEntity> findClassement() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PlayerEntity> playerEntities = Lists.newArrayList();
        try {
            session.beginTransaction();
            List<?> players = session.createQuery("select p from Player p").list();
            for (Object p : players) {
                if (p instanceof PlayerEntity) {
                    playerEntities.add((PlayerEntity) p);
                }
            }
            session.getTransaction().commit();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return playerEntities;
    }

    @Override
    public PlayerEntity findPlayer(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        PlayerEntity player = (PlayerEntity) session.createQuery("select p from Player p where p.name = :name")
                .setParameter("name", name).uniqueResult();
        return player;
    }

}
