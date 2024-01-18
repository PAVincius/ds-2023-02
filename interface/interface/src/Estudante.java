import java.util.Arrays;

public class Estudante implements Comparable<Estudante> {

private String nome;
private String sobrenome;
 private int idade;
private double[] notas;

    public Estudante(String nome, String sobrenome, int idade, double[] notas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.notas = notas;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia() {

        if (notas.length == 0) {
            return 0.0;
        }
        double soma = Arrays.stream(notas).sum();
        return soma / notas.length;
    }
    @Override
    public int compareTo(Estudante outroEstudante) {
        return this.nome.compareTo(outroEstudante.getNome());
    }
}
