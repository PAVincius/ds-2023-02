
// Comparador por sobrenome

import java.util.Comparator;

public class ComparadorPorSobrenome implements Comparator<Estudante> {
    @Override
    public int compare(Estudante estudante1, Estudante estudante2) {
        return estudante1.getSobrenome().compareTo(estudante2.getSobrenome());
    }
}