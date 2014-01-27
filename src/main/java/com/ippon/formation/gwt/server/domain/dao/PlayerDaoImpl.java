package com.ippon.formation.gwt.server.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.common.collect.Lists;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.server.util.HibernateUtil;

public class PlayerDaoImpl implements PlayerDao {

    @Override
    public List<PlayerEntity> findClassement() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<PlayerEntity> playerEntities = Lists.newArrayList();
        try {
            em.getTransaction().begin();
            List<?> players = em.createQuery("select p from Player p").getResultList();
            for (Object p : players) {
                if (p instanceof PlayerEntity) {
                    playerEntities.add((PlayerEntity) p);
                }
            }
            em.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return playerEntities;
    }

    @Override
    public PlayerEntity findPlayer(String name) {
        EntityManager em = HibernateUtil.getEntityManager();
        PlayerEntity player = (PlayerEntity) em.createQuery("select p from Player p where p.name = :name")
                .setParameter("name", name).getSingleResult();
        return player;
    }

    @Override
    public PlayerEntity findPlayer(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        PlayerEntity player = em.find(PlayerEntity.class, id);
        return player;
    }

    @Override
    public void addPlayer(PlayerEntity player) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.persist(player);
    }

    @Override
    public void updatePlayer(PlayerEntity player) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.merge(player);
    }

}
