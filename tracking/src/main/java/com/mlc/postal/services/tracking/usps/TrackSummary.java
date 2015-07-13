package com.mlc.postal.services.tracking.usps;

public class TrackSummary {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TrackSummary [" + text + "]";
    }

}
