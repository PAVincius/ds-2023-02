public class Teste {
    public static void main(String[] args) {
        // Cria uma instância de Observable com identificador "carro"
        Observable carroObservable = new Observable("carro");

        // Cria uma instância de CarroObserver
        CarroObserver carroObserver = new CarroObserver();

        // fica olhando o objeto carroObserver
        carroObservable.adicionarObserver(carroObserver);
    }
}
