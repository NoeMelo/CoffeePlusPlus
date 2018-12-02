package com.example.laboratorioesan.ilunch;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Luis Chang on 13/09/2017.
 */

//Recibe una clase que hace referencia a los controles(items que se van a repetir)
public class RVAdapter extends RecyclerView.Adapter<PersonaViewHolder> {

    List<Restaurante> restaurantes;
    //Método constructor que asigna la lista de personas
    RVAdapter(List<Restaurante> personas) {
        this.restaurantes = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Se hace referencia al layout Item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        PersonaViewHolder pvh = new PersonaViewHolder(vista);
        return pvh;
    }
    //Recibe el objeto PersonaViewHolder y la posición
    //Este método se va cargando tantas veces el número de datos o registros de acuerdo con getItemCount()
    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        holder.txtNombre.setText(restaurantes.get(position).nombre);
        holder.txtAnno.setText(restaurantes.get(position).descripcion);
        holder.imgFoto.setImageResource(restaurantes.get(position).fotores);
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }
}