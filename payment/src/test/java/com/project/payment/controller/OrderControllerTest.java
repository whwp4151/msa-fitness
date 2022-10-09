package com.project.payment.controller;

import com.google.gson.Gson;
import com.project.payment.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveOrderTest() throws Exception{
        String trainerId = "hong12";
        String lessonName = "lessontest12";
        Long lessonId = 1L;
        String paymentType = "무통장입금";
        Long lessonPrice = 10003L;

        OrderDto dto = OrderDto.builder()
                .userId(trainerId)
                .lessonId(lessonId)
                .paymentType(paymentType)
                .lessonName(lessonName)
                .lessonPrice(lessonPrice)
                .build();
        String json = new Gson().toJson(dto);

        mockMvc.perform(MockMvcRequestBuilders.post("/payment-service/order")
                        .header("user-id", "user12")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
