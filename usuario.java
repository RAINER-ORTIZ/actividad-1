public class Usuario {
    private String nombre;
    private String username;
    private String password;
    private String email;

    public Usuario(String nombre, String username, String password, String email) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
