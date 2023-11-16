import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoTexto {
    public static void main(String[] args) {
        String nombreArchivo = "archivo.txt";
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader lector = new BufferedReader(archivo);
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
