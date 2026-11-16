package edu.unitec.minidbms.modelo;
public class LlaveForanea {
    private String campoLocal;
    private String archivoDeReferencia;
    private String campoDeReferencia;

    public LlaveForanea(String campoLocal, String archivoDeReferencia, String campoDeReferencia) {
        this.campoLocal = campoLocal;
        this.archivoDeReferencia = archivoDeReferencia;
        this.campoDeReferencia = campoDeReferencia;
    }

    public String getCampoLocal() {
        return campoLocal;
    }

    public String getArchivoDeReferencia() {
        return archivoDeReferencia;
    }

    public String getCampoDeReferencia() {
        return campoDeReferencia;
    }

    public void setCampoLocal(String campoLocal) {
        this.campoLocal = campoLocal;
    }

    public void setArchivoDeReferencia(String archivoDeReferencia) {
        this.archivoDeReferencia = archivoDeReferencia;
    }

    public void setCampoDeReferencia(String campoDeReferencia) {
        this.campoDeReferencia = campoDeReferencia;
    }
    
    
}
