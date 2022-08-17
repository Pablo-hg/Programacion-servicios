
package Servidor;

import java.io.File;
import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

//Clase que guarda el contenido de una carpeta en memoria ram para poder mostrala luego
public class EstructuraArchivosIO implements Serializable {
    
    File archivos[];
    DefaultTreeModel model;

    public EstructuraArchivosIO(String raiz) {
        File contenido = new File(raiz);
        archivos = contenido.listFiles();
        crearArbol(archivos, new DefaultMutableTreeNode(raiz));
    }

    public void crearArbol(File archivos[], DefaultMutableTreeNode raiz) {
        DefaultMutableTreeNode node;
        if (model == null) {
            model = new DefaultTreeModel(raiz);
        }
        for (int i = 0; i < archivos.length; i++) {
            node = new DefaultMutableTreeNode(archivos[i].getName());
            if (archivos[i].isDirectory()) {
                File nodoHijo = new File(archivos[i].getParent(), archivos[i].getName());
                crearArbol(nodoHijo.listFiles(), node);
            } else {
                node = new DefaultMutableTreeNode(archivos[i].getName());
            }
            model.insertNodeInto(node, raiz, i);
        }
    }

    //Devolvemos el tipo de modelo que queremos ver en el Jtree
    public DefaultTreeModel getModel() {
        return model;
    }
}

