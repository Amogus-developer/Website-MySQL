package com.example.servingwebcontent.controllers

import com.example.servingwebcontent.models.Data
import com.example.servingwebcontent.repo.DataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ServerController() {
    @Autowired
    private lateinit var dataRepository: DataRepository

    @GetMapping("/servers")
    fun servers(model: Model): String {
        val dates: Iterable<Data> = dataRepository.findAll()
        model.addAttribute("dates", dates)
        return "servers"
    }
    @GetMapping("/add-server")
    fun addServer(model: Model): String {
        return "add-server"
    }

    @PostMapping("/add-server")
    fun postServer(@RequestParam title: String,
                   @RequestParam description: String,
                   @RequestParam address: String,
                   @RequestParam password: String,
                   model: Model): String {
        if (password == "я админ") {
            val data = Data(title, description, address)
            dataRepository.save(data)
        }
        return "redirect:/servers"
    }
}