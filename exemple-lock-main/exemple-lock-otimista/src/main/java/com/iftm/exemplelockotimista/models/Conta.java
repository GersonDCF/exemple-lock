package com.iftm.exemplelockotimista.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Conta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String conta;
    private String agencia;
    private Double saldo;
    @Version
    private int version;


    public boolean retirar( Double valor) {
        if (valor > this.saldo) {
            throw new ResponseStatusException(BAD_REQUEST, "Saldo insuficiente para saque.");
        } else {
            System.out.println("Realizando saque...");
            this.saldo -= valor;
            return true;
        }
    }

    public boolean depositar( Double valor ) {
        if (valor <= 0) {
            throw new ResponseStatusException(BAD_REQUEST, "Valor de depósito inválido.");
        } else {
            System.out.println("Realizando depósito...");
            this.saldo += valor;
            return true;
        }
    }

}
