package com.ejemplo.test.usuario.dao.impl;

import com.ejemplo.test.usuario.dao.UsuarioCustomDao;
import com.ejemplo.test.usuario.entity.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pedro
 */
@Transactional(readOnly = true)
public class UsuarioDaoImpl implements UsuarioCustomDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsuarioEntity> findByNombreCustomJpa(String nombre) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();

        Root<UsuarioEntity> tablaUsuario = query.from(UsuarioEntity.class);

        List<Predicate> condiciones = new ArrayList<>();
        condiciones.add(
                builder.equal(
                        tablaUsuario.get(UsuarioEntity.Attributes.NOMBRE),
                        nombre
                )
        );

        TypedQuery<UsuarioEntity> typedQuery = entityManager.createQuery(
                query
                        .select(
                                tablaUsuario
                        )
                        .where(condiciones.toArray(new Predicate[]{}))
        );

        return typedQuery.getResultList();
    }

    @Override
    public List<UsuarioEntity> findByNombreCustomHibernate(String nombre) {
        Session session = entityManager.unwrap(Session.class);
        return session
                .createCriteria(UsuarioEntity.class)
                .add(
                        Restrictions.eq(UsuarioEntity.Attributes.NOMBRE, nombre)
                )
                .list();
    }
}
