import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s_name = new ArrayList<String>();
        ArrayList<String> s_categories = new ArrayList<String>();
        ArrayList<Double> s_rate = new ArrayList<Double>();
        ArrayList<Boolean> s_booked = new ArrayList<>();
        
        ArrayList<Integer> cart = new ArrayList<>();
        String[] categories = {"Tutoirng", "Plumbing", "Cleaning"};
        
        boolean run = true;
        while (run){
            System.out.print("1. Add a Service \n 2. Book a Service \n 3. View/Update Cart \n 4. Checkout \n 5. Exit \n Enter Option: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    while(true){
                        System.out.print("Service name: ");
                        s_name.add(sc.nextLine());
                        System.out.print("Category: ");
                        s_categories.add(sc.nextLine());
                        System.out.print("Hourly Rate: ");
                        double rate = Double.parseDouble(sc.nextLine());
                        s_booked.add(true);
                        
                        
                        System.out.print("Your service has been added! Would you like to add another (Yes/No)? ");
                        if(!sc.nextLine().equalsIgnoreCase("yes"))
                            break;
                    }
                    break;
                    
                case 2: {
                    
                }
            }
            
    }
}
