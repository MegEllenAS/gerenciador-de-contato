import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ContatoCRUD {

	// Método para salvar um contato comum
    public void salvarContato(Contato contato) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(contato);
        transaction.commit();
        session.close();
    }
	
 // Método para salvar um contato profissional
	public void salvarContatoProfissional(ContatoProfissional contatoProfissional) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(Utils.criarNovoContato(contatoProfissional)); 
        transaction.commit();
        session.close();
    }

	// Método para buscar um contato pelo ID
    public Contato buscarContato(int id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Contato contato = session.get(Contato.class, id);
        session.close();
        return contato;
    }

	// Método para listar todos os contatos
    public List<Contato> listarContatos() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        List<Contato> contatos = session.createQuery("from Contato", Contato.class).list();
        session.close();
        return contatos;
    }

 // Método para atualizar um contato
    public void atualizarContato(Contato contato) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(contato);
        transaction.commit();
        session.close();
    }

 // Método para deletar um contato pelo ID
    public void deletarContato(int id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Contato contato = session.get(Contato.class, id);
        if (contato != null) {
            session.remove(contato);
            transaction.commit();
        }
        session.close();
    }
}
