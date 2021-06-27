package org.aplas.basicappx;

public class Temperature {
    private double celcius;
    Temperature(){
        this.celcius = 0;
    }
    void setCelcius(double C){
        this.celcius = C;
    }
    void setFahrenheit(double F){
        this.celcius = (F-32) * 5/9;
    }
    void setKelvins(double K){
        this.celcius = K - 273.15;
    }

    public double getCelcius(){
        return this.celcius;
    }

    public double getFahrenheit(){
        return this.celcius * 9/5 + 32;
    }

    public double getKelvins(){
        return this.celcius + 273.15;
    }

    double convert(String OriUnit, String convUnit, double valueOri){
        if (("°C".equals(OriUnit)) && ("°C".equals(convUnit))){
            return getCelcius();
        } else if (("°C".equals(OriUnit)) && ("°F".equals(convUnit))){
            return getFahrenheit();
        } else if (("°C".equals(OriUnit)) && ("K".equals(convUnit))) {
            return getKelvins();
        } else if (("°F".equals(OriUnit)) && ("°C".equals(convUnit))){
            return getCelcius();
        } else if (("°F".equals(OriUnit)) && ("°F".equals(convUnit))){
            return getFahrenheit();
        } else if (("°F".equals(OriUnit)) && ("K".equals(convUnit))){
            return getKelvins();
        }else if (("K".equals(OriUnit)) && ("°C".equals(convUnit))){
            return getCelcius();
        } else if (("K".equals(OriUnit)) && ("°F".equals(convUnit))){
            return getFahrenheit();
        } else if (("K".equals(OriUnit)) && ("K".equals(convUnit))){
            return getKelvins();
        } else {
            return 0;
        }
    }
}
