package com.mlc.postal.services.tracking;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.core.JsonProcessingException;

public class USPS {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        ResteasyClient resteasyClient = resteasyClientBuilder.build();
        ResteasyWebTarget target = resteasyClient.target("http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2&XML=<TrackRequest USERID=\"792MLCSA6462\"><TrackID ID=\"CB105454173US\"></TrackID></TrackRequest>");
        // "http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2%20&XML=%3CTrackRequest%20USERID=%22792MLCSA6462%22%3E%20%3CTrackID%20ID=%22CB105454173US%22%3E%3C/TrackID%3E%3C/TrackRequest%3E");
        // http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2%20&XML=%3CTrackRequest%20USERID=%22792MLCSA6462%22%3E%20%3CTrackID%20ID=%22CB105454173US%22%3E%3C/TrackID%3E%3C/TrackRequest%3E
        // ("http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=<TrackRequestUSERID=\"790MLCSA6406\"><TrackID ID=\"CB105454173US\"></TrackID></TrackRequest>");
        // "http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=<TrackRequestUSERID=\"790MLCSA6406\"><TrackID ID=\"CB105454173US\"></TrackID></TrackRequest>");

        Response response = target.request().accept("application/xml").get();

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
