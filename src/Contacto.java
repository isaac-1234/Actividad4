public class Contacto {
    public String nombre;
    public String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    public boolean equals(Contacto e){
        if(this.nombre.equalsIgnoreCase(e.getNombre())){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "nombre=" + nombre + ", telefono=" + telefono;
    }
}