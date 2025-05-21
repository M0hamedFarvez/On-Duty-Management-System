import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/od_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "farvezdatabase@7337";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printBox("Welcome to OD Management System");

        while (true) {
            printMenu();
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    submitODRequest(scanner);
                    break;
                case 2:
                    viewODRequests();
                    break;
                case 3:
                    approveOrRejectRequest(scanner);
                    break;
                case 4:
                    printBox("Exiting... Goodbye!");
                    return;
                default:
                    printBox("Invalid choice. Please try again.");
            }
        }
    }

    private static void submitODRequest(Scanner scanner) {
        System.out.print("Enter your Student ID (1-60): ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter the Reason for OD: ");
        String reason = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO od_requests (student_id, student_name, reason) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setString(2, studentName);
            stmt.setString(3, reason);
            stmt.executeUpdate();
            printBox("OD Request submitted successfully!");
        } catch (SQLException e) {
            printBox("Error submitting OD request: " + e.getMessage());
        }
    }

    private static void viewODRequests() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM od_requests";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            printBox("OD Requests");
            while (rs.next()) {
                String request = String.format("ID: %d | Student ID: %d | Name: %s | Reason: %s | Status: %s",
                        rs.getInt("id"), rs.getInt("student_id"), rs.getString("student_name"),
                        rs.getString("reason"), rs.getString("status"));
                printBox(request);
            }
        } catch (SQLException e) {
            printBox("Error fetching OD requests: " + e.getMessage());
        }
    }

    private static void approveOrRejectRequest(Scanner scanner) {
        System.out.print("Enter the Request ID to update: ");
        int requestId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the new status (Approved/Rejected): ");
        String status = scanner.nextLine();

        if (!status.equalsIgnoreCase("Approved") && !status.equalsIgnoreCase("Rejected")) {
            printBox("Invalid status. Please enter 'Approved' or 'Rejected'.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE od_requests SET status = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, status);
            stmt.setInt(2, requestId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                printBox("Request updated successfully!");
            } else {
                printBox("Request ID not found.");
            }
        } catch (SQLException e) {
            printBox("Error updating request: " + e.getMessage());
        }
    }

    private static void printMenu() {
        String[] menu = {
            "1. Submit OD Request",
            "2. View OD Requests (Staff)",
            "3. Approve/Reject OD Request",
            "4. Exit"
        };
        printBox(menu);
    }

    private static void printBox(String text) {
        int width = text.length() + 4;
        printBorder(width);
        System.out.printf("* %s *%n", text);
        printBorder(width);
    }

    private static void printBox(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        int width = maxLength + 4;
        printBorder(width);
        for (String line : lines) {
            System.out.printf("* %-" + maxLength + "s *%n", line);
        }
        printBorder(width);
    }

    private static void printBorder(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
