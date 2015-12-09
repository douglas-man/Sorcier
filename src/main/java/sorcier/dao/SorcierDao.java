package sorcier.dao;

import java.util.List;
import sorcier.Sorcier;

public interface SorcierDao {
	List<Sorcier> findSorciers(long max, int count);
	
	Sorcier findOne(long id);
}