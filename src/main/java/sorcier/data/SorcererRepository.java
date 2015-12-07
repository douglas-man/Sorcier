package sorcier.data;

import sorcier.Sorcerer;

public interface SorcererRepository {
	Sorcerer save(Sorcerer sorcier);
	Sorcerer findByUsername(String username);
}