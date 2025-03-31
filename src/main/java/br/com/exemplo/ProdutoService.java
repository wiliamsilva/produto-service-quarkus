package br.com.exemplo;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoService {
	
	@Incoming("produto-nome-in")
	public void receiveMessageFromKafka(String message) {
		System.out.println("A mensagem recebida do Kafka é: " + message);
	}

}
