package com.example.servingwebcontent.controllers

import com.example.servingwebcontent.`udp-request`.SourceEngineClient
import com.example.servingwebcontent.models.Data
import com.example.servingwebcontent.repo.DataRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ServerController(private val dataRepository: DataRepository,
                       private val client: SourceEngineClient) {

    @GetMapping("/servers")
    fun getServers(model: Model): String {
        model.addAttribute("servers", dataRepository.findAll().map { client.getInfo(it.address, it.port) })
        return "servers"
    }

    @GetMapping("/servers/add")
    fun addServer(model: Model): String{
        return "add_server"
    }

    @PostMapping("/servers/add")
    fun addServer(@RequestParam address: String,
                  @RequestParam port: Int,
                  @RequestParam password: String,
                  model: Model): String {
        val data = Data(address, port)
        if (password == "я админ") dataRepository.save(data)
        return "redirect:/servers"
    }
}