package com.example.servingwebcontent.udp_request

import java.io.ByteArrayOutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.nio.ByteBuffer
fun getPlayer(address: String, port: String): String {
    val clientSocket = DatagramSocket()
    val IPAddress = InetAddress.getByName(address)
    val output = ByteArrayOutputStream()

    //пример ->  "FF FF FF FF 54 53 6F 75 72 63 65 20 45 6E 67 69 6E 65 20 51 75 65 72 79 00 0A 08 5E EA"
    //FF FF FF FF 54 53 6F 75 72 63 65 20 45 6E 67 69 6E 65 20 51 75 65 72 79 00 FF FF FF FF
    val result = "FF FF FF FF 54 53 6F 75 72 63 65 20 45 6E 67 69 6E 65 20 51 75 65 72 79 00 0A 08 5E EA"

    result.split(' ').forEach { output.write(it.toInt(16)) }

    val buffer = ByteBuffer.allocate(output.size())
    buffer.put(output.toByteArray())
    val bytes = buffer.array()

    val receivingDataBuffer = ByteArray(1400)
    val sendingPacket =  DatagramPacket(bytes, bytes.size, IPAddress, port.toInt())
    clientSocket.send(sendingPacket)

    val receivingPacket = DatagramPacket(receivingDataBuffer,receivingDataBuffer.size)
    clientSocket.receive(receivingPacket)

    clientSocket.close()

    return receivingPacket.data.contentToString()
}