import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s_names = new ArrayList<String>();
        s_names.add("Ashley's Tutoring"); s_names.add("Ariana's Plumbing"); s_names.add("Tiffany's Cleaning");
        ArrayList<String> s_categories = new ArrayList<String>();
        s_categories.add("Tutoring"); s_categories.add("Plumbing"); s_categories.add("Cleaning");
        ArrayList<Double> s_rates = new ArrayList<Double>();
        s_rates.add(23.25); s_rates.add(53.47); s_rates.add(41.12);
        ArrayList<Boolean> s_booked = new ArrayList<Boolean>();
        s_booked.add(true); s_booked.add(true); s_booked.add(true);
        
        ArrayList<Integer> cart = new ArrayList<Integer>();
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Tutoring"); categories.add("Plumbing"); categories.add("Cleaning");
        
        boolean run = true;
        while (run){
            System.out.print("Welcome to the Local Service Marketplace \n1. Add a Service \n2. Book a Service \n3. View/Update Cart \n4. Checkout \n5. Exit \nEnter Option: ");
            
            int option = sc.nextInt();
            sc.nextLine();
            
            switch (option){
                case 1:
                    while(true){
                        System.out.print("Service name: ");
                        s_names.add(sc.nextLine());
                        System.out.print("Category (frist letter uppercase): ");
                        String cat = sc.nextLine();
                        s_categories.add(cat);
                        if(!categories.contains(cat))
                            categories.add(cat);
                        System.out.print("Hourly Rate: ");
                        s_rates.add(sc.nextDouble());
                        s_booked.add(true);
                        sc.nextLine();
                        
                        System.out.print("Your service has been added! Would you like to add another (Yes/No)? ");
                        if (!sc.nextLine().equalsIgnoreCase("yes"))
                            break;
                    }
                    break;
                    
                case 2: 
                    for(int i = 0; i < categories.size(); i++){
                        System.out.println((i+1) + ". " + categories.get(i));
                    }
                    System.out.print("Enter category number: ");
                    int c_index = sc.nextInt() - 1;
                    while (c_index < 0 || c_index >= categories.size()){
                        System.out.print("Invalide category. Enter category number: ");
                        c_index = sc.nextInt()-1;
                    }
                    sc.nextLine();
                    String selected_c = categories.get(c_index);
                    ArrayList<Integer> matches = new ArrayList<Integer>();
                    System.out.println("Service in "+ selected_c + ":");
                    for(int i = 0; i < s_names.size(); i++){
                        if (s_categories.get(i).equalsIgnoreCase(selected_c)){
                            if(s_booked.get(i))
                                System.out.println((i+1) + ". " + s_names.get(i) + " - $" + s_rates.get(i) + " - " + "Available");
                            else
                                System.out.println((i+1) + ". " + s_names.get(i) + " - $" + s_rates.get(i) + " - " + "Fully Booked");
                            matches.add(i);
                        }
                    }
                    if (matches.size() == 0) {
                        System.out.println("There are no services in this category.");
                        break;
                    }
                    
                    System.out.print("Enter service number to add to cart: ");
                    int s_index = sc.nextInt() - 1;
                    while (!matches.contains(s_index) || s_index < 0 || s_index >= s_names.size()) {
                        System.out.println("Invalid service number. Enter service number to add to cart: ");
                        s_index = sc.nextInt() - 1;
                    }
                    if (!s_booked.get(s_index)) {
                        System.out.println("Service is fully booked.");
                    } else {
                        cart.add(s_index);
                        s_booked.set(s_index, false);
                        System.out.println("Service has been added to cart.");
                    }
                    break;
                    
                case 3:
                    if (cart.size() == 0) {
                        System.out.println("Your cart is empty.");
                        break;
                    }
                    System.out.println("Cart:");
                    for (int i = 0; i < cart.size(); i++){
                        int serviceIndex = cart.get(i);
                        System.out.println((i+1) + ". " + s_names.get(serviceIndex) + " - $ " + s_rates.get(serviceIndex));
                    }

                    System.out.println("Options: U = Update, R = Remove, B = Back");
                    String cart_Op = sc.nextLine();

                    if (cart_Op.equalsIgnoreCase("U")) {
                        System.out.print("Enter item number for updating: ");
                        int upd = sc.nextInt() - 1;
                        sc.nextLine();
                        if (upd > -1 && upd < cart.size()) {
                            int idx = cart.get(upd);
                            s_booked.set(idx, true);
                            cart.remove(upd);
                            System.out.println("What service would you like to rebook with?");
                            for (int i = 0; i < categories.size(); i++) {
                                System.out.println((i+1) + ". " + categories.get(i));
                            }
                            System.out.print("Select category number: ");
                            int updateCart = sc.nextInt() - 1;
                            while (updateCart < 0 || updateCart >= categories.size()) {
                                System.out.print("Invaid category. Select category number: ");
                                updateCart = sc.nextInt() - 1;
                            }
                            String upCart = categories.get(updateCart);

                            ArrayList<Integer> available = new ArrayList<>();
                            
                            for (int i = 0; i < s_names.size(); i++) {
                                if (s_categories.get(i).equalsIgnoreCase(upCart)) {
                                    if (s_booked.get(i))
                                        System.out.println((i+1) + ". " + s_names.get(i) + " - $" + s_rates.get(i) +
                                            " - " + "Available");
                                    else
                                        System.out.println((i+1) + ". " + s_names.get(i) + " - $" + s_rates.get(i) +
                                            " - " + "Fully Booked");
                                    available.add(i);
                                }
                            }
                            if (available.size() ==0) 
                                break;
                            System.out.print("Choose service number: ");
                            int newService = sc.nextInt() - 1;
                            if (available.contains(newService) && s_booked.get(newService)) {
                                cart.add(newService);
                                s_booked.set(newService, false);
                                System.out.println("Updated");
                            } else {
                                System.out.println("Invalid or unavailable.");
                            }
                        }
                    } else if (cart_Op.equalsIgnoreCase("R")) {
                        System.out.print("Enter item number you would like to  remove: ");
                        int del = sc.nextInt() - 1;
                        if (del >= 0 && del < cart.size()) {
                            int idx = cart.get(del);
                            s_booked.set(idx, true);
                            cart.remove(del);
                            System.out.println("Removed.");
                        }
                    }
                    break;

                case 4:
                    if (cart.size() == 0) {
                        System.out.println("Your cart is empty.");
                        break;
                    }
                    double total = 0;
                    System.out.println("Invoice:");
                    for (int idx : cart) {
                        System.out.println(s_names.get(idx) + " - $" + s_rates.get(idx));
                        total += s_rates.get(idx);
                    }
                    System.out.println("Total: $" + total);
                    System.out.println("Your order has been confirmed. Thank you!");
                    cart.clear();
                    break;

                case 5:
                    System.out.println("Exiting. Please come again, Bye!");
                    run = false;
                    break;

                default:
                    System.out.println("Ivalid option.");
                
            }
        }
        sc.close();
    }
}
