package com.example.lunagonzalez.login;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Luna Gonzalez on 15/06/2016.
 */
public class FragmentListado extends Fragment {

    private Receta[] datos =
            new Receta[]{
                    new Receta("Pan con chancho", "Ingrediente", "Preparacion","xvideos.com",2000),
                    new Receta("Pan con palta", "Ingrediente2", "Preparacion2","pornhub.com",3000),
            };

    private ListView listaRecetas;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_listado, container, false);
    }


    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        listaRecetas = (ListView) getView().findViewById(R.id.listadoRecetas);

        listaRecetas.setAdapter(new AdaptadorRecetas(this));

        listaRecetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {

                Fragment fragmentDetalle = new FragmentDetalle();

                Receta correo = datos[pos];

                Bundle args = new Bundle();
                args.putString("detalle",correo.getNombre());
                fragmentDetalle.setArguments(args);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                //fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.mainFragment, fragmentDetalle, "det");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    }


    class AdaptadorRecetas extends ArrayAdapter<Receta> {

        Activity context;

        AdaptadorRecetas(Fragment context) {
            super(context.getActivity(), R.layout.fragment_itemrecetas, datos);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.fragment_itemrecetas, null);

            TextView lblIng = (TextView)item.findViewById(R.id.ingredientes);
            lblIng.setText(datos[position].getIngredientes());

            TextView lblPre = (TextView)item.findViewById(R.id.preparacion);
            lblPre.setText(datos[position].getPreparacion());

            TextView lblUrl = (TextView)item.findViewById(R.id.url);
            lblUrl.setText(datos[position].getUrl());

            TextView lblPr = (TextView)item.findViewById(R.id.precio);
            lblPr.setText(datos[position].getPrecio());

            return(item);
        }
    }


}

