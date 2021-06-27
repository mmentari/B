package org.aplas.basicappx;

public class Weight {
    private double gram;

    Weight(){
        this.gram = 0;
    }
    public void setGram(double gram) {
        this.gram = gram;
    }
    public void setOunce(double ounce){
        this.gram = ounce * 28.3495231;
    }
    public void setPound (double pound){
        this.gram = pound * 453.59237;
    }

    public double getGram(){
        return this.gram;
    }
    public double getOunce(){
        return this.gram * 0.035274;
    }
    public double getPound(){
        return this.gram * 0.00220462;
    }

    public double convert(String oriUnit, String convUnit, double value){
        if (("Grm".equals(oriUnit)) && ("Grm".equals(convUnit))){
            return getGram();
        }else if (("Grm".equals(oriUnit)) && ("Onc".equals(convUnit))){
            return getOunce();
        }else if (("Grm".equals(oriUnit)) && ("Pnd".equals(convUnit))){
            return getPound();
        }else if (("Onc".equals(oriUnit)) && ("Grm".equals(convUnit))){
            return getGram();
        }else if (("Onc".equals(oriUnit)) && ("Onc".equals(convUnit))){
            return getOunce();
        }else  if (("Onc".equals(oriUnit)) && ("Pnd".equals(convUnit))){
            return getPound();
        }else if (("Pnd".equals(oriUnit)) && ("Grm".equals(convUnit))){
            return getGram();
        }else if (("Pnd".equals(oriUnit)) && ("Onc".equals(convUnit))){
            return getOunce();
        }else if (("Pnd".equals(oriUnit)) && ("Pnd".equals(convUnit))){
            return getPound();
        }else {
            return 0;
        }
    }
}
