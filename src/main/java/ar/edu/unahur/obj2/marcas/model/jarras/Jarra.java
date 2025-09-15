package ar.edu.unahur.obj2.marcas.model.jarras;

import ar.edu.unahur.obj2.marcas.Marca;

public class Jarra {
    private Double capacidad;
    public Double getCapacidad() {
        return capacidad;
    }

    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public Jarra(Double capacidad, Marca marca) {
        this.capacidad = capacidad;
        this.marca = marca;
    }

    public Double cantidadDeAlcohol(){
        return capacidad * marca.graduacionDeAlcohol();
    }
    
}
