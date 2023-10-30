package com.iftm.exemplelockotimista.controllers;

import com.iftm.exemplelockotimista.models.Conta;
import com.iftm.exemplelockotimista.models.OperacaoConta;
import com.iftm.exemplelockotimista.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/retirar")
    public ResponseEntity<?> retirar(@RequestBody OperacaoConta operacaoConta) {
        System.out.println("Iniciando operação de saque...");
        return contaService.retirar(operacaoConta.idConta(), operacaoConta.valor());
    }

    @PostMapping("")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        System.out.println("Iniciando operação de salvar...");
        return contaService.save(conta);
    }

    @PostMapping("/depositar")
    public ResponseEntity<?> deposito(@RequestBody OperacaoConta operacaoConta) { // Alterado aqui
        System.out.println("Iniciando operação de depósito...");
        return contaService.depositar(operacaoConta.idConta(), operacaoConta.valor()); // Alterado aqui
    }
    @GetMapping
    public ResponseEntity<List<Conta>> findAll() {
        System.out.println("Iniciando operação de encontrar todas as contas...");
        return contaService.findAll();
    }
}
