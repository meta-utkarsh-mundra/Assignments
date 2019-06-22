package Initials;

import java.util.*;
class Item {
	ArrayList<Item> arrList1=new ArrayList<Item>(4);
    String name;
	int price;
	int id;
	int quantity;
	Scanner scan=new Scanner(System.in);
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

class Shop extends Item {
	
	public Shop(){
		for(int i=1;i<=4;i++){
			Item Ii=new Item();
			Ii.setName("Item"+i);
			Ii.setId(i);
			Ii.setPrice(i*4+10);
			Ii.setQuantity(0);
			arrList1.add(Ii);
			}
		}
	void add(int id){
		System.out.println("\nenter the quantity of the item : ");
		int q=scan.nextInt(); //quantity
		int prvqty = arrList1.get(id-1).getQuantity();  //previous quantity
		arrList1.get(id-1).setQuantity(prvqty+q);
		System.out.println("\nItem added : "+arrList1.get(id-1).getName());
		System.out.println("total quantity of the item is : "+(prvqty+q));
		System.out.println("total price of the item"+id+" is " +arrList1.get(id-1).getQuantity()*arrList1.get(id-1).getPrice());
		}
	void delete(int id) {
		System.out.println("enter the quantity you want to delete : ");
		int q=scan.nextInt(); //quantity
		int qty=arrList1.get(id-1).getQuantity();//previous quantity
		qty=qty-q;//quantity after deletion
		System.out.println("Quantity after deletion : ");
		if(qty>=0) {
			System.out.println(qty);
		}
		else System.out.println(0);
	}
	void display() {
		System.out.println("\nyour cart contains : ");
		System.out.println("\nItems    Quantity    price");
		for(int i=1;i<=4;i++)
		{
			System.out.println("\n"+arrList1.get(i-1).getName()+"       "+arrList1.get(i-1).getQuantity()+"         "+arrList1.get(i-1).getPrice()*arrList1.get(i-1).getQuantity());
		}
	}
	void generateBill() {
		int sum=0;
		for(int i=1;i<=4;i++) {
			sum+=arrList1.get(i-1).getPrice()*arrList1.get(i-1).getQuantity();
		}
		System.out.println("your total bill is : "+sum);
	}
}

public class Cart {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); //for input to switch case
		Shop sh=new Shop();
		while (true)
		{
			System.out.println("\npress 1 to add item 1, 2 to add item 2, 3 to add item 3 and 4 to add item 4 ");
			System.out.println("press 5 to delete any item, 6 to display your cart and 7 to generate bill : ");
			int i=sc.nextInt();
			switch(i) {
			case 1:{
				sh.add(1);
				break;
			}
			case 2:{
				sh.add(2);
				break;
			}
			case 3:{
				sh.add(4);
				break;
			}
			case 4 : {
				sh.add(5);
				break;
			}
			case 5: {
				System.out.println("\nenter the id of the item you want to delete : ");
				int j=sc.nextInt();
				if(j>0&&j<=4) {
				sh.delete(j);
			}
				else {
					System.out.println("\nthis item does not exist");
				}
				break;
			}
			case 6: {
				sh.display();
				break;
			}
			case 7:{
				sh.generateBill();
				break;
			}
			default:{
				System.out.println("\n i think you entered a wrong choice, try again");
			}
		}
		System.out.println("\npree y to continue or press n to end : ");
		char choice=sc.next().charAt(0);
		if(choice=='y') {
			continue;
		}
		else {
			break;
		}

	}
	}
}