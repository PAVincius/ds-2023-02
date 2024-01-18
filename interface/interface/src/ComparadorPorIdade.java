
// Comparador por idade

import java.util.Comparator;

public class ComparadorPorIdade implements Comparator<Estudante> {
    @Override
    public int compare(Estudante estudante1, Estudante estudante2) {
        return Integer.compare(estudante1.getIdade(), estudante2.getIdade());
    }
}