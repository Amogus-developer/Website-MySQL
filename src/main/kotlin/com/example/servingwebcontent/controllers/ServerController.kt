package com.example.servingwebcontent.controllers

import com.example.servingwebcontent.models.Data
import com.example.servingwebcontent.repo.DataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ServerController() {
    @Autowired
    private lateinit var dataRepository: DataRepository

    @GetMapping("/server-main")
    fun servers(model: Model): String {
        val dates: Iterable<Data> = dataRepository.findAll()
        model.addAttribute("dates", dates)
        return "server-main"
    }
}