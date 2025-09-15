package ar.edu.unahur.obj2.marcas.model.carpas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.model.jarras.Jarra;
import ar.edu.unahur.obj2.marcas.model.jarras.personas.Persona;

public class Carpa {
    private final Integer limiteAdmitido;
    private final Boolean tieneBanda;
    private final Marca marcaDeCerveza;
    private Jarra jarra;
    
    private List<Persona> personas;

    public Carpa(Integer limiteAdmitido, Boolean tieneBanda, Marca marcaDeCerveza, Jarra jarra) {
        this.limiteAdmitido = limiteAdmitido;
        this.tieneBanda = tieneBanda;
        this.marcaDeCerveza = marcaDeCerveza;
        this.jarra = jarra;
        this.personas = new ArrayList<>();
    }

    public Boolean dejaIngresar(Persona persona){
        return !(personas.size() > limiteAdmitido) && !persona.estaEbria();
    }

    public Boolean puedeEntrarAUnaCarpa(Persona persona){
        return persona.quiereEntrar(this) && this.dejaIngresar(persona);
    }

    public Boolean quiereEntrar(Persona persona){
        return persona.leGustaLaCerveza(marcaDeCerveza);
    }

    public void entrarCarpa(Persona persona){
        if (puedeEntrarAUnaCarpa(persona)) {
            this.personas.add(persona);
        }else
            throw new RuntimeException("No puede entrar a la carpa");
    }

    public void servirJarraDeCerveza(Persona persona, Double capacidad){
        if (!personas.contains(persona)) {
            throw new RuntimeException("La persona no esta en la carpa");
        }else
            persona.comprarJarra(new Jarra(capacidad, marcaDeCerveza));
    }

    public Long cantidadDeEbriosEmpedernidos(){
        return personas.stream().filter(persona -> sonSuperioresAUnLitro(persona.getJarrasCompradas())
        && persona.estaEbria()).count();
    }

    private Boolean sonSuperioresAUnLitro(List<Jarra> jarras){
        return jarras.stream().allMatch(j -> j.getCapacidad() > 1.0);
    }

    public Jarra getJarra() {
        return jarra;
    }

    public Boolean getTieneBanda() {
        return tieneBanda;
    }

    public Integer getLimiteAdmitido() {
        return limiteAdmitido;
    }

    public Marca getMarcaDeCerveza() {
        return marcaDeCerveza;
    }

    public void setJarra(Jarra jarra) {
        this.jarra = jarra;
    }

    public Integer cantidadDePersonas(){
        return this.personas.size();
    }
}
