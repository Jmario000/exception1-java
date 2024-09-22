package model.exceptions;

public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;
	
	//instacia a exceção personalizada passando uma mensagem
	public DomainException(String msg) {
		super(msg);
	}

}
