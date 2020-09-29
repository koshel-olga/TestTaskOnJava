package ru.testtaskolga.testtask;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geojson{
    private String type;
    private ArrayList coordinates;

    public ArrayList getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
