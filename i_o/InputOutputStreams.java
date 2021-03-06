package i_o;

import java.io.*;
import java.util.Scanner;

class InputOutputStreams {
    static void inputStream() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        // Initialization
        InputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        InputStream fileInputStream1 = null;
        InputStream fileInputStream2 = null;
        try {
            fileInputStream1 = new FileInputStream("i_o/TextFile1.txt");
            fileInputStream2 = new FileInputStream("i_o/TextFile2.txt");

            // Information about sizes
            System.out.println("Input size: " + byteArrayInputStream.available());
            System.out.println("File1 size: " + fileInputStream1.available());
            System.out.println("File2 size: " + fileInputStream2.available());
            System.out.println("Input and files size: "
                    + (byteArrayInputStream.available() + fileInputStream1.available() + fileInputStream2.available()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print data from all streams
        printInputStream(byteArrayInputStream);
        printInputStream(fileInputStream1);
        printInputStream(fileInputStream2);

        // Closing all streams
        try {
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (fileInputStream1 != null) {
                fileInputStream1.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printInputStream(InputStream inputStream) {
        int i;
        try {
            while ((i = inputStream.read()) != -1) {
                System.out.print(((char) i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void outputStream() {
        Scanner scanner = new Scanner(System.in);
        String output1 = scanner.nextLine();
        String output2 = scanner.nextLine();
        scanner.close();

        // Initialization
        File file1 = new File("i_o/TextFile1.txt");
        File file2 = new File("i_o/TextFile2.txt");

        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        try {
            // Rewriting
            writeToFile(output1, file1);
            writeToFile(output2, file2);

            // Closing all streams
            if (outputStream1 != null) {
                outputStream1.close();
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String output1, File file1) throws IOException {
        OutputStream outputStream1;
        if (file1.canWrite()) {
            outputStream1 = new FileOutputStream(file1);
            outputStream1.write(output1.getBytes());
            System.out.println("FILE " + file1.getName() + " HAS BEEN SUCCESSFULLY OVERWRITTEN!");
        } else {
            System.out.println("CANNOT WRITE IN FILE " + file1.getName() + "!");
        }
    }
}