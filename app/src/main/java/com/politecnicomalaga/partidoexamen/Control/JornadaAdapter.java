package com.politecnicomalaga.partidoexamen.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.politecnicomalaga.partidoexamen.Model.Partido;
import com.politecnicomalaga.partidoexamen.R;
import java.util.LinkedList;
public class JornadaAdapter extends RecyclerView.Adapter<com.politecnicomalaga.partidoexamen.Control.JornadaViewHolder> {
    private final LinkedList<Partido> mList;
    private LayoutInflater mInflater;
    public JornadaAdapter(Context context,
                          LinkedList<Partido> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }
    @NonNull
    @Override
    public com.politecnicomalaga.partidoexamen.Control.JornadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.partidos_item,
                parent, false);
        return new com.politecnicomalaga.partidoexamen.Control.JornadaViewHolder(mItemView, this);
    }
    @Override
    public void onBindViewHolder(@NonNull com.politecnicomalaga.partidoexamen.Control.JornadaViewHolder holder, int position) {
        //TODO: fill data
       holder.setEquipo1(this.mList.get(position).getEquipo1());
       holder.setEquipo2(this.mList.get(position).getEquipo2());
       holder.setResultado(this.mList.get(position).getResultado());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
}
