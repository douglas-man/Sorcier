package sorcier.dao.hibernate4;

import static org.junit.Assert.*;

//import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sorcier.dao.SorcererDao;
import sorcier.domain.Sorcerer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DaoTestConfig.class)
public class SorcererDaoTest {
  
  @Autowired
  SorcererDao sorcererDao;
    
  @Test
  @Transactional
  public void findByUsername() {
    assertSorcerer(0, sorcererDao.findByUsername("habuma"));
    assertSorcerer(1, sorcererDao.findByUsername("mwalls"));
    assertSorcerer(2, sorcererDao.findByUsername("chuck"));
    assertSorcerer(3, sorcererDao.findByUsername("artnames"));
  }

  private static void assertSorcerer(int expectedSorcererIndex, Sorcerer actual) {
    assertSorcerer(expectedSorcererIndex, actual, "Newbie");
  }

  private static void assertSorcerer(int expectedSorcererIndex, Sorcerer actual,
      String expectedStatus) {
    Sorcerer expected = SORCERERS[expectedSorcererIndex];
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getUsername(), actual.getUsername());
    assertEquals(expected.getPassword(), actual.getPassword());
    assertEquals(expected.getFullName(), actual.getFullName());
    assertEquals(expected.getEmail(), actual.getEmail());
    assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
  }
	
  private static Sorcerer[] SORCERERS = new Sorcerer[6];

  @BeforeClass
  public static void before() {
    SORCERERS[0] = new Sorcerer(1L, "habuma", "password", "Craig Walls",
        "craig@habuma.com", false);
    SORCERERS[1] = new Sorcerer(2L, "mwalls", "password", "Michael Walls",
        "mwalls@habuma.com", true);
    SORCERERS[2] = new Sorcerer(3L, "chuck", "password", "Chuck Wagon",
        "chuck@habuma.com", false);
    SORCERERS[3] = new Sorcerer(4L, "artnames", "password", "Art Names",
        "art@habuma.com", true);
    SORCERERS[4] = new Sorcerer(5L, "newbee", "letmein", "New Bee",
        "newbee@habuma.com", true);
    SORCERERS[5] = new Sorcerer(4L, "arthur", "letmein", "Arthur Names",
        "arthur@habuma.com", false);
  }
	
}