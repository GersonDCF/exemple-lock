package com.iftm.exemplelockotimista.services;

import com.iftm.exemplelockotimista.models.Conta;
import com.iftm.exemplelockotimista.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Transactional
    public ResponseEntity<?> retirar(String numConta, Double valor) {
        var conta = contaRepository.findByConta(numConta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inexistente"));

        if (!conta.retirar(valor))
            throw new ResponseStatusException(BAD_REQUEST, "Saldo insuficiente");

        return ResponseEntity.ok(contaRepository.save(conta));
    }

    @Transactional
    public ResponseEntity<?> depositar(String numConta, Double valor) {
        var conta = contaRepository.findByConta(numConta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inexistente"));

        if (!conta.depositar(valor))
            throw new ResponseStatusException(BAD_REQUEST, "Valor incorreto");

        return ResponseEntity.ok(contaRepository.save(conta));
    }

    public ResponseEntity<List<Conta>> findAll() {
        return ResponseEntity.ok(contaRepository.findAll());
    }
}
