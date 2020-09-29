package ru.testtaskolga.testtask;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class TestTaskService {

    @Cacheable(value = "regionCache",key="{#regionName.toLowerCase()}")
    public Region getRegionInfo(String regionName, String type) {

        RestTemplate restTemplate = new RestTemplate();
        Region[] regions = restTemplate.getForObject(setUrl(regionName,type), Region[].class);

        for (Region region : regions){
            if (region.getType().equals("administrative")) {
                region.getGeojson().setCoordinates(
                        getMaxArea(region.getGeojson().getCoordinates(), region.getGeojson().getType()
                        )
                );
                return region;            }
        }
        return  new Region();
    }

    public String setUrl(String regionName, String type) {
        String url = "https://nominatim.openstreetmap.org/search?";
        if (type.equals("область")) {
            url = url + "state=";
        }
        else {
            url = url + "q=";
        }
        url = url + regionName +"&country=russia&format=json&polygon_geojson=1";
        return url;
    }

    private ArrayList getMaxArea(ArrayList coordinates, String type) {
        if (type.equals("Polygon")) {
            return searchMaxArea(coordinates);
        }
        else if (type.equals("MultiPolygon")) {
            return searchMaxAreaMultiPolygon(coordinates);
        }
        else {
            return coordinates;
        }
    }

    private ArrayList searchMaxAreaMultiPolygon(ArrayList coordinates) {
        return searchMaxArea((ArrayList)  coordinates.get(0));
    }

    private ArrayList searchMaxArea(ArrayList coordinates) {
        Integer maxSize = 0;
        ArrayList maxArrayCoordinate = new ArrayList();
        for (Object newCoordinate : coordinates) {
            ArrayList nC = (ArrayList) newCoordinate;
            if (nC.size() > maxSize) {
                maxSize = nC.size();
                maxArrayCoordinate = nC;
            }
        }
        return maxArrayCoordinate;
    }
}
