package sorcier.data;

import java.util.List;
import sorcier.Sorcier;

public interface SorcierRepository {
	List<Sorcier> findSorciers(long max, int count);
	
	Sorcier findOne(long id);
}