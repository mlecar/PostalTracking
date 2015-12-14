package com.mlc.postal.services.tracking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tracking-beans.xml")
public class TrackingTest {

    @Autowired
    private Tracking correiosBrazil;

    @Autowired
    private Tracking USPS;

    @Test
    public void track() throws Exception {
        correiosBrazil.track("CB105454173US");
        USPS.track("");
    }

}
