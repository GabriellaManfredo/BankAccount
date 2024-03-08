package bankAccount.controller;

import java.util.ArrayList;

import bankAccount.model.BankAccount;
import bankAccount.repository.BankAccountRepository;

public class BankAccountController implements BankAccountRepository{
	
	private ArrayList<BankAccount> listBankAccount = new ArrayList<BankAccount> ();
	int number = 0;
	
	@Override
	public void searchByNumber(int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listAll() {
		for (var account : listBankAccount) {
			account.view();
		}
		
	}

	@Override
	public void register(BankAccount bankAccount) {
		listBankAccount.add(bankAccount);
		System.out.println("\nA conta número: " + bankAccount.getNumber() + " foi criada com sucesso!");
		
		
		
	}

	@Override
	public void update(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(int originNumber, int destinationNumber, float value) {
		// TODO Auto-generated method stub
		
	}
	
	public int generateNumber () {
		return ++ number;
	}
	
}
