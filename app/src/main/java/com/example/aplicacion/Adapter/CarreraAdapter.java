package com.example.aplicacion.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aplicacion.LogicaNegocio.Carrera;
import com.example.aplicacion.R;

import java.util.Collections;
import java.util.List;

public class CarreraAdapter extends RecyclerView.Adapter<CarreraAdapter.MyViewHolder> {

    private List<Carrera> listaCarreras;
    private List<Carrera> filtroListaCarreras;
    private CarreraAdapterListener listener; // Por medio de la interfaz creada

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
    public CarreraAdapter(List<Carrera> listaCarreras, CarreraAdapterListener listener){
        this.listaCarreras = listaCarreras;
        this.listener = listener;
        // init filter
        this.filtroListaCarreras = listaCarreras;
    }

    // METODOS QUE SE ORIGINAN CON LA HERENCIA DE LA CLASE PRINCIPAL
    @Override
    public CarreraAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // asigna un layout XML en una vista
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarreraAdapter.MyViewHolder holder, int position) {
        final Carrera carrera = filtroListaCarreras.get(position);
        holder.titulo1.setText(carrera.getCodigo());
        holder.titulo2.setText(carrera.getNombre());
        holder.descripcion.setText(carrera.getTitulo());
    }

    @Override
    public int getItemCount() {
        return filtroListaCarreras.size();
    }

    public void onItemMove(int fromPosition, int toPosition) {
        if (listaCarreras.size() == filtroListaCarreras.size()) { // without filter
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(listaCarreras, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(listaCarreras, i, i - 1);
                }
            }
        } else {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(filtroListaCarreras, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(filtroListaCarreras, i, i - 1);
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    // Creacion de interfaz
    public interface CarreraAdapterListener {
        void onContactSelected(Carrera carrera);
    }
}
