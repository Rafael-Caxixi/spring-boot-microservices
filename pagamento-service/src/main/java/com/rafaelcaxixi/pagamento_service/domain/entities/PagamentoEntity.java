package com.rafaelcaxixi.pagamento_service.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    public PagamentoEntity(Long idPedido, Long idCliente, Double valorTotal) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
    }
}
