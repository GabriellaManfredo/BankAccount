package bankAccount;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import bankAccount.controller.BankAccountController;
import bankAccount.model.CurrentAccount;
import bankAccount.model.SavingsAccount;
import bankAccount.util.colors;

public class menu {

	public static void main(String[] args) {
		
		BankAccountController bankAccounts = new BankAccountController();
		
		Scanner scanner = new Scanner(System.in);
		
		int option, number, branch, type, birthday;
		String accountHolder;
		float balance, overdraftLimit;
		
		System.out.println("\nCriar contas\n");
	
		CurrentAccount ca1 = new CurrentAccount(bankAccounts.generateNumber(), 123, 1, "João da Silva", 1000f, 100.0f);
		bankAccounts.register(ca1);
		
		CurrentAccount ca2 = new CurrentAccount(bankAccounts.generateNumber(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		bankAccounts.register(ca2);
		
		SavingsAccount sa1 = new SavingsAccount(bankAccounts.generateNumber(), 125, 2, "Kiara Santos", 4000f, 12);
		bankAccounts.register(sa1);
		
		SavingsAccount sa2 = new SavingsAccount(bankAccounts.generateNumber(), 126, 2, "Giovane Coelho", 8000f, 15);
		bankAccounts.register(sa2);
		
		bankAccounts.listAll();
		
		while (true) {
			
			System.out.println(colors.TEXT_YELLOW + colors.ANSI_BLACK_BACKGROUND);
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("                       GabsBank                       ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("             1 - Criar Conta                          ");
			System.out.println("             2 - Listar todas as Contas               ");
			System.out.println("             3 - Buscar Conta por Numero              ");
			System.out.println("             4 - Atualizar Dados da Conta             ");
			System.out.println("             5 - Apagar Conta                         ");
			System.out.println("             6 - Sacar                                ");
			System.out.println("             7 - Depositar                            ");
			System.out.println("             8 - Transferir valores entre Contas      ");
			System.out.println("             9 - Sair                                 ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("Entre com a opção desejada:                           ");
			System.out.println("                                                      " + colors.TEXT_RESET);
			
			try {
				option = scanner.nextInt();
			} catch (InputMismatchException error) {
				System.err.println("Exceção: " + error);
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				option = 0;
			}
			
			if (option == 9) {
				System.out.println(colors.TEXT_WHITE_BOLD + "\nGabsBank - Sua rota para o sucesso financeiro!");
				about();
				scanner.close();
				System.exit(0);
			}
			
			switch(option) {
				case 1: 
					System.out.println(colors.TEXT_WHITE_BOLD +  "Criar conta\n\n");
					
					System.out.println("Digite o número da agência: ");
					branch = scanner.nextInt();
					System.out.println("Digite o nome do titular: ");
					scanner.skip("\\R?");
					accountHolder = scanner.nextLine();
					
					do {
						System.out.println("Digite o tipo da conta (1 - Conta corrente ou 2 - Conta poupança");
						type = scanner.nextInt();
					} while (type < 1 && type > 2);
					
					System.out.println("Digite o saldo da conta (R$): ");
					balance = scanner.nextFloat();
					
					switch (type) {
						case 1 -> { 
							System.out.println("Digite o limite de crédito(R$): ");
							overdraftLimit = scanner.nextFloat();
							bankAccounts.register(new CurrentAccount (bankAccounts.generateNumber(), branch, type, accountHolder, balance, overdraftLimit));
						}
						
						case 2 -> {
							System.out.println("Digite o dia do aniversário da conta: ");
							birthday = scanner.nextInt();
							bankAccounts.register(new SavingsAccount (bankAccounts.generateNumber(), branch, type, accountHolder, balance, birthday));
						}
					}
					
					keyPress();
					break;            
					                  
				case 2:               
					System.out.println(colors.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
					bankAccounts.listAll();
					keyPress();
					break;             
					                   
				case 3:                
					System.out.println(colors.TEXT_WHITE_BOLD + "Consultar dados da conta - por número\n\n");

					keyPress();
					break;            
				                      
				case 4:               
					System.out.println(colors.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");

					keyPress();
					break;        
				                  
				case 5:           
					System.out.println(colors.TEXT_WHITE_BOLD + "Apagar conta\n\n");

					keyPress();
					break;         
				                   
				case 6:            
					System.out.println(colors.TEXT_WHITE_BOLD + "Saque\n\n");

					keyPress();
					break;             
				                       
				case 7:                
					System.out.println(colors.TEXT_WHITE_BOLD + "Depósito\n\n");

					keyPress();
					break;            
				                      
				case 8:               
					System.out.println(colors.TEXT_WHITE_BOLD + "Transferência entre contas\n\n");

					keyPress();
					break;             
					                   
				default:               
					System.out.println(colors.TEXT_WHITE_BOLD + "\nOpção inválida!");

					keyPress();
					break;
					
					
			}
		}

	}

	public static void keyPress() {
		try {
			System.out.println(colors.TEXT_RESET + "\n\nPressione Enter para continuar.");
			System.in.read();
			
		} catch (IOException error) {
			System.err.println("Exceção: " + error);
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}
	
	
	public static void about() {
		System.out.println("******************************************************");
		System.out.println("Projeto desenvolvido por: ");
		System.out.println("Gabriella Manfredo");
		System.out.println("LinkedIn: linkedin.com/in/gabriellamanfredo/");
		System.out.println("GitHub: github.com/GabriellaManfredo");
		System.out.println("******************************************************");
	}
}
