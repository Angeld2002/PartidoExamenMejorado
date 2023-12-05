package com.politecnicomalaga.partidoexamen.Control;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class Peticion {
    public Peticion() {
    }
    public void requestData(String URL) {
        OkHttpClient cliente = new OkHttpClient();
        Request peticion = new Request.Builder()
                .url(URL)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();
         Call llamada = cliente.newCall(peticion);
         llamada.enqueue(new Callback() {
             public void onResponse(Call call, Response respuestaServer)
                     throws IOException {
                 String respuesta = respuestaServer.body().string();
                 Handler manejador = new Handler(Looper.getMainLooper());
                 manejador.post(new Runnable() {
                     @Override
                     public void run() {
                         MainController.getSingleton().setDataFromQuiniela(respuesta);
                     }
                 });
             }
             public void onFailure(Call call, IOException e) {
                 String respuesta = e.getMessage();
                 Handler manejador = new Handler(Looper.getMainLooper());
                 manejador.post(new Runnable() {
                     @Override
                     public void run() {
                         MainController.getSingleton().setDataFromQuiniela("");
                         MainController.getSingleton().setErrorFromQuiniela(respuesta);
                     }
                 });
             }
         });





    }

}
