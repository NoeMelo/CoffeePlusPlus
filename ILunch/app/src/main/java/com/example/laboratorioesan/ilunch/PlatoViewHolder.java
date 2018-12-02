package com.example.laboratorioesan.ilunch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlatoViewHolder extends RecyclerView.ViewHolder {

    TextView txtNombrePla;
    TextView txtTipoPla;
    TextView txtDescripcionPla;
    ImageView imgFotoPla;

    PlatoViewHolder(View itemView) {
        super(itemView);
        txtNombrePla = (TextView) itemView.findViewById(R.id.txtNombrePla);
        txtTipoPla = (TextView) itemView.findViewById(R.id.txtTipoPla);
        txtDescripcionPla = (TextView) itemView.findViewById(R.id.txtDescripcionPla);
        imgFotoPla = (ImageView) itemView.findViewById(R.id.imgFotoPla);
    }
}