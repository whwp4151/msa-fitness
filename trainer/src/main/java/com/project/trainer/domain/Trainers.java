package com.project.trainer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.trainer.dto.TrainerDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAINERS")
@EntityListeners(AuditingEntityListener.class)
public class Trainers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    @Column(length = 10, nullable = false)
    private String name;


    public Trainers(TrainerDto trainerDto){
        this.userId = trainerDto.getUserId();
        this.password = trainerDto.getPassword();
        this.name = trainerDto.getName();
    }


}
