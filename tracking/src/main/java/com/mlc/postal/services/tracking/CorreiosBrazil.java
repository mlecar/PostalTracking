package com.mlc.postal.services.tracking;

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
        String[] trackingCodes = new String[] { "CB105454173US", "CB105450389US" };

        ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        ResteasyClient resteasyClient = resteasyClientBuilder.build();

        for (String trackingCode : trackingCodes) {
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
    }

}
