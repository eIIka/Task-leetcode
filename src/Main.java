public class Main {
    public static void main(String[] args) {

        //Рівність 1: 50/19 = 2.63
        double preciseValue1 = 50.0 / 19.0;
        double approximateValue1 = 2.63;

        double absoluteError1 = Math.abs(preciseValue1 - approximateValue1);
        double relativeError1 = (absoluteError1 / preciseValue1) * 100;

        System.out.println("Рівність 1: 50/19 = 2.63");
        System.out.println("  Точне значення: " + preciseValue1);
        System.out.println("  Наближене значення: " + approximateValue1);
        System.out.printf("  Абсолютна похибка: %.15f%n", absoluteError1);
        System.out.printf("  Відносна похибка: %.4f%%%n", relativeError1);
        System.out.println("------------------------------------------");

        //Рівність 2: sqrt(27) = 5.19
        double preciseValue2 = Math.sqrt(27.0);
        double approximateValue2 = 5.19;

        double absoluteError2 = Math.abs(preciseValue2 - approximateValue2);
        double relativeError2 = (absoluteError2 / preciseValue2) * 100;

        System.out.println("Рівність 2: sqrt(27) = 5.19");
        System.out.println("  Точне значення: " + preciseValue2);
        System.out.println("  Наближене значення: " + approximateValue2);
        System.out.printf("  Абсолютна похибка: %.15f%n", absoluteError2);
        System.out.printf("  Відносна похибка: %.4f%%%n", relativeError2);
        System.out.println("------------------------------------------");


        if (relativeError1 < relativeError2) {
            System.out.println("Висновок: Рівність 50/19 = 2.63 є точнішою.");
        } else if (relativeError2 < relativeError1) {
            System.out.println("Висновок: Рівність sqrt(27) = 5.19 є точнішою.");
        } else {
            System.out.println("Висновок: Обидві рівності мають однакову точність.");
        }
    }
}