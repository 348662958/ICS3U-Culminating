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
            System.out.print("Welcome to the Local Service Marketplace \n1. Add a Service \n2. Book a Service \nEnter Option (0 to exit): ");
            
            int option = sc.nextInt();
            sc.nextLine();
            
            switch (option){
                case 0: // to exit
                    System.out.println("Exiting. Please come again, Bye!");
                    run = false;
                    break;
                case 1: // to add services
                    while(true){
                        System.out.print("Service name: ");
                        s_names.add(sc.nextLine());
                        System.out.print("Category (frist letter MUST be uppercase): ");
                        String cat = sc.nextLine();
                        s_categories.add(cat);
                        if(!categories.contains(cat))
                            categories.add(cat);
                        System.out.print("Hourly Rate: ");
                        s_rates.add(sc.nextDouble());
                        s_booked.add(true);
                        sc.nextLine();
                        
                        System.out.print("Your service has been added! \nWould you like to add another (Yes/No)? ");
                        if (!sc.nextLine().equalsIgnoreCase("yes"))
                            break;
                    }
                    break;
                    
                case 2: // to book a service
                    boolean backToMain = false;
                    while (!backToMain){
                        System.out.print("1. Browse Services \n2. View/Update Cart \n3. Checkout \nEnter Option: ");
                        int subOption = sc.nextInt();
                        sc.nextLine();
                        
                        switch (subOption){
                            case 1: // to actually browse the services
                                System.out.println("Available Categories: ");
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
                                    System.out.println("Updated Cart: ");
                                    for(int i = 0; i < cart.size(); i++){
                                        int idx = cart.get(i);
                                        System.out.println((i+1) + ". " + s_names.get(idx) + " - $" + s_rates.get(idx));
                                    }
                                }
                                
                                break;
                            case 2: // view cart
                                if (cart.size() == 0) {
                                    System.out.println("Your cart is empty.");
                                    break;
                                }
                                System.out.println("Your cart:");
                                for (int i = 0; i < cart.size(); i++){
                                    int idx = cart.get(i);
                                    System.out.println((i+1) + ". " + s_names.get(idx) + " - $" + s_rates.get(idx));
                                }
            
                                System.out.println("Options: U = Update, R = Remove, B = Back");
                                String choice = sc.nextLine();
            
                                if (choice.equalsIgnoreCase("U")) {
                                    System.out.print("Enter item number for updating: ");
                                    int updIdx = sc.nextInt() - 1;
                                    sc.nextLine();
                                    if (updIdx >= 0 && updIdx < cart.size()) {
                                        int oldIdx = cart.get(updIdx);
                                        s_booked.set(oldIdx, true);
                                        cart.remove(updIdx);
                                        System.out.println("What service would you like to rebook with?");
                                        for (int i = 0; i < categories.size(); i++) {
                                            System.out.println((i+1) + ". " + categories.get(i));
                                        }
                                        System.out.print("Select category number: ");
                                        int updateCartIdx = sc.nextInt() - 1;
                                        while (updateCartIdx < 0 || updateCartIdx >= categories.size()) {
                                            System.out.print("Invaid category. Select category number: ");
                                            updateCartIdx = sc.nextInt() - 1;
                                        }
                                        String newCart = categories.get(updateCartIdx);
            
                                        ArrayList<Integer> availableServices = new ArrayList<Integer>();
                                        
                                        for (int i = 0; i < s_names.size(); i++) {
                                            if (s_categories.get(i).equalsIgnoreCase(newCart)) {
                                                if (s_booked.get(i))
                                                    System.out.println((i+1) + ". " + s_names.get(i) + " - $" + s_rates.get(i) +
                                                        " - " + "Available");
                                                else
                                                    System.out.println((i+1) + ". " + s_names.get(i) + " - $" + s_rates.get(i) +
                                                        " - " + "Fully Booked");
                                                availableServices.add(i);
                                            }
                                        }
                                        
                                        if (availableServices.size() ==0) {
                                            System.out.println("No available services.");
                                            break;
                                        }
                                        
                                        System.out.print("Choose new service number: ");
                                        int newServiceIdx = sc.nextInt() - 1;
                                        sc.nextLine();
                                        if (availableServices.contains(newServiceIdx)) {
                                            cart.set(updIdx, newServiceIdx);
                                            s_booked.set(newServiceIdx, false);
                                            System.out.println("Cart updated.");
                                            // Display updated cart
                                            System.out.println("\nUpdated Cart:");
                                            for (int i = 0; i < cart.size(); i++) {
                                                int idx = cart.get(i);
                                                System.out.println((i+1) + ". " + s_names.get(idx) + " - $" + s_rates.get(idx));
                                            }
                                        } else {
                                            System.out.println("Invalid service.");
                                        }
                                    } else {
                                        System.out.println("Invalid item number.");
                                    }
                                } else if (choice.equalsIgnoreCase("R")) {
                                    System.out.print("Enter item number to  remove: ");
                                    int remIdx = sc.nextInt() - 1;
                                    sc.nextLine();
                                    if (remIdx >= 0 && remIdx < cart.size()) {
                                        int removedService = cart.remove(remIdx);
                                        s_booked.set(removedService, true);
                                        System.out.println("Item has been removed.");
                                        if (cart.size() ==0) {
                                            System.out.println("Your cart is empty.");
                                        } else {
                                            System.out.println("\nUpdated Cart:");
                                            for (int i = 0; i < cart.size(); i++) {
                                                int idx = cart.get(i);
                                                System.out.println((i+1) + ". " + s_names.get(idx) + " - $" + s_rates.get(idx));
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid item number.");
                                    }
                                }
                                break;
                                
                            case 3: // Checkout
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
                                backToMain = true;
                            break;
                        
                        case 4: // Back to Main Menu
                                backToMain = true;
                                break;
                                
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;

                default:
                    System.out.println("Ivalid option.");
                
            }
        }
        sc.close();
    }
}
