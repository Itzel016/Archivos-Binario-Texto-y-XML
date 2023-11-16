import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirArchivoBinario{
    public static void main(String[] args) {
        String nombreArchivo="archivo_salida.bin";
        try {
            FileOutputStream salida=new FileOutputStream(nombreArchivo);
            for(int i=0;i < 10;i++){
                salida.write(i);
            }
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 