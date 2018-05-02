package ru.vachok.ftpplus.feat;



import java.util.Scanner;

/**
 Контроллер для фич
 <p>
 Сначала просим юзера вврести 3 числа. <code>double, double, int</code>, которые будут
 <i>стартовая сумма, процентная ставка и срок в годах</i>.

 @since 02.05.2018 (9:06)
 // TODO: 02.05.2018 <code>FeatMainTest</code> */
public class FeatMain {
    public static void main(String[] args) {
        rateOfInterCon();
    }

    static void rateOfInterCon() {
        System.out.println("Enter your start money: ");
        Scanner scanner = new Scanner(System.in);
        double summaStart = scanner.nextDouble();
        System.out.print(" OK.");
        System.out.println("Now enter % : ");
        double bankRate = scanner.nextDouble();
        System.out.print(" OK.");
        System.out.println("And term (years) :");
        int yearToStay = 5;
    }
}