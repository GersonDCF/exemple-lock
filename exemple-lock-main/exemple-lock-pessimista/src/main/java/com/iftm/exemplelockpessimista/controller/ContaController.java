package com.iftm.exemplelockpessimista.controller;

import com.iftm.exemplelockpessimista.models.Conta;
import com.iftm.exemplelockpessimista.models.Transacao;
import com.iftm.exemplelockpessimista.services.ContaService;
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
    public ResponseEntity<?> retirar(@RequestBody Transacao transacao) {
        System.out.println("Iniciando operação de saque...");
        return contaService.retirar(transacao.numeroConta(), transacao.valor());
    }

    @PostMapping("/depositar")
    public ResponseEntity<?> depositar(@RequestBody Transacao transacao) {
        System.out.println("Iniciando operação de depósito...");
        return contaService.depositar(transacao.numeroConta(), transacao.valor());
    }

    @PostMapping()
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        System.out.println("Iniciando operação de salvar...");
        return contaService.save(conta);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> findAll() {
        System.out.println("Iniciando operação de encontrar todas as contas...");
        return contaService.findAll();
    }
}
