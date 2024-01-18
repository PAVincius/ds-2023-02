
// Comparador por nome

import java.util.Comparator;

public class ComparadorPorNome implements Comparator<Estudante> {
    @Override
    public int compare(Estudante estudante1, Estudante estudante2) {
        return estudante1.getNome().compareTo(estudante2.getNome());
    }
}