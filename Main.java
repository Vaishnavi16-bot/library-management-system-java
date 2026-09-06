import java.util.Scanner;

class Library {

    int bookId;
    String bookName;
    String authorName;
    String category;
    int totalCopies;
    int availableCopies;

    int studentId;
    String studentName;

    Scanner sc = new Scanner(System.in);

    void viewMenu() {
        System.out.println("1. AddBook");
        System.out.println("2. ViewBook");
        System.out.println("3. SearchBook");
        System.out.println("4. IssueBook");
        System.out.println("5. ReturnBook");
        System.out.println("6. DeleteBook");
        System.out.println("7. LibraryReport");
        System.out.println("8. Exit");
    }

    void addBook() {

        System.out.print("Enter BookId: ");
        bookId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter BookName: ");
        bookName = sc.nextLine();

        System.out.print("Enter AuthorName: ");
        authorName = sc.nextLine();

        System.out.print("Enter Category: ");
        category = sc.nextLine();

        System.out.print("Enter TotalCopies: ");
        totalCopies = sc.nextInt();

        availableCopies = totalCopies;

        System.out.println("Book Added");
    }

    void viewBook() {

        if (bookId == 0) {
            System.out.println("No Book Found");
            return;
        }

        System.out.println("BookId: " + bookId);
        System.out.println("BookName: " + bookName);
        System.out.println("AuthorName: " + authorName);
        System.out.println("Category: " + category);
        System.out.println("TotalCopies: " + totalCopies);
        System.out.println("AvailableCopies: " + availableCopies);
    }

    void searchBook() {

        System.out.print("Enter SearchBookId: ");
        int searchId = sc.nextInt();

        if (bookId == searchId) {

            System.out.println("Book Found");
            System.out.println("BookId: " + bookId);
            System.out.println("BookName: " + bookName);
            System.out.println("AuthorName: " + authorName);
            System.out.println("Category: " + category);
            System.out.println("TotalCopies: " + totalCopies);
            System.out.println("AvailableCopies: " + availableCopies);

        }
        else {
            System.out.println("BookNotFound");
        }
    }

    void issueBook() {

        if (bookId == 0) {
            System.out.println("No Book Found");
            return;
        }

        if (availableCopies == 0) {
            System.out.println("BookNotAvailable");
            return;
        }

        System.out.print("Enter StudentId: ");
        studentId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter StudentName: ");
        studentName = sc.nextLine();

        availableCopies--;

        System.out.println("Book Issued");
        System.out.println("StudentId: " + studentId);
        System.out.println("StudentName: " + studentName);
        System.out.println("AvailableCopies: " + availableCopies);
    }

    void returnBook() {

        if (bookId == 0) {
            System.out.println("No Book Found");
            return;
        }

        if (availableCopies == totalCopies) {
            System.out.println("All Books Are Already In Library");
            return;
        }

        System.out.print("Enter StudentId: ");
        int returnStudentId = sc.nextInt();

        if (returnStudentId == studentId) {

            availableCopies++;

            studentId = 0;
            studentName = "";

            System.out.println("Book Returned");
            System.out.println("AvailableCopies: " + availableCopies);
        }
        else {
            System.out.println("StudentNotFound");
        }
    }

    void deleteBook() {

        System.out.print("Enter BookId: ");
        int deleteId = sc.nextInt();

        if (bookId == deleteId) {

            bookId = 0;
            bookName = "";
            authorName = "";
            category = "";
            totalCopies = 0;
            availableCopies = 0;
            studentId = 0;
            studentName = "";

            System.out.println("Book Deleted");
        }
        else {
            System.out.println("BookNotFound");
        }
    }

    void libraryReport() {

        if (bookId == 0) {
            System.out.println("No Books In Library");
            return;
        }

        int issuedCopies = totalCopies - availableCopies;

        System.out.println("Library Report");
        System.out.println("BookId: " + bookId);
        System.out.println("BookName: " + bookName);
        System.out.println("TotalCopies: " + totalCopies);
        System.out.println("AvailableCopies: " + availableCopies);
        System.out.println("IssuedCopies: " + issuedCopies);

        if (studentId != 0) {
            System.out.println("StudentId: " + studentId);
            System.out.println("StudentName: " + studentName);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();

        int choice;

        do {

            lib.viewMenu();

            System.out.print("Enter Choice: ");
            choice = lib.sc.nextInt();

            switch (choice) {

                case 1:
                    lib.addBook();
                    break;

                case 2:
                    lib.viewBook();
                    break;

                case 3:
                    lib.searchBook();
                    break;

                case 4:
                    lib.issueBook();
                    break;

                case 5:
                    lib.returnBook();
                    break;

                case 6:
                    lib.deleteBook();
                    break;

                case 7:
                    lib.libraryReport();
                    break;

                case 8:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);
    }
}