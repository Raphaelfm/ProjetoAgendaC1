public class Pessoa {
    private Data dataDeAniversario = new Data();
    private String nome, telefone, email;

    public Pessoa() {
        super();

    }

    public Pessoa(String nome, String telefone, String email, Data dataDeAniversario) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Data getDataDeAniversario() {

        return dataDeAniversario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDeAniversario(int dia, int mes, int ano) {
        this.dataDeAniversario.setDia(dia);
        this.dataDeAniversario.setMes(mes);
        this.dataDeAniversario.setAno(ano);
    }

    public int getDia() {

        return dataDeAniversario.getDia();

    }

    public int getMes() {

        return dataDeAniversario.getMes();
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", data de aniversario=" + dataDeAniversario.getDia() + "/"
                + dataDeAniversario.getMes() + "/" + dataDeAniversario.getAno() +
                "\ntelefone=" + telefone + ", email=" + email + "]";
    }

}