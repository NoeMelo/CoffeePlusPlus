package com.example.laboratorioesan.ilunch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RVAdapterPlato extends RecyclerView.Adapter<PlatoViewHolder> {

    List<Plato> plato;
    //Método constructor que asigna la lista de personas
    RVAdapterPlato(List<Plato> plato) {
        this.plato = plato;
    }

    @Override
    public PlatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Se hace referencia al layout Item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plato, parent, false);
        PlatoViewHolder pvh = new PlatoViewHolder(vista);
        return pvh;
    }
    //Recibe el objeto PersonaViewHolder y la posición
    //Este método se va cargando tantas veces el número de datos o registros de acuerdo con getItemCount()
    @Override
    public void onBindViewHolder(PlatoViewHolder holder, int position) {
        holder.txtNombrePla.setText(plato.get(position).nombre);
        holder.txtTipoPla.setText(plato.get(position).tipo);
        holder.txtDescripcionPla.setText(plato.get(position).descripcion);
        holder.imgFotoPla.setImageResource(plato.get(position).fotoplato);
    }

    @Override
    public int getItemCount() {
        return plato.size();
    }
}