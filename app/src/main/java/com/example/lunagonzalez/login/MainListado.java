package com.example.lunagonzalez.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainListado extends AppCompatActivity {

    TextView Logueado;
    String cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Logueado = (TextView) findViewById(R.id.txtLogueado);

        Bundle recibir = this.getIntent().getExtras();

        cuenta = recibir.getString("logueado");

        Logueado.setText("Bienvenido " + cuenta + "!!!");


        Fragment fragmentListado = new FragmentListado();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFragment,fragmentListado);
        fragmentTransaction.commit();

    }
}
