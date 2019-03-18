package com.example.aplicacion.AccesoDatos;

import com.example.aplicacion.LogicaNegocio.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class ModeloDatos {

    List<Estudiante> listaEstudiantes;

    public ModeloDatos(){
        listaEstudiantes = new ArrayList<>();
        estudiantesDefecto();
    }

    // Datos quemados
    public void estudiantesDefecto() {
        Estudiante est = new Estudiante("123", "Jose", 321, "@Jose", "23/06/1985", "Ingenieria en sistemas");
        listaEstudiantes.add(est);

        est = new Estudiante("321", "Juan", 213, "@Juan", "24/06/1986", "Administracion de empresas");
        listaEstudiantes.add(est);
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes( List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
