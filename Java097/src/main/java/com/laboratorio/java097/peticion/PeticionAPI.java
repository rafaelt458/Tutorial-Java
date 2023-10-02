package com.laboratorio.java097.peticion;

import api.FrankfurterAPIEnum;

public class PeticionAPI {
    private int id;
    private FrankfurterAPIEnum operacion;
    private String respuesta;

    public PeticionAPI(int id, FrankfurterAPIEnum operacion) {
        this.id = id;
        this.operacion = operacion;
        this.respuesta = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FrankfurterAPIEnum getOperacion() {
        return operacion;
    }

    public void setOperacion(FrankfurterAPIEnum operacion) {
        this.operacion = operacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}