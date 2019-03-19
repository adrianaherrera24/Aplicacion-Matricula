package com.example.aplicacion.AccesoDatos;

import com.example.aplicacion.LogicaNegocio.Carrera;
import com.example.aplicacion.LogicaNegocio.Curso;
import com.example.aplicacion.LogicaNegocio.Estudiante;
import com.example.aplicacion.LogicaNegocio.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ModeloDatos {

    private List<Estudiante> listaEstudiantes;
    private List<Carrera> listaCarreras;
    private List<Curso> listaCursos;
    private List<Profesor> listaProfesores;

    public ModeloDatos(){
        listaEstudiantes = new ArrayList<>();
        listaCarreras = new ArrayList<>();
        listaCursos = new ArrayList<>();
        listaProfesores = new ArrayList<>();
        estudiantesDefecto();
        carrerasDefecto();
        profesorDefecto();
        cursosDefecto();
    }

    // Datos quemados
    public void estudiantesDefecto() {
        Estudiante est = new Estudiante("123", "Jose", 321, "@Jose", "23/06/1985", "Ingenieria en sistemas");
        listaEstudiantes.add(est);

        est = new Estudiante("321", "Juan", 213, "@Juan", "24/06/1986", "Administracion de empresas");
        listaEstudiantes.add(est);
    }

    public void carrerasDefecto() {
        Carrera carrera = new Carrera("EIF", "Ingenieria en sistemas");
            carrera.addCurso(new Curso("ST", "Soporte", 3, 4));
            carrera.addCurso(new Curso("FD", "Fundamentos", 3, 4));
            carrera.addCurso(new Curso("PG1", "Programacion I", 3, 4));
        listaCarreras.add(carrera);

        carrera = new Carrera("ADM", "Administracion");
        carrera.addCurso(new Curso("FAD", "Fundamentos de Administracion", 3, 4));
        carrera.addCurso(new Curso("C1", "Contabilidad I", 3, 4));
        listaCarreras.add(carrera);
    }

    public void cursosDefecto(){
        // Cursos de Informatica
        Curso curso = new Curso("ST", "Soporte", 3, 4);
        listaCursos.add(curso);
        curso = new Curso("FD", "Fundamentos", 3, 4);
        listaCursos.add(curso);
        curso = new Curso("PG1", "Programacion I", 3, 4);
        listaCursos.add(curso);

        // Cursos de Administracion
        curso = new Curso("FAD", "Fundamentos de Administracion", 3, 4);
        listaCursos.add(curso);
        curso = new Curso("C1", "Contabilidad I", 3, 4);
        listaCursos.add(curso);
    }

    public void profesorDefecto() {
        Profesor profesor = new Profesor("123", "Jose", "@jose", 678);
        listaProfesores.add(profesor);

        profesor = new Profesor("234", "Juan", "@juan", 876);
        listaProfesores.add(profesor);

        profesor = new Profesor("345", "Mario", "@mario", 789);
        listaProfesores.add(profesor);

        profesor = new Profesor("456", "Jesus", "@Jesus", 978);
        listaProfesores.add(profesor);
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }
    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }
    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaEstudiantes( List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void setListaCarreras( List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public void setListaProfesores( List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public void setListaCursos( List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

}
