package com.mlc.postal.services.tracking.usps;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TrackResponse")
public class TrackResponse {

    private TrackInfo trackInfo;

    public void setTrackInfo(TrackInfo trackInfo) {
        this.trackInfo = trackInfo;
    }

    @XmlElement(name = "TrackInfo")
    public TrackInfo getTrackInfo() {
        return trackInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(trackInfo.getID());
        sb.append("\n" + trackInfo.getTrackSummary());
        for (String trackDetail : trackInfo.getTrackDetail()) {
            sb.append("\n" + trackDetail);
        }
        return sb.toString();

    }

}
