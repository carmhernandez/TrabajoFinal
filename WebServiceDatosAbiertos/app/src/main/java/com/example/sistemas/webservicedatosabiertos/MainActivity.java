package com.example.sistemas.webservicedatosabiertos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sistemas.webservicedatosabiertos.datosApi.DatosOpenAPIService;
import com.example.sistemas.webservicedatosabiertos.models.Gobernacion;
import com.example.sistemas.webservicedatosabiertos.models.Vehiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    public final static String TAG = "OpenData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")  //url Base debe tenerminar con el > /
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatosVehiculo();
        obtenerDatosGobernacion();
    }

    private void obtenerDatosGobernacion() {


        {
            DatosOpenAPIService service = retrofit.create(DatosOpenAPIService.class);//se reemplazan el arraylist

            Call<List<Gobernacion>> GobernacionRespuestaCall = service.obtenerListaReporteGobernacion(); // regresa un arreglo <<list>
            GobernacionRespuestaCall.enqueue(new Callback<List<Gobernacion>>() {
                @Override
                public void onResponse(Call<List<Gobernacion>> call, Response<List<Gobernacion>> response) { //se importan
                    if (response.isSuccessful()) {
                        List lista = response.body(); //se crea un objeto de tipo lista

                        for (int i = 0; i < lista.size(); i++) // vaya de 0 hasta toda la lista
                        {
                            Gobernacion p = (Gobernacion) lista.get(i); //de la lista se crea un objeto de tipo Vehiculo, saca el primer objeto y lo carca en vehiculo
                            Log.i(TAG, " nombre: " + p.getMarca()+ " particular: " + p.getPlaca()); // se reemplaza de acuerdo a los datos
                        }

                    } else {
                        Log.e(TAG, "onResponse: " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Gobernacion>> call, Throwable t) {
                    Log.e(TAG, " onFailure: " + t.getMessage());
                }
            });
        }
    }


    private void obtenerDatosVehiculo() {
        DatosOpenAPIService service = retrofit.create(DatosOpenAPIService.class);//se reemplazan el arraylist

        Call<List<Vehiculo>> VehiculoRespuestaCall = service.obtenerListaReporteVehículos(); // regresa un arreglo <<list>
        VehiculoRespuestaCall.enqueue(new Callback<List<Vehiculo>>() {
            @Override
            public void onResponse(Call<List<Vehiculo>> call, Response<List<Vehiculo>> response) { //se importan
                if (response.isSuccessful()) {
                    List lista = response.body(); //se crea un objeto de tipo lista

                    for (int i = 0; i < lista.size(); i++) // vaya de 0 hasta toda la lista
                    {
                        Vehiculo p = (Vehiculo) lista.get(i); //de la lista se crea un objeto de tipo Vehiculo, saca el primer objeto y lo carca en vehiculo
                        Log.i(TAG, " nombre: " + p.getParticular() + " particular: " + p.getPublico()); // se reemplaza de acuerdo a los datos
                    }

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Vehiculo>> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
}

