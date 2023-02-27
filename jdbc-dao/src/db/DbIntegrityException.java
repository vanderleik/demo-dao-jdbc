package db;

/**
 * Classe que lança uma exceção de integridade referencial caso uma tabela, que seja dependência de outra, seja deletada
 */
public class DbIntegrityException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String msg) {
        super(msg);
    }
}