import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> service = new ArrayList<String>();
        ArrayList<String> cart = new ArrayList<String>();
        String[] categories = {"Tutoirng", "Plumbing", "Cleaning"};
        
        boolean repeat = true;
        while (repeat){
            System.out.print("Would you like to add or book a service? ");
            String service = sc.nextLine().toUpperCase();
        
            if(service.contains("ADD")){
                boolean add = true; //to ensure that the user woud like to add more services
                while(add){ //allow for looping if the user would like
                    System.out.print("Enter service name: ");
                    s_name.add(sc.nextLine());
                    System.out.print("Enter category: ");
                    c_name.add(sc.nextLine());
                    System.out.print("Enter cost (DO NOT enter \"$\"): ");
                    rate.add(sc.nextDouble());
                    
                    System.out.print("Would you like to add another service (Y/N)? ");
                    switch(sc.nextLine().toUpperCase()){
                        case "Y" -> add = true; //the loop will contiune
                        case "N" -> add = false; //the loop will end
                    }
                }
                for(int i = 1; i < s_name.size(); i++){
                    System.out.print("You have added "+ s_name.get(i) + " under the " + c_name.get(i) + " category for " + rate.get(i));
            }
            
        } else {
            
        }
        
    }
}
