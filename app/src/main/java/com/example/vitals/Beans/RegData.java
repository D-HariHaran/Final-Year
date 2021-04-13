package com.example.vitals.Beans;

public class RegData {


    public String name;
    public int age,male,currSmoker,cigsPerDay,bpMeds,prevStroke,prevHyp,diab,tenYearCHD,hardwareid;
    public double totchol,height,weight,glucose;


    public RegData(String name,
                   int age,
                   int male,
                   int currSmoker,
                   int cigsPerDay,
                   int bpMeds,
                   int prevStroke,
                   int prevHyp,
                   int diab,
                   int tenYearCHD,
                   double totchol,
                   double height,
                   double weight,
                   double glucose,
                   int hardwareid) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.currSmoker = currSmoker;
        this.cigsPerDay = cigsPerDay;
        this.bpMeds = bpMeds;
        this.prevStroke = prevStroke;
        this.prevHyp = prevHyp;
        this.diab = diab;
        this.tenYearCHD = tenYearCHD;
        this.totchol = totchol;
        this.height = height;
        this.weight = weight;
        this.glucose = glucose;
        this.hardwareid=hardwareid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getCurrSmoker() {
        return currSmoker;
    }

    public void setCurrSmoker(int currSmoker) {
        this.currSmoker = currSmoker;
    }

    public int getCigsPerDay() {
        return cigsPerDay;
    }

    public void setCigsPerDay(int cigsPerDay) {
        this.cigsPerDay = cigsPerDay;
    }

    public int getBpMeds() {
        return bpMeds;
    }

    public void setBpMeds(int bpMeds) {
        this.bpMeds = bpMeds;
    }

    public int getPrevStroke() {
        return prevStroke;
    }

    public void setPrevStroke(int prevStroke) {
        this.prevStroke = prevStroke;
    }

    public int getPrevHyp() {
        return prevHyp;
    }

    public void setPrevHyp(int prevHyp) {
        this.prevHyp = prevHyp;
    }

    public int getDiab() {
        return diab;
    }

    public void setDiab(int diab) {
        this.diab = diab;
    }

    public int getTenYearCHD() {
        return tenYearCHD;
    }

    public void setTenYearCHD(int tenYearCHD) {
        this.tenYearCHD = tenYearCHD;
    }

    public double getTotchol() {
        return totchol;
    }

    public void setTotchol(double totchol) {
        this.totchol = totchol;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }


    public int getHardwareid() {
        return hardwareid;
    }

    public void setHardwareid(int hardwareid) {
        this.hardwareid = hardwareid;
    }
}
