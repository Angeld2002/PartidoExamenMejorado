package com.politecnicomalaga.partidoexamen.Control;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.politecnicomalaga.partidoexamen.R;
public class JornadaViewHolder extends RecyclerView.ViewHolder {
    final JornadaAdapter mAdapter;
    private TextView tvEquipo1;
    private TextView tvEquipo2;
    private TextView tvResultado;
    public JornadaViewHolder(View itemView, JornadaAdapter adapter) {
        super(itemView);
        tvEquipo1 = itemView.findViewById(R.id.Equipo1);
        tvEquipo2 = itemView.findViewById(R.id.Equipo2);
        tvResultado = itemView.findViewById(R.id.Resultado);
        this.mAdapter = adapter;
    }
    public void setEquipo1(String data) {
        tvEquipo1.setText(data);
    }
    public void setEquipo2(String data) {
        tvEquipo2.setText(data);
    }
    public void setResultado(String data) {
        tvResultado.setText(data);
    }
}
