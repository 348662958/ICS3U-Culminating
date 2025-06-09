import java.util.Scanner;
import java.util.ArrayList();
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s_name = new ArrayList<String>();
        System.out.println("Would you like to add or book a service");
        String service = sc.nextLine().toUpperCase();
        
        if(service.equals("ADD")){
            boolean add = true; //to ensure that the user woud like to add more services
            while(true){
                System.out.print("Enter service name: ");
                s_name.add(sc.nextLine());
                System.out.print("Enter category: ");
                s_name.add(sc.nextLine());
            }
        }
        else{
