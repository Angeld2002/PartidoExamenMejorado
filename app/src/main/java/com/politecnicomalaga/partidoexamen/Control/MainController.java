package com.politecnicomalaga.partidoexamen.Control;
import com.politecnicomalaga.partidoexamen.Model.Partido;
import com.politecnicomalaga.partidoexamen.View.MainActivity;
import java.util.LinkedList;
import java.util.List;
public class MainController {
    private static String DATA_URL;
    private static MainController mySingleController;
    private List<Partido> dataRequested;
    private static MainActivity activeActivity;
    private MainController() {
         dataRequested = new LinkedList<Partido>();
    }
    public static void setURL() {
        DATA_URL = "https://www.loteriasyapuestas.es/es/la-quiniela/escrutinios/la-quiniela-premios-y-ganadores-del-22-de-octubre-de-2023";
    }
    public static MainController getSingleton() {
        if (MainController.mySingleController == null) {
            mySingleController = new MainController();
        }
        return mySingleController;
    }
    public List<Partido> getDataFromQuiniela() {
        return this.dataRequested;
    }
    public static String getDataUrl() {
        return DATA_URL;
    }
    public void requestDataFromQuiniela() {
        Peticion p = new Peticion();
        p.requestData(DATA_URL);
    }
    public void setDataFromQuiniela(String json) {
        Respuesta answer = new Respuesta(json);
        dataRequested = answer.getData();
        //Load data on the list
        MainController.activeActivity.accessData();
    }
    public void setErrorFromQuiniela(String error) {
        //Load data on the list
        MainController.activeActivity.errorData(error);
    }
    public static void setActivity(MainActivity myAct) {
        activeActivity = myAct;
    }

}
