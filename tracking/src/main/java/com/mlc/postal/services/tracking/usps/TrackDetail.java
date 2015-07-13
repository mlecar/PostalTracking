package com.mlc.postal.services.tracking.usps;

public class TrackDetail {

    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "TrackDetail [detail=" + detail + "]";
    }

}
