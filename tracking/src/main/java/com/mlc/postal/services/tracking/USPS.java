package com.mlc.postal.services.tracking;

import java.io.IOException;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mlc.postal.services.tracking.usps.TrackResponse;

@Component
public class USPS {

    public void track(String trackingCode) throws JsonProcessingException, IOException {
        ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        ResteasyClient resteasyClient = resteasyClientBuilder.build();
        ResteasyWebTarget target = resteasyClient.target("http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2&XML=<TrackRequest USERID=\"792MLCSA6462\"><TrackID ID=\"CB105454173US\"></TrackID></TrackRequest>");
        // "http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2%20&XML=%3CTrackRequest%20USERID=%22792MLCSA6462%22%3E%20%3CTrackID%20ID=%22CB105454173US%22%3E%3C/TrackID%3E%3C/TrackRequest%3E");
        // http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2%20&XML=%3CTrackRequest%20USERID=%22792MLCSA6462%22%3E%20%3CTrackID%20ID=%22CB105454173US%22%3E%3C/TrackID%3E%3C/TrackRequest%3E
        // ("http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=<TrackRequestUSERID=\"790MLCSA6406\"><TrackID ID=\"CB105454173US\"></TrackID></TrackRequest>");
        // "http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=<TrackRequestUSERID=\"790MLCSA6406\"><TrackID ID=\"CB105454173US\"></TrackID></TrackRequest>");

        TrackResponse response = target.request().accept("application/xml").get(TrackResponse.class);

        System.out.println(response);
    }
}
