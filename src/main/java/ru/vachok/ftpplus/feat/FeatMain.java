package ru.vachok.ftpplus.feat;



import ru.vachok.ftpplus.Const;

/**
 Контроллер для фич
 <p>
 Сначала просим юзера вврести 3 числа. <code>double, double, int</code>, которые будут
 <i>стартовая сумма, процентная ставка и срок в годах</i>.

 @since 02.05.2018 (9:06)*/
public class FeatMain {
    public static void main(String[] args) {
        rateOfInterCon();
    }

    static void rateOfInterCon() {
        Const.EXECUTOR_SERVICE.execute(new RateOfInterestConsole());
    }
}