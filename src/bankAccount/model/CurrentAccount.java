package bankAccount.model;

//CurrentAccount herda de Account
public class CurrentAccount extends BankAccount {

	private float overdraftLimit; 
	
	public CurrentAccount(int accountNumber, int numberAgency, int type, String accountHolder, float balance, float overdraftLimit) {
		
		// Método const. da super classe
		super(accountNumber, numberAgency, type, accountHolder, balance);
		
		//Atributo da classe
		this.overdraftLimit = overdraftLimit;
		
	}

	// Métodos da classe
	public float getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(float overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	// Métodos específicos
	
	@Override 
		public boolean withdrawal(float value) {
			if (this.getBalance() + this.getOverdraftLimit() < value) {
				System.out.println("\nSaldo Insuficiente!");
				return false;
			}
			
			this.setBalance(this.getBalance() - value);
			return true;
		}
		
		public void view() {
			// Super == chamada da superclasse => Account.view();
			super.view();
			System.out.println("Limite de Crédito: " + this.overdraftLimit);
		}

}
