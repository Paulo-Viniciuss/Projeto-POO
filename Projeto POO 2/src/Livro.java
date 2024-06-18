public class Livro {
    private int id;
    private String nome;
    private String autor;
    private double valor;

    public Livro(int id, String nome, String autor, double valor) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nome + " by " + autor + " - $" + valor;
    }
}
