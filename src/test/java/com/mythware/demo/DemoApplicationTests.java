package com.mythware.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	private MockMvc mockMvc;
	 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLogin() throws Exception {
        String responseString = mockMvc.perform(
        		MockMvcRequestBuilders.post("/login")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.content("{\"account\":\"admin\",\"password\":\"12345\"}"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }
    
    @Test
    public void testHome() throws Exception {
    	String responseString = mockMvc.perform(
        		MockMvcRequestBuilders.get("/home")
        		.header("authorization", "12345"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

}
