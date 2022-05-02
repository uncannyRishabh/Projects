import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int sid;
        String sname;
        int sage;
        String saddress;
        boolean loggedIn = false;

        DBUtils utils = new DBUtils();
        System.out.println("--------------STUDENT MANAGEMENT SYSTEM--------------");
        while (true) {
            System.out.println("\n0: Login ");
            System.out.println("1: Signup ");
            System.out.println("2: Add Student ");
            System.out.println("3: Update Student ");
            System.out.println("4: Delete Student");
            System.out.println("5: Get Student by id");
            System.out.println("6: Get Student by name");
            System.out.println("7: Get all Student");
            System.out.println("8: Logout");
            System.out.println("9: Quit");

            int choice = sc.nextInt();
            switch (choice){
                case 0:{
                    if(loggedIn) {
                        System.out.println("Already logged in.");
                        break;
                    }
                    System.out.print("Enter UserName : ");
                    sc.nextLine();
                    String userName = sc.nextLine();
                    System.out.print("Enter Password : ");
                    String password = sc.nextLine();

                    Authenticator auth = new Authenticator(userName, password);
                    loggedIn = auth.logInUser();
                    break;
                }
                case 1:{
                    System.out.print("Enter UserName : ");
                    sc.nextLine();
                    String userName = sc.nextLine();
                    System.out.print("Enter Password : ");
                    String password = sc.nextLine();

                    Authenticator auth = new Authenticator(userName, password);
                    loggedIn = auth.addUser();
                    break;
                }
                case 2: {
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    try {
                        System.out.println("Enter ID:");
                        sid = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Name: ");
                        sname = sc.nextLine();
                        System.out.println("Enter Age:");
                        sage = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Address: ");
                        saddress = sc.nextLine();
                        utils.addStudent(sid, sage, sname, saddress);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    System.out.println("Enter the student ID to update:");
                    sid=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name");
                    sname=sc.nextLine();
                    System.out.println("Enter age");
                    sage=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter address");
                    saddress=sc.nextLine();
                    utils.updateStudent(sid, sname, sage, saddress);
                    break;
                }
                case 4: {
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    System.out.println("Enter the Student Id to be deleted:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    utils.deleteStudent(id);
                    break;
                }
                case 5:{
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    System.out.println("Enter ID to search : ");
                    sid=sc.nextInt();
                    utils.getStudentById(sid);
                    break;
                }
                case 6:{
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    System.out.println("Enter Name");
                    sc.nextLine();
                    sname = sc.nextLine();
                    utils.getStudentByName(sname);
                    break;
                }
                case 7: {
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    utils.getAllStudents();
                    break;
                }
                case 8: {
                    if(!loggedIn){
                        System.out.println("LOGIN TO CONTINUE");
                        break;
                    }
                    loggedIn = false;
                    System.out.println("LOGGED OUT");
                    break;
                }
                case 9: {
                    loggedIn = false;
                    sc.close();
                    System.out.println("EXITING...");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("wrong choice please enter valid no");
                    break;
                }
            }
        }
    }



}


