package aluno;

public class Aluno {

    private int ra;

    private String nome;

    private String endereco;

    private String celular;

    private String dataDeNascimento;

    public Aluno(int ra, String nome, String endereco, String celular, String dataDeNascimento){
        setRa(ra);
        setNome(nome);
        setEndereco(endereco);
        setCelular(celular);
        setDataDeNascimento(dataDeNascimento);
    }

    public Aluno(){}

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
