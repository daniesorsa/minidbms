package edu.unitec.minidbms.storage;
import edu.unitec.minidbms.modelo.Campo;
import edu.unitec.minidbms.modelo.MetaData;
import edu.unitec.minidbms.modelo.TipoDato;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class IOEncabezado {
    private MetaData metadataActual;
    private File archivoActual;
    private boolean modificado;

    public IOEncabezado() {
        this.metadataActual = null;
        this.archivoActual = null;
        this.modificado = false;
    }

    public void crearArchivo(File archivo, String nombreTabla) throws Exception {
//        if (archivo.exists()) {
//            throw new Exception("El archivo ya existe");
//        }
        this.metadataActual = new MetaData();
        this.metadataActual.setNombreArchivo(nombreTabla);
        this.archivoActual = archivo;
        guardarArchivo();
    }

    public void abrirArchivo(File archivo) throws Exception {
        if (!archivo.exists()) {
            throw new Exception("El archivo seleccionado no existe.");
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            this.metadataActual = (MetaData) ois.readObject();
            this.archivoActual = archivo;
            this.modificado = false;
        } catch (Exception e) {
            throw new Exception("El archivo está dañado o no existe");
        }
    }

    public void guardarArchivo() throws Exception {
        if (this.archivoActual == null || this.metadataActual == null) {
            throw new Exception("No hay archivos abiertos");
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.archivoActual))) {
            oos.writeObject(this.metadataActual);
            this.modificado = false;
        }
    }

    public void cerrarArchivo() throws Exception {
        if (this.modificado) {
            guardarArchivo();
        }
        this.metadataActual = null;
        this.archivoActual = null;
        this.modificado = false;
    }

    public void crearCampo(String nombre, TipoDato tipo, int longitudMax, boolean obligatorio, boolean esLlavePrimaria) throws Exception {
        if (metadataActual == null) {
            throw new Exception("Debe crear o abrir un archivo primero");
        }
        if (esLlavePrimaria) {
            for (Campo c : metadataActual.getCampos()) {
                if (c.getEsLlave()) {
                    throw new Exception("Ya hay una llave primaria");
                }
            }
        }
        for (Campo c : metadataActual.getCampos()) {
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
        
        metadataActual.getCampos().add(nuevoCampo);
        this.modificado = true;
    }

    public List<Campo> listarCampos() throws Exception {
        if (metadataActual == null) {
            throw new Exception("No hay archivos abiertos");
        }
        return metadataActual.getCampos();
    }

    public void modificarCampo(String nombreAntiguo, String nuevoNombre, int nuevaLongitud) throws Exception {
        if (metadataActual == null) {
            throw new Exception("No hay archivos abiertos");
        }
        Campo campoEncontrado = null;
        for (Campo c : metadataActual.getCampos()) {
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
        if (metadataActual == null) {
            throw new Exception("No hay archivos abiertos");
        }
        Campo campoBorrar = null;
        for (Campo c : metadataActual.getCampos()) {
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
        metadataActual.getCampos().remove(campoBorrar);
        this.modificado = true;
    }

    public MetaData getMetadataActual() {
        return metadataActual;
    }

    public File getArchivoActual() {
        return archivoActual;
    }
}