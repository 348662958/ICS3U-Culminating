import java.util.Scanner;
import java.util.ArrayList();
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s_name = new ArrayList<String>();
        ArrayList<String> c_name = new ArrayList<String>();
        ArrayList<Double> rate = new ArrayList<Double>();
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
                rate.add(sc.nextdouble());
                
                System.out.print("Would you like to add another service (Y/N)? ");
                switch(sc.nextLine().toUpperCase()){
                    case "Y" -> add = true; //the loop will contiune
                    case "N" -> add = false; //the loop will end
                }
            }
            for(int i = 1; i < s_name.length(); i++){
                System.out.print("You have added "+ s_name(i) + " under the " + c_name(i) + " category for " + rate(i));
            }
            
        } else {
            
        }
        
    }
}
