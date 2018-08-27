import java.util.Scanner;

public class BankSimulationTest 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		CustomerStore customerOperations = new CustomerStore();
		
		int option = 0;
		
		int counter = 0;
		
		do 
		{
			System.out.println("[1] Create A New Customer");
			System.out.println("[2] Delete An Existing Customer");
			System.out.println("[3] List All Customer");
			System.out.println("[4] List Customer");
			System.out.println("[5] Update A Customer Information");
			System.out.println("[6] Show How Many Customer The Bank Has");
			System.out.println("[7] Add or Draw Money");
							
			option = scan.nextInt();
				
			if(option < 1 || option > 7)
			{
				System.out.println("Error !");
			}
			else
			{
				
				
				if(option == 1)
				{
					customerOperations.createNewCustomer(counter);
				}
				
				else if(option == 2)
				{
					System.out.println("Enter The ID Which You Want to Delete : ");
					int id = scan.nextInt();
					customerOperations.deleteCustomer(id);
					counter++;		
				}
				
				else if(option == 3)
				{
					customerOperations.listCustomerByCustomerID();
				}
				
				else if(option == 4)
				{
					Scanner scan3 = new Scanner(System.in);
					
					System.out.println("[1] Sort by Customer ID");
					System.out.println("[2] Sort by Customer Name");
					System.out.println("[3] Sort by Customer Last Name");
					System.out.println("[4] Sort by Customer Gender");
					option = scan3.nextInt();
					if(option == 1)
					{
						customerOperations.listCustomerByCustomerID();
					}
					
					else if(option == 2)
					{
						customerOperations.listCustomerByName();
					}
					
					else if(option == 3)
					{
						customerOperations.listCustomerByLastName();							
					}
					
					else if(option == 4)
					{
						customerOperations.listCustomerByGender();
					}
					else
					{
						System.out.println("Error !");
					}
				}
				
				else if(option == 5)
				{
					Scanner scan1 = new Scanner(System.in);
					
					System.out.println("Enter The ID Which You Want to Update : ");
					
					int id = scan1.nextInt();
					
					Customer looking = customerOperations.searchingCustomer(id);
					
					if( looking != null)
					{
						System.out.printf("Customer ID : %d \nName : %s \nLast Name : %s \nBalance : %.2f\n",looking.getCustomerID(), looking.name,looking.surname,looking.getBalance());
						
					}
					else
					{
						System.out.println("The Customer You Are Looking For Not Found ! \n");						
					}
					 
				}
				
				else if(option == 6)
				{
					customerOperations.showHowManyCustomer();
				}
				
				else if(option == 7)
				{
					Scanner scan1 = new Scanner(System.in);
					
					System.out.println("Enter The ID Which You Want to Do Money Operations : ");
					
					int id = scan1.nextInt();
					
					Customer looking = customerOperations.moneyOperations(id);
					
					if( looking != null)
					{
						System.out.printf("Customer ID : %d \nName : %s \nLast Name : %s \nBalance : %.2f\n",looking.getCustomerID(), looking.name,looking.surname,looking.getBalance());
					}
										
					else
					{
						System.out.println("The Customer You Are Looking For Not Found ! \n");						
					}
					
				}
			}			
		} while (option != -1);
	}
	

}
