import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    // Создан обьект сканер для получения данных от пользователя
    Scanner tDobleScanner = new Scanner(System.in);
    // Создан обьект модели для получения данных от пользователя
    CalculatorModel model = CalculatorModel.getInstance();
    // Создан обьект вьюшки для получения данных от пользователя
    CalculatorView view = CalculatorView.getInstance();
    // Создан обьект пресентера
    CalculatorController controller = CalculatorController.getInstance(model, view);

    while (controller.exitflag) {
      view.printMenu();
      Integer choice = tDobleScanner.nextInt();
      switch (choice) {
        case 1:
          controller.calculate(tDobleScanner);
          break;
        case 2:
          try {
            controller.calculateRnd();
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 3:
          view.printStoryLog(controller.getLog());
          break;
        case 4:
          Logger.writeFile(controller.getLog(), "Log.txt");
          controller.exitflag = false;
          // Написать логер
          break;
        default:
          throw new Exception("Нет такой опции в меню. ");
      }
    }
    tDobleScanner.close();
  }

}