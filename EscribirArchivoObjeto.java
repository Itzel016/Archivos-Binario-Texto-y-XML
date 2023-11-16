import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscribirArchivoObjeto {
    public static void main(String[] args) {
        String nombreArchivo = "objeto.dat";
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            ArrayList<Mascota> m = new ArrayList<>();
            m.add(new Mascota("Dogi", 12));
            m.add(new Mascota("Sasi", 14));
            m.add(new Mascota("nena", 1));
            m.add(new Mascota("Michi", 3));
            m.add(new Mascota("Chems", 11));

            salida.writeObject(m);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
