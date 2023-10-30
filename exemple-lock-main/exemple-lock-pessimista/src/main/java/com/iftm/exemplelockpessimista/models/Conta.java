package com.iftm.exemplelockpessimista.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.annotation.Documented;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String conta;
    private String agencia;
    private Double saldo;
//    @Version
//    private int version;


    public boolean retirar( Double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public boolean depositar( Double valor ) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido.");
        } else {
            this.saldo += valor;
            return true;
        }
    }
}
