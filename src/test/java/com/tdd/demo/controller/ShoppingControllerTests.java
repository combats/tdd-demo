package com.tdd.demo.controller;

import com.google.gson.Gson;
import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.service.ShoppingOrderService;
import com.tdd.demo.stub.StubShoppingOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShoppingOrderService shoppingOrderService;

    @Autowired
    private StubShoppingOrder stubShoppingOrder;

    @Test
    public void saveOrder() throws Exception {
        Gson gson = new Gson();

        when(shoppingOrderService.save(stubShoppingOrder.stub(1))).thenReturn(stubShoppingOrder.stub(25));

        MvcResult mvcResult = mvc
                .perform(post("/order")
                        .contentType(APPLICATION_JSON)
                        .content(gson.toJson(stubShoppingOrder.stub(1)))
                )

                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        ShoppingOrder shoppingOrder = gson.fromJson(mvcResult.getResponse().getContentAsString(), ShoppingOrder.class);

        assertEquals(stubShoppingOrder.stub(25), shoppingOrder);
    }
}
