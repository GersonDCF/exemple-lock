package com.iftm.exemplelockpessimista.services;

import com.iftm.exemplelockpessimista.models.Conta;
import com.iftm.exemplelockpessimista.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    @Transactional
    public ResponseEntity<Conta> save (Conta conta) {
        if (contaRepository.findByConta(conta.getConta()).isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contaRepository.save(conta));
    }

    public ResponseEntity<List<Conta>> findAll() {
        return ResponseEntity.ok(contaRepository.findAll());
    }

    @Transactional
    public ResponseEntity<?> retirar(String conta, Double valor) {
        var contaDb = contaRepository.findByConta(conta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inexistente"));

        if (!contaDb.retirar(valor))
            return ResponseEntity.status(400).body("Saldo insuficiente");

        return ResponseEntity.ok(contaRepository.save(contaDb));
    }

    @Transactional
    public ResponseEntity<?> depositar(String conta, Double valor) {
        var contaDb = contaRepository.findByConta(conta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inexistente"));

        if (!contaDb.depositar(valor))
            return ResponseEntity.status(400).body("Valor incorreto");

        return ResponseEntity.ok(contaRepository.save(contaDb));
    }
}
