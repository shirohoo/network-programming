package io.github.shirohoo.rfc865

import java.net.ServerSocket
import java.util.concurrent.ExecutorService

class Server(private val threadPool: ExecutorService) {
    fun run() {
        while (true) {
            ServerSocket(PORT, BACKLOG).use {
                threadPool.submit(Worker(QuoteRepository, it.accept()))
            }
        }
    }

    companion object {
        private const val PORT = 17
        private const val BACKLOG = 0
    }
}
