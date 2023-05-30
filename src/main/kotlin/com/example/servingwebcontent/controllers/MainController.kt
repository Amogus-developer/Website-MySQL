package com.example.servingwebcontent.controllers

import com.example.servingwebcontent.repo.DataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController() {
    @Autowired
    private lateinit var dataRepository: DataRepository

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("nahlebnic.com", "nahlebnic")
        return "home"
    }
    @GetMapping("/register")
    fun register(model: Model): String {
        model.addAttribute("nahlebnic.com", "nahlebnic")
        return "register"
    }
}
