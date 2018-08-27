import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerStore 
{
	Scanner scan = new Scanner(System.in);
	
	ArrayList<Customer> store = new ArrayList <Customer>();
	
	public void createNewCustomer(int a)
	{
		
		System.out.println("Please Enter Customer's Name : ");
		String c_name = scan.nextLine();
		
		System.out.println("Please Enter Customer's Last Name : ");
		String c_surname = scan.nextLine();
		
		System.out.println("Please Enter Customer's Sex ( Male or Female ) : ");
		String c_sex = scan.nextLine();	
		
		if(c_sex.equalsIgnoreCase("Male") || c_sex.equalsIgnoreCase("Female"))
		{
			int c_id = 10000000 + store.size() + 1 + a;
			
			Customer cust = new Customer(c_name, c_surname, c_sex, c_id, 0);
		
			store.add(cust);
		} 
		else
		{
			System.out.println("Error !");
		}
	
				
	}
	
	public void deleteCustomer(int id)
	{	
		id -= 10000001; 
		store.remove(id);
	}
	
	public void listCustomerByCustomerID()
	{
		Collections.sort(store, new Comparator<Customer>() {
		    @Override
		    public int compare(Customer c1, Customer c2) {
		      Integer id1 = c1.getCustomerID();
		      Integer id2 = c2.getCustomerID();
		      return id1.compareTo(id2);
		    }
		  });
		System.out.println("Customer ID\tName\tLast Name\tSex\tBalance");
		
		for (int i = 0; i < store.size(); i++) 
		{
			System.out.println(store.get(i));			
		}
	}
	
	public void listCustomerByName()
	{
		Collections.sort(store, new Comparator<Customer>() 
		{
			@Override
			public int compare(Customer c1, Customer c2)
			{
				String cName1 = c1.name;
				String cName2 = c2.name;
				return cName1.compareTo(cName2);				
			}
			
		});
		
		System.out.println("Customer ID\tName\tLast Name\tSex\tBalance");
		
		for (int i = 0; i < store.size(); i++) 
		{
			System.out.println(store.get(i));			
		}		
		
	}
	
	public void listCustomerByLastName()
	{
		Collections.sort(store, new Comparator<Customer>() 
		{
			@Override
			public int compare(Customer c1, Customer c2)
			{
				String cSurname1 = c1.surname;
				String cSurname2 = c2.surname;
				return cSurname1.compareTo(cSurname2);				
			}
			
		});
		
		System.out.println("Customer ID\tName\tLast Name\tSex\tBalance");
		
		for (int i = 0; i < store.size(); i++) 
		{
			System.out.println(store.get(i));			
		}
		
	}
	
	public void listCustomerByGender()
	{
		System.out.println("How Do You Want to List for Female[1] or Male[2] ? ");
		int option = Integer.parseInt(scan.nextLine());
		
		if(option == 1 )
		{		
			Collections.sort(store, new Comparator<Customer>() 
			{
				@Override
				public int compare(Customer c1, Customer c2)
				{
					String cSex1 = c1.sex;
					String cSex2 = c2.sex;
					return cSex1.compareTo(cSex2);				
				}
			
			});
			System.out.println("Customer ID\tName\tLast Name\tSex\tBalance");
		
			for (int i = 0; i < store.size(); i++) 
			{
				System.out.println(store.get(i));			
			}
		}
		else if( option == 2 )
		{
			Collections.sort(store, new Comparator<Customer>() 
			{
				@Override
				public int compare(Customer c1, Customer c2)
				{
					String cSex1 = c1.sex;
					String cSex2 = c2.sex;
					return cSex1.compareTo(cSex2);				
				}
				
			});
			System.out.println("Customer ID\tName\tLast Name\tSex\tBalance");
			
			for (int i = store.size() - 1; i >= 0 ; i--) 
			{
				System.out.println(store.get(i));			
			}			
		}		
	}
	
	public void showHowManyCustomer()
	{
		System.out.println("The Bank Has " + store.size() + " Customer");
	}	

	public Customer searchingCustomer(int id)
	{
		Customer found = null;
		
		Scanner scan1 = new Scanner(System.in);
		
		for (int i = 0; i < store.size(); i++) 
		{		
			for (Customer customer : store)
			{
				if(customer.getCustomerID()==id)
				{
					found = customer;
				
					System.out.println("Please Enter New Customer's Name : ");
					found.name = scan1.nextLine();
				
					System.out.println("Please Enter New Customer's Last Name : ");
					found.surname = scan1.nextLine();
				
					System.out.println("Please Enter New Customer's Sex : ");
					found.sex = scan1.nextLine();
				}
				
				
			}break;
		}
		
		return found;		
	}
	
	public Customer moneyOperations(int id)
	{
		Customer found = null;
		for (int i = 0; i < store.size(); i++) 
		{
			
		
		for (Customer customer : store)
		{
			if(customer.getCustomerID() == id)
			{
				found = customer;
				
				Scanner scan1 = new Scanner(System.in);
				
				System.out.println("Add Money [1] or Draw Money [2]");
				
				int option =scan1.nextInt();
				
				if(option == 1)
				{
					System.out.println("How Much Money Do You Want to Add ?");
					double amount = scan1.nextDouble();
					if(amount > 0)
					{
						found.setBalance(found.getBalance() + amount);
					}
					else
					{
						System.out.println("Error !");
					}
					
				}
				else if(option == 2)
				{
					System.out.println("How Much Money Do You Want to Draw ?");
					double amount = scan1.nextDouble();
					if(amount > 0)
					{
						if(found.getBalance() >= amount)
						{
							found.setBalance(found.getBalance() - amount);
						}
						else
						{
							System.out.println("You Do Not Have Enough Money to Draw !");
						}
						
					}
					else
					{
						System.out.println("Error !");
					}
										
				}	
				else
				{
					System.out.println("Error ! ");
				}				
			}
		}
			break;
		}		
		return found;		
	}	
}
