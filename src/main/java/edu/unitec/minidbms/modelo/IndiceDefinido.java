package edu.unitec.minidbms.modelo;
public class IndiceDefinido {
    private String campo;
    private int orden;
    private boolean unico;
    private String archivoDeIndice;

    public IndiceDefinido(String campo, int orden, boolean unico, String archivoDeIndice) {
        this.campo = campo;
        this.orden = orden;
        this.unico = unico;
        this.archivoDeIndice = archivoDeIndice;
    }

    public String getCampo() {
        return campo;
    }

    public int getOrden() {
        return orden;
    }

    public boolean isUnico() {
        return unico;
    }

    public String getArchivoDeIndice() {
        return archivoDeIndice;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setUnico(boolean unico) {
        this.unico = unico;
    }

    public void setArchivoDeIndice(String archivoDeIndice) {
        this.archivoDeIndice = archivoDeIndice;
    }
    
    
}
