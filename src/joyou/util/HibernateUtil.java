package joyou.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory factory = createSessionFactory(); // 只建立一個。

	public static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()
				.build(); // 註冊物件
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata()
				.buildSessionFactory();
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}