package com.example.restapi.train;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class TrainList {

    private List<Train> trainList;

    public TrainList() {
    }

    @XmlElement(name="train")
    public List<Train> getTrains() {
        return trainList;
    }

    public void setTrains(List<Train> trainList) {
        this.trainList = trainList;
    }

}
