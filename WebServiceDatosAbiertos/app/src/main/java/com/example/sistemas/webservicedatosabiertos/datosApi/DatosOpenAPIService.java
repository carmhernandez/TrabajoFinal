package com.example.sistemas.webservicedatosabiertos.datosApi;

import com.example.sistemas.webservicedatosabiertos.models.Gobernacion;
import com.example.sistemas.webservicedatosabiertos.models.Vehiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 22/05/17.
 */

public interface DatosOpenAPIService {

    @GET("rvmt-7x4r.json") //se modifica segun la pagina
    Call<List<Vehiculo>> obtenerListaReporteVehículos ();  //se modifica segun el listado

    @GET("8fk7-6imt.json") //se modifica segun la pagina
    Call<List<Gobernacion>> obtenerListaReporteGobernacion();
}
