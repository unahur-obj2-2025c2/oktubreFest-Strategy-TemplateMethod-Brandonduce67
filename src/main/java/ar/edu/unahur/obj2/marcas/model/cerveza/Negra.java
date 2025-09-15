package ar.edu.unahur.obj2.marcas.model.cerveza;

import ar.edu.unahur.obj2.Reglamento;
import ar.edu.unahur.obj2.marcas.Marca;

public class Negra extends Marca {

    public Negra(Double contenidoDeLupulo, String pais) {
        super(contenidoDeLupulo, pais);
    }
    
    @Override
    public Double graduacionDeAlcohol() {
        Reglamento.getIntance();
        return Math.min(Reglamento.getGraduacionReglamentaria(), getContenidoDeLupulo() * 2);
    }
}
