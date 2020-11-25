package com.fitnessapp_18011883;

public class UserWeights {
    String MorningWeight;
    String AfternoonWeight;
    String NightWeight;

    public String getMorningWeight() {
        return MorningWeight;
    }

    public void setMorningWeight(String morningWeight) {
        MorningWeight = morningWeight;
    }

    public String getAfternoonWeight() {
        return AfternoonWeight;
    }

    public void setAfternoonWeight(String afternoonWeight) {
        AfternoonWeight = afternoonWeight;
    }

    public String getNightWeight() {
        return NightWeight;
    }

    public void setNightWeight(String nightWeight) {
        NightWeight = nightWeight;
    }

    public UserWeights(){
        //default constructor
    }

    public UserWeights(String morningWeight, String afternoonWeight, String nightWeight) {
        MorningWeight = morningWeight;
        AfternoonWeight = afternoonWeight;
        NightWeight = nightWeight;
    }
}
