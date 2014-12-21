package br.com.semeru.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author roberval
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final String HIBERNATE_SESSION = "hibernate_session";
    
    
    static{
        
        System.out.println("Tentando configurar a sessionfactory");
        try {
            System.out.println("Tentando abrir uma conexão");
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("SessionFactory criada corretamente.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao iniciar a SessionFactory. "+e);
            throw new ExceptionInInitializerError(e);
        }
        
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
