# Desktop

CONFIGURAR ECLIPSE PARA JAVAFX

1) En esta direccion https://gluonhq.com/products/javafx/ descargar el product SDK JavaFX segun el hardware de uso. Guardar y descomprimir la carpeta descargada.

2) Luego abrir Eclipse e ir a Window -> Preferences -> Java -> Build Path -> User Libraries -> New. Crear una nueva user library "javaFX11". En la carpeta descomprimida
en el punto 1) ir a hasta la carpeta lib e añadir todas las librerias en esa carpeta a la nueva library "javaFX11".

3) Instalar el pluguin E(fx)clipse. Para eso ir HELP -> Eclipse Marketplace y buscar E(fx)clipse. Reiniciar Eclipse.

IMPORTAR EL PROYECTO Y CONFIGURACIONES

4) Importar el proyecto: File -> import -> Git -> Project from Git. Poner la url git del proyecto https://github.com/AppMatriculaciones/Desktop

5) En el Buildpath del proyecto -> Libraries -> Classpath y añadir la libreria creada en el punto 2) y los jars en https://github.com/AppMatriculaciones/Desktop/tree/main/libraries

6) Abrir el menu contextual del proyecto, clicar en Run -> Run Configurations ir a la pestaña "(x)= Arguments" y en el apartado VM arguments
poner la linea siguiente -> --module-path "\path\to\javafx-sdk-11\lib" --add-modules javafx.controls,javafx.fxml
Donde \path\to\javafx-sdk-11\lib es el camino a la carpeta lib de la carpeta descargada en el punto 1)
