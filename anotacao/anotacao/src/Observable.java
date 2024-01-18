import java.util.ArrayList;
import java.util.List;

public class Observable {
    private String identificador; // Identificador único para este objeto observado
    private List<ObserverInterface> observadores = new ArrayList<>();

    public Observable(String identificador) {
        this.identificador = identificador;
    }

    public void adicionarObserver(ObserverInterface observer) {
        observadores.add(observer);
    }

    public void notificarObservadores() {
        observadores.forEach(ObserverInterface::notificar);
    }
}
