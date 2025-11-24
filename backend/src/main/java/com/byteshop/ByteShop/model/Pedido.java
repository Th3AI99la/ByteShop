package com.byteshop.ByteShop.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataEmissao = LocalDateTime.now();
    private String clienteNome;
    private String status; // Ex: ABERTO, FINALIZADO

    // O Mestre manda nos Detalhes.
    // CascadeType.ALL: Ao salvar o Pedido, salva todos os Itens automaticamente.
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens;
}