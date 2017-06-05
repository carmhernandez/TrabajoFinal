package com.example.sistemas.webservicedatosabiertos.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sistemas on 22/05/17.
 */

public class Gobernacion {

    @SerializedName("ips")
    @Expose
    private String ips;
    @SerializedName("marca")
    @Expose
    private String marca;
    @SerializedName("modelo")
    @Expose
    private String modelo;
    @SerializedName("placa")
    @Expose
    private String placa;
    @SerializedName("propiedad")
    @Expose
    private String propiedad;
    @SerializedName("tipo")
    @Expose
    private String tipo;

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
