package edu.unitec.minidbms.modelo;
import java.util.ArrayList;
public class MetaData {
    private String archivo;
    private double version = 1.0;
    private boolean llaveEstablecida = false;
    private ArrayList<Campo> campos = new ArrayList<Campo>(); // llave primaria es el primer elemento de campos
    private ArrayList<IndiceDefinido> indices = new ArrayList<IndiceDefinido>();
    private ArrayList<LlaveForanea> llavesForaneas = new ArrayList<LlaveForanea>();
    private long cabeza = -1L;
    private PoliticaDeReutilizacion estrategia;
    private long registrosActivos = 0;
    private long registrosEliminados = 0;
    private long bytesLibres = 0;
    public MetaData(String archivo, PoliticaDeReutilizacion estrategia) {
        this.archivo = archivo;
        this.estrategia = estrategia;
    }
        
    // SE ITERA SOBRE EL ARCHIVO ORIGINAL AL MOMENTO DE GUARDAR. /STORAGE RECIVE OBJETO METADATA
    public void agregarCampo(String nombre, TipoDato tipoDato, int longitudMax, boolean obligatorio, String valorPred, boolean esLlave) {
        if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
        if(this.llaveEstablecida && esLlave == true) {
            throw new IllegalArgumentException("Ya existe un campo como llave primaria");
        }
        Campo c = new Campo(nombre, tipoDato, longitudMax, obligatorio, valorPred, esLlave);
        for(Campo campoActual : this.campos) {
            if(nombre.equals(campoActual.getNombre())) {
                throw new IllegalArgumentException("No pueden haber nombres duplicados");
            }
        }
        if(esLlave) {
            this.campos.add(0, c);
            IndiceDefinido nuevoIndice = new IndiceDefinido(nombre, 6, true, this.archivo);
            this.indices.add(nuevoIndice);
            this.llaveEstablecida = true;
        }
        else {
            this.campos.add(c);
        }
    }
    public void cambiarTipo(int indideCampo, TipoDato nuevoTipo) {
        this.campos.get(indideCampo).setTipoDato(nuevoTipo);
    }
    public void redcirLongitudMax(int nuevaLongitud, int indiceCampo) {
        if(nuevaLongitud < 1) {
            throw new IllegalArgumentException("La nueva longitud debe ser al menos 1");
        }
        this.campos.get(indiceCampo).setLongitudMax(nuevaLongitud);
    }
    public void borrarCampo(int indiceCampo) {
        if(this.campos.get(indiceCampo).getEsLlave()) {
            throw new IllegalArgumentException("El campo es una llave primaria y no se puede borrar");
        }
        else {
            this.campos.remove(indiceCampo);
        }
    }
}
