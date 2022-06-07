package com.microservice.fibonicci;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.microservice.fibonicci.model.Fibonicci;
import com.microservice.fibonicci.FibonicciController;
import com.microservice.fibonicci.service.IFibonicciService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
public class FibonicciControllerTest {

	@Autowired
    private FibonicciController controller;

	@Autowired
    private MockMvc mockMvc;

	@Autowired
    private IFibonicciService fibonicciService;
	
	@Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

	@Test
    public void testFibonicciUrl() throws Exception {
        this.mockMvc.perform(get("/fibonicci/20"))
		.andDo(print())
		.andExpect(status().isOk());
    }

	@Test
    public void testValidInput() throws Exception {
		String expected = "[]";
        this.mockMvc.perform(get("/fibonicci/50"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expected)));
    }

	@Test
    public void testFibonicciArray() throws Exception {
		String expected = "[0,1,1,2,3,5,8,13,21,34,55]";
        this.mockMvc.perform(get("/fibonicci/10"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expected)));
    }

	@Test
    public void testFibonicciHistory() throws Exception {
        this.mockMvc.perform(get("/list"))
		.andDo(print())
		.andExpect(status().isOk());
    }

	@Test
    public void testFibonicciFrequent() throws Exception {
		Fibonicci entity_ = fibonicciService.findByNumber(10);
		int frequent = entity_.getFrequent();
        this.mockMvc.perform(get("/fibonicci/10"))
		.andDo(print())
		.andExpect(status().isOk());
		entity_ = fibonicciService.findByNumber(10);
		int next_frequent = entity_.getFrequent();
		assertThat(Objects.equals(frequent + 1, next_frequent)).isTrue();
    }
}
