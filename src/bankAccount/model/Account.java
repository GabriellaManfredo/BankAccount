package bankAccount.model;

public class Account {
	
	// Atributos / Caracteristicas
	
	// Encapsulamento: encapsular/proteger algo
	// Private / Protected / Public / Friendly
	
	private int number; 
	private int branch;
	private int type;
	private float balance;
	private String accountHolder;
	
	
	// Métodos Construtor: que auxilia na criação/intanciação de um objeto da classe
	public Account(int accountNumber, int branch, int type, String accountHolder, float balance) {
		// this(esta): representa o nome da própria classe (conta)
		
		this.number = accountNumber; //bankAccount.number recebe o valor do arg. number
		this.branch = branch;
		this.type = type;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	// Métodos de acesso (método Get/Getter - metodo set/setter)
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int accountNumber) {
		this.number = accountNumber;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public boolean withdrawal(float value) {
		if (this.getBalance() < value) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		} else {
			this.setBalance(this.getBalance() - value);
			return true;
		}
	}
	
	public void deposit(float value) {
		this.setBalance(this.getBalance() + value);
	}
	
	public void view() {
		String type = "";
		switch (this.type) {
		
			case 1: 
				type = "Conta Corrente";
				break;
				
			case 2: 
				type = "Conta Poupança";
				break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da conta: " + this.number);
		System.out.println("Agência: " + this.branch);
		System.out.println("Tipo da conta: " + type);
		System.out.println("Titular: " + this.accountHolder);
		System.out.println("Saldo: " + this.balance);
		
	}
	
	
}
