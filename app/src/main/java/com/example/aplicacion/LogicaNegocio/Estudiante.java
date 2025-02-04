package com.example.aplicacion.LogicaNegocio;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private String cedula, nombre, email, fechaNacimiento, carrera;
    private int telefono;

    public Estudiante(String cedula, String nombre, int telefono, String email, String fechaNacimiento, String carrera) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;

        Estudiante alumno = (Estudiante) o;

        if (getTelefono() != alumno.getTelefono()) return false;
        if (getCedula() != null ? !getCedula().equals(alumno.getCedula()) : alumno.getCedula() != null)
            return false;
        if (getNombre() != null ? !getNombre().equals(alumno.getNombre()) : alumno.getNombre() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(alumno.getEmail()) : alumno.getEmail() != null)
            return false;
        if (getFechaNacimiento() != null ? !getFechaNacimiento().equals(alumno.getFechaNacimiento()) : alumno.getFechaNacimiento() != null)
            return false;
        return getCarrera() != null ? getCarrera().equals(alumno.getCarrera()) : alumno.getCarrera() == null;
    }

    @Override
    public int hashCode() {
        int result = getCedula() != null ? getCedula().hashCode() : 0;
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + getTelefono();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getFechaNacimiento() != null ? getFechaNacimiento().hashCode() : 0);
        result = 31 * result + (getCarrera() != null ? getCarrera().hashCode() : 0);
        return result;
    }
}
