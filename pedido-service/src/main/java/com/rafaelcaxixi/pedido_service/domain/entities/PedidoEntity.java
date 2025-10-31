package com.rafaelcaxixi.pedido_service.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

}
