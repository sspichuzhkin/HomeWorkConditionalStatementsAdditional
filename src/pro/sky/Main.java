package pro.sky;

public class Main {
    public static void main(String[] args) {
        Task6();
        Task7();
    }

    public static void Task6() {
//Людям старше (или равно) 23 лет мы предоставляем лимит в размере 3 зарплат.
//Людям младше 23 лет мы предоставляем лимит в размере 2 зарплат.
//Если заработная плата клиента выше (или равно) 50 тысяч, мы увеличиваем лимит в 1.2 раза.
//Если заработная плата выше (или равно) 80 тысяч, мы увеличиваем лимит в 1.5 раза.
//Наша задача: написать программу, которая показывает, какую сумму на кредитке может получить клиент.
//Вводные данные: переменная age = 19 для обозначения возраста клиента, salary = 58_000 для обозначения зарплаты клиента.
//Увеличения не могут быть применены одновременно.
//Необходимо вывести максимальный лимит в консоль в формате: «Мы готовы выдать вам кредитную карту с лимитом *** рублей».
        int age = 23;
        double salary = 80_000;

        if (age >= 23 && salary < 80000) {
            double creditLimit = salary * 3;
            SalaryDependence(salary, creditLimit);
        } else if (age >= 23 && salary >= 80000) {
            double creditLimit = salary * 2;
            SalaryDependence(salary, creditLimit);
        } else if (age < 23 && salary >= 80000) {
            double creditLimit = salary * 3;
            SalaryDependence(salary, creditLimit);
        } else if (age < 23 && salary < 80000) {
            double creditLimit = salary * 2;
            SalaryDependence(salary, creditLimit);
        }

    }

    private static void SalaryDependence(double salary, double creditLimit) {
        if (salary >= 50_000 && salary < 80_000) {
            creditLimit = creditLimit + creditLimit * 0.2;
        } else if (salary >= 80_000) {
            creditLimit = creditLimit + creditLimit * 0.5;
        }
        String creditLimit1Round = String.format("%.2f", creditLimit);
        System.out.println("«Мы готовы выдать вам кредитную карту с лимитом " + creditLimit1Round + " рублей»");
    }

    public static void Task7() {
//Правила следующие:
//Базовая ставка для клиента — 10% годовых. Срок кредитования — 12 месяцев. Максимальный ежемесячный платеж — 50% от ЗП.
//Если возраст меньше 23, то добавляем 1% к ставке.Если возраст меньше 30, то добавляем 0.5% к ставке.
//Если зарплата больше 80_000, уменьшаем ставку на 0.7%.

//Нам нужно написать программу для предварительного одобрения/отказа заявки по кредиту.
//Вводные данные: используйте переменные age = 25 для обозначения возраста,salary = 60_000 для обозначения зарплаты,
// wantedSum = 330_000 для обозначения желаемой суммы кредита.
//Подсчитайте и выведите ответ, одобрен кредит или нет. На основании зарплаты подсчитайте максимальный допустимый платеж.
//Если максимальный допустимый платеж по ЗП больше стандартного платежа по кредиту согласно процентной ставке, то кредит одобрен, если меньше — отказан.
//Пример ответа в консоль: «Максимальный платеж при ЗП *** равен *** рублей. Платеж по кредиту *** рублей. Одобрено/отказано».

//Критерии оценки
//При изменении значения переменной age результат вывода в консоль изменяется согласно условиям задачи
//При изменении значения переменной salary результат вывода в консоль изменяется согласно условиям задачи
//Написанный код отрабатывает условия задачи и изменение значений переменных, выводит в консоль корректный результат
//Нет вложенности в коде.

        int age = 25;
        double salary = 60_000;
        double wantedSum = 330_000;
        double baseYearRate = 0.1;
        double creditingPeriod = 12;
        double baseMonthRate = baseYearRate / creditingPeriod;
        double maxPaymentMonth = salary * 0.5;
        double stdPaymentMonth = wantedSum * baseMonthRate / (1 - 1 / Math.pow(1 + baseMonthRate, 1 * 12));
        String salaryResult = String.format("%.2f", salary);
        String maxPaymentMonthResult = String.format("%.2f", maxPaymentMonth);
        String stdPaymentMonthResult = String.format("%.2f", stdPaymentMonth);

//        double monthlyPayment = loanAmount * monthlyInterestRate / (
//                1-1 / Math.pow(1+ monthlyInterestRate,numberOfYears * 12));


        if (salary > 80000) {
            baseYearRate = baseYearRate + baseYearRate * 0.007;
        }

        if (age < 23) {
            baseYearRate = baseYearRate + baseYearRate * 0.01;
        } else if (age < 30) {
            baseYearRate = baseYearRate + baseYearRate * 0.005;
        }

        if (maxPaymentMonth > stdPaymentMonth) {
            String resultAnswer = "Одобрено";
            System.out.println("«Максимальный платеж при ЗП " + salaryResult + " равен " + maxPaymentMonthResult + " рублей. Платеж по кредиту " + stdPaymentMonthResult + " рублей. " + resultAnswer + ".");
        } else {
            String resultAnswer = "Отказано";
            System.out.println("«Максимальный платеж при ЗП " + salaryResult + " равен " + maxPaymentMonthResult + " рублей. Платеж по кредиту " + stdPaymentMonthResult + " рублей. " + resultAnswer + ".");

        }

    }

}
