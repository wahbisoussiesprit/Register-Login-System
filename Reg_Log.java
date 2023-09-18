import java.util.Scanner;

public class Reg_Log {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        boolean loggedIn = false;
        boolean passwordRecoveryMode = false;
        int loginAttempts = 0;
        String name = "";
        String address = "";
        String pn = "" ;
        String email = "";
        String pass = "";

        while (!loggedIn) {
            System.out.println("+*+*+*+*+* REGISTRATION/LOGIN SYSTEM (using Java) +*+*+*+*+*");

            System.out.println("Choose an option:");
            System.out.println("1) Registration");
            System.out.println("2) Login");
            System.out.println("3) Exit");

            int option = read.nextInt();
            read.nextLine();

            switch (option) {

                case 1:
                // Registration
                System.out.println("- Registration -");
                
                System.out.print("Enter Your Name: ");
                name = read.nextLine();
    
                System.out.print("Enter Your Address: ");
                address = read.nextLine();
    
                System.out.print("Enter Your Phone Number: ");
                pn = read.nextLine();
    
                System.out.print("Enter Your Email: ");
                email = read.nextLine(); // Assign value to the email variable
    
                System.out.print("Enter Your Password: ");
                pass = read.nextLine(); // Assign value to the password variable
                System.out.println("Registration Was Successful.");

    break;
                    
    case 2:
    // Login
    System.out.println("*** Login ***");
    System.out.print("Enter Your Email: ");
    String enteredEmail = read.nextLine();

    System.out.print("Enter Your Password: ");
    String enteredPass = read.nextLine();

    if (enteredEmail.equals(email) && enteredPass.equals(pass)) {
        System.out.printf("Welcome To Your Profile %s\n", name);
        System.out.println("-----------------------------------");
        System.out.println("Here Is Your Profiles Details : ");
        System.out.println("-----------------------------------");
        System.out.printf("Name : %s\n", name);
        System.out.printf("Address : %s\n", address);
        System.out.printf("Phone Number : %s\n", pn);
        System.out.printf("Email : %s\n", email);
        System.out.printf("Password : %s\n", pass);

        loggedIn = true;

        System.out.println("Do You Want TO Make Some Changes In Your Profile ? ");
        System.out.println("1) Yes");
        System.out.println("2) No");

        int editChoice = read.nextInt() ;
        read.nextLine();


               if(editChoice == 1) 
               {
                while(true)
                        {
                            System.out.println("Make The Changes Please :");
                            System.out.println("1) Change Name");
                            System.out.println("2) Change Address");
                            System.out.println("3) Change Phone Number");
                            System.out.println("4) Change Email");
                            System.out.println("5) Change Password");
                            System.out.println("6) Delete Your Profile");
                            System.out.println("7) Exit, After The Changes .");

                            int editOption = read.nextInt();
                            read.nextLine();

                            switch (editOption) {

                                case 1:
                                System.out.print("Enter The New Name: ");
                                name = read.nextLine();
                                break;

                            case 2:
                                System.out.print("Enter New Address: ");
                                address = read.nextLine();
                                break;

                            case 3:
                                System.out.print("Enter New Phone Number: ");
                                pn = read.nextLine();
                                break;

                            case 4:
                                System.out.print("Enter New Email: ");
                                email = read.nextLine();
                                break;

                            case 5:
                                System.out.print("Enter New Password: ");
                                pass = read.nextLine();
                                break;
                            
                            case 6:
                            
                            System.out.println("Profile Deletion Page :\n") ;
                            System.out.println("To Delete Your Profile, Please Confirm Your Profile Here :\n");

                            String confirmPassword = read.nextLine() ;

                            if(confirmPassword.equals(pass))
                            {
                                System.out.println("Are you sure you want to delete your profile?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int deleteChoice = read.nextInt();
                                read.nextLine();

                                if(deleteChoice == 1)
                                    {
                                        System.out.println("Profile Deleted ! \n");
                                        System.exit(0);
                                    }
                                else if (deleteChoice == 2)
                                {
                                    System.out.println("Profile Deletion Canceled \n") ;
                                    System.exit(0);
                                }
                                else
                                {
                                    System.out.println("Invalid option. Please try again.");
                                }
                            }
                            else
                            {
                                System.out.println("Wrong Password. Deletion Canceled \n");   
                            }
                                break;

                            case 7:
                                System.exit(0);
                                break;

                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        

                            }

                        }
               }
                   
    } else {
        loginAttempts++;
        if (loginAttempts >= 3) {
            System.out.println("Wrong Email Or Password! Would you like to recover your password?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int recoveryChoice = read.nextInt();
            read.nextLine();

            if (recoveryChoice == 1) {
                passwordRecoveryMode = true;
            } else {
                System.out.println("Try Again Later.");
                loginAttempts = 0;
            }
        } else {
            System.out.println("Wrong Email Or Password!");
            System.out.println("Try Again.");
        }
    }
    break;
                case 3:
                    System.out.println("Exiting...");
                    loggedIn = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            // Password Recovery
            while (passwordRecoveryMode) {
                System.out.println("Choose password recovery option:");
                System.out.println("1) Recovery through Phone");
                System.out.println("2) Recovery through Email");
                System.out.println("3) Connect to Another Account");

                int recoveryOption = read.nextInt();
                read.nextLine();

                switch (recoveryOption) {
                    case 1:
                        System.out.print("Enter Your Phone Number : ");
                        String recoveryPhone = read.nextLine();
                        System.out.println("Verification code sent to " + recoveryPhone);
                        break;
                    case 2:
                        System.out.print("Enter Your Email : ");
                        String recoveryEmail = read.nextLine();
                        System.out.println("Password reset link sent to " + recoveryEmail);
                        break;
                    case 3:
                        passwordRecoveryMode = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        read.close();
    }
}
