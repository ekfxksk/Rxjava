package com.kyu.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private long weatherId;

    @Column(name="temperature")
    private int temperature;

    @Column(name="humidity")
    private int humidity;

    public Weather() { }

    public Weather(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
