package com.mlc.postal.services.tracking.usps;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TrackInfo {

    private String ID;

    private String trackSummary;

    private List<String> trackDetail;

    @XmlAttribute(name = "ID")
    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    @XmlElement(name = "TrackSummary")
    public String getTrackSummary() {
        return trackSummary;
    }

    public void setTrackSummary(String trackSummary) {
        this.trackSummary = trackSummary;
    }

    @XmlElement(name = "TrackDetail")
    public List<String> getTrackDetail() {
        return trackDetail;
    }

    public void setTrackDetail(List<String> trackDetail) {
        this.trackDetail = trackDetail;
    }

    @Override
    public String toString() {
        return "TrackInfo [ID=" + ID + ", trackSummary=" + trackSummary + ", trackDetail=" + trackDetail + "]";
    }

}
