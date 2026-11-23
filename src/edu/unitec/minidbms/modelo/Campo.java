package edu.unitec.minidbms.modelo;

public class Campo {
    private String nombre;
    private TipoDato tipoDato; //Los tipos mínimos son entero, decimal, texto, fecha y booleano
    private int longitudMax;
    private boolean obligatorio;
    private String valorPred = "";
    private boolean esLlave;

    public Campo(){
        
    }
    public Campo(String nombre, TipoDato tipoDato, int longitudMax, boolean obligatorio, String valorPred, boolean esLlave) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
        this.longitudMax = longitudMax;
        this.esLlave = esLlave;
        if(esLlave){
            this.obligatorio = true;
        }
        else {
            this.obligatorio = obligatorio;
        }
        this.valorPred = valorPred;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTipoDato(TipoDato tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDato getTipoDato() {
        return tipoDato;
    }

    public int getLongitudMax() {
        return longitudMax;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public String getValorPred() {
        return valorPred;
    }

    public boolean getEsLlave() {
        return esLlave;
    }

    public void setLongitudMax(int longitudMax) {
        this.longitudMax = longitudMax;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public void setValorPred(String valorPred) {
        this.valorPred = valorPred;
    }

    public void setEsLlave(boolean esLlave) {
        this.esLlave = esLlave;
    }
    
    
    
}
