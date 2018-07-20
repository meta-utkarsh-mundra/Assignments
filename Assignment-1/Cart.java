package Initials;

import java.util.*;
class Item {
    String name;
    int price;
    int id;
    int quantity;
    Scanner scan=new Scanner(System.in);
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Shop extends Item {
	ArrayList<Item> arrList1=new ArrayList<Item>(4);
    public Shop(){
        for(int i=1;i<=4;i++){
            Item Ii=new Item();
            Ii.setName("Item"+i);
            Ii.setId(i);
            Ii.setPrice(i*4+10);
            Ii.setQuantity(0);
            arrList1.add(Ii);
            }
        System.out.println("\nitems available are : ");
        for(int i=1;i<=4;i++){
        	System.out.println(arrList1.get(i-1).getName());
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
        qty = qty  >q ? qty - q : 0;//quantity after deletion
        arrList1.get(id-1).setQuantity(qty);
        System.out.println("Quantity after deletion : "+arrList1.get(id-1).getQuantity());
        
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
            System.out.println("\npress 1 to add items, press 2 to delete any item, 3 to display your cart and 4 to generate bill ");
            
            int i=sc.nextInt();
            switch(i) {
            case 1:{
                System.out.println("\nenter the id of the item you want to add : ");
                int id=sc.nextInt();
                sh.add(id);
                break;
            }
            case 2: {
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
            case 3: {
                sh.display();
                break;
            }
            case 4:{
                sh.generateBill();
                break;
            }
            default:{
                System.out.println("\n i think you entered a wrong choice, try again");
            }
        }
        System.out.println("\npress y to continue or press n to end : ");
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