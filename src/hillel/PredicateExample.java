package hillel;

import java.util.function.Predicate;

interface MyPredicate<T> extends Predicate<T> {
  MyPredicate<T> negate();

}

public class PredicateExample {
  public static void main(String[] args) {
    // Використання стандартного предиката
    Predicate<Integer> standardPredicate = n -> n % 2 == 0;
    System.out.println("Стандартний предикат:");
    System.out.println("Число 4 є парним: " + standardPredicate.test(4));
    System.out.println("Число 5 є парним: " + standardPredicate.test(5));

    // Використання власного предиката
    MyPredicate<Integer> customPredicate = new CustomPredicate(standardPredicate);
    System.out.println("\nВласний предикат:");
    System.out.println("Число 4 є парним: " + customPredicate.test(4));
    System.out.println("Число 5 є парним: " + customPredicate.test(5));

    // Обернення власного предиката
    MyPredicate<Integer> negatedPredicate = customPredicate.negate();
    System.out.println("\nОбернений власний предикат:");
    System.out.println("Число 4 не є парним: " + negatedPredicate.test(4));
    System.out.println("Число 5 не є парним: " + negatedPredicate.test(5));
  }
}

class CustomPredicate implements MyPredicate<Integer> {
  Predicate<Integer> predicate;

  public CustomPredicate(Predicate<Integer> predicate) {
    this.predicate = predicate;
  }

  @Override
  public MyPredicate<Integer> negate() {
    return new CustomPredicate(predicate.negate());
  }

  @Override
  public boolean test(Integer number) {
    return predicate.test(number);
  }

}

