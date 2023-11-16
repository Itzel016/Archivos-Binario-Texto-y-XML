import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class EscribirArchivoXML {

    public static void main(String[] args) {

        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Creo un DOMImplementation
            DOMImplementation implementation = builder.getDOMImplementation();

            // Creo un documento con un elemento raiz
            Document documento = implementation.createDocument(null, "mascotas", null);
            documento.setXmlVersion("1.0");

            // Creo la lista de mascotas (puedes modificar esto con tu lógica de aplicación)
            List<Mascota> mascotas = new ArrayList<>();
            mascotas.add(new Mascota("Fido", 3));
            mascotas.add(new Mascota("Luna", 2));

            // Creo los elementos para cada mascota
            Element listaMascotas = documento.createElement("listaMascotas");

            for (Mascota mascota : mascotas) {
                Element mascotaElement = documento.createElement("mascota");

                // Nombre
                Element nombre = documento.createElement("nombre");
                Text textNombre = documento.createTextNode(mascota.getNombre());
                nombre.appendChild(textNombre);
                mascotaElement.appendChild(nombre);

                // Edad
                Element edad = documento.createElement("edad");
                Text textEdad = documento.createTextNode(String.valueOf(mascota.getEdad()));
                edad.appendChild(textEdad);
                mascotaElement.appendChild(edad);

                // Añado al elemento listaMascotas el elemento mascota
                listaMascotas.appendChild(mascotaElement);
            }

            // Añado al root el elemento listaMascotas
            documento.getDocumentElement().appendChild(listaMascotas);

            // Asocio el source con el Document
            Source source = new DOMSource(documento);
            // Creo el Result, indicando qué archivo se va a crear
            Result result = new StreamResult(new File("mascotas.xml"));

            // Creo un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
