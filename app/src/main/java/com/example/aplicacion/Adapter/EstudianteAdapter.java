package com.example.aplicacion.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplicacion.LogicaNegocio.Estudiante;
import com.example.aplicacion.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstudianteAdapter extends RecyclerView.Adapter<EstudianteAdapter.MyViewHolder>
        implements Filterable {

    private List<Estudiante> listaEstudiantes;
    private List<Estudiante> alumnoListFiltered;
    private EstudianteAdapterListener listener; // Por medio de la interfaz creada

    // NUEVA CLASE ANIDADA
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView titulo1, titulo2, descripcion;
        public RelativeLayout vistaPrincipal, vistaEditar, vistaBorrar;

        // Se debe crear un constructor super
        public MyViewHolder(View view) {
            super(view);
            // busca dentro del layout donde tiene que mostrar la informacion => findViewById
            titulo1 = view.findViewById(R.id.titulo1_vp);
            titulo2 = view.findViewById(R.id.titulo2_vp);
            descripcion = view.findViewById(R.id.description_vp);
            vistaPrincipal = view.findViewById(R.id.vista_principal); // foreground
            vistaEditar = view.findViewById(R.id.vista_editar);
            vistaBorrar  = view.findViewById(R.id.vista_borrar);
        }
    } // TERMINA LA CLASE MyViewHolder

    //  Constructor de EstudianteAdapter
    public EstudianteAdapter(List<Estudiante> listaEstudiantes, EstudianteAdapterListener listener){
        this.listaEstudiantes = listaEstudiantes;
        this.listener = listener;
        // init filter
        this.alumnoListFiltered = listaEstudiantes;
    }

    // METODOS QUE SE ORIGINAN CON LA HERENCIA DE LA CLASE PRINCIPAL
    @Override
    public EstudianteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // asigna un layout XML en una vista
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EstudianteAdapter.MyViewHolder holder, int position) {
        final Estudiante estudiante = alumnoListFiltered.get(position);
        holder.titulo1.setText(estudiante.getCedula());
        holder.titulo2.setText(estudiante.getNombre());
        holder.descripcion.setText(estudiante.getCarrera());
    }

    @Override
    public int getItemCount() {
        return alumnoListFiltered.size();
    }

    public void onItemMove(int fromPosition, int toPosition) {
        if (listaEstudiantes.size() == alumnoListFiltered.size()) { // without filter
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(listaEstudiantes, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(listaEstudiantes, i, i - 1);
                }
            }
        } else {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(alumnoListFiltered, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(alumnoListFiltered, i, i - 1);
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

     // METODOS QUE SE ORIGINAN CON LA IMPLEMENTACION DE Filterable
    @Override
    public Filter getFilter() {
        return null;
    }

    // Creacion de interfaz
    public interface EstudianteAdapterListener {
        void onContactSelected(Estudiante alumno);
    }
}
