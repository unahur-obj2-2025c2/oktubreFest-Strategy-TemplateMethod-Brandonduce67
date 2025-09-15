package ar.edu.unahur.obj2;

public class Reglamento {
    private static Reglamento intance;
    private static Double graduacionReglamentaria;

    public static Double getGraduacionReglamentaria() {
        return graduacionReglamentaria;
    }

    public static Reglamento getIntance(){
        if (intance == null){
            intance = new Reglamento();
        }
        return intance;
    }
    public void setGraduacionReglamentaria(Double graduacionReglamentaria) {
        Reglamento.graduacionReglamentaria = graduacionReglamentaria;
    }
}
