
import java.util.ArrayList;
import java.util.List;


/**
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaSala {

    private final List fileiras;

    public GerenciaSala() {
        fileiras = new ArrayList<>();
        fileiras.add(new ArrayList<>());
    }

    public boolean adicionarCadeira(Cadeira cadeira, int fileira) {
        if (validarFila(fileira)) {
            List fila = (List) fileiras.get(fileira);
            fila.add(cadeira);
            return true;
        }
        return false;
    }

    public boolean validarFila(int fileira) {
        if (fileira < fileiras.size()) {
            return true;
        } else {
            if (fileira == fileiras.size()) {
                fileiras.add(new ArrayList<>()); // adiciona outra fila
                return true;
            }
        }
        return false;
    }

    public List getFileiras() {
        return fileiras;
    }

    public boolean sentar(int fileira, Cadeira cadeira) {
        if (fileira < fileiras.size()) {
            List f = (List) fileiras.get(fileira);
            int indice = f.indexOf(cadeira);
            if (indice != -1) {
                Cadeira c = (Cadeira) f.get(indice);
                if (c.getStatus() == EstadoCadeira.VAZIA) {
                    c.setStatus(EstadoCadeira.OCUPADA);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean levantar(int fileira, Cadeira cadeira) {
        if (fileira < fileiras.size()) {
            List f = (List) fileiras.get(fileira);
            int indice = f.indexOf(cadeira);
            if (indice != -1) {
                Cadeira c = (Cadeira) f.get(indice);
                if (c.getStatus() == EstadoCadeira.OCUPADA) {
                    c.setStatus(EstadoCadeira.VAZIA);
                    return true;
                }
            }
        }
        return false;
    }
}
