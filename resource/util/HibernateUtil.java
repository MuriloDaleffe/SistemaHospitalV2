package util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements Serializable {

    public static Session getSession() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();

        return f.openSession();
    }
}
