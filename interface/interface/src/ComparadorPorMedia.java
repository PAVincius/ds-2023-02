import java.util.Comparator;

// Comparador por média
public class ComparadorPorMedia implements Comparator<Estudante> {
    @Override
    public int compare(Estudante estudante1, Estudante estudante2) {
        return Double.compare(estudante1.calcularMedia(), estudante2.calcularMedia());
    }
}
