import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {

    public static Long generateRandomUserId(int numCharacters) {
        Random random = new Random();
        long min = (long) Math.pow(10, numCharacters - 1);
        long max = (long) Math.pow(10, numCharacters) - 1;
        return min + (long) (random.nextDouble() * (max - min + 1));
    }

    public static Long generateRandomCatalogNumber(int numCharacters) {
        Random random = new Random();
        long min = (long) Math.pow(10, numCharacters - 1);
        long max = (long) Math.pow(10, numCharacters) - 1;
        return min + (long) (random.nextDouble() * (max - min + 1));
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();
        Scanner scanner_d = new Scanner(System.in);
        Scanner scanner_l = new Scanner(System.in);

        System.out.println("Welcome to the library system");
        boolean exit = false;
        while (!exit) {
            try {

                System.out.println("=======================");
                System.out.println("==  Main Menu        ==");
                System.out.println("=======================");
                System.out.println(" 1 ⮞ User matters");
                System.out.println(" 2 ⮞ Book matters");
                System.out.println(" 3 ⮞ Loan matters");
                System.out.println(" 0 ⮞ Quit");

                int escolha = scanner_d.nextInt();
                boolean exitSub = false;
                switch (escolha) {
                    case 1:
                        while (!exitSub) {
                            try {
                                System.out.println(" ⮞ User matters");
                                System.out.println(" 1. Register user");
                                System.out.println(" 2. Search user");
                                System.out.println(" 3. List users");
                                System.out.println(" 4. Delete users");
                                System.out.println(" 0. Quit");

                                int subChoice = scanner_d.nextInt();

                                switch (subChoice) {
                                    case 1:
                                        System.out.println("Service selected: 1 - Register user");
                                        System.out.println("Insert the information about the user");

                                        System.out.println("The name: ");
                                        String name = scanner_l.nextLine();

                                        System.out.println("The publicPlace: ");
                                        String publicPlace = scanner_l.nextLine();

                                        System.out.println("The neighbourhood: ");
                                        String neighbourhood = scanner_l.nextLine();

                                        System.out.println("The city: ");
                                        String city = scanner_l.nextLine();

                                        System.out.println("The state: ");
                                        String state = scanner_l.nextLine();

                                        System.out.println("The zip code: ");
                                        String zipCode = scanner_l.nextLine();

                                        System.out.println("The individual registry: ");
                                        long individualRegistry = scanner_d.nextLong();

                                        System.out.println("The identity card: ");
                                        long identityCard = scanner_d.nextLong();

                                        System.out.println("The phone: ");
                                        String phone = scanner_l.nextLine();

                                        System.out.println("The email: ");
                                        String email = scanner_l.nextLine();

                                        System.out.println("The user register date: ");
                                        String userRegisterDate = scanner_l.nextLine();

                                        System.out.println("The birthday date: ");
                                        String birthdayDate = scanner_l.nextLine();

                                        User newUser = new User(
                                                generateRandomUserId(5),
                                                name,
                                                publicPlace,
                                                neighbourhood,
                                                city,
                                                state,
                                                zipCode,
                                                individualRegistry,
                                                identityCard,
                                                phone,
                                                email,
                                                userRegisterDate,
                                                birthdayDate
                                        );
                                        users.add(newUser);

                                        System.out.println("User registered successfully!");
                                        System.out.println();
                                        break;

                                    case 2:
                                        System.out.println("Service selected: 2 - Search user");
                                        System.out.println("Enter the name of the user, watch out to misspells");
                                        name = scanner_l.nextLine().toLowerCase();
                                        boolean userFound = false;
                                        for (User user : users) {
                                            if (name.equals(user.getName().toLowerCase())) {
                                                System.out.println();
                                                System.out.println(STR."ID: \{user.getId()}");
                                                System.out.println(STR."Email: \{user.getEmail()}");
                                                System.out.println(STR."Phone number: \{user.getPhone()}");
                                                System.out.println();
                                                userFound = true;
                                            }
                                        }
                                        if (!userFound) {
                                            System.out.println("This user is not registered.");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Service selected: 3 - List users");

                                        if (users.isEmpty()) {
                                            System.out.println("Sorry! There are no users registered.");
                                        } else {
                                            for (User user : users) {
                                                System.out.println();
                                                System.out.println(STR."User e-mail: \{user.getEmail()}");
                                                System.out.println(STR."Register date: \{user.getUserRegisterDate()}");
                                                System.out.println(STR."Phone number: \{user.getPhone()}");
                                                System.out.println(STR."Name: \{user.getName()}");
                                            }
                                        }
                                        break;

                                    case 4:
                                        System.out.println("Service selected: 4 - Delete user");
                                        System.out.println(STR."Current number of users registered: \{users.size()}");

                                        if (users.isEmpty()) {
                                            System.out.println("No users to be deleted");
                                        } else {
                                            System.out.println("Enter the Id of the user to delete: ");
                                            Long id = scanner_d.nextLong();
                                            boolean userFoundById = false;
                                            for (User user : users) {
                                                if (id.equals(user.getId())) {
                                                    System.out.println();
                                                    System.out.println(STR."User ID: \{user.getId()}");
                                                    System.out.println(STR."Name:  \{ user.getName()}");
                                                    System.out.println(STR."Register date: \{user.getUserRegisterDate()}");
                                                    System.out.println(STR."Phone number: \{user.getPhone()}");
                                                    System.out.println();

                                                    userFoundById = true;
                                                    System.out.println("Are you sure you want to delete this user? (y/n) ");
                                                    char decision = scanner_l.next().charAt(0);

                                                    if (decision == 'y' || decision == 'Y') {
                                                        users.remove(user);
                                                        System.out.println(STR."The user: \{user.getName()} was deleted from the system!");
                                                    } else {
                                                        System.out.println(STR."The user: \{user.getName()} remains in the system!");
                                                    }
                                                    break;
                                                }
                                            }
                                            if (!userFoundById) {
                                                System.out.println("This ID is not registered.");
                                            }
                                        }
                                        break;
                                    case 0:
                                        System.out.println("Back to main menu! :D");
                                        exitSub = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                }
                            }   catch (InputMismatchException e) {
                                    System.out.println("Invalid input, please try again.");
                                }

                        }
                        break;
                    case 2:
                        while (!exitSub) {
                            try {
                            System.out.println();
                            System.out.println(" ⮞ Book matters     ");
                            System.out.println(" 1. Register books  ");
                            System.out.println(" 2. Search books    ");
                            System.out.println(" 3. List books      ");
                            System.out.println(" 4. Delete books    ");
                            System.out.println(" 0. Quit            ");

                            int Sub = scanner_d.nextInt();
                            switch (Sub) {
                                case 1:
                                    System.out.println("Service selected: 1 - Register book ");

                                    System.out.println("Insert the information about the book ");

                                    System.out.println("The title: ");
                                    String title = scanner_l.nextLine();

                                    System.out.println("The author: ");
                                    String author = scanner_l.nextLine();

                                    System.out.println("The category: ");
                                    String category = scanner_l.nextLine();

                                    System.out.println("The editor: ");
                                    String editor = scanner_l.nextLine();

                                    System.out.println("The year: ");
                                    String year = scanner_l.nextLine();

                                    System.out.println("The register date: ");
                                    String registerDate = scanner_l.nextLine();

                                    System.out.println("The situation: ");
                                    System.out.println("(borrowed ; available ; not available)");
                                    String situation = scanner_l.nextLine();

                                    Book newBook = new Book(
                                            generateRandomCatalogNumber(4),
                                            title,
                                            author,
                                            category,
                                            editor,
                                            year,
                                            registerDate,
                                            situation
                                    );

                                    books.add(newBook);

                                    System.out.println("Book registered successfully!");
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("Service selected: 2 - Search book ");
                                    System.out.println("Enter the name of the book, watch out to misspells ");

                                    title = scanner_l.nextLine().toLowerCase();
                                    boolean bookFound = false;

                                    for (Book book : books) {
                                        if (title.equals(book.getTitle().toLowerCase())) {
                                            System.out.println();
                                            System.out.println("Yes, we have that book");
                                            System.out.println(STR."Catalog Number: \{book.getCatalogNumber()}");
                                            System.out.println(STR."Title: \{book.getTitle()}");
                                            System.out.println(STR."The book is \{book.getSituation()}");
                                            System.out.println();
                                            bookFound = true;
                                        }
                                    }
                                    if (!bookFound) {
                                        System.out.println("This book is not registered in the system.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Service selected: 3 - List book " + '\n' );

                                    if (books.isEmpty()) {
                                        System.out.println("Sorry! There are no books registered :( ");
                                    }
                                    for (Book book : books) {
                                        System.out.println();
                                        System.out.println(STR."Catalog Number: \{book.getCatalogNumber()}");
                                        System.out.println(STR."Title: \{book.getTitle()}");
                                        System.out.println(STR."Situation: \{book.getSituation()}");
                                    }

                                    break;
                                case 4:
                                    System.out.println("Service selected: 4 - Delete book ");
                                    System.out.println(STR."Current number of books registered: \{books.size()}");
                                    boolean exitDel = false;
                                    if (books.isEmpty()) {
                                        System.out.println("No books to be deleted");
                                    }
                                    else {
                                        do {
                                            try {
                                                System.out.println(" ===== Main Menu =====  ");
                                                System.out.println("  1 ⮞ Select by title        ");
                                                System.out.println("  2 ⮞ Select by catalog N.   ");
                                                System.out.println("  0 ⮞ Quit                   ");

                                                int choice = scanner_d.nextInt();
                                                char decision;

                                                switch (choice) {
                                                    case 1:
                                                        System.out.println("Enter the name of the book, watch out to misspells ");
                                                        title = scanner_l.nextLine().toLowerCase();
                                                        boolean bookFoundByTitle = false;
                                                        for (Book book : books) {
                                                            if (title.equals(book.getTitle().toLowerCase())) {
                                                                System.out.println();
                                                                System.out.println(STR."Catalog Number: \{book.getCatalogNumber()}");
                                                                System.out.println(STR."Title: \{book.getTitle()}");
                                                                System.out.println(STR."The book is \{book.getSituation()}");
                                                                System.out.println();
                                                                bookFoundByTitle = true;
                                                                System.out.println("Are you sure you want to delete this book? (y/n) ");

                                                                decision = scanner_d.next().charAt(0);
                                                                if (decision == 'y' || decision == 'Y') {
                                                                    books.remove(book);
                                                                    System.out.println(STR."The book: \{book.getTitle()} was deleted from system! ");
                                                                }
                                                                else if (decision == 'n' || decision == 'N') {
                                                                    System.out.println(STR."The book: \{book.getTitle()} remains in the system! ");
                                                                } else {
                                                                    System.out.println("Invalid option...");
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        if (!bookFoundByTitle) {
                                                            System.out.println("This book is not registered in the system.");
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter the name of the book, watch out to misspells ");
                                                        boolean bookFoundByNumber = false;
                                                        Long catalogNumber = scanner_d.nextLong();
                                                        for (Book book : books) {
                                                            if (catalogNumber.equals(book.getCatalogNumber())) {
                                                                System.out.println();
                                                                System.out.println(STR."Catalog Number: \{book.getCatalogNumber()}");
                                                                System.out.println(STR."Title: \{book.getTitle()}");
                                                                System.out.println(STR."The book is \{book.getSituation()}");
                                                                System.out.println();
                                                                bookFoundByNumber = true;
                                                                System.out.println("Are you sure you want to delete this book? (y/n) ");
                                                                decision = scanner_d.next().charAt(0);
                                                                if (decision == 'y' || decision == 'Y') {
                                                                    books.remove(book);
                                                                    System.out.println(STR."The book: \{book.getCatalogNumber()} was deleted from system! ");
                                                                }
                                                                else if (decision == 'n' || decision == 'N') {
                                                                    System.out.println(STR."The book: \{book.getCatalogNumber()} remains in the system! ");
                                                                } else {
                                                                    System.out.println("Invalid option...");
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        if (!bookFoundByNumber) {
                                                            System.out.println("This catalog number is not registered in the system.");
                                                        }
                                                        break;

                                                    case 0:
                                                        System.out.println("Exiting...");
                                                        return;

                                                    default:
                                                        System.out.println("Invalid option");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("That's not an option");
                                                scanner_d.next();
                                            }
                                        } while (!exitSub);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Back to main menu! :D");
                                    exitSub = true;
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("That's not an option");
                            scanner_d.next();
                        }

                        } break;

            case 3: {
                while (!exitSub) {
                    try {
                        System.out.println();
                        System.out.println(" ⮞ Loan matters         ");
                        System.out.println(" 1. Loan book           ");
                        System.out.println(" 2. Return books        ");
                        System.out.println(" 3. List available book ");
                        System.out.println(" 4. List users in loan  ");
                        System.out.println(" 0. Quit                ");

                        int Sub = scanner_d.nextInt();
                        switch (Sub) {
                            case 1:
                                // Borrow book
                                System.out.println("Service selected: 1 - Borrow book ");
                                System.out.println("Enter user ID: ");
                                long userId = scanner_d.nextLong();

                                User user = null;
                                for (User u : users) {
                                    if (u.getId() == userId) {
                                        user = u;
                                        break;
                                    }
                                }

                                if (user == null) {
                                    System.out.println("User not found.");
                                    return;
                                }

                                System.out.println("Enter book catalog number: ");
                                long catalogNumber = scanner_d.nextLong();

                                Book book = null;
                                for (Book b : books) {
                                    if (b.getCatalogNumber() == catalogNumber) {
                                        book = b;
                                        break;
                                    }
                                }

                                if (book == null || !book.getSituation().equals("available")) {
                                    System.out.println("Book not available.");
                                    return;
                                }

                                System.out.println("Enter reservation date (YYYY-MM-DD): ");
                                String reservationDate = scanner_l.nextLine();

                                System.out.println("Enter devolution date (YYYY-MM-DD): ");
                                String devolutionDate = scanner_l.nextLine();

                                Loan loan = new Loan((loans.size() + 1), book, user, reservationDate, devolutionDate);
                                loans.add(loan);

                                book.setSituation("borrowed");

                                System.out.println("Book borrowed successfully!");
                                break;

                            case 2:
                                System.out.println("Service selected: 2 - Return book ");
                                System.out.println("Enter book catalog number: ");
                                catalogNumber = scanner_d.nextLong();

                                Loan loanToRemove = null;


                            for (Loan ln : loans) {
                                if (ln.getBook().getCatalogNumber() == catalogNumber) {
                                    loanToRemove = ln;
                                    break;
                                }
                            }

                            if (loanToRemove != null) {
                                loans.remove(loanToRemove);
                                loanToRemove.getBook().setSituation("available");
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("Loan not found.");
                            }

                                break;

                            case 3:
                                // List available books
                                System.out.println("Service selected: 3 - List available books ");
                                for (Book bk : books) {
                                    if (bk.getSituation().equals("available")) {
                                        System.out.println(bk);
                                    }
                                }
                                break;
                            case 4:
                                // List users in loan
                                System.out.println("Service selected: 4 - List users in loan ");
                                for (Loan ln : loans) {
                                    System.out.println(ln);
                                }
                                break;

                            case 0:
                                System.out.println("Back to main menu! :D");
                                exitSub = true;
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("That's not an option");
                        scanner_d.next();
                    }
                }

                }
            break;
            case 0:
                // Quit
                System.out.println("Exiting...");
                exit = true;
                break;

            default:
                System.out.println("Invalid option");
        }

    } catch (InputMismatchException e) {
                System.out.println("That's not an option");
                scanner_d.next();
            }

        } while (!exit);

    }
}



