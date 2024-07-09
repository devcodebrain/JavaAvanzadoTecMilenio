
package com.mycompany.devcodebrain.evidenciajavaavanzado.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class IMC implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private int idPersona;
    @Temporal(TemporalType.TIMESTAMP)
    private Date TimeStmp;
    @Basic
    private float estatura;
    private float peso;
    private float IMC;
    private String clasificacion;

    public IMC() {
    }

    public IMC(int id, int idPersona, Date TimeStmp, float estatura, float peso, float IMC, String clasificacion) {
        this.id = id;
        this.idPersona = idPersona;
        this.TimeStmp = TimeStmp;
        this.estatura = estatura;
        this.peso = peso;
        this.IMC = IMC;
        this.clasificacion = clasificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Date getTimeStmp() {
        return TimeStmp;
    }

    public void setTimeStmp(Date TimeStmp) {
        this.TimeStmp = TimeStmp;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    
}
    

