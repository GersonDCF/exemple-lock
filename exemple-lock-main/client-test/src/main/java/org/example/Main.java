package org.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String urlServidorPessimista = "http://localhost:8000/account/sacar";
        int totalContas = 1000;

        ExecutorService executor = Executors.newFixedThreadPool(totalContas);

        for (int i = 1; i <= totalContas; i++) {
            final int indiceConta = i;
            executor.execute(() -> {

                double valorSaque = 100.0;

                try {
                    URL url = new URL(urlServidorPessimista);
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                    conexao.setRequestMethod("POST");
                    conexao.setRequestProperty("Content-Type", "application/json");
                    conexao.setDoOutput(true);

                    String corpoRequisicao = "[\"" + "1234" + "\", " + valorSaque + "]";

                    try (DataOutputStream out = new DataOutputStream(conexao.getOutputStream())) {
                        out.write(corpoRequisicao.getBytes("UTF-8"));
                    }

                    int codigoResposta = conexao.getResponseCode();
                    System.out.println("Requisição enviada para " + urlServidorPessimista + ". Código de resposta: " + codigoResposta);

                    conexao.disconnect();
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro ao tentar conectar ao servidor: " + e.getMessage());
                }
            });
        }

        executor.shutdown();
    }
}
