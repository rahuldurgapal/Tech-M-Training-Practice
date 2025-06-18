package org.myspringproject.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.myspringproject.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    private SessionFactory sessionFactory;



    public void save(Department dept) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(dept);
        tx.commit();
    }

    public Department findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Department.class, id);
    }

    public List<Department> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query<Department> query = session.createQuery("from Department", Department.class);
        tx.commit();
        return query.getResultList();

    }

    public void update(Department dept) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(dept);
        tx.commit();
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Department dept = findById(id);
        if (dept != null) session.remove(dept);
        tx.commit();
    }
}

