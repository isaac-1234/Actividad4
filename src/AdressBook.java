public class AdressBook {
    public Contacto[] contactos;

    public AdressBook(){
        contactos = new Contacto[20];
    }
    public AdressBook(int tamano){

        contactos = new Contacto[tamano];
    }
    public void create(Contacto c){ //método para crear contacto
        if(existeContacto(c)){
            System.out.println("El contacto con ese nombre ya existe");
        }
        boolean encontrado = false;
        for(int i=0;i<contactos.length && !encontrado;i++){
            if(this.contactos[i]==null){
                this.contactos[i]=c;
                encontrado=true;
            }
        }
        if(encontrado == true){
            System.out.println("Se ha añadido con éxito");
        }else{
            System.out.println("No se ha podido añadir el contacto");
        }
    }

    public boolean existeContacto(Contacto contacto){ //para crear contacto primero ver que no existe
        for(int i = 0;i < contactos.length; i++){
            if(contactos[i] != null && contactos[i].equals(contacto)){
                return true;
            }
        }
        return false;
    }

    public void list(){ //devuelve una lista de los contactos
        for(int i=0;i<contactos.length;i++){
            if(contactos[i]!=null){
                System.out.println("Nombre: " + contactos[i].getNombre());
                System.out.println("Teléfono: " + contactos[i].getTelefono());
                System.out.println("");
            }
        }
    }

    public void delete(Contacto contacto){ //borrar un contacto
        boolean encontrado = false;
        for(int i=0;i<contactos.length && !encontrado;i++){
            if(contactos[i]!=null && contactos[i].equals(contacto)){
                contactos[i]=null;
                encontrado=true;
            }
        }
        if(encontrado == true){
            System.out.println("Se eliminó el contacto");
        }else{
            System.out.println("no se pudo eliminar el contacto");
        }
    }

}