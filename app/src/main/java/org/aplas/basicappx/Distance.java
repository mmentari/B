package org.aplas.basicappx;

public class Distance {
    private double meter;
    Distance(){
        this.meter = 0;
    }
    //setter
    public void setMeter (double m){
        this.meter = m;
    }
    public void setInch (double i){
        this.meter =  i /39.3701 ;
    }
    public void setMile (double mi){
        this.meter = mi /0.000621371;
    }
    public void setFoot (double f){
        this.meter = f/3.28084;
    }

    //getter
    double getMeter(){
        return this.meter;
    }
    double getInch(){
        return this.meter * 39.3701;
    }
    double getMile(){
        return this.meter /1609;
    }
    double getFoot(){
        return this.meter * 3.28084;
    }

    //method convert
    double convert (String oriUnit, String convUnit, double value) {
        if (("Mtr".equals(oriUnit)) && ("Mtr".equals(convUnit))) {
            return getMeter();
        } else if (("Mtr".equals(oriUnit)) && ("Inc".equals(convUnit))) {
            return getInch();
        } else if (("Mtr".equals(oriUnit)) && ("Mil".equals(convUnit))) {
            return getMile();
        } else if (("Mtr".equals(oriUnit)) && ("Ft".equals(convUnit))) {
            return getFoot();
        } else if (("Inc".equals(oriUnit)) && ("Mtr".equals(convUnit))) {
            return getMeter();
        } else if (("Inc".equals(oriUnit)) && ("Inc".equals(convUnit))) {
            return getInch();
        } else if (("Inc".equals(oriUnit)) && ("Mil".equals(convUnit))) {
            return getMile();
        } else if (("Inc".equals(oriUnit)) && ("Ft".equals(convUnit))) {
            return getFoot();
        } else if (("Mil".equals(oriUnit)) && ("Mtr".equals(convUnit))) {
            return getMeter();
        } else if (("Mil".equals(oriUnit)) && ("Inc".equals(convUnit))) {
            return getInch();
        } else if (("Mil".equals(oriUnit)) && ("Mil".equals(convUnit))) {
            return getMile();
        } else if (("Mil".equals(oriUnit)) && ("Ft".equals(convUnit))) {
            return getFoot();
        } else if (("Ft".equals(oriUnit)) && ("Mtr".equals(convUnit))) {
            return getMeter();
        } else if (("Ft".equals(oriUnit)) && ("Inc".equals(convUnit))) {
            return getInch();
        } else if (("Ft".equals(oriUnit)) && ("Mil".equals(convUnit))) {
            return getMile();
        } else if (("Ft".equals(oriUnit)) && ("Ft".equals(convUnit))) {
            return getFoot();
        }else {
            return 0;
        }
    }

}
