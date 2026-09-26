package com.quipux.colegio.dao;

import com.quipux.colegio.models.HechizoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HechizoDaoImpl implements HechizoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HechizoEntity guardarHechizo(HechizoEntity hechizo) {
        entityManager.persist(hechizo);
        return hechizo;
    }

    @Override
    public List<HechizoEntity> buscarPorTipo(String tipoMagia) {
        Query query = entityManager.createQuery(
            "SELECT h FROM HechizoEntity h WHERE h.tipoMagia = :tipo"
        );
        query.setParameter("tipo", tipoMagia);

        return query.getResultList();
    }

    @Override
    public HechizoEntity buscarPorNombre(String nombre) {
        Query query = entityManager.createQuery(
            "SELECT h FROM HechizoEntity h WHERE h.nombre = :nombre"
        );
        query.setParameter("nombre", nombre);

        List<HechizoEntity> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }
}