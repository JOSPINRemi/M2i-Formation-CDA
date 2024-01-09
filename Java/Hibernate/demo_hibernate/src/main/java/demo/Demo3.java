package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Fonctions d'aggregations :
//        max()
        /*Query<Integer> query = session.createQuery("SELECT max(age) FROM Personne ");
        int maxAge = query.uniqueResult();
        System.out.println("Age max : " + maxAge);*/

//        avg()
        /*double moyenneAge = (double) session.createQuery("SELECT avg(age) FROM Personne ").uniqueResult();
        System.out.println("Moyenne age : " + moyenneAge);*/

//        Utilisation IN
        /*List noms = new ArrayList<String>();
        noms.add("Ine");
        noms.add("Pafroua");

        Query<Personne> query1 = session.createQuery("FROM Personne WHERE nom IN :noms");
        query1.setParameter("noms", noms);

        List<Personne> personneList = query1.list();
        for (Personne p : personneList){
            System.out.println("Personne : " + p.getPrenom());
        }*/

//        Utilisation execute Update
        String update_query = "UPDATE Personne SET nom = :nomP WHERE id=2";
        Query query3 = session.createQuery(update_query);
        query3.setParameter("nomP", "Romain");
        int success = query3.executeUpdate();

        session.getTransaction().commit();
        System.out.println(success);
        session.close();
        sessionFactory.close();
    }
}
