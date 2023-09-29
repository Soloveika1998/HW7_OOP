import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс пресентер для связи вьюшки и модели
 */
public class CalculatorController {
    /**
     * Поле для привязки бизнес модели к пресентеру
     */
    private CalculatorModel model;
    /**
     * Поле для привязки вьюера к пресентеру
     */
    private CalculatorView view;
    /**
     * Локальный линкед лист для сохранения истории последних операций
     */
    private LinkedList<String> log;

    public LinkedList<String> getLog() {
        return log;
    }

    /**
     * Логическая переменная для определения возмо;ности доступа к вычеслениям на
     * основании выобора соответствующего варианта в менью
     */
    protected Boolean innerflag = false;
    /**
     * Логическая переменная для выхода из цикла вайл в майн, после соответствующего
     * выбора варианта менью
     */
    public Boolean exitflag = true;

    /**
     * Использование патерная синглтон
     */
    private static CalculatorController instance;

    // Функция для реализации синглтон патерна
    public static CalculatorController getInstance(CalculatorModel newModel, CalculatorView newView) {
        if (instance == null) {
            return new CalculatorController(newModel, newView);
        }
        return instance;
    }

    /**
     * Конструктор Класса требующий привязки виью и модели
     * 
     * @param newModel аргумент класса CalculatorModel
     * @param newView  аргумент класса CalculatorView
     */
    private CalculatorController(CalculatorModel newModel, CalculatorView newView) {
        model = newModel;
        view = newView;
        this.log = new LinkedList<String>();
    }

    /**
     * Функция реализующая математические вычесления и передачу информации в лог
     * 
     * @param sc аргумент сканер
     */
    public void calculate(Scanner sc) {
        ComplexNumber result;
        System.out.println("Введите реальную часть первого комплексного числа ");
        double tempTruePart = sc.nextInt();
        System.out.println("Введите мнимую часть первого комплексного числа ");
        double tempImageneryPart = sc.nextInt();
        ComplexNumber num1 = new ComplexNumberBuilder().setTruePart(tempTruePart).setImageneryPart(tempImageneryPart)
                .build();
        System.out.println(
                "Введите математический оператор \n" +
                        "[+] Сложить \n" +
                        "[-] Вычесть \n" +
                        "[*] Умножить\n" +
                        "[/] Разделить \n");
        char operator = sc.next().charAt(0);
        System.out.println("Введите реальную часть первого комплексного числа ");
        tempTruePart = sc.nextInt();
        System.out.println("Введите мнимую часть первого комплексного числа ");
        tempImageneryPart = sc.nextInt();
        ComplexNumber num2 = new ComplexNumberBuilder().setTruePart(tempTruePart).setImageneryPart(tempImageneryPart)
                .build();
        try {
            switch (operator) {
                case '+':
                    result = model.add(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                case '-':
                    result = model.subtraction(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                case '*':
                    result = model.multiply(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                case '/':
                    result = model.divide(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                default:
                    view.printError("Неверная операция");
                    return;
            }
            view.printResult(result);
            view.printStoryLog(log);

        } catch (ArithmeticException e) {
            view.printError(e.getMessage());
        }
    }

    /**
     * Функция возвращает случаное вычесление двух случайных комплексных чиссел.
     */
    public void calculateRnd() {
        ComplexNumber result;
        ComplexNumber num1 = new ComplexNumberBuilder().buildRandom();
        ComplexNumber num2 = new ComplexNumberBuilder().buildRandom();
        int rnd = new Random().nextInt(1, 4);
        char operator = '+';
        try {
            switch (rnd) {
                case 1:
                    result = model.add(num1, num2);
                    operator = '+';
                    logingCalculations(num1, num2, operator, result);
                    break;
                case 2:
                    result = model.subtraction(num1, num2);
                    operator = '-';
                    logingCalculations(num1, num2, operator, result);
                    break;
                case 3:
                    result = model.multiply(num1, num2);
                    operator = '*';
                    logingCalculations(num1, num2, operator, result);
                    break;
                case 4:
                    result = model.divide(num1, num2);
                    operator = '/';
                    logingCalculations(num1, num2, operator, result);
                    break;
                default:
                    view.printError("Неверная операция");
                    return;
            }
            view.printResult(result);
            view.printStoryLog(log);

        } catch (ArithmeticException e) {
            view.printError(e.getMessage());
        }
    }

    /**
     * Функция для передачи данных вычесления в лог
     * 
     * @param num1     первое число
     * @param num2     второе число
     * @param operator математический оператор
     * @param result   результат вычеслений
     */
    void logingCalculations(ComplexNumber num1, ComplexNumber num2, char operator, ComplexNumber result) {
        log.add("Calculation result : " + num1.toString() + " " + operator + " " + num2.toString() + " = "
                + result.toString());
    }

}