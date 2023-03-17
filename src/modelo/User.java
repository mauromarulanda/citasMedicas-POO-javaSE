package modelo;

public abstract class User {

    private String name, telefono, email;

    public User( String name,String email ,String telefono) {
        this.name = name;
        this.email = email;
        this.telefono = telefono;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.length() != 10) {
            System.out.println("el numero de telefono debe terner 10 digitos exactamente");
        } else {
            this.telefono = telefono;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract void showDataUser();
}
