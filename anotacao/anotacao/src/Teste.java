public class Teste {
    public static void main(String[] args) {
        // Cria uma instância de Observable com identificador "carro"
        Observable carroObservable = new Observable("carro");

        // Adiciona um CarroObserver usando uma expressão lambda
        carroObservable.adicionarObserver(() -> System.out.println("CarroObserver notificado via lambda"));

        // Notifica todos os observadores
        carroObservable.notificarObservadores();
    }
}
