package com.its.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "member_test_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_email" , length = 50 , unique = true)
    private String memberEmail;

    @Column(name = "member_password" , length = 50 , nullable = false)
    private String memberPassword;

    @Column(name = "member_name" , length = 20)
    private String memberName;



}
