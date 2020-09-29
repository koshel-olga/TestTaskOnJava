package ru.testtaskolga.testtask;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {
    private String display_name;
    private float lat;
    private float lon;
    private String type;
    private List boundingbox;
    private Geojson geojson;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public Geojson getGeojson() {
        return geojson;
    }

    public List getBoundingbox() {
        return boundingbox;
    }

    public void setBoundingbox(List boundingbox) {
        this.boundingbox = boundingbox;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

}
