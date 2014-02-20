package br.com.semeru.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Leonardo
 */
public class HibernateUtil {
    private static final SessionFactory sessionfactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static{
        try {
            System.out.println("Tentando configurar a Session Factory...");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionfactory = configuration.buildSessionFactory(serviceRegistry);            
            System.out.println("Session Factory criada com sucesso!");
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao iniciar a Session Factory: " + ex);
            throw new ExceptionInInitializerError(ex);            
        }
        
        
    }

    public static SessionFactory getSessionfactory() {
        return sessionfactory;
    }
}