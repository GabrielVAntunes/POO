import java.io.Serializable;

public class Verificacoes implements Serializable{

    // Verifica se um email é válido
    public boolean emailValido(String email){
        if (email != null && email.contains("@") && email.contains(".")) {
            return true;
        } else {
            return false;
        }
    }
}