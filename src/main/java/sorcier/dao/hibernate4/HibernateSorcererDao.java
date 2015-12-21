package sorcier.dao.hibernate4;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sorcier.dao.SorcererDao;
import sorcier.domain.Sorcerer;

@Repository
public class HibernateSorcererDao implements SorcererDao {
	
	private SessionFactory sessionFactory;
	
	@Inject
	public HibernateSorcererDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Sorcerer save(Sorcerer sorcerer) {
		Serializable id = currentSession().save(sorcerer);
		return new Sorcerer((Long) id,
		                sorcerer.getUsername(),
						sorcerer.getPassword(),
						sorcerer.getFullName(),
//						sorcerer.getLastName(),
						sorcerer.getEmail(),
						sorcerer.isUpdateByEmail());
	}
	
	public Sorcerer findByUsername(String username) {
		return (Sorcerer) currentSession()
		                 .createCriteria(Sorcerer.class)
						 .add(Restrictions.eq("username", username))
						 .list().get(0);
	}
	
}