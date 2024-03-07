package bankAccount.repository;

import bankAccount.model.BankAccount;

public interface BankAccountRepository {
	//CRUD da conta
	
	public void searchByNumber (int number);
	public void listAll();
	public void register(BankAccount bankAccount);
	public void update (BankAccount bankAccount);
	public void delete (int number);
	
	// Métodos bancários
	public void withdraw(int number, float value);
	public void deposit(int number, float value);
	public void transfer(int originNumber, int destinationNumber, float value); 
}
