package sorcier.dao;

import sorcier.domain.Sorcerer;

public interface SorcererDao {
	Sorcerer save(Sorcerer sorcier);
	Sorcerer findByUsername(String username);
}