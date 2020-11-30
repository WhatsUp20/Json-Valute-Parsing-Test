package com.example.appforfocus;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "valutes")
public class Valutes {

    public Valutes(int ide, String ID, String NumCode, String CharCode, float Nominal, String Name, float Value, float Previous) {
        this.ide = ide;
        this.ID = ID;
        this.NumCode = NumCode;
        this.CharCode = CharCode;
        this.Nominal = Nominal;
        this.Name = Name;
        this.Value = Value;
        this.Previous = Previous;
    }

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int ide;

    public int getIde() {
        return ide;
    }

    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("NumCode")
    @Expose
    private String NumCode;
    @SerializedName("CharCode")
    @Expose
    private String CharCode;
    @SerializedName("Nominal")
    @Expose
    private float Nominal;
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Value")
    @Expose
    private float Value;
    @SerializedName("Previous")
    @Expose
    private float Previous;

    public String getID() {
        return ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public float getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public float getValue() {
        return Value;
    }

    public float getPrevious() {
        return Previous;
    }

    // Setter Methods

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNumCode(String NumCode) {
        this.NumCode = NumCode;
    }

    public void setCharCode(String CharCode) {
        this.CharCode = CharCode;
    }

    public void setNominal(float Nominal) {
        this.Nominal = Nominal;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setValue(float Value) {
        this.Value = Value;
    }

    public void setPrevious(float Previous) {
        this.Previous = Previous;
    }
    }

