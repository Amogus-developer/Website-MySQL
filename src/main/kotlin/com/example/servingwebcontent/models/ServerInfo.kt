package com.example.servingwebcontent.models

class ServerInfo(val address: String,
                 val port: Int,
                 val protocol: Int,
                 val serverName: String,
                 val mapName: String,
                 val folder: String,
                 val game: String,
                 val appId: Int,
                 val playerCount: Int,
                 val maxPlayers: Int)