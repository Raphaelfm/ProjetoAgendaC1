
import java.util.Arrays;

public class VetPessoa {
    private int tamanho;
    private Pessoa vetor[];
    private int quant;

    public void setVetor(Pessoa[] vetor) {
        this.vetor = vetor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Pessoa getPos(int posicao) {
        int pos = posicao;

        if (posicao > 0 && posicao < vetor.length) {
            return vetor[pos];
        } else {
            return null;
        }

    }

    public boolean insere(Pessoa objetoo) {

        if (quant < vetor.length) {
            vetor[quant] = objetoo;
            this.quant += 1;
            return true;
        } else {
            return false;
        }
    }

    // Metodo para remover os dados de uma pessoa
    // realizando a verificacao pelo nome dessa pessoa
    // Apos verificar e remover, o mesmo refaz o vetor,
    // Caso o booleano seja verdadeiro
    public boolean remove(String nome) {
        boolean verificador = false;

        for (int i = 0; i < this.quant; i++) {
            if (vetor[i].getNome().equalsIgnoreCase(nome)) {
                vetor[i] = vetor[this.quant - 1];
                vetor[this.quant - 1] = null;
                quant -= 1;
                verificador = true;
            }
        }

        return verificador;
    }

    // Metodo de pesquisa pelo nome
    public int pesquisa(String nome) {
        for (int i = 0; i < this.quant; i++) {
            if (vetor[i].getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    public VetPessoa pesquisaDiaMes(int dia, int mes) {

        VetPessoa pessoaDiaMes = new VetPessoa(this.tamanho);

        for (int i = 0; i < this.quant; i++) {

            if (vetor[i].getDia() == dia && vetor[i].getMes() == mes) {
                pessoaDiaMes.insere(vetor[i]);
            }
        }

        if (pessoaDiaMes.getQuant() != 0) {
            return pessoaDiaMes;
        } else {
            return null;
        }
    }

    public VetPessoa pesquisaMes(int mes) {
        VetPessoa pessoaMes = new VetPessoa(this.tamanho);
        for (int a = 0; a < this.quant; a++) {
            if (vetor[a].getMes() == mes) {
                pessoaMes.insere(vetor[a]);
            }
        }

        if (pessoaMes.getQuant() != 0) {
            return pessoaMes;
        } else {
            return null;
        }
    }

    // Construtor recebendo apenas o tamanho do vetor que sera instanciado
    public VetPessoa(int tamanho) {
        this.tamanho = tamanho;
        vetor = new Pessoa[this.tamanho];
        this.quant = 0;

    }

    public Pessoa getPessoa(int i) {
        if (vetor[i] != null) {
            return vetor[i];
        }

        return null;
    }

    @Override
    public String toString() {
        return "VetPessoa [vetor=" + Arrays.toString(vetor) + "]";
    }

}
