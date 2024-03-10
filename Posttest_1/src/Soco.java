public class Soco {

    String merk;
    String product;
    int product_code;
    int stock;
    double price;

    public Soco(String merks, String products,
     int product_codes, int stocks, double prices) {
        this.merk = merks;
        this.product = products;
        this.product_code = product_codes;
        this.stock = stocks;
        this.price =prices;
    }

    void display(){
        System.out.println("Merk Skincare    : " + this.merk);
        System.out.println("Product Name     : " + this.product);
        System.out.println("Product Codes    : " + this.product_code);
        System.out.println("Product Stocks   : " + this.stock);
        System.out.println("Product Prices   : " + this.price);
    }


}