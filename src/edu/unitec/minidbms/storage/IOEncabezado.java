package edu.unitec.minidbms.storage;
import edu.unitec.minidbms.modelo.*;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
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
        this.md = new MetaData(nombreTabla, politica);
        this.archivoActual = archivo;
        guardarArchivo();
    }

public void abrirArchivo(File archivo) throws Exception {
        if (!archivo.exists() || archivo.length() < 12) {
            throw new Exception("El archivo seleccionado no existe o está vacío.");
        }
        try (java.io.DataInputStream dis = new java.io.DataInputStream(new FileInputStream(archivo))) {
            int numeroLeido = dis.readInt();
            int versionLeida = dis.readInt();
            int tamEncabezadoLeido = dis.readInt();

            if (numeroLeido != NUMERO || versionLeida != VERSION) {
                throw new Exception("Formato o versión de archivo incompatible.");
            }

            String nombreTabla = dis.readUTF();
            boolean llaveEst = dis.readBoolean();
            long cabeza = dis.readLong();
            PoliticaDeReutilizacion politica = PoliticaDeReutilizacion.values()[dis.readInt()];
            long regActivos = dis.readLong();
            long regEliminados = dis.readLong();
            long bytesLibres = dis.readLong();

            MetaData nuevaMd = new MetaData(nombreTabla, politica);
            nuevaMd.setLlaveEstablecida(llaveEst);
            nuevaMd.setCabeza(cabeza);
            nuevaMd.setRegistrosActivos(regActivos);
            nuevaMd.setRegistrosEliminados(regEliminados);
            nuevaMd.setBytesLibres(bytesLibres);

            int cantCampos = dis.readInt();
            for (int i = 0; i < cantCampos; i++) {
                String nombreCampo = dis.readUTF();
                TipoDato tipo = TipoDato.values()[dis.readInt()];
                int longMax = dis.readInt();
                boolean oblig = dis.readBoolean();
                String valPred = dis.readUTF();
                boolean esLlave = dis.readBoolean();

                nuevaMd.getCampos().add(new Campo(nombreCampo, tipo, longMax, oblig, valPred, esLlave));
            }

            int cantIndices = dis.readInt();
            for (int i = 0; i < cantIndices; i++) {
                String campoIdx = dis.readUTF();
                int orden = dis.readInt();
                boolean unico = dis.readBoolean();
                String archIdx = dis.readUTF();

                nuevaMd.getIndices().add(new IndiceDefinido(campoIdx, orden, unico, archIdx));
            }

            int cantForaneas = dis.readInt();
            for (int i = 0; i < cantForaneas; i++) {
                String campoLocal = dis.readUTF();
                String archRef = dis.readUTF();
                String campoRef = dis.readUTF();

                nuevaMd.getLlavesForaneas().add(new LlaveForanea(campoLocal, archRef, campoRef));
            }

            this.md = nuevaMd;
            this.archivoActual = archivo;
            this.modificado = false;
        } catch (Exception e) {
            throw new Exception("El archivo está dañado o tiene un formato inválido: " + e.getMessage());
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

        // .ordinal para no enums
        dos.writeUTF(md.getArchivo());
        dos.writeBoolean(md.isLlaveEstablecida());
        dos.writeLong(md.getCabeza());
        dos.writeInt(md.getEstrategia().ordinal());
        dos.writeLong(md.getRegistrosActivos());
        dos.writeLong(md.getRegistrosEliminados());
        dos.writeLong(md.getBytesLibres());
        
        dos.writeInt(md.getCampos().size());
        for (Campo c : md.getCampos()) {
            dos.writeUTF(c.getNombre());
            dos.writeInt(c.getTipoDato().ordinal());
            dos.writeInt(c.getLongitudMax());
            dos.writeBoolean(c.isObligatorio());
            dos.writeUTF(c.getValorPred() != null ? c.getValorPred() : "");
            dos.writeBoolean(c.getEsLlave());
        }
        
        // indices
        dos.writeInt(md.getIndices().size());
        for (IndiceDefinido ind : md.getIndices()) {
            dos.writeUTF(ind.getCampo());
            dos.writeInt(ind.getOrden());
            dos.writeBoolean(ind.isUnico());
            dos.writeUTF(ind.getArchivoDeIndice());
        }
        
        // llaves
        dos.writeInt(md.getLlavesForaneas().size());
        for (LlaveForanea lf : md.getLlavesForaneas()) {
            dos.writeUTF(lf.getCampoLocal());
            dos.writeUTF(lf.getArchivoDeReferencia());
            dos.writeUTF(lf.getCampoDeReferencia());
        }
        dos.flush();

        byte[] bytesMetadata = buffer.toByteArray();
        if (bytesMetadata.length > TAM_ENCABEZADO) {
            throw new Exception("La metadata excede el tamaño máximo del encabezado");
        }
        
        byte[] bloqueFijo = new byte[TAM_ENCABEZADO];
        System.arraycopy(bytesMetadata, 0, bloqueFijo, 0, bytesMetadata.length);

        try (FileOutputStream fos = new FileOutputStream(this.archivoActual)) {
            fos.write(bloqueFijo);
            this.modificado = false;
        }
    }

    public void cerrarArchivo() throws Exception {
        if (this.modificado) {
            guardarArchivo();
        }
        if(md == null) {
            throw new Exception("Ningun archivo abierto o creado");
        }
        this.md = null;
        this.archivoActual = null;
        this.modificado = false;
    }

    public void crearCampo(String nombre, TipoDato tipo, int longitudMax, boolean obligatorio, String valorPred, boolean esLlavePrimaria) throws Exception {
        if (md == null) {
            throw new Exception("Debe crear o abrir un archivo primero");
        }
        
        md.agregarCampo(nombre, tipo, longitudMax, obligatorio, valorPred, esLlavePrimaria);
        this.modificado = true;
    }

    public void modificarCampo(String nombreAntiguo, String nuevoNombre, int nuevaLongitud) throws Exception {
        if (md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        int indice = -1;
        for (int i = 0; i < md.getCampos().size(); i++) {
            if (md.getCampos().get(i).getNombre().equalsIgnoreCase(nombreAntiguo)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new Exception("No existe el campo");
        }
        // validar que el nuevo nombre no sea uno antiguo
        if (!nombreAntiguo.equalsIgnoreCase(nuevoNombre)) {
            for (Campo c : md.getCampos()) {
                if (c.getNombre().equalsIgnoreCase(nuevoNombre)) {
                    throw new Exception("Ya existe un campo con ese nuevo nombre");
                }
            }
            md.getCampos().get(indice).setNombre(nuevoNombre);
        }
        md.redcirLongitudMax(nuevaLongitud, indice);
        this.modificado = true;
    }

    public void borrarCampo(String nombreCampo) throws Exception {
        if (md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        for (int i = 0; i < md.getCampos().size(); i++) {
            if (md.getCampos().get(i).getNombre().equalsIgnoreCase(nombreCampo)) {
                md.borrarCampo(i); // valida si es llave primaria y lo elimina en metadata
                this.modificado = true;
                return;
            }
        }
        throw new Exception("No existe el campo: " + nombreCampo);
    }

    public List<Campo> listarCampos() throws Exception {
        if (md == null) {
            throw new Exception("No hay archivos abiertos");
        }
        return md.getCampos();
    }

    public MetaData getMetadataActual() {
        return md;
    }

    public File getArchivoActual() {
        return archivoActual;
    }
}