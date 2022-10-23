package com.project.gym.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@Embeddable
public class PersonalUser {
    private Long count;

    public PersonalUser(Long count){
        this.count = count;
    }
}
