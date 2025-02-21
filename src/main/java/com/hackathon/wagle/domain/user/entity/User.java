package com.hackathon.wagle.domain.user.entity;


import com.hackathon.wagle.domain.user.dto.request.UserRequestDto;
import com.hackathon.wagle.domain.user.entity.enums.Role;
import com.hackathon.wagle.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static com.hackathon.wagle.domain.user.entity.enums.Role.MEMBER;

@Getter
@Entity
@Table
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    private String username;

    private String major;

    private String studentNumber;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static User of(UserRequestDto dto) {
        return User.builder()
                .username(dto.username())
                .major(dto.major())
                .studentNumber(dto.studentNumber())
                .email(dto.email())
                .password(dto.password())
                .role(MEMBER)
                .build();
    }

}
