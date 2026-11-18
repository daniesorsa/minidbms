package edu.unitec.minidbms.storage;
import edu.unitec.minidbms.modelo.*;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class IOEncabezado {
    
    private static final int NUMERO = 1;
    private static final int VERSION = 1;
    private static final int TAM_ENCABEZADO = 102400;
    
    private MetaData md;
    private File archivoActual;
    private boolean modificado;

    public IOEncabezado() {
        this.md = null;
        this.archivoActual = null;
        this.modificado = false;
    }

    public void crearArchivo(File archivo, String nombreTabla,PoliticaDeReutilizacion politica) throws Exception {
//        if (archivo.exists()) {
//            throw new Exception("El archivo ya existe");
//        }
        //System.out.println(archivo.getAbsolutePath().toString());
        this.md = new MetaData(nombreTabla, politica);
        this.archivoActual = archivo;
        guardarArchivo();
    }

    public void abrirArchivo(File archivo) throws Exception {
        if (!archivo.exists()) {
            throw new Exception("El archivo seleccionado no existe.");
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            this.md = (MetaData) ois.readObject();
            this.archivoActual = archivo;
            this.modificado = false;
        } catch (Exception e) {
            throw new Exception("El archivo está dañado o no existe");
        }
    }

    public void guardarArchivo() throws Exception {
        if (this.archivoActual == null || this.md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(buffer);
        
        dos.writeInt(NUMERO);
        dos.writeInt(VERSION);
        dos.writeInt(TAM_ENCABEZADO);

        dos.writeUTF(md.getArchivo());
        dos.writeBoolean(md.isLlaveEstablecida());
        dos.writeLong(md.getCabeza());
        dos.writeInt(md.getEstrategia().hashCode());
        dos.writeLong(md.getRegistrosActivos());
        dos.writeLong(md.getRegistrosEliminados());
        dos.writeLong(md.getBytesLibres());
        
        dos.writeInt(md.getCampos().size());
        for (Campo c : md.getCampos()) {
            dos.writeUTF(c.getNombre());
            dos.writeInt(c.getTipoDato().hashCode());
            dos.writeInt(c.getLongitudMax());
            dos.writeBoolean(c.isObligatorio());
            dos.writeUTF(c.getValorPred());
            dos.writeBoolean(c.getEsLlave());
        }
        
        dos.writeInt(md.getIndices().size());
        for (IndiceDefinido ind : md.getIndices()) {
            
        }
        
        dos.writeInt(md.getLlavesForaneas().size());
        for (LlaveForanea lf : md.getLlavesForaneas()) {
            
        }

//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.archivoActual))) {
//            oos.writeObject(this.metadataActual);
//            this.modificado = false;
//            System.out.println("Llega hasta el final");
//        }
    }

    public void cerrarArchivo() throws Exception {
        if (this.modificado) {
            guardarArchivo();
        }
        else {
            throw new Exception("Ningun archivo abierto o creado");
        }
        this.md = null;
        this.archivoActual = null;
        this.modificado = false;
    }

    public void crearCampo(String nombre, TipoDato tipo, int longitudMax, boolean obligatorio, boolean esLlavePrimaria) throws Exception {
        if (md == null) {
            throw new Exception("Debe crear o abrir un archivo primero");
        }
        if (esLlavePrimaria) {
            for (Campo c : md.getCampos()) {
                if (c.getEsLlave()) {
                    throw new Exception("Ya hay una llave primaria");
                }
            }
        }
        for (Campo c : md.getCampos()) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("Ya existe un campo con ese nombre");
            }
        }
        Campo nuevoCampo = new Campo();
        nuevoCampo.setNombre(nombre);
        nuevoCampo.setTipoDato(tipo);
        nuevoCampo.setLongitudMax(longitudMax);
        nuevoCampo.setObligatorio(obligatorio);
        nuevoCampo.setEsLlave(esLlavePrimaria);
        
        md.getCampos().add(nuevoCampo);
        this.modificado = true;
    }

    public List<Campo> listarCampos() throws Exception {
        if (md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        return md.getCampos();
    }

    public void modificarCampo(String nombreAntiguo, String nuevoNombre, int nuevaLongitud) throws Exception {
        if (md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        Campo campoEncontrado = null;
        for (Campo c : md.getCampos()) {
            if (c.getNombre().equalsIgnoreCase(nombreAntiguo)) {
                campoEncontrado = c;
                break;
            }
        }
        if (campoEncontrado == null) {
            throw new Exception("No existe.");
        }
        campoEncontrado.setNombre(nuevoNombre);
        campoEncontrado.setLongitudMax(nuevaLongitud);
        this.modificado = true;
    }

    public void borrarCampo(String nombreCampo) throws Exception {
        if (md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        Campo campoBorrar = null;
        for (Campo c : md.getCampos()) {
            if (c.getNombre().equalsIgnoreCase(nombreCampo)) {
                campoBorrar = c;
                break;
            }
        }
        if (campoBorrar == null) {
            throw new Exception("No existe");
        }
        if (campoBorrar.getEsLlave()) {
            throw new Exception("No se puede borrar la llave primaria.");
        }
        md.getCampos().remove(campoBorrar);
        this.modificado = true;
    }

    public MetaData getMetadataActual() {
        return md;
    }

    public File getArchivoActual() {
        return archivoActual;
    }
}