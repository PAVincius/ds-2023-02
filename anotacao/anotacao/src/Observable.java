import java.lang.annotation.Annotation;

public class Observable {
    private String identificador; // Identificador único para este objeto observado

    public Observable(String identificador) {
        this.identificador = identificador;
    }

    public void adicionarObserver(ObserverInterface observer) {
        Class<?> observerClass = observer.getClass();

        // Verifica se a anotação ObserverAnnotation está presente
        if (observerClass.isAnnotationPresent(ObserverAnnotation.class)) {
            ObserverAnnotation observerAnnotation = observerClass.getAnnotation(ObserverAnnotation.class);

            // Verifica se o identificador do Observer coincide
            if (observerAnnotation.observado().equals(identificador)) {
                // Notifica o Observer
                observer.notificar();
            }
        }
    }
}
