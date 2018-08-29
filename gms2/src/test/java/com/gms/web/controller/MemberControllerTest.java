package com.gms.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.gms.web.domain.MemberDTO;
import com.gms.web.service.MemberService; 

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:META-INF/root-context.xml")
public class MemberControllerTest {
	@Autowired
    private WebApplicationContext wac;
	private MockMvc mockMvc;
	@Before
    public void setup () {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
	@Test
	public void testLogin() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
		 MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(
                 "/member/login");
		 builder.header("userid", "joon");
		 this.mockMvc.perform(builder)
         .andExpect(ok);
				
	}

}
