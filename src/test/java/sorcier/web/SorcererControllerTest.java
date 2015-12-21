package sorcier.web;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.web.servlet.view.InternalResourceView;

import sorcier.domain.Sorcerer;
import sorcier.dao.SorcererDao;
import sorcier.web.SorcererController;

public class SorcererControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SorcererDao mockDao = mock(SorcererDao.class);
		SorcererController controller = new SorcererController(mockDao);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/sorcerer/register"))
		       .andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SorcererDao mockDao = mock(SorcererDao.class);
		
		Sorcerer unsaved = new Sorcerer(0L, "jbauer", "24hours", "Jack Bauer", "jbauer@ctu.gov", false);
		Sorcerer saved = new Sorcerer(24L, "jbauer", "24hours", "Jack Bauer", "jbauer@ctu.gov", false);
		when(mockDao.save(unsaved)).thenReturn(saved);
		
		SorcererController controller = new SorcererController(mockDao);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/sorcerer/register")
		       .param("fullName", "Jack Bauer")
//			   .param("lastName", "Bauer")
			   .param("username", "jbauer")
			   .param("password", "24hours")
			   .param("email", "jbauser@ctu.gov")
			   .param("updateByEmail", "false"))
			   .andExpect(redirectedUrl("/sorcerer/jbauer"));
			   
		verify(mockDao, atLeastOnce()).save(unsaved);
	}
}