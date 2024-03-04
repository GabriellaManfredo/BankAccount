package bankAccount;

import java.util.Scanner;
import bankAccount.util.colors;

public class menu {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int option;
		
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
			
			option = scanner.nextInt();
			
			if (option == 9) {
				System.out.println(colors.TEXT_WHITE_BOLD + "\nGabsBank - Sua rota para o sucesso financeiro!");
				about();
				scanner.close();
				System.exit(0);
			}
			
			switch(option) {
				case 1: 
					System.out.println(colors.TEXT_WHITE_BOLD +  "Criar conta\n\n");
					break;            
					                  
				case 2:               
					System.out.println(colors.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
					break;             
					                   
				case 3:                
					System.out.println(colors.TEXT_WHITE_BOLD + "Consultar dados da conta - por número\n\n");
					break;            
				                      
				case 4:               
					System.out.println(colors.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
					break;        
				                  
				case 5:           
					System.out.println(colors.TEXT_WHITE_BOLD + "Apagar conta\n\n");					
					break;         
				                   
				case 6:            
					System.out.println(colors.TEXT_WHITE_BOLD + "Saque\n\n");					
					break;             
				                       
				case 7:                
					System.out.println(colors.TEXT_WHITE_BOLD + "Depósito\n\n");					
					break;            
				                      
				case 8:               
					System.out.println(colors.TEXT_WHITE_BOLD + "Transferência entre contas\n\n");					
					break;             
					                   
				default:               
					System.out.println(colors.TEXT_WHITE_BOLD + "\nOpção inválida!");
					break;
					
					
			}
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
