package ar.edu.unahur.obj2.marcas;

public abstract class Marca {
    private Double contenidoDeLupulo;
    public Double getContenidoDeLupulo() {
        return this.contenidoDeLupulo;
    }

    private String pais;
    public String getPais() {
        return this.pais;
    }

    public Marca(Double contenidoDeLupulo, String pais) {
        this.contenidoDeLupulo = contenidoDeLupulo;
        this.pais = pais;
    }

    
    public abstract Double graduacionDeAlcohol();
}
