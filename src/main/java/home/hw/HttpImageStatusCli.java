package home.hw;

import home.hw.service.ResourceNotFoundException;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        int code = requestCode();
        if (code == -1) return;

        try {
            new HttpStatusChecker().getStatusImage(code);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return;
        }
        new HttpStatusImageDownloader().downloadStatusImage(code);
    }

    private int requestCode() {
        Scanner scanner = new Scanner(System.in);

        String stringCode = "";
        int code = -1;

        boolean isInt = false;

        do {
            System.out.print("Enter HTTP status code: ");
            stringCode = scanner.nextLine();

            if (stringCode.toLowerCase().equals("exit")) return code;

            try {
                code = Integer.parseInt(stringCode);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
            }
        } while (!isInt);

        return code;
    }

    public static void main(String[] args) {
        new HttpImageStatusCli().askStatus();
    }
}
