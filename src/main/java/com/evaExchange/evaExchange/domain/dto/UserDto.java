package com.evaExchange.evaExchange.domain.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private double amountMoney;

    private Date createDate;

    private Long createUserId;

    private Date updateDate;

    private Long updateUserId;

    private Long deleteUserId;

    private Date deleteDate;

    private Boolean isDeleted;
}
