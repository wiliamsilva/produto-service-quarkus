package br.com.exemplo.integration.kafka;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProdutoEmitter {

	@Inject @Channel("produto-nome-out")
	Emitter<String> emitter;

	public void sendKafkaData(String message) {
		emitter.send(message);
	}
	
	
}
