package com.solstice.api.contact;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.solstice.api.contact.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactApplicationTests {


		@Autowired
		private MockMvc mvc;

		@Test
		public void listContactsTest() throws Exception {
			mvc.perform(get("/api/list/")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.notNullValue()))
					.andExpect(jsonPath("$[0].firstname", Matchers.is("Sindhu")));
		}
		
		@Test
		public void deleteContactTest() throws Exception {
			mvc.perform(delete("/api/delete/1")).andExpect(status().isOk());
		}
}
