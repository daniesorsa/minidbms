Nombre del proyecto: minidbms
Id de netbeans: edu.unitec

### Estructura
- Se debe seguir una estructura profesional siguiendo principios de
  **separación de responsabilidades**
- En la industria mundial de Java (y lenguajes similares), los paquetes siempre empiezan con el dominio web de la empresa o institución al revés, seguido del nombre del proyecto:
	- Si trabajas en Google haciendo Gmail: `com.google.gmail`
	- Si es un proyecto abierto de Apache: `org.apache.commons`
	- En su proyecto universitario: `com.equipo.minidbms` (o `edu.unitec.minidbms`)
- Esto se hace con el fin de evitar problemas entre librerías y archivos propios del proyecto

| Paquete Estándar                | Rol en la Industria                                                                                                                       | Clases en tu Mini DBMS                                                  |
| ------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| model (domain / entity)         | Datos puros: Objetos del sistema con atributos, constructores y getters/setters, independientes de la interfaz y del disco.               | Metadata, Campo, TipoDato, Registro, Hueco, IndiceDefinicion.           |
| ui (view / gui)                 | Interfaz visual: Ventanas, tablas y paneles gráficos. Recoge acciones del usuario y las delega sin tocar el disco directamente.           | VentanaPrincipal, DialogoCampos, vistas del Árbol B y mapa del archivo. |
| service (controller / manager)  | Lógica de negocio: Coordina operaciones, aplica reglas, manipula estructuras (btree, availlist) y solicita lecturas/escrituras a storage. | ArbolB, AvailListManager, GestorBaseDatos (cruces y llaves foráneas).   |
| storage (dao / repository / io) | Persistencia: Único paquete que lee y escribe bytes en disco (RandomAccessFile) y gestiona flujos de archivos externos.                   | ArchivoDatosIO, ArchivoIndiceIO, SerializadorMetadata, exportadores.    |
| util (common / helper)          | Herramientas transversales: Funciones de apoyo reutilizables por cualquier paquete del proyecto.                                          | GestorHistorial (Ctrl+Z), ValidadorTipos, conversores de bytes.         |
---
El flujo siempre va de arriba hacia abajo:
$$\text{UI (Ventanas)} \longrightarrow \text{Lógica (BTree / AvailList)} \longrightarrow \text{Storage (Disco)}$$
---
## Estructura Para Este Proyecto
```
minidbms/                        <-- Raíz del repositorio Git
├── pom.xml                      <-- Archivo de Maven (configuración y librerías del proyecto)
├── .gitignore                   <-- Lista de archivos que Git debe ignorar
├── README.md                    <-- Portada en GitHub (explica cómo compilar y quiénes son el equipo)
├── docs/                        <-- Documentación técnica (diagramas de bytes, pruebas, PDF)
├── datos_prueba/                <-- Archivos .dat y .idx del caso de la aerolínea (Aeropuertos, Vuelos...)
└── src/
    ├── main/
    │   ├── java/                <-- AQUÍ vive todo tu código fuente (.java)
    │   │   └── com/equipo/
    │   │       ├── Main.java    <-- Único punto de entrada que arranca la aplicación
    │   │       ├── model/
    │   │       ├── ui/
    │   │       ├── storage/
    │   │       ├── availlist/
    │   │       ├── btree/
    │   │       └── util/
    │   └── resources/           <-- Íconos, imágenes o plantillas (NO código Java)
    └── test/
        └── java/                <-- Pruebas pequeñas (ej. probar el Árbol B sin abrir ventanas)

```
---
## Usos de Git

```bash
# Clonar
git clone https://github.com/daniesorsa/minidbms.git

# limpiar configuración ip
ipconfig /flushdns
git config --global --unset http.proxy
git config --global --unset https.proxy

# Secuencia para subir avances

## Antes de empezar
git checkout develop # Moverse a esta rama
git pull origin develop # Actualizar esta rama de manera local
git checkout -b feature/tareaactual # Nueva rama para cada objetivo, nombre del objetivo luego de '/'

## Agregando cambios
git add .
git commit -m "Implementa..."

### Push la primera vez
git push --set-upstream origin feature/tareaactual

### Push de ahí en adelante
git push


## Eliminar Ramas

## Chequear estado de merge
git branch --no-merged

## Eliminar rama de manera local
git branch -d nombre_de_la_rama
# cambiar a -D para eliminar sin subir cambios

## Eliminar rama del repo
git push origin --delete nombre_de_la_rama

## Comprobar que ya no existe
git branch -r # branch lista todas las ramas, -r las del remoto

### Pull Request: En la página web de GitHub: 1) Pull Request (PR) de `feature/tareaactual` hacia `develop`. 2) Revisar que no haya archivos `.form` rotos ni errores -> clic a Merge
```
