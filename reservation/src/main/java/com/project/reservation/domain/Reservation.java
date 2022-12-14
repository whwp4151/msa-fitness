package com.project.reservation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.reservation.dto.ReservationDto;
import com.project.reservation.feign.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "RESERVATIONS")
@EntityListeners(AuditingEntityListener.class)
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reservatorId;

    private Long ticketId;

    private Long trainerId;

    private Long lessonId;

    @Column(length = 20, nullable = false)
    private String reservatorName;

    private LocalDate reservationDate;

    private String reservationTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;


    public Reservation(ReservationDto reservationDto, UserResponse userResponse){
        this.ticketId = reservationDto.getTicketId();
        this.lessonId = reservationDto.getLessonId();
        this.trainerId = reservationDto.getTrainerId();
        this.reservatorId = userResponse.getUserId();
        this.reservatorName = userResponse.getName();
        this.reservationDate = reservationDto.getReservationDate();
        this.reservationTime = reservationDto.getReservationTime();
        this.reservationStatus = ReservationStatus.PLACED;
    }

    public void setReservationStatus(ReservationStatus reservationStatus){
        this.reservationStatus = reservationStatus;
    }
}
