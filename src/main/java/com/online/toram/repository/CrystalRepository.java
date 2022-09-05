package com.online.toram.repository;

import com.online.toram.domain.Crystal;
import com.online.toram.domain.item.CrystalKind;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CrystalRepository {
    private final EntityManager em;

    public void save(Crystal crystal) {
        em.persist(crystal);
    }

    public void remove(Crystal crystal) {
        em.remove(crystal);
    }

    // 업데이트 로직
    public void updateName(Crystal crystal, String name) {
        crystal.updateName(name);
    }

    public void updateCrystalKind(Crystal crystal, CrystalKind crystalKind) {
        crystal.updateCrystalKind(crystalKind);
    }

    public void updateBefore(Crystal crystal, String before) {
        crystal.updateBefore(before);
    }

    public void updateCompetency(Crystal crystal, String competency) {
        crystal.updateCompetency(competency);
    }

    // 조회 로직
    public Crystal findOne(Long id) {
        return em.find(Crystal.class, id);
    }

    public List<Crystal> findAll() {
        return em.createQuery("SELECT c FROM Crystal AS c", Crystal.class)
                .getResultList();
    }

    public List<Crystal> findCrystalKind(CrystalKind crystalKind) {
        return em.createQuery("SELECT c FROM Crystal AS c WHERE c.crystalKind = :crystalKind", Crystal.class)
                .setParameter("crystalKind", crystalKind)
                .getResultList();
    }

    public List<Crystal> findName(String name) {
        return em.createQuery("SELECT c FROM Crystal AS c WHERE c.name = :name", Crystal.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
