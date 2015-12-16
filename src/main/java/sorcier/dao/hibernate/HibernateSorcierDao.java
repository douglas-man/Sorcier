package sorcier.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query; 
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sorcier.dao.SorcierDao;
import sorcier.domain.Sorcier;

@Repository
public class HibernateSorcierDao implements SorcierDao {
	
	private SessionFactory sessionFactory;

	@Inject
	public HibernateSorcierDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();//<co id="co_RetrieveCurrentSession"/>
	}	
	
	public List<Sorcier> findSorciers(long max, int count) {
		/* ---
		        "select id, message, created_at, latitude, longitude" +
                " from Spittle" +
                " where id < ?" +
                " order by created_at desc limit 20",
                new SpittleRowMapper(), max);
         */
		String SQL_QUERY = "from Sorcier where id < :id order by postedTime desc limit :count";
        Query query = currentSession().createQuery(SQL_QUERY);
		query.setParameter("id", max);
		query.setParameter("count", count);
		return (List<Sorcier>)query.list();
		
		return (List<Sorcier>) currentSession().createCriteria(Sorcier.class)
		                      .add(Restrictions.lt("id", max))
							  .addOrder(Order.desc("postedTime"))
							  .setMaxResults(count).list(); 
	}

	public Sorcier findOne(long id) {
		return (Sorcier) currentSession().get(Sorcier.class, id);
	}	
}