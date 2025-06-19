package com.springproject2.springproject2.repository;


import com.springproject2.springproject2.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Student s) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    @Override
    public Student findById(int id) {
        Session session= sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public boolean existById(int id) {
        return findById(id)!=null;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student s = findById(id);
        if(s==null) {
            System.out.println("Student not found with this id");
            return;
        }
        session.remove(s);
        tx.commit();
        session.close();
    }

    @Override
    public Student findByEmail(String email) {
        Session session = sessionFactory.openSession();
        Student s = session.createQuery("from Student where email = :email",Student.class)
                            .setParameter("email",email)
                            .uniqueResult();
        return s;
    }
}
