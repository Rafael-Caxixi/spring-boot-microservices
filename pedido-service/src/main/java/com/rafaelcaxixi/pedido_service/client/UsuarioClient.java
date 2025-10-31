package com.rafaelcaxixi.pedido_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "usuario-service", url = "http://localhost:8081")
public interface UsuarioClient {
}
