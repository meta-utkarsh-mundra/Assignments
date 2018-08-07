package cartExtended;
import java.util.*;
class Item {
    String name;
    double price;
    int id;
    int quantity;
    Scanner scan=new Scanner(System.in);
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
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
    static ArrayList<Item> arrList1=new ArrayList<Item>(4);
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
        double sum=0;
        for(int i=1;i<=4;i++) {
            sum+=arrList1.get(i-1).getPrice()*arrList1.get(i-1).getQuantity();
        }
        FixedOrderPromotion orderPromotion = new FixedOrderPromotion();
        int fDiscount = orderPromotion.getFixedDiscount(sum);
        int minPrice = 1000; 
        orderPromotion.setMinimumPrice(minPrice);
        double tot_bill = sum;
        System.out.println("A fixed discount of "+fDiscount+"% has been applied to your order!");
        tot_bill = sum - fDiscount;
        System.out.println("Do you have any promo code ? Press y to enter code else press n : ");
        char choice=scan.next().charAt(0);
        if(choice=='y') {
            String code = scan.next();
            double cDiscount = 0;
            if(orderPromotion.isPromotionApplicable(code.toUpperCase())){
                switch(code.toUpperCase()){
                    case "NEWBILL":
                        //70% off
                        cDiscount=0.7;
                        System.out.println("Coupon code : NEWBILL has been applied to your order (70% off)");
                        break;
                    case "F50":
                        //50% off
                        cDiscount = 0.5;
                        System.out.println("Coupon code : F50 has been applied to your order (50% off)");
                        break;
                    case "FP20":
                        //20% off
                        cDiscount = 0.2;
                        System.out.println("Coupon code : FP20 has been applied to your order (20% off)");
                        break;
                }

                tot_bill = tot_bill-tot_bill*cDiscount;
            }
        }
        System.out.println("your final total bill is : "+tot_bill);
    }
}
enum PromotionEnum { NEWBILL, F50, FP20 };

interface Promotion {

    public double getMinimumPrice();
    public void setMinimumPrice(double price);
    public int getFixedDiscount(double price);
    public boolean isPromotionApplicable(String code);

}


class FixedOrderPromotion implements Promotion{

    double price;

    @Override
    public double getMinimumPrice() {
        return price;
    }

    @Override
    public void setMinimumPrice(double minPrice) {
        price=minPrice;
    }

    @Override
    public int getFixedDiscount(double totalbill) {
        double p = getMinimumPrice();
    	if(totalbill > p) {
    		totalbill = totalbill - 0.25*totalbill;
    	}
        if(totalbill>800){
            totalbill=totalbill-0.2*totalbill;//20% off
            setMinimumPrice(totalbill);
            return 20;
        }else if(totalbill>600){
            totalbill=totalbill-0.1*totalbill;//10% off
            setMinimumPrice(totalbill);
            return 10;
        }
        return 0;
    }


    @Override
    public boolean isPromotionApplicable(String code) {
        for (PromotionEnum c : PromotionEnum.values()) {
            if (c.name().toUpperCase().equals(code)) {
                return true;
            }
        }
        return false;
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
