package com.example.tabtab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TabHostActivity extends AppCompatActivity {

    private ListView listaWebs;
    private Webs [] datos = {new Webs("google","https://www.google.com"/*,R.mipmap.logo_google*/),
            new Webs("PC Componentes","https://www.pccomponentes.com"/*,R.mipmap.pc_componentes*/),
            new Webs("PC Gamer", "https://www.pcgamer.com"/*,R.mipmap.pc_gamer*/)};

    private TextView lblTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestanas_tab_host);

        //Referencia al control principal TabHost y preparación para su configuración
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        //Objeto de tipo TabSpec para cada una de las pestañas
        //asignación layout correspondiente a la pestaña (setContent())
        //Indicaremos texto y/o icono de la pestaña (setIndicator(texto, icono))
        TabHost.TabSpec spec = tabs.newTabSpec("miTab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TAB 1", getResources().getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB 2", getResources().getDrawable(android.R.drawable.ic_dialog_info));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab3");
        spec.setContent(R.id.tab3);
        //spec.setIndicator("TAB 3", getResources().getDrawable(android.R.drawable.ic_menu_agenda));
        spec.setIndicator("", getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        //Pestaña activa al arrancar la aplicacion
        tabs.setCurrentTab(0);
        lblTextView = findViewById(R.id.lblTextView);
        AdaptadorTitulares adaptadorListView = new AdaptadorTitulares(this, datos);
        listaWebs = (ListView) findViewById(R.id.lvLista);
        listaWebs.setAdapter(adaptadorListView);
        eventos();
    }

    class AdaptadorTitulares extends ArrayAdapter<Webs> {
        public AdaptadorTitulares(@NonNull TabHostActivity context, Webs [] dat ) {
            super(context, R.layout.listawebs, dat);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listawebs, null);

            TextView tvURL = (TextView)item.findViewById(R.id.urlWeb);
            tvURL.setText(datos[position].getUrl());

            TextView tvNombre = (TextView)item.findViewById(R.id.nombreWeb);
            tvNombre.setText(datos[position].getNombre());

            ImageView ivRuta = (ImageView) item.findViewById(R.id.imagenWeb);
            ivRuta.setImageResource(datos[position].getImagen());
            return (item);
        }
    }
    private void  eventos(){
        listaWebs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Webs w = (Webs) listaWebs.getItemAtPosition(position);
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(w.getUrl()));
                startActivity(intent);
            }
        });
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