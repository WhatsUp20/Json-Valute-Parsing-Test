package com.example.appforfocus.focus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CurrencyResponce {

    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("PreviousDate")
    @Expose
    private String PreviousDate;

    @SerializedName("PreviousURL")
    @Expose
    private String PreviousURL;

    @SerializedName("Timestamp")
    @Expose
    private String Timestamp;

    @SerializedName("Valute")
    @Expose
    private Map<String, String> Valute;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPreviousDate() {
        return PreviousDate;
    }

    public void setPreviousDate(String previousDate) {
        PreviousDate = previousDate;
    }

    public String getPreviousURL() {
        return PreviousURL;
    }

    public void setPreviousURL(String previousURL) {
        PreviousURL = previousURL;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Map<String, String> getValute() {
        return Valute;
    }

    public void setValute(Map<String, String> valute) {
        Valute = valute;
    }
}
