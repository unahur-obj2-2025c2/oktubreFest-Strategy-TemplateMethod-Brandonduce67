package ar.edu.unahur.obj2.marcas.model.jarras.personas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.model.carpas.Carpa;
import ar.edu.unahur.obj2.marcas.model.jarras.Jarra;
import ar.edu.unahur.obj2.marcas.model.nacionalidad.Nacionalidad;

public class Persona {
    private Double peso;
    private List<Jarra> jarrasCompradas;
    private Boolean leGustaLaMusicaTradicional;
    private Integer nivelDeAguante;
    private Nacionalidad nacionalidad;


    public Persona(Double peso, Boolean leGustaLaMusicaTradicional, Integer nivelDeAguante, Nacionalidad nacionalidad) {
        this.peso = peso;
        this.leGustaLaMusicaTradicional = leGustaLaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
        this.nacionalidad = nacionalidad;
        this.jarrasCompradas = new ArrayList<>();
    }

    public Boolean getLeGustaLaMusicaTradicional() {
        return leGustaLaMusicaTradicional;
    }

    public Boolean estaEbria(){
        return alcoholIngerido() * peso > nivelDeAguante;
    }

    public Double alcoholIngerido(){
        return jarrasCompradas.stream().mapToDouble(j -> j.cantidadDeAlcohol()).sum();
    }

    public Boolean leGustaLaCerveza(Marca marca){
        return switch (nacionalidad.name()) {
            case "BELGA" ->
                 marca.getContenidoDeLupulo() > 4.0;
            case "CHECO" ->
                marca.graduacionDeAlcohol() < 0.00;
            case "ALEMAN" ->
                true;
            default ->
                false;
        };
    } 

    public Boolean esPatriota(){
        return this.jarrasCompradas.stream().allMatch(j -> j.getMarca()
        .getPais().equals(nacionalidad.name()));
    }

    public Boolean quiereEntrar(Carpa carpa){
        return  leGustaLaCerveza(carpa.getMarcaDeCerveza()) && this.leGustaLaMusicaTradicional 
                && carpa.getTieneBanda() && !(nacionalidad.name().equals("ALEMAN"))
                || carpa.cantidadDePersonas() % 2 == 0; 
    }

    public void comprarJarra(Jarra jarra){
        this.jarrasCompradas.add(jarra);
    }
    
    public List<Jarra> getJarrasCompradas(){
       return this.jarrasCompradas;
    }
}
