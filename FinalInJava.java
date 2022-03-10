import java.nio.file.*;
import java.io.*;
import java.io.File;
import static java.nio.file. StandardOpenOption.*;
import java.util.Scanner;
import java.io.IOException;
public class FinalInJava {
    public static void main(String[] args) throws IOException {
        int i;
        int count = 1;
        String Number = "O";
        final String QUIT = "3";
        Scanner s = new Scanner(System.in);
        System.out.println("WELCOME TO LOCKEME.COM");
        System.out.println("Devloped by:-..Akram Raja");
        for (i = 1; i < 10; i++) {
            System.out.println("\nPlease Enter The Number For Your Choice-");
            System.out.println("1. -FILE LIST\n2. -BUSSINESS OPERATION\n3. -CLOSE THE APPLICATION");
            Number = s.nextLine();
            while (Number.equals(QUIT) == false) {
                if (Number.equals("1")) {
                    System.out.println("List of files in LOCKEME.COM:-");
                    File f = new File("E:\\LOCKEME.COM\\");
                    String[] s1 = f.list();
                    for (String s2 : s1) {
                        File f1 = new File(f, s2);
                        if (f1.isFile()) {
                            System.out.println(s2);
                            count++;
                        }
                    }
                    System.out.println("...............................................");
                    System.out.println("\nPlease Enter The Number For Your Choice-");
                    System.out.println("1. -FILE LIST\n2. -BUSSINESS OPERATION\n3. -CLOSE THE APPLICATION");
                }
                if (Number.equals("2")) {
                    System.out.println("For Bussiness Operation:-\nPlease Enter The Number For Your Choice:" +
                            "\n4 - CREATE FILE\n5 - DELETE FILE\n6 - SEARCH FILE");
                }
                Number = s.nextLine();
                if (Number.equals("4")) {
                    //CREATE
                    System.out.println("For Creating a file:-\nPlease enter name of file:");
                    String Name = s.nextLine();
                    Path p1 = Paths.get("E:\\LOCKEME.COM\\" + Name);
                    try {
                        OutputStream o = new BufferedOutputStream(Files.newOutputStream(p1, CREATE));
                        o.flush();
                        o.close();
                        System.out.println("The file " + Name + " was successfully created.");
                        System.out.println("......................................................");
                        System.out.println("\nPlease Enter The Number For Your Choice-");
                        System.out.println("1. -FILE LIST\n2. -BUSSINESS OPERATION" +
                                "\n3. -CLOSE THE APPLICATION");
                    } catch (Exception e) {
                        System.out.println("Problem/s encountered while creating the file.");
                    }
                }//End of CREATE
                else if (Number.equals("5")) {
                    //DELETE
                    String Delete;
                    System.out.println("for Deleting a file:-\nPlease enter file name has to be delete:");
                    Delete = s.nextLine();
                    Path p2 = Paths.get("E:\\LOCKEME.COM\\" + Delete);
                    try {
                        Files.delete(p2);
                        System.out.println("The file " +Delete + " has been deleted.");
                        System.out.println("..................................................................");
                        System.out.println("Please Enter The Number For Your Choice-");
                        System.out.println("1. -FILE LIST\n2. -BUSSINESS OPERATION" +
                                "\n3. -CLOSE THE APPLICATION");
                    } catch (NoSuchFileException e) {
                        System.out.println("The file does not exist.");
                        System.out.println("\nPlease Enter The Number For Your Choice-");
                        System.out.println("1. -FILE LIST\n2. -BUSSINESS OPERATION" +
                                "\n3. -CLOSE THE APPLICATION");
                    } catch (SecurityException e) {
                        System.out.println("You do not have the permission to delete this file.");
                    } catch (DirectoryNotEmptyException e) {
                        System.out.println("Directory is not empty.");
                    } catch (IOException e) {
                        System.out.println("IO Exception.");
                    }
                }//END of DELETE
                else if (Number.equals("6")) {
                    //START PROGRAMME FOR SEARCH
                    String Search;
                    System.out.println("For Searching any file:-\nPlease enter name of file has to be search:");
                    Search = s.nextLine();
                    Path p3 = Paths.get("E:\\LOCKEME.COM\\" + Search);
                    if (Files.exists(p3)) {
                        System.out.println("This file is exist in LOCKME.COM.");
                    } else {
                        System.out.println("This file is not exist in LOCKME.COM");
                    }
                    System.out.println("..............................................................");
                    System.out.println("\nPlease Enter The Number For Your Choice-");
                    System.out.println("1. -FILE LIST\n2. -BUSSINESS OPERATION" +
                            "\n3. -CLOSE THE APPLICATION");
                }
                }
            s.close();
            System.out.println("You choose exit option So, Applictaion has been closed.");
            System.exit(0);
        }
    }
}