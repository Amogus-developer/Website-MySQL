package com.example.servingwebcontent.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Data(var address: String = "",
           var port: Int = 0) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}