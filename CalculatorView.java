import java.util.LinkedList;

//Класс view 

public class CalculatorView {

    private static CalculatorView instance;

    // Метод для реализации синглтон патерна
    public static CalculatorView getInstance() {
        if (instance == null) {
            return new CalculatorView();
        }
        return instance;
    }

    //Метод вывода результата в терминал
    public void printResult(ComplexNumber result) {
        System.out.println("Результат: " + result.toString());
    }

    //Метод вывода ошибки в терминал
    public void printError(String errorMessage) {
        System.err.println("Ошибка: " + errorMessage);
    }

    //Метод вывода логов в терминал
    public void printStoryLog(LinkedList<String> list) {
        System.out.println("Лог ");
        for (String string : list) {
            System.err.println(string);
        }
    }

    //Метод отображения меню
    public void printMenu() {
        System.out.println("1. Произвести вычесления ");
        System.out.println("2. Произвести вычесления c случайными комлексными числами ");
        System.out.println("3. Посмотреть историю вычеслений ");
        System.out.println("4. Выйти ");
    }

}