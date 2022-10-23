package com.project.reservation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.project.reservation.config.TestConfig;
import com.project.reservation.dto.ReservationDto;
import com.project.reservation.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestConfig.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriHost = "127.0.0.1", uriPort = 8001)
public class ReservationControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReservationService reservationService;

    @Test
    void findReservationTest() throws Exception {
        Long reservationId = 1L;

        ReservationDto reservationDto = ReservationDto.builder()
                .id(reservationId)
                .build();

        String json = new Gson().toJson(reservationDto);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post("/reservation-service/reservation")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON));

        actions.andExpect(status().isOk())
                .andDo(print())
                .andDo(document("getReservation",
                        responseFields(
                                fieldWithPath("data.id").description("예약 고유번호"),
                                fieldWithPath("data.reservatorId").description("예약자 id"),
                                fieldWithPath("data.ticketId").description("이용권 고유번호"),
                                fieldWithPath("data.lessonId").description("수업 고유번호"),
                                fieldWithPath("data.trainerId").description("강사 고유번호"),
                                fieldWithPath("data.reservationDate").description("예약 날짜")
                        )));
    }
}
