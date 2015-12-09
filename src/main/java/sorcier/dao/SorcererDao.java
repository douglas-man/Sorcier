package sorcier.dao;

import sorcier.Sorcerer;

public interface SorcererDao {
	Sorcerer save(Sorcerer sorcier);
	Sorcerer findByUsername(String username);
}