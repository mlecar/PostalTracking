package com.mlc.postal.services.tracking;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Component
public class CorreiosBrazil implements Tracking {

    public void track(String trackingCode) throws JsonProcessingException, IOException {
        ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        ResteasyClient resteasyClient = resteasyClientBuilder.build();

        System.out.println("######## trackingCode " + trackingCode + " ##########");
        ResteasyWebTarget target = resteasyClient.target("http://developers.agenciaideias.com.br/correios/rastreamento/json/{trackingCode}").resolveTemplate("trackingCode", trackingCode);

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

    public static void main(String[] args) throws JsonProcessingException, IOException {
        new CorreiosBrazil().track("CB105454173US");
        new CorreiosBrazil().track("CB105450389US");
    }

}
