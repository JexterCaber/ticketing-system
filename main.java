import java.util.Locale;
import java.util.Scanner;
/*
    Accept: Name, Age, Number of Passenger, Travel Type, Travel Destination.
 */
public class Main {

    /*
        Private, Cap of 20, With 2 pilots 4 stewardess
        Business, Cap of 30, with 2 pilots 1 assistant pilot 4 stewardess
        Regular, Cap of 100, with 2 pilots 2 assistant pilots 8 stewardess and 40 reserved/taken seats
    */

    //Checks for Space in Airplane
    static boolean CheckSpace(boolean pbool, boolean bbool, boolean rbool, int pCurrentSpace, int bCurrentSpace, int rCurrentSpace) {

        if (pbool){
            if (pCurrentSpace > 20){
                System.out.println("There is no more space.");
                return false;
            } else {
                System.out.println("There is space.");
                return true;
            }
        } else if (bbool) {
            if (bCurrentSpace > 30) {
                System.out.println("There is no more space.");
                return false;
            } else {
                System.out.println("There is space.");
                return true;
            }
        } else if (rbool) {
            if (rCurrentSpace > 100) {
                System.out.println("There is no more space.");
                return false;
            } else {
                System.out.println("There is space.");
                return true;
            }
        } else {
            System.out.println("Invalid Input.");
            return false;
        }
    }

    //Get Airplane Type
    static int GetAirplaneType(){
        Scanner s = new Scanner(System.in);
        String Atype;

        System.out.println("Please pick an airplane type: ");
        System.out.println("Private, Business, Regular.");
        Atype = s.nextLine();
        Atype = Atype.toLowerCase(Locale.ROOT);

        switch (Atype) {
            case "p" -> {
                System.out.println("Airplane Type is Private.");
                return 1;
            }
            case "b" -> {
                System.out.println("Airplane Type is Business.");
                return 2;
            }
            case "r" -> {
                System.out.println("Airplane Type is Regular");
                return 3;
            }
            default -> {
                System.out.println("Invalid Input");
                return 4;
            }
        }
    }

    //Get Passenger Name
    static String GetName() {
        String name;
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        return name;
    }

    public static void main(String[] args) {

        int pCurrentSpace = 6, bCurrentSpace = 7, rCurrentSpace = 52;
        boolean Space;
        boolean pbool = false, bbool = false, rbool = false;
        Scanner s = new Scanner(System.in);

        String[] Pnames = new String[14];
        String[] Bnames = new String[23];
        String[] Rnames = new String[48];

        do {
            // Gets Airplane Type
            int AtypeConfirmed = GetAirplaneType();

            if (AtypeConfirmed == 1) {
                pbool = true;
            } else if (AtypeConfirmed == 2) {
                bbool = true;
            } else if (AtypeConfirmed == 3) {
                rbool = true;
            } else {
                System.out.println("Invalid Input.");
            }

            // Check if Airplane has Space
            Space = CheckSpace(pbool, bbool, rbool, pCurrentSpace, bCurrentSpace, rCurrentSpace);
        }while (!Space);

        //Input number of Passengers
        int numPassenger;

        System.out.println("Input number of passengers: ");
        numPassenger = s.nextInt();

        if (pbool) {
            pCurrentSpace = pCurrentSpace + numPassenger;
            if (pCurrentSpace > 20) {
                System.out.println("Sorry! You have exceeded the number of passengers required.");
                pCurrentSpace = pCurrentSpace - numPassenger;
            } else {
                while(numPassenger>0) {
                    for(int i = 0; i<numPassenger; i++) {
                        //WORK IN PROGRESS
                    }
                }
            }
        } else if (bbool) {
            bCurrentSpace = bCurrentSpace + numPassenger;
            if (bCurrentSpace > 30) {
                System.out.println("Sorry! You have exceeded the number of passengers required.");
                bCurrentSpace = bCurrentSpace - numPassenger;
            }
        } else if (rbool) {
            rCurrentSpace = rCurrentSpace + numPassenger;
            if (rCurrentSpace > 100) {
                System.out.println("Sorry! You have exceeded the number of passengers required.");
                rCurrentSpace = rCurrentSpace - numPassenger;
            }
        }
    }
}
