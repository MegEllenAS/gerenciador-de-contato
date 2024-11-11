import java.util.List;
import java.util.Scanner;

public class Utils {
	public static Contato capturarcontato() {
        Scanner scanner = new Scanner(System.in);
		// Método para capturar os dados de um contato
		System.out.println("Digite o nome do novo contato: ");
		String nome = scanner.nextLine();
		System.out.println("Digite o telefone: ");
		String telefone = scanner.nextLine();
		System.out.println("Digite o sexo: ");
		String sexo = scanner.nextLine();
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		System.out.println("Digite o email: ");
		String email = scanner.nextLine();
		System.out.println("Digite o endereço: ");
		String endereco = scanner.nextLine();

		Contato contato = new Contato(nome, telefone, sexo, cpf, email, endereco);
		return contato;
	}

	// Método para capturar os dados de um contato
	public static ContatoProfissional capturarContatoProfissional() {
        Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do novo contato profissional: ");
		String nome = scanner.nextLine();
		System.out.println("Digite o telefone: ");
		String telefone = scanner.nextLine();
		System.out.println("Digite o sexo: ");
		String sexo = scanner.nextLine();
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		System.out.println("Digite o email: ");
		String email = scanner.nextLine();
		System.out.println("Digite o endereço: ");
		String endereco = scanner.nextLine();
		System.out.println("Digite o CNPJ da empresa: ");
		String cnpj = scanner.nextLine();

		return new ContatoProfissional(nome, telefone, sexo, cpf, email, endereco, cnpj);
	}

	// Listar todos os contatos
	public static void listcontato(ContatoCRUD contatoCrud) {
        Scanner scanner = new Scanner(System.in);
        
		List<Contato> contatos = contatoCrud.listarContatos();
		System.out.println("\nLista de Contatos:");
		for (Contato c : contatos) {
			System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Telefone: " + c.getTelefone()
					+ ", Sexo: " + c.getSexo() + ", CPF: " + c.getCpf() + ", Email: " + c.getEmail() + ", Endereço: "
					+ c.getEndereco());
		}
	}

	// Buscar contato pelo ID
	public static void buscarContato(ContatoCRUD contatoCrud) {
        Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número do ID do contato que deseja buscar: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha

		Contato contato = contatoCrud.buscarContato(id);
		if (contato != null) {
			System.out.println("Contato encontrado:");
			System.out.println("ID: " + contato.getId() + ", Nome: " + contato.getNome() + ", Telefone: "
					+ contato.getTelefone() + ", Sexo: " + contato.getSexo() + ", CPF: " + contato.getCpf()
					+ ", Email: " + contato.getEmail() + ", Endereço: " + contato.getEndereco());
		} else {
			System.out.println("Contato não encontrado.");
		}
	}

	// Atualizar um contato específico
	public static void atualizarContato(ContatoCRUD contatoCrud) {
        Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número do ID do contato que você quer atualizar: ");
		int idAtualizar = scanner.nextInt();
		scanner.nextLine();
		Contato contatoParaAtualizar = contatoCrud.buscarContato(idAtualizar);

		if (contatoParaAtualizar != null) {
			// Atualizar os campos do contato
			System.out.println("Atualizar o novo nome (DEIXAR EM BRANCO MANTEM O ATUAL): ");
			String novoNome = scanner.nextLine();
			if (!novoNome.isEmpty())
				contatoParaAtualizar.setNome(novoNome);

			System.out.println("Atualizar o novo telefone (DEIXAR EM BRANCO MANTEM O ATUAL): ");
			String novoTelefone = scanner.nextLine();
			if (!novoTelefone.isEmpty())
				contatoParaAtualizar.setTelefone(novoTelefone);

			System.out.println("Atualizar o novo sexo (DEIXAR EM BRANCO MANTEM O ATUAL): ");
			String novoSexo = scanner.nextLine();
			if (!novoSexo.isEmpty())
				contatoParaAtualizar.setSexo(novoSexo);

			System.out.println("Atualizar o novo CPF (DEIXAR EM BRANCO MANTEM O ATUAL): ");
			String novoCpf = scanner.nextLine();
			if (!novoCpf.isEmpty())
				contatoParaAtualizar.setCpf(novoCpf);

			System.out.println("Atualizar o novo email (DEIXAR EM BRANCO MANTEM O ATUAL): ");
			String novoEmail = scanner.nextLine();
			if (!novoEmail.isEmpty())
				contatoParaAtualizar.setEmail(novoEmail);

			System.out.println("Atualizar o novo endereço (DEIXAR EM BRANCO MANTEM O ATUAL): ");
			String novoEndereco = scanner.nextLine();
			if (!novoEndereco.isEmpty())
				contatoParaAtualizar.setEndereco(novoEndereco);

			// Salvar as alterações
			contatoCrud.atualizarContato(contatoParaAtualizar);
			System.out.println("Contato atualizado com sucesso!");
		} else {
			System.out.println("Contato não encontrado.");
		}
	}

	// Deletar um contato pelo ID
	public static void deletarId(ContatoCRUD contatoCrud) {
        Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número do ID do contato que deseja deletar: ");
		int idDeletar = scanner.nextInt();
		scanner.nextLine();

		Contato contatoParaDeletar = contatoCrud.buscarContato(idDeletar);
		if (contatoParaDeletar != null) {
			contatoCrud.deletarContato(idDeletar);
			System.out.println("Contato deletado com sucesso!");
		} else {
			System.out.println("Contato não encontrado.");
		}
	}

	public static Contato criarNovoContato(ContatoProfissional contatoProfissional) {
		return new Contato(contatoProfissional.getNome(), contatoProfissional.getTelefone(),
				contatoProfissional.getSexo(), contatoProfissional.getCpf(), contatoProfissional.getEmail(),
				contatoProfissional.getEndereco());

	}

}