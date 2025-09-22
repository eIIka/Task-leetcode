package cours;
// Клас-модель продажу
public class Sale {

  int quota;
  double price;

  public Sale(int quota, double price) {
    this.quota = quota;
    this.price = price;
  }

  public int getQuota() {
    return quota;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Sale: " +
        "quota is " + quota + " " +
        Constants.MEASURE +
        ", price is " + Constants.CURRENCY +
        " " + price + ".";
  }
}