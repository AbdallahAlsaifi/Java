import java.io.*;
import java.util.*;

class io {
    static String filename = "students.txt";
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        boolean isExit = false;
        while(!isExit) {
        System.out.println("\n");
        System.out.println("##########################");
        System.out.println("1. Display all students  #");
        System.out.println("2. Add a new student     #");
        System.out.println("3. Delete a student      #");
        System.out.println("4. Update a student      #");
        System.out.println("5. Search a student      #");
        System.out.println("0. Exit                  #");
        System.out.println("##########################");
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch(x){
            case 1:
                display();
                break;
            case 2:
                add();
                break;
            case 3:
                System.out.println("Delete a student");
                break;
            case 4:
                System.out.println("Update a student");
                break;
            case 5:
                System.out.println("Search a student");
                break;
            case 0:
                System.out.println("Exit");
                isExit = true;
                break;
        }
        break;

    }
    
}
//function to display all lines from txt file
public static void display() {

    try {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
        fr.close();
    } catch(IOException e) {
        System.out.println("Error: " + e);
    }
    System.out.println("\n");
    menu();

}

//function to add a new student to txt file
public static void add(){
    Scanner sc = new Scanner(System.in);
        String id = null, name = "", gpa = null, birthdate = null, gender = null;
        System.out.print("Please enter the student id: ");
        id = sc.nextLine();
        System.out.print("Please enter the student name: ");
        name = sc.nextLine();
        System.out.print("Please enter the student gpa: ");
        gpa = sc.nextLine();
        System.out.print("Please enter the student birthdate: ");
        birthdate = sc.nextLine();
        System.out.print("Please enter the student gender: ");
        gender = sc.nextLine();
    try {
        
        FileWriter fw = new FileWriter(filename, true);
        BufferedWriter bw = new BufferedWriter(fw);
        int totalSpaceLength = 30 - name.length();
        String space = "";
        for(int i = 0; i<=totalSpaceLength -1; i++) {
            space += " ";
        }
        bw.write(id + "," + name + space + "," + gpa + "," + birthdate + "," + gender+"\n");
        bw.close();
        fw.close();
        
}catch(IOException e) {
    System.out.println("Error: " + e);
}

System.out.println("## this is the new list after adding the student #"+name);
display();
menu();
}}