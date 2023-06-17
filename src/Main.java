package AdressBook;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner an = new Scanner(System.in);
        an.useDelimiter("\n");
        boolean salir = false;
        int menu = an.nextInt();

        while (!salir) {
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar los contactos");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                int opcion = an.nextInt();

                switch (menu)
                {
                    case 1: //añadir un contacto
                        System.out.println("Escribe el nombre del contacto");
                        String nombre = an.next();
                        System.out.println("Escribe el telefono");
                        int telefono = an.nextInt();
                        String c = new Contacto(nombre, telefono);
                        AdressBook.create(contacto);
                        break;
                    case 2: //lista de contactos
                        System.out.println("");
                        AdressBook.list();
                        System.out.println("");
                        break;
                    case 3: //eliminar contacto
                        System.out.println("Escribe el nombre del contacto");
                        nombre = an.next();
                        contacto = new Contacto(nombre, 0);
                        AdressBook.delete(c);
                        break;
                    case 4: //salir
                        salir = true;
                        break;
                    default:
                        System.out.println("No es una opcion valida, por favor digite una opcion valida");
                        System.out.println("");
                        break;

                } //fin del switch
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }// fin del while
    }
}