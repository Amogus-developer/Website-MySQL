package com.example.servingwebcontent.repo

import com.example.servingwebcontent.models.Data
import org.springframework.data.repository.CrudRepository

interface DataRepository: CrudRepository<Data, Long> {

}