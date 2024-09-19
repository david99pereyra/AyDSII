package com.tp.spark.model;

public class Clima {
    private String name;
    private Main main;
    private Wind wind;

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public static class Main {
        private double temp;
        private int humidity;

        public double getTemp() {
            return temp;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }
    }

}
