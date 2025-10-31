package com.rafaelcaxixi.pedido_service.controllers;

import com.rafaelcaxixi.pedido_service.domain.dto.PedidoRequestDTO;
import com.rafaelcaxixi.pedido_service.domain.dto.PedidoResponseDTO;
import com.rafaelcaxixi.pedido_service.domain.entities.PedidoEntity;
import com.rafaelcaxixi.pedido_service.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.ok(pedidoService.cadastrarPedido(pedidoRequestDTO));
    }

}
