package com.example.servingwebcontent.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Data(private var title: String = "",
           private var description: String = "",
           private var address: String = "") {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0

    fun getId(): Long {return id}
    fun setId(id: Long) {this.id = id}

    fun getTitle(): String {return title}
    fun setTitle(title: String) {this.title = title}

    fun getAddress(): String {return address}
    fun setAddress(address: String) {this.address = address}

    fun getDescription(): String {return description}
    fun setDescription(description: String) {this.description = description}
}