
public class Customer 
{
	private int customerID;
	
	public String name; 
	public String surname;
	public String sex;
	
	private double balance = 0;
	
	

	public void setBalance(double balance) 
	{		
		this.balance = balance;
	}

	public double getBalance() 
	{
		return balance;
	}

	public int getCustomerID() 
	{
		return customerID;
	}

	public void setCustomerID(int customerID) 
	{
		this.customerID = customerID;
	}
	
	public Customer(String name, String surname, String sex, int id, double balance)
	{
		customerID = id;
		this.name=name;
		this.surname = surname;
		this.sex=sex;
		
		this.balance = balance;
	}
	
	public String toString()
	{		
		return this.getCustomerID()+ "\t" + this.name + "\t" + this.surname + "\t\t" + this.sex + "\t" + this.getBalance();
	}
	
}
