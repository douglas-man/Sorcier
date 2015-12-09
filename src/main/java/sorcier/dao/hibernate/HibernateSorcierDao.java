package sorcier.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import sorcier.dao.SorcierDao;
import sorcier.domain.Sorcier;

@Repository
public class HibernateSorcierDao implements SorcierDao {
	public List<Sorcier> findSorciers(long max, int count) {
		return null; 
	}

	public Sorcier findOne(long id) {
		return null; 
	}	
}