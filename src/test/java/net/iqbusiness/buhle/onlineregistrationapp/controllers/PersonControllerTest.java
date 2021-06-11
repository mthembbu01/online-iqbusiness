package net.iqbusiness.buhle.onlineregistrationapp.controllers;

import net.iqbusiness.buhle.onlineregistrationapp.service.PersonService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
//@Ignore
//@RunWith(SpringRunner.class)
//@WebMvcTest
class PersonControllerTest {

    //@MockBean
    private PersonService personService;

    //@Autowired
    PersonController personController;

   // @Autowired
    private MockMvc mockMvc;

    //@Test
    void findAll() throws Exception {
      /*  mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(MockMvcResultMatchers.status().isOk());*/
    }

    //@Test
    void findOneByIdNumber() {
    }

    //@Test
    void addPerson() {
    }

    //@Test
    void updateByIdNumber() {
    }
}