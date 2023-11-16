import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivoXML {

    public static void main(String[] args) {

        try {
            File archivo = new File("mascotas.xml");  // Assuming the XML file is named "mascotas.xml"

            // Creo un DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);

            doc.getDocumentElement().normalize();

            // Obtengo la raíz del documento
            Element root = doc.getDocumentElement();

            // Obtengo la lista de nodos 'mascota'
            NodeList nodeList = root.getElementsByTagName("mascota");

            // Lista para almacenar las mascotas
            List<Mascota> mascotas = new ArrayList<>();

            // Itero sobre la lista de nodos 'mascota'
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoMascota = (Element) node;

                    // Obtengo los elementos dentro de 'mascota'
                    String nombre = elementoMascota.getElementsByTagName("nombre").item(0).getTextContent();
                    int edad = Integer.parseInt(elementoMascota.getElementsByTagName("edad").item(0).getTextContent());

                    // Creo una instancia de Mascota y la agrego a la lista
                    mascotas.add(new Mascota(nombre, edad));
                }
            }

            // Imprimo la información de las mascotas
            for (Mascota mascota : mascotas) {
                System.out.println("Nombre: " + mascota.getNombre());
                System.out.println("Edad: " + mascota.getEdad());
                System.out.println("-----");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

