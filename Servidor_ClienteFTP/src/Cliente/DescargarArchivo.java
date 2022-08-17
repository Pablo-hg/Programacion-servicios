
package Cliente;

import java.io.Serializable;

public class DescargarArchivo  implements Serializable{
    
    byte []bufferArchivo;
    String ruta;
    String nombre;

    public DescargarArchivo(byte[] bufferArchivo, String ruta, String nombre) {
        this.bufferArchivo = bufferArchivo;
        this.ruta = ruta;
        this.nombre = nombre;
    }

    public byte[] getBufferArchivo() {
        return bufferArchivo;
    }

    

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }
    
}
