public class CarroObserver implements ObserverInterface {
    @Override
    public void notificar() {
        System.out.println("CarroObserver notificado sobre mudanças no carro.");
    }
}
