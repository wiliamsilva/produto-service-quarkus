package br.com.exemplo;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import br.com.exemplo.integration.kafka.ProdutoEmitter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("produto")
public class ProdutoResource {

	@ConfigProperty(name = "quarkus.message")
	private String message;

	@GET
	@Path("message")
	public String getMessage() {
		return message;
	}
	
	@Inject
	ProdutoEmitter produtoEmitter;
	
	@POST
	@Path("message")
	public Response sendMessageToKafka(String nomeProduto) {
		try {
			produtoEmitter.sendKafkaData(nomeProduto);
			return Response.ok("O nome do produto foi enviado parao Kafka").build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
}
