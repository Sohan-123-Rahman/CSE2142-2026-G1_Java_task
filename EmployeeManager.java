
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Helper method to read employee data from file
    public static String readEmployeeData() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.FILE_NAME)));
        return reader.readLine();
    }

    // Helper method to write employee data to file
    public static void writeEmployeeData(String data, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.FILE_NAME, append));
        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {
        // Task #2: Check if arguments are passed correctly
        if (args.length == 0) {
            System.out.println("Error: No arguments provided! Please pass valid arguments.");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                for (String emp : readEmployeeData().split(",")) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String line = readEmployeeData();
                System.out.println(line);
                String employees[] = line.split(",");
                System.out.println(employees[new Random().nextInt(employees.length)]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                writeEmployeeData(", " + args[0].substring(1), true);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String searchTarget = args[0].substring(1);
                for (String emp : readEmployeeData().split(",")) {
                    if (emp.equals(searchTarget)) {
                        System.out.println("Employee found!");
                        break; // Task #7: Control flow without extra boolean flags
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                char[] chars = readEmployeeData().toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployeeData().split(",");
                String target = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(target)) {
                        employees[i] = "Updated";
                    }
                }
                writeEmployeeData(String.join(",", employees), false);
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                List<String> list = new ArrayList<>(Arrays.asList(readEmployeeData().split(",")));
                list.remove(args[0].substring(1));
                writeEmployeeData(String.join(",", list), false);
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}