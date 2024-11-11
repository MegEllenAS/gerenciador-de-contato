
public class ContatoProfissional extends Contato {
    private String cnpj;
    
    public ContatoProfissional(String nome, String telefone, String sexo, String cpf, String email, String endereco, String cnpj) {
        super(nome, telefone, sexo, cpf, email, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
