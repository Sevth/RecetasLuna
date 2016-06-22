package com.example.lunagonzalez.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Luna Gonzalez on 15/06/2016.
 */
public class FragmentDetalle extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_detalle, container, false);

        String detalleI = this.getArguments().getString("detalle1");
        String detalleP = this.getArguments().getString("detalle2");
        String detalleU = this.getArguments().getString("detalle3");
        String detallePR = this.getArguments().getString("detalle4");

        TextView Ing = (TextView)root.findViewById(R.id.txtIngrediente);
        Ing.setText(detalleI);
        TextView Pre = (TextView)root.findViewById(R.id.txtPreparacion);
        Pre.setText(detalleP);
        TextView Url = (TextView)root.findViewById(R.id.txtUrl);
        Url.setText(detalleU);
        TextView Precio = (TextView)root.findViewById(R.id.txtPrecio);
        Precio.setText(detallePR);


        return root;


    }

}
