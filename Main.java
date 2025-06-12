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
                        s_rate = sc.nextDouble();
                        s_booked.add(true);
                        
                        
                        System.out.print("Your service has been added! Would you like to add another (Yes/No)? ");
                        if(!sc.nextLine().equalsIgnoreCase("yes"))
                            break;
                    }
                    break;
                    
                case 2: {
                    for(int i = 0; i < categories.length; i++){
                        System.out.print((i+1) + ". " + categories[i]);
                    }
                    System.out.print("Enter category number: ");
                    int c_index = sc.nextInt() - 1;
                    while (c_index < 0 || c_Index >= categories.length){
                        System.out.print("You did not choose a category. Enter Category number:");
                        c_index = sc.nextInt();
                    }
                    String selected_c = categories[c_index];
                    ArrayList<Integer> matches = new ArrayList<Integer>();
                    System.out.print("Service in "+ selected_c + ":");
                    for(int i = 0;i < s_Names.size(); i++);{
                        if (s_categories.get(i).equalsIngoreCase(selected_c)){
                            System.out.println()
                        }
                    }
                }
            }
        }
    }
}
