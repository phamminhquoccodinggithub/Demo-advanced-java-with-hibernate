/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import com.dht.pojo.Tag;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Quoc
 */
public class HibernateDemo {

    public static void main(String[] args) {
        SessionFactory f = HibernateUtils.getFactory();
        try (Session session = f.openSession()) {
            Category c = session.get(Category.class, 2);
            Tag t1 = session.get(Tag.class, 1);
            Tag t2 = session.get(Tag.class, 2);
            Product p = new Product();
            p.setName("iPad Pro new 2022");
            p.setPrice(new BigDecimal(14000000));
            p.setCategory(c);
            List<Tag> tags = new ArrayList<>();
            tags.add(t1);
            tags.add(t2);
            p.setTags(tags);
            session.getTransaction().begin();
            session.save(p);
            session.getTransaction().commit();

// Lay du lieu
//            Query q = session.createQuery("From Category");
//            List<Category> results = q.getResultList();
//            results.forEach(c -> System.out.printf("%d - %s\n", c.getId(), c.getName()));
// Update, Delete
//            Category c = session.get(Category.class, 5);// persistent
//            c.setName("GAMING");
//            session.getTransaction().begin();
////            session.save(c);
//            session.delete(c);
//            session.getTransaction().commit();
// Insert
//            Category c = new Category();//transient
//            c.setName("Gaming");
//            session.save(c);
        }

//       session.close();
    }
}
