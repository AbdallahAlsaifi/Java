import java.io.*;
import java.util.*;

class io {
    static String filename = "test4.txt";
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
                delete();
                break;
            case 4:
                update();
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
}

//function to delete a student from txt file by id
public static void delete(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter the student id: ");
    String id = sc.nextLine();
    try {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String newFile = "";
        while(line != null) {
            String[] arr = line.split(",");
            if(!arr[0].equals(id)) {
                newFile += line + "\n";
            }
            line = br.readLine();
        }
        br.close();
        fr.close();
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(newFile);
        bw.close();
        fw.close();
    } catch(IOException e) {
        System.out.println("Error: " + e);
    }
    System.out.println("## this is the new list after deleting the student of id #"+id);
    display();
menu();


}

//function to update a student from txt file by id
public static void update(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter the student id: ");
    String id = sc.nextLine();
    System.out.println("\n");
    System.out.println("#########################");
    System.out.println("$ Choose what to update #");
    System.out.println("1. id                   #");
    System.out.println("2. name                 #");
    System.out.println("3. gpa                  #");
    System.out.println("4. birth date           #");
    System.out.println("5. gender               #");
    System.out.println("0. Back                 #");
    System.out.println("#########################");
    System.out.println("\n");
    String Choice = sc.nextLine();

    try {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        String line = raf.readLine();
        while(line != null) {
            String[] arr = line.split(",");
            if(arr[0].equals(id)) {
                switch(Choice) {
                    case "1":
                        System.out.print("Please enter the new id: ");
                        String newId = sc.nextLine();
                        raf.seek(raf.getFilePointer() - line.length() -1);
                        raf.writeBytes(newId);
                        System.out.println("## this is the list of the students after updating##");
                        display();
                        menu();
                        break;
                    case "2":
                        System.out.print("Please enter the new name: ");
                        String newName = sc.nextLine();
                        raf.seek(raf.getFilePointer() - line.length() +4);
                        raf.writeBytes(newName+"       ");
                        System.out.println("## this is the list of the students after updating##");
                        display();
                        menu();
                        break;
                    case "3":
                        System.out.print("Please enter the new gpa: ");
                        String newGpa = sc.nextLine();
                        raf.seek(raf.getFilePointer() - line.length() +35);
                        raf.writeBytes(newGpa);
                        System.out.println("## this is the list of the students after updating##");
                        display();
                        menu();
                        break;
                    case "4":
                        System.out.print("Please enter the new birth date: ");
                        String newBirthdate = sc.nextLine();
                        raf.seek(raf.getFilePointer()- line.length() +40);
                        raf.writeBytes(newBirthdate );
                        System.out.println("## this is the list of the students after updating##");
                        display();
                        menu();
                        break;
                    case "5":
                        System.out.print("Please enter the new gender: ");
                        String newGender = sc.nextLine();
                        raf.seek(raf.getFilePointer()- line.length() +51);
                        raf.writeBytes(newGender );
                        System.out.println("## this is the list of the students after updating##");
                        display();
                        menu();
                        break;
                    case "0":
                        System.out.println("Back");
                        menu();
                        break;
                    
                } 
            }
            raf.close();
        
    
}}catch(IOException e) {
    System.out.println("Error: " + e);
}}}