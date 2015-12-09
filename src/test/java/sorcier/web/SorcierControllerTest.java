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
import org.springframework.web.servlet.view.InternalResourceView;

import sorcier.Sorcier;
import sorcier.dao.SorcierDao;
import sorcier.web.SorcierController;




public class SorcierControllerTest {
	
	@Test
	public void shouldShowRecentSorciers() throws Exception {
		List<Sorcier> expectedSorciers = createSorcierList(20);
		SorcierDao mockDao = mock(SorcierDao.class);
		
		when(mockDao.findSorciers(/* -- Long.MAX_VALUE -- */238900, 50))
		     .thenReturn(expectedSorciers);
			 
	    SorcierController controller = new SorcierController(mockDao);
		
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(
			new InternalResourceView("/WEB-INF/views/sorciers.jsp")).build();
			
		mockMvc.perform(get("/sorciers?max=238900&count=50"))
		 .andExpect(view().name("sorciers"))
		 .andExpect(model().attributeExists("sorcierList"))
		 .andExpect(model().attribute("sorcierList", hasItems(expectedSorciers.toArray())));				
	}
	
	@Test
	public void testSorcier() throws Exception {
		Sorcier expectedSorcier = new Sorcier("Hello", new Date());
		SorcierDao mockDao = mock(SorcierDao.class);
		when(mockDao.findOne(12345)).thenReturn(expectedSorcier);
		
		SorcierController controller = new SorcierController(mockDao);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/sorciers/12345"))
		  .andExpect(view().name("sorcier"))
		  .andExpect(model().attributeExists("sorcier"))
		  .andExpect(model().attribute("sorcier", expectedSorcier));
	}
	
	
	private List<Sorcier> createSorcierList(int count) {
		List<Sorcier> sorciers = new ArrayList<Sorcier>();
		for(int i=0; i < count; i++) {
			sorciers.add(new Sorcier("Sorcier " + i, new Date()));
		}
		return sorciers;
	}	
}