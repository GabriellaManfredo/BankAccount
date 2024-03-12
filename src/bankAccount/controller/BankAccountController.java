package bankAccount.controller;

import java.util.ArrayList;

import bankAccount.model.BankAccount;
import bankAccount.repository.BankAccountRepository;

public class BankAccountController implements BankAccountRepository{
	
	private ArrayList<BankAccount> listBankAccount = new ArrayList<BankAccount> ();
	int number = 0;
	
	@Override
	public void searchByNumber(int number) {
		var account = searchInTheCollection(number);
		
		if(account != null) {
			account.view();
		} else {
			System.out.println("\nA conta número: " + number + " não foi encontrada!");
		}	
		
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
		var searchBankAccount = searchInTheCollection(bankAccount.getNumber());
		
		if(searchBankAccount != null) {
			listBankAccount.set(listBankAccount.indexOf(searchBankAccount), bankAccount);
			System.out.println("\nA conta número: " + bankAccount.getNumber() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA conta número " + bankAccount.getNumber() + " não foi encontrada!");
		}
		
	}

	@Override
	public void delete(int number) {
		var bankAccount = searchInTheCollection(number);
		
		if(bankAccount != null) {
			if(listBankAccount.remove(bankAccount) == true) {
				System.out.println("\nA conta número: " + number + " foi deletada com sucesso!");
			}
		} else {
			System.out.println("\nA conta número: " + number + " não foi encontrada!");
		}
	}

	@Override
	public void withdraw(int number, float value) {
		var bankAccount = searchInTheCollection(number);
		
		if (bankAccount != null) {
			if (bankAccount.withdraw(value) == true) {
				System.out.println("\nO saque na conta número " + number + " foi efetuado com sucesso!");
			} 
		} else {
			System.out.println("\nA conta número " + number + " não foi encontrada!");
		}
		
	}

	@Override
	public void deposit(int number, float value) {
		var bankAccount = searchInTheCollection(number);
		
		if (bankAccount != null) {
			bankAccount.deposit(value);
			System.out.println("\nO depósito na conta número: " + number + " foi efetuado com sucesso!");
		} else {
			System.out.println("\nA conta número " 
								+ number + " não foi encontrada ou a conta destino não é uma conta corrente!");
		}
		
	}

	@Override
	public void transfer(int originNumber, int destinationNumber, float value) {
		var originBankAccount = searchInTheCollection(originNumber);
		var destinationBankAccount = searchInTheCollection(destinationNumber);
		
		if(originBankAccount != null && destinationBankAccount != null) {
			
			if(originBankAccount.withdraw(value) == true) {
				destinationBankAccount.deposit(value);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
		} else {
			System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
		}
		
		
		
	}

	public int generateNumber () {
		return ++ number;
	}
	
	public BankAccount searchInTheCollection(int number) {
		for (var account : listBankAccount) {
			if(account.getNumber() == number) {
				return account;
			}
		}
		return null;
	}
}
