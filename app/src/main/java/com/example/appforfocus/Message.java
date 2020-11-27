package com.example.appforfocus;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("ID")
    private String id;
    @SerializedName("NumCode")
    private int numCode;
    @SerializedName("CharCode")
    private String charCode;
    @SerializedName("Nominal")
    private int nominal;
    @SerializedName("Name")
    private String name;
    @SerializedName("Value")
    private double value;
    @SerializedName("Previous")
    private double previous;

    public Message(String id, int numCode, String charCode, int nominal, String name, double value, double previous) {

        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.previous = previous;
    }
}
