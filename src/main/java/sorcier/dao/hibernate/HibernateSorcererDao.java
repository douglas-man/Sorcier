package sorcier.dao.hibernate;

import org.springframework.stereotype.Repository;

import sorcier.dao.SorcererDao;
import sorcier.domain.Sorcerer;

@Repository
public class HibernateSorcererDao implements SorcererDao {
	
	public Sorcerer save(Sorcerer sorcier) {
		return null;
	}
	
	public Sorcerer findByUsername(String username) {
		return null;
	}
	
}