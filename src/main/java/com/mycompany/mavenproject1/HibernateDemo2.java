/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Quoc
 */
public class HibernateDemo2 {

    public static void main(String[] args) {
        SessionFactory f = HibernateUtils.getFactory();
        try (Session session = f.openSession()) {
// dem so san pham 
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = b.createQuery(Object[].class);
            Root rootP = query.from(Product.class);
            Root rootC = query.from(Category.class);
            Predicate p = b.equal(rootP.get("category"), rootC.get("id"));
            query = query.where(p);
            query.multiselect(rootC.get("id"), rootC.get("name"), b.count(rootP.get("id")));
            query.groupBy(rootC.get("id"));
            query.orderBy(b.asc(rootC.get("name")));
            Query q = session.createQuery(query);
            List<Object[]> results = q.getResultList();
            results.forEach(o -> {
                System.out.printf("%d - %s - %d\n", o[0], o[1], o[2]);
            });

//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Product> query = b.createQuery(Product.class);
//            Root root = query.from(Product.class);
//            query.select(root);
// lay giua
//            Predicate p4 = b.between(root.get("price").as(BigDecimal.class), new BigDecimal(10000000), new BigDecimal(20000000));
//            query = query.where(p4);
// Gia tu 20m tro xuong
//            Predicate p2 = b.lessThanOrEqualTo(root.get("price").as(BigDecimal.class), new BigDecimal(20000000));
//            query = query.where(p2);
// Lay san pham co ten voi Pro
//            Predicate p1 = b.like(root.get("name").as(String.class), "%Pro%");
//            query = query.where(p1);
//            Query q = session.createQuery(query);
//            List<Product> products = q.getResultList();
//            products.forEach(p -> {
//                System.out.printf("%d - %s - %.1f VND - %s\n",
//                        p.getId(), p.getName(),
//                        p.getPrice(), p.getCategory().getName());
//            });
        }
    }
}
