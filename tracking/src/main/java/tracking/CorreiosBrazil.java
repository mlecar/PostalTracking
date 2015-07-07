package tracking;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class CorreiosBrazil {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        ResteasyClient resteasyClient = resteasyClientBuilder.build();
        ResteasyWebTarget target = resteasyClient.target("http://developers.agenciaideias.com.br/correios/rastreamento/json/CB105450389US");

        Response response = target.request().accept("application/json").get();
        String tracking = response.readEntity(String.class);

        ObjectReader reader = new ObjectMapper().reader();
        JsonNode nodes = reader.readTree(tracking);

        for (JsonNode node : nodes) {
            // System.out.println(node);
            System.out.println(node.get("data").asText());
            System.out.println("\t" + node.get("local").asText() + " - " + node.get("acao").asText());
            System.out.println("\t" + node.get("detalhes").asText());
        }
    }

}
