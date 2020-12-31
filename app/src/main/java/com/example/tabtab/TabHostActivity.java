package com.example.tabtab;

import android.app.Activity;
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
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class TabHostActivity extends AppCompatActivity {

    private ListView listaWebs;
    private Webs [] datos = {new Webs("google","https://www.google.com"/*,R.mipmap.logo_google*/),
            new Webs("PC Componentes","https://www.pccomponentes.com"/*,R.mipmap.pc_componentes*/),
            new Webs("PC Gamer", "https://www.pcgamer.com"/*,R.mipmap.pc_gamer*/)};
    private Menu buscar;
    private TextView lblTextView;
    private TabHost tabs;
    private final Cancion[] datosC = {
            new Cancion("Persona 1", "Cancion 1", "Texto del Cancion 1"),
            new Cancion("Persona 2", "Cancion 2", "Texto del Cancion 2"),
            new Cancion("Persona 3", "Cancion 3", "Texto del Cancion 3"),
            new Cancion("Persona 4", "Cancion 4", "Texto del Cancion 4"),
            new Cancion("Persona 5", "Cancion 5", "Texto del Cancion 5"),
            new Cancion("Persona 6", "Cancion 6", "Texto del Cancion 6"),
            new Cancion("Persona 7", "Cancion 7", "Texto del Cancion 7")
    };
    private final Telefono[] datosT = {
            new Telefono("945123789","Persona 1"),
            new Telefono("945789456","Persona 2"),
            new Telefono("945123456","Persona 3"),
            new Telefono("945741456","Persona 4"),
            new Telefono("945122586","Persona 5"),
            new Telefono("945129516","Persona 6"),
            new Telefono("945123376","Persona 7")
    };
    private ListView lstListado,lstTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestanas_tab_host);

        //Referencia al control principal TabHost y preparación para su configuración
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();
        setTitle("WhatsApp");
        //Objeto de tipo TabSpec para cada una de las pestañas
        //asignación layout correspondiente a la pestaña (setContent())
        //Indicaremos texto y/o icono de la pestaña (setIndicator(texto, icono))
        TabHost.TabSpec spec = tabs.newTabSpec("miTab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Llamadas");
        tabs.addTab(spec);


        spec = tabs.newTabSpec("miTab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Chats");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab3");
        spec.setContent(R.id.tab3);
        //spec.setIndicator("TAB 3", getResources().getDrawable(android.R.drawable.ic_menu_agenda));
        spec.setIndicator("Contactos", getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        //Pestaña activa al arrancar la aplicacion
        tabs.setCurrentTab(0);
        lstTel = findViewById(R.id.telefono);
        lstListado = findViewById(R.id.lvlLista1);
        AdaptadorTitulares adaptadorListView = new AdaptadorTitulares(this, datos);
        AdaptadorCancion adaptadorListViewC = new AdaptadorCancion(this, datosC);
        AdaptadorTelefonos adaptadorListView2 = new AdaptadorTelefonos(this, datosT);
        listaWebs = (ListView) findViewById(R.id.lvLista);
        listaWebs.setAdapter(adaptadorListView);
        lstListado.setAdapter(adaptadorListViewC);
        lstTel.setAdapter(adaptadorListView2);
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

    class AdaptadorTelefonos extends ArrayAdapter<Telefono> {
        public AdaptadorTelefonos(@NonNull TabHostActivity context, Telefono [] dat ) {
            super(context, R.layout.listatel, dat);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listatel, null);

            TextView tvURL = (TextView)item.findViewById(R.id.nombre);
            tvURL.setText(datosT[position].getNombre());

            TextView tvNombre = (TextView)item.findViewById(R.id.numero);
            tvNombre.setText(datosT[position].getNumero());

            return (item);
        }
    }
    class AdaptadorCancion extends ArrayAdapter<Cancion> {

        AdaptadorCancion(@NonNull TabHostActivity context, Cancion [] dat ) {
            super(context, R.layout.listacancion, dat);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listacancion, null);

            TextView lblDe = (TextView) item.findViewById(R.id.nomCancion);
            lblDe.setText(datosC[position].getNombreCancion());

            TextView lblAsunto = (TextView) item.findViewById(R.id.nomAutor);
            lblAsunto.setText(datosC[position].getAutor());
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
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int i = tabs.getCurrentTab();
                if(i == 0){
                    buscar.getItem(1).setIcon(ContextCompat.getDrawable(TabHostActivity.this, R.drawable.ic_otros));
               }else if(i == 1){
                    buscar.getItem(1).setIcon(ContextCompat.getDrawable(TabHostActivity.this, R.drawable.ic_otros1));

                }else{
                    buscar.getItem(1).setIcon(ContextCompat.getDrawable(TabHostActivity.this, R.drawable.ic_otros2));

                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        buscar = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}