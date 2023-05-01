
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haris
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        String name;
        String category;
        System.out.println("Select search method\n1.By Name\n2.By Category:\n");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println("Enter the name:");
            name=sc.next();
            System.out.println(getDetailsByName(name));
        }
        else if(choice==2){
            System.out.println("Enter the category:");
            category=sc.next();
            System.out.println(getDetailsByCategory(category));
        }
    }

    private static String getDetailsByCategory(java.lang.String category) {
        ip14.Ip14Server_Service service = new ip14.Ip14Server_Service();
        ip14.Ip14Server port = service.getIp14ServerPort();
        return port.getDetailsByCategory(category);
    }

    private static String getDetailsByName(java.lang.String name) {
        ip14.Ip14Server_Service service = new ip14.Ip14Server_Service();
        ip14.Ip14Server port = service.getIp14ServerPort();
        return port.getDetailsByName(name);
    }
    
}
