package sorcier.dao.hibernate4;

import static org.junit.Assert.*;

//import java.util.Date;
//import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sorcier.dao.SorcierDao;;
import sorcier.domain.Sorcier;
import sorcier.domain.Sorcerer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DaoTestConfig.class)
public class SorcierDaoTest {
	
	@Autowired
	SorcierDao sorcierDao;
	
	@Test
	@Transactional
	public void findOne() {
		Sorcier thirteen = sorcierDao.findOne(13);
		
		assertEquals(13, thirteen.getId().longValue());
		assertEquals("Bonjour from Art!", thirteen.getMessage());
		assertEquals(1332682500000L, thirteen.getPostedTime().getTime());
		assertEquals(4, thirteen.getSorcerer().getId().longValue());
		assertEquals("artnames", thirteen.getSorcerer().getUsername());
		assertEquals("password", thirteen.getSorcerer().getPassword());
		assertEquals("Art Names", thirteen.getSorcerer().getFullName());
		assertEquals("art@habuma.com", thirteen.getSorcerer().getEmail());
		assertTrue(thirteen.getSorcerer().isUpdateByEmail());
	}
}