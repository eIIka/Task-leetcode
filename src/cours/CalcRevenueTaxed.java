package cours;

public class CalcRevenueTaxed extends CalcRevenueBase{
  // Ставка податку на доход у відсотках
  private static final double TAX_RATE = 5;

  @Override
  public double calcRevenue(Sale sale) {
    return super.calcRevenue(sale) * (1 - TAX_RATE / 100);
  }
}
