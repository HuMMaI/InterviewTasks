package Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRails;
        do {
            System.out.println("Enter number of rails:");
            numOfRails = scanner.nextInt();

            if (numOfRails < 2) {
                System.out.println("Your number of rails <= 2. Please, try again!");
            }
        } while (numOfRails < 2);

        System.out.println("Enter message:");
        String message = scanner.next();

        System.out.println("Number of rails: " + numOfRails);
        System.out.println("Message: " + message);
        String encMessage = encryption(message, numOfRails);
        System.out.println("Enc message: " + encMessage);
        String decMessage = decryption(encMessage, numOfRails);
        System.out.println("Dec message: " + decMessage);

        System.out.println();

        numOfRails = 3;
        message = "";
        System.out.println("Number of rails: " + numOfRails);
        System.out.println("Message: " + message);
        encMessage = encryption(message, numOfRails);
        System.out.println("Enc message:" + encMessage);
        decMessage = decryption(encMessage, numOfRails);
        System.out.println("Dec message:" + decMessage);
    }

    static String encryption(String message, int numOfRails) {
        if (message.isEmpty()) {
            return "";
        }

        String encMessage = "";

        for (int i = 0; i < numOfRails; i++) {
            int index = i;
            boolean moveDown = true;

            while (index < message.length()) {
                encMessage += message.charAt(index);

                if (i == 0 || i == numOfRails - 1) {
                    index = index + 2 * (numOfRails - 1);
                } else if (moveDown) {
                    index = index + 2 * (numOfRails - i - 1);
                    moveDown = false;
                } else {
                    index = index + 2 * i;
                    moveDown = true;
                }
            }
        }

        return encMessage;
    }

    static String decryption(String message, int numOfRails) {
        if (message.isEmpty()) {
            return "";
        }

        char[] decMessage = new char[message.length()];
        int n = 0;

        for (int i = 0; i < numOfRails; i++) {
            int index = i;
            boolean moveDown = true;

            while (index < message.length()) {
                decMessage[index] = message.charAt(n++);

                if (i == 0 || i == numOfRails - 1) {
                    index = index + 2 * (numOfRails - 1);
                } else if (moveDown) {
                    index = index + 2 * (numOfRails - i - 1);
                    moveDown = false;
                } else {
                    index = index + 2 * i;
                    moveDown = true;
                }
            }
        }

        return new String(decMessage);
    }
}
