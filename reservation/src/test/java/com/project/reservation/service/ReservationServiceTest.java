package com.project.reservation.service;

import com.project.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationServiceTest {

    @Autowired
    private ReservationRepository reservationRepository;

    public void reservationSaveTest(){
        String userId = "user12";
        String userName = "테스트";
        Long ticketId = 1L;
        Long lessonId = 1L;
    }
}
