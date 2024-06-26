package ru.nikidzawa.datingapp.telegramBot.services.parsers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


@Component
public class JsonParser {
    @SneakyThrows
    public String getName(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        AddressResponse addressResponse = objectMapper.readValue(json, AddressResponse.class);
        AddressResponse.Address address = addressResponse.getAddress();

        return address.getCity() != null ? address.getCity()
                : address.getMunicipality() != null ? address.getMunicipality()
                : address.getVillage() != null ? address.getVillage()
                : address.getTown() != null ? address.getTown()
                : address.getState() != null ? address.getState()
                : address.getCountry() != null ? address.getCountry()
                : "Москва";
    }

    public Geocode parseGeocode(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode featureMemberNode = rootNode.path("response")
                    .path("GeoObjectCollection")
                    .path("featureMember");

            JsonNode firstGeoObjectNode = featureMemberNode.get(0).path("GeoObject");
            JsonNode pointNode = firstGeoObjectNode.path("Point");
            String pos = pointNode.path("pos").asText();
            String[] lonLat = pos.split(" ");
            Geocode geocode = new Geocode();
            geocode.setLon(Double.parseDouble(lonLat[0]));
            geocode.setLat(Double.parseDouble(lonLat[1]));
            return geocode;
        } catch (Exception e) {
            Geocode geocode = new Geocode();
            geocode.setLat(55.7535926);
            geocode.setLon(37.62148935239179);
            return geocode;
        }
    }
}

