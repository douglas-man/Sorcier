package sorcier.dao;

import java.util.List;
import sorcier.domain.Sorcier;

public interface SorcierDao {
	List<Sorcier> findSorciers(long max, int count);
	
	Sorcier findOne(long id);
}