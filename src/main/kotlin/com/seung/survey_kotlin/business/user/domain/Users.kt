package com.seung.survey_kotlin.business.user.domain

import jakarta.persistence.*

@Entity
@Table
class Users (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val userId: Long = 0,
    @Column
    var phoneNum: String,
    @Column
    var address: String,
    @Column
    var addressDetails: String?,
    @Column
    var storeName: String,
    @Column(unique = true)
    var accountId: String,
    @Column
    var password: String
)