package com.rafaelcaxixi.pagamento_service.rabbitmq;

import com.rafaelcaxixi.pagamento_service.domain.entities.PagamentoEntity;
import com.rafaelcaxixi.pagamento_service.rabbitmq.dto.PedidoMessage;
import com.rafaelcaxixi.pagamento_service.repositories.PagamentoJpaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoConsumer {

    private final PagamentoJpaRepository pagamentoJpaRepository;

    public PagamentoConsumer(PagamentoJpaRepository pagamentoJpaRepository) {
        this.pagamentoJpaRepository = pagamentoJpaRepository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE, containerFactory = "rabbitListenerContainerFactory")
    public void processarPagamento(PedidoMessage pedido) {
        System.out.println("Pagamento recebido para pedido ID: " + pedido.idPedido());
        PagamentoEntity pagamento = new PagamentoEntity(pedido.idPedido(), pedido.idCliente(), pedido.valorTotal());
        pagamentoJpaRepository.save(pagamento);
        System.out.println("Pagamento processado com sucesso!");
    }
}
