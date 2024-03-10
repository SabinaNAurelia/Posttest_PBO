// NIM  : 2209106002
// NAMA : SABINA NURLATIFAH AURELIA
// KELAS: A1 22

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static List<Acc> DataAcc = new ArrayList<>(); // untuk menyimpan objek dari kelas Acc
    private static List<Soco> DataSoco = new ArrayList<>();// untuk menyimpan objek dari kelas Soco

    public static void main(String[] args) throws NumberFormatException, IOException {
        account();
    }

    // clear screen
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // pause program
    private static void pause() {
        System.out.print("Press Anything To Back Menu...");
        try {
            input.readLine(); // Menunggu sampai pengguna menekan sesuatu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // register
    private static void register() throws IOException {
        clear();
        System.out.println("----------------------------------------------------");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("----------------------------------------------------");
        System.out.println("|                    REGISTER                      |");
        System.out.println("----------------------------------------------------");
        System.out.print("Username   : ");
        String user = input.readLine();
        System.out.print("Password   : ");
        String pw = input.readLine();
        Acc new_Acc = new Acc(user, pw);
        DataAcc.add(new_Acc);
        System.out.println("----------------------------------------------------");
        System.out.println("                Account Registered                  ");
        System.out.println("----------------------------------------------------");
        System.out.println("                 Please Login                       ");
        System.out.println("");
        pause();
        login();
    }

    // login
    private static void login() throws NumberFormatException, IOException {
        clear();
        System.out.println("----------------------------------------------------");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("----------------------------------------------------");
        System.out.println("|                      LOGIN                       |");
        System.out.println("----------------------------------------------------");
        System.out.print("Username   : ");
        String userp = input.readLine();
        System.out.print("Password   : ");
        String pwp = input.readLine();
        boolean isLogIn = false;
        for (Acc Acc : DataAcc) {
            if (Acc.getusername().equals(userp) && Acc.getPass().equals(pwp)) {
                isLogIn = true;
                break;
            }
        }

        if (isLogIn) {
            clear();
            System.out.println("----------------------------------------------------");
            System.out.println("                 Login Succesful!                   ");
            System.out.println("----------------------------------------------------");
            pause();
            mainmenu();
        } else {
            clear();
            System.out.println("----------------------------------------------------");
            System.out.println("             Username / Password Invalid!           ");
            System.out.println("----------------------------------------------------");
            pause();
        }
    }

    // account menu
    private static void account() throws NumberFormatException, IOException {
        while (true) {
            clear();
            tableacc();
            System.out.println("|         1. Register                              |");
            System.out.println("|         2. Login                                 |");
            System.out.println("|         3. Exit                                  |");
            System.out.println("====================================================");
            System.out.print("Enter The Menu Option You Want : ");
            int choose = Integer.parseInt(input.readLine());
            switch (choose) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    clear();
                    exitprogram();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    // menu for crud skincare products
    private static void menu() {
        System.out.println("====================================================");
        System.out.println("|                       WELCOME                    |");
        System.out.println("|                  SOCO BEAUTY STORE               |");
        System.out.println("====================================================");
        System.out.println("|          1. Add Skincare Data                    |");
        System.out.println("|          2. Show Skincare Data                   |");
        System.out.println("|          3. Update Skincare Data                 |");
        System.out.println("|          4. Delete Skincare Data                 |");
        System.out.println("|          5. Exit                                 |");
        System.out.println("====================================================");
    }

    // main menu
    private static void mainmenu() throws NumberFormatException, IOException {
        boolean continuemenu = true;
        while (continuemenu) {
            clear();
            menu();
            System.out.print("Enter The Menu Option You Want : ");
            int choose = Integer.parseInt(input.readLine());
            switch (choose) {
                case 1:
                    addadata();
                    pause();
                    // clear();
                    break;
                case 2:
                    display();
                    pause();
                    // clear();
                    break;
                case 3:
                    update_data();
                    pause();
                    // clear();
                    break;
                case 4:
                    delete_data();
                    pause();
                    // clear();
                    break;
                case 5:
                    account();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    // table account
    private static void tableacc() {
        System.out.println("====================================================");
        System.out.println("|                       WELCOME                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                  SOCO BEAUTY STORE               |");
        System.out.println("====================================================");
    }

    // table add data
    private static void tableadddata() {
        System.out.println("====================================================");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                 Add Skincare Data                |");
        System.out.println("====================================================");
    }

    // table show data
    private static void showdata() {
        System.out.println("----------------------------------------------------");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("----------------------------------------------------");
    }

    // table update data
    private static void tableupdate() {
        System.out.println("====================================================");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                Update Skincare Data              |");
        System.out.println("====================================================");
    }

    // table exit program
    private static void exitprogram() {
        System.out.println("====================================================");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|    Thank You For Choosing Soco Beauty Store      |");
        System.out.println("====================================================");
    }

    // // only integer
    // private static int only_number() throws IOException {
    // int fillint = 0;
    // while (true) {
    // String inputString = input.readLine();
    // if (inputString.matches("\\d+")) { // Memeriksa apakah input hanya terdiri
    // dari angka
    // fillint = Integer.parseInt(inputString);
    // break;
    // } else {
    // System.out.println("");
    // System.err.print("Input Must Be a Number: ");
    // }
    // }
    // return fillint;
    // }

    // not empty
    private static String not_empty() throws IOException {
        String fillString = "";
        while (true) {
            String inputString = input.readLine();
            if (!inputString.trim().isEmpty()) { // Memeriksa apakah input tidak kosong
                fillString = inputString;
                break;
            } else {
                System.out.println("");
                System.err.print("Input Cannot Be Empty: ");
            }
        }
        return fillString;
    }

    // //only positif
    // private static int positive_number() throws IOException {
    // int fillint = 0;
    // while (true) {
    // fillint = only_number();
    // if (fillint > 0) {
    // break;
    // } else {
    // System.out.println("");
    // System.err.print("Input Must Be a Positive Number: ");
    // }
    // }
    // return fillint;
    // }

    // validate number
    private static int validate_number(boolean requirePositive) throws IOException {
        int fillint = 0;
        while (true) {
            String inputString = input.readLine();
            if (inputString.matches("\\d+")) { // Memeriksa apakah input hanya terdiri dari angka
                fillint = Integer.parseInt(inputString);
                if (!requirePositive || fillint > 0) { // Validasi positif jika diperlukan
                    break;
                } else {
                    System.out.println("");
                    System.err.print("Input Number >= 0: ");
                }
            } else {
                System.out.println("");
                System.err.print("Input Must Be a Number: ");
            }
        }
        return fillint;
    }

    // add data skincare
    private static void addadata() throws NumberFormatException, IOException {
        clear();
        tableadddata();
        System.out.print("Merk Skincare   : ");
        String Merk = not_empty();
        System.out.print("Product Name    : ");
        String Product = not_empty();
        System.out.print("Product Codes   : ");
        int Product_codes = validate_number(true);
        System.out.print("Product Stocks  : ");
        int Stock = validate_number(true);
        System.out.print("Product Prices  : ");
        double Price = validate_number(true);
        Soco skincare = new Soco(Merk, Product, Product_codes, Stock, Price);
        DataSoco.add(skincare);

        System.out.println("----------------------------------------------------");
        System.out.println("Data Added Succesfully!");
        System.out.println("");

    }

    // show data skincare
    private static void display() {
        clear();
        if (DataSoco.isEmpty()) {
            System.out.println("----------------------------------------------------");
            System.out.println("                  ! Empty Data !                    ");
            System.out.println("----------------------------------------------------");
        } else {
            showdata();
            for (int i = 0; i < DataSoco.size(); i++) {
                Soco skincare = DataSoco.get(i);
                System.out.println("Data " + (i + 1));
                System.out.println("----------------------------------------------------");
                skincare.display();
                System.out.println("----------------------------------------------------");
            }
        }
    }

    // update data skincare
    private static void update_data() throws NumberFormatException, IOException {
        clear();
        display();
        System.out.print("Enter The Data Number You Want Update : ");
        int no = Integer.parseInt(input.readLine()) - 1; // Kurangi dengan 1 untuk mengonversi ke indeks nol

        // cek apakah indeks valid?
        if (no >= 0 && no < DataSoco.size()) {
            // Get the Soco object based on the index
            Soco skinToEdit = DataSoco.get(no);
            clear();
            tableupdate();
            System.out.print("Merk Skincare   : ");
            String Merk = not_empty();
            System.out.print("Product Name    : ");
            String Product = not_empty();
            System.out.print("Product Codes   : ");
            int Product_codes = validate_number(true);
            System.out.print("Product Stocks  : ");
            int Stock = validate_number(true);
            System.out.print("Product Prices  : ");
            double Price = validate_number(true);

            // update data dengan yang baru
            skinToEdit.merk = Merk;
            skinToEdit.product = Product;
            skinToEdit.product_code = Product_codes;
            skinToEdit.stock = Stock;
            skinToEdit.price = Price;

            System.out.println("");
            System.out.println("Data Updated!");
        } else {
            System.out.println("Invalid Data Number, Please Choose A Valid One");
        }

        System.out.println("----------------------------------------------------");
    }

    private static void delete_data() throws NumberFormatException, IOException {
        showdata();
        display();

        // masukkan nomor data yang akan dihapus
        System.out.print("Enter The Data Number You Want Delete : ");
        int no = Integer.parseInt(input.readLine()) - 1; // Kurangi dengan 1 untuk mengonversi menjadi indeks nol

        // apakah nomor data yang dimasukkan valid?
        if (no >= 0 && no < DataSoco.size()) {
            // Hapus data Soco dari list berdasarkan nomor yang dipilih
            DataSoco.remove(no);
            System.out.println("");
            System.out.println("Data Succesfully Delete!");
        } else {
            System.out.println("");
            System.out.println("Invalid!");
        }

        System.out.println("----------------------------------------------------");
    }
}
