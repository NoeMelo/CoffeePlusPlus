package com.example.laboratorioesan.ilunch;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
public class  PlatoAdapter extends ArrayAdapter<Plato>  {

    private List<Plato> productos;

    public PlatoAdapter(Context context, List<Plato> productos){
        super(context, R.layout.item, productos);
        this.productos = productos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item, null);
        }

        TextView tvCodigo = (TextView) view.findViewById(R.id.nombreplatos);

        tvCodigo.setText(String.valueOf(productos.get(position).getNombre()));


        return view;
    }
}
