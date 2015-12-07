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

import sorcier.Sorcerer;
import sorcier.data.SorcererRepository;
import sorcier.web.SorcererController;

public class SorcererControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SorcererRepository mockRepository = mock(SorcererRepository.class);
		SorcererController controller = new SorcererController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/sorcerer/register"))
		       .andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SorcererRepository mockRepository = mock(SorcererRepository.class);
		
		Sorcerer unsaved = new Sorcerer("jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
		Sorcerer saved = new Sorcerer(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
		when(mockRepository.save(unsaved)).thenReturn(saved);
		
		SorcererController controller = new SorcererController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/sorcerer/register")
		       .param("firstName", "Jack")
			   .param("lastName", "Bauer")
			   .param("username", "jbauer")
			   .param("password", "24hours")
			   .param("email", "jbauser@ctu.gov"))
			   .andExpect(redirectedUrl("/sorcerer/jbauer"));
			   
		verify(mockRepository, atLeastOnce()).save(unsaved);
	}
}