import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerArchivoObjeto {
    public static void main(String[] args) {
        String nombreArchivo = "objeto.dat";
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
            ArrayList<Mascota> m1 = (ArrayList<Mascota>) entrada.readObject();
            entrada.close();

            for (Mascota mascota : m1) {
                System.out.println("Nombre: " + mascota.getNombre());
                System.out.println("Edad: " + mascota.getEdad());
                System.out.println(); // Espacio en blanco para separar las mascotas
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
