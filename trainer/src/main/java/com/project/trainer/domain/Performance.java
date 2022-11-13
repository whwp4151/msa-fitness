package com.project.trainer.domain;

import com.project.trainer.dto.PerformanceDto;
import com.project.trainer.message.event.PerformanceSaveEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERFORMANCE")
@EntityListeners(AuditingEntityListener.class)
public class Performance extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Trainers trainerId;

    private Long paymentId;

    private Long amount;

    private Long lessonCount;

    public Performance(PerformanceSaveEvent performanceSaveEvent, Trainers trainer){
        this.trainerId = trainer;
        this.amount = performanceSaveEvent.getAmount();
        this.lessonCount = performanceSaveEvent.getLessonCount();
    }
}
