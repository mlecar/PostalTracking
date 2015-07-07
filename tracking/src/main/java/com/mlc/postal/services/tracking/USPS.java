package com.mlc.postal.services.tracking;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.core.JsonProcessingException;

public class USPS {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        ResteasyClient resteasyClient = resteasyClientBuilder.build();
        ResteasyWebTarget target = resteasyClient.target("http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2&XML=<TrackRequestUSERID=\"xxxxxxxxxxxx\"><TrackID ID=\"EJ958083578US\"></TrackID></TrackRequest>");

        Form form = new Form().param("API", "TrackV2");
        Response response = target.request().accept("application/xml").post(Entity.form(form));

        System.out.println(response.readEntity(String.class));
        /*
         * String tracking = response.readEntity(String.class);
         * 
         * ObjectReader reader = new ObjectMapper().reader(); JsonNode nodes =
         * reader.readTree(tracking);
         * 
         * for (JsonNode node : nodes) { // System.out.println(node);
         * System.out.println(node.get("data").asText());
         * System.out.println("\t" + node.get("local").asText() + " - " +
         * node.get("acao").asText()); System.out.println("\t" +
         * node.get("detalhes").asText()); }
         */}
}
