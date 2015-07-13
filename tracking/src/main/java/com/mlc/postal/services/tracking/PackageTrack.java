package com.mlc.postal.services.tracking;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class PackageTrack {

    @Autowired
    private static USPS usps;

    @Autowired
    private static CorreiosBrazil correios;

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        String[] trackingCodes = new String[] { "CB105454173US", "CB105450389US" };

        for (String trackingCode : trackingCodes) {
            usps.track(trackingCode);
            correios.track(trackingCode);
        }

    }
}
