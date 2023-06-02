package com.example.servingwebcontent.controllers

import com.example.servingwebcontent.models.Data
import com.example.servingwebcontent.repo.DataRepository
import com.example.servingwebcontent.udp_request.getPlayer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.Optional

@Controller
class ServerController() {
    @Autowired
    private lateinit var dataRepository: DataRepository

    @GetMapping("/servers")
    fun serversMAIN(model: Model): String {
        val dates: Iterable<Data> = dataRepository.findAll()
        model.addAttribute("dates", dates)
        return "servers"
    }
    @GetMapping("/servers/{id}")
    fun serverINFO(@PathVariable(value = "id") id: Long, model: Model): String {
        val data: Optional<Data> = dataRepository.findById(id)
        val res: ArrayList<Data> = ArrayList()
        data.ifPresent(res::add)
        res.forEach {it.setPlayers(getPlayer(it.getAddress(), it.getPort()))}
        model.addAttribute("data", res)
        return "server-info"
    }
    @GetMapping("/add-server")
    fun serverADD(model: Model): String {
        return "add-server"
    }

    @PostMapping("/add-server")
    fun serverPOST(@RequestParam title: String,
                   @RequestParam description: String,
                   @RequestParam address: String,
                   @RequestParam port: String,
                   @RequestParam password: String,
                   model: Model): String {
        if (password == "я админ") {
            val data = Data(title, description, address, port)
            dataRepository.save(data)
        }
        return "redirect:/servers"
    }
}