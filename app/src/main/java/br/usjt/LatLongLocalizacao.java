package br.usjt;

import java.io.Serializable;

public class LatLongLocalizacao implements Serializable {

    private int id;
    private Double latitude;
    private Double longitude;

    public LatLongLocalizacao(double latitude, double longitude) {
        this.latitude = longitude;
        this.longitude = longitude;
    }

    public LatLongLocalizacao(int id, double latitude, double longitude) {
        this(latitude, longitude);
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}