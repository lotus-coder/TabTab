package com.example.tabtab;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

public class ActionBarActivity extends AppCompatActivity {
    private TextView lblTextView;
    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,
                getSupportFragmentManager(),android.R.id.tabcontent);

        //Introduce una nueva pestaña usando el método addTab().
        //Se indican3 parametros: Un objeto TabSpec
        //                        una clse con el fragment a visulizar en la pestaña,
        //                        un Bundle por si se quiere pasar información a la lengüeta.
        //El método newTabSpec() crea una nueva pestaña en un TabHost. Se le puede pasar
        //como parametro un String, que se utiliza como identificador y devuelve el objeto de tipo TabSpec creado.

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Lengüeta 1"),
                Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Lengüeta 2"),
                Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Lengüeta 3"),
                Tab3.class, null);
        lblTextView = findViewById(R.id.lblTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_opc1){
            lblTextView.append("\nBoton Opcion 1 pulsado");
            return true;
        }
        if (id == R.id.action_opc2){
            lblTextView.append("\nBoton opcion 2 pulsado");
            return true;
        }
        if (id == R.id.action_opc3){
            lblTextView.append("\nBoton opcion 3 pulsado");
            return true;
        }
        if (id == R.id.action_opc4){
            lblTextView.append("\nBoton opcion 4 pulsado");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}