package com.example.aplicacion.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.aplicacion.AccesoDatos.ModeloDatos;
import com.example.aplicacion.Adapter.CarreraAdapter;
import com.example.aplicacion.Helper.RecyclerItemTouchHelper;
import com.example.aplicacion.LogicaNegocio.Carrera;
import com.example.aplicacion.R;

import java.util.ArrayList;
import java.util.List;

public class AdmCarreraActivity extends AppCompatActivity
implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, CarreraAdapter.CarreraAdapterListener {

    private RecyclerView mRecyclerView;
    private CarreraAdapter mAdapter;
    private List<Carrera> listaCarreras;
    private CoordinatorLayout coordinatorLayout;
    private SearchView searchView;
    private FloatingActionButton fab;
    private ModeloDatos modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_carrera);
        Toolbar toolbar = findViewById(R.id.toolbarCarrera);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Carreras"); // Para el titulo del activity

        mRecyclerView = findViewById(R.id.recycler_carrera); // llamo al recyclerView a utilizar
        listaCarreras = new ArrayList<>();
        modelo = new ModeloDatos();
        listaCarreras = modelo.getListaCarreras();
        mAdapter = new CarreraAdapter(listaCarreras, this);
        coordinatorLayout = findViewById(R.id.coordinatorLayout_Carrera);

        // Para la barra de notificacion
        whiteNotificationBar(mRecyclerView); // metodo de la clase

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregar carreras", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Swiping left and right
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);


        // Para refrescar las vistas
        mAdapter.notifyDataSetChanged();
    }

    // Para deslizamientos
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        if (direction == ItemTouchHelper.START) {
            // Notifica el movimiento
            mAdapter.notifyDataSetChanged(); //restart left swipe view
        } else {
            // Notifica el movimiento
            mAdapter.notifyDataSetChanged(); //restart left swipe view
        }
    }

    // Posiciones de movimiento
    @Override
    public void onItemMove(int source, int target) {
        mAdapter.onItemMove(source, target);
    }

    // Para que retroceda al menu principal
    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        // Se devuelve al NavDrawer
        Intent a = new Intent(this, NavDrawerActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
        super.onBackPressed();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    // Nace de la implementacion de CarreraAdapter y listener
    @Override
    public void onContactSelected(Carrera carrera) {

    }
}
