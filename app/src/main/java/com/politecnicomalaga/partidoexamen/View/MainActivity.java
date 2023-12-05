package com.politecnicomalaga.partidoexamen.View;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.politecnicomalaga.partidoexamen.Control.JornadaAdapter;
import com.politecnicomalaga.partidoexamen.Control.MainController;
import com.politecnicomalaga.partidoexamen.Model.Partido;
import com.politecnicomalaga.partidoexamen.R;
import java.util.LinkedList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private LinkedList<Partido> mList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private JornadaAdapter mAdapter;
    private static MainActivity myActiveActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_Quiniela);
        mAdapter = new JornadaAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainController.setURL();
        MainController.getSingleton().requestDataFromQuiniela();
        MainActivity.myActiveActivity = this;
        MainController.setActivity(this);;
    }
    public void accessData() {
        List<Partido> nuevaLista = MainController.getSingleton().getDataFromQuiniela();
        mList.clear();
        for (Partido item:nuevaLista) {
            mList.add(item);
        }
        mAdapter.notifyDataSetChanged();
        TextView tv = (TextView) findViewById(R.id.tv_futbolDesc);
    }
    public void errorData(String error) {
        TextView tv = (TextView) findViewById(R.id.tv_futbolDesc);
        tv.setText(error);
    }
}
