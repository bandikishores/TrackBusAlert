
package com.bandi.trackbusalert.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Result implements Serializable
{

    private Integer destinationIndex;
    private Integer originIndex;
    private Integer totalWalkDuration;
    private Double travelDistance;
    private Double travelDuration;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4345331844341217072L;

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }

    public Integer getOriginIndex() {
        return originIndex;
    }

    public void setOriginIndex(Integer originIndex) {
        this.originIndex = originIndex;
    }

    public Integer getTotalWalkDuration() {
        return totalWalkDuration;
    }

    public void setTotalWalkDuration(Integer totalWalkDuration) {
        this.totalWalkDuration = totalWalkDuration;
    }

    public Double getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(Double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public Double getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(Double travelDuration) {
        this.travelDuration = travelDuration;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
