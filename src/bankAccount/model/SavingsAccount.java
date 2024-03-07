package bankAccount.model;

public class SavingsAccount extends BankAccount {
	
	private int birthday;

	public SavingsAccount(int accountNumber, int branch, int type, String accountHolder, float balance, int birthday) {
		super(accountNumber, branch, type, accountHolder, balance);
		this.birthday = birthday;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	@Override
		public void view() {
			super.view();
			System.out.println("Aniversário da conta: " + this.birthday);
		}
}
