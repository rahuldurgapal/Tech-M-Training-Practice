package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Student("rahul","chandigarh",21));
        session.persist(new Student("amit","mohali",22));
        session.persist(new Student("ramesh","delhi",34));


//        String sql = "select * from Student where age > 20 and age<25";
//        String sql1 = "insert into Student(name, age, address) values (?, ?, ?)";
//        NativeQuery<Student> query = session.createNativeQuery(sql1,Student.class);
//
//        query.setParameter(1,"tushar");
//        query.setParameter(2,28);
//        query.setParameter(3,"chandigarh");
//
//        query.executeUpdate();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Student> query =  builder.createQuery(Student.class);
//
        Root<Student> root = query.from(Student.class);
//
//        query.select(root);
//
//        List<Student> students = session.createQuery(query).getResultList();
//        System.out.println(students);

        int age =30;
        String address = "Chandigarh";

        Predicate agePredicate = builder.equal(root.get("id"), 4);
        Predicate agePredicate1 = builder.equal(root.get("name"),"tushar");
        Predicate addressPredicate = builder.equal(root.get("address"),address);


        Predicate finalPredicate = builder.and(agePredicate,agePredicate1);

        query.where(finalPredicate);

        List<Student> students = session.createQuery(query).getResultList();
        System.out.println(students);



        tx.commit();

       // List<Student> students = query.getResultList();
       // System.out.println(students);

//

    }
}