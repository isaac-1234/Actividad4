import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class ESArchivo {
    public static void ESArchivo(String[] args) {
        List<Contacto> usuarios = new ArrayList<Contacto>();

        usuarios.add(new Contacto("Sergio P", "1234567"));
        usuarios.add(new Contacto("Ana L", "7654321"));

        //ExportarCSV(usuarios);

        ImportarCSV();
    }


    public static void ExportarCSV(List<Contacto> usuarios) {
        String salidaArchivo = "/Users/silviamdl/Desktop/PruebasJava/Actividad4/imput.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

// Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }

        try {
// Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

// Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Telefono");

            salidaCSV.endRecord(); // Deja de escribir en el archivo

// Recorremos la lista y lo insertamos en el archivo
            for(Contacto user : usuarios) {
                salidaCSV.write(user.getNombre());
                salidaCSV.write(String.valueOf(user.getTelefono()));

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void ImportarCSV() {
        try{
            List<Contacto> usuarios = new ArrayList<Contacto>(); // Lista donde guardaremos los datos del archivo

            CsvReader leerUsuarios = new CsvReader("Usuarios.csv");
            leerUsuarios.readHeaders();

// Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String nombre = leerUsuarios.get(0);
                String telefono = leerUsuarios.get(1);

                usuarios.add(new Contacto(nombre, telefono)); // Añade la informacion a la lista
            }

            leerUsuarios.close(); // Cierra el archivo

// Recorremos la lista y la mostramos en la pantalla
            for(Contacto user : usuarios) {
                System.out.println(user.getNombre() + " , "
                        + user.getTelefono() );
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}