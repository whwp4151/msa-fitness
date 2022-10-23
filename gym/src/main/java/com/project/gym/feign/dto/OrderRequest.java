package com.project.gym.feign.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class OrderRequest {
    private Long id;

    private Long paymentId;

    private String userId;

    private Long lessonId;

    private String paymentType;

    private String lessonName;

    private Long lessonPrice;
}
