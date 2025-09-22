package cours;

public class CalcRevenueBase {
  public double calcRevenue(Sale sale) {
    return sale.getQuota() * sale.getPrice();
  }
}
