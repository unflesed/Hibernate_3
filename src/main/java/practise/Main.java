package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Person person = new Person();
        person.setName("Anton");
        person.setAge(25);
        person.setGender("Male");
        addPerson(person);

    }

    public static void addPerson(Person person){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);
        transaction.commit();
        session.close();
    }
}
