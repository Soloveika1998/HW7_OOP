// Класс билдер для комплексных чисел, для реализации паттерна builder

import java.util.Locale;
import java.util.Random;

public class ComplexNumberBuilder {
  
  private double truePart;

  private double imageneryPart;

  //Сетер для реальной части КЧ
  public ComplexNumberBuilder setTruePart(double truePart) {
    this.truePart = truePart;
    return this;
  }

  //Сетер для мнимой части КЧ
  public ComplexNumberBuilder setImageneryPart(double imageneryPart) {
    this.imageneryPart = imageneryPart;
    return this;
  }

  //Билдер комплеусного числа
  public ComplexNumber build() {
    return new ComplexNumber(truePart, imageneryPart);
  }
   public ComplexNumber buildRandom() {
    double d = new Random().nextInt();
    this.truePart = Double.parseDouble(truncateUptoTwoDecimal(d));
    d = new Random().nextInt();
    this.imageneryPart = Double.parseDouble(truncateUptoTwoDecimal(d));
    return new ComplexNumber(truePart, imageneryPart);
  }

  /**
   * @param doubleValue число
   * @return строковое представление числа doubleValue, сократив количество знаков
   *         после . до двух.
   */
  public static String truncateUptoTwoDecimal(double doubleValue) {
    String value = String.valueOf(doubleValue);
    if (value != null) {
      String result = value;
      int decimalIndex = result.indexOf(".");
      if (decimalIndex != -1) {
        String decimalString = result.substring(decimalIndex + 1);
        if (decimalString.length() > 2) {
          result = value.substring(0, decimalIndex + 3);
        } else if (decimalString.length() == 1) {
          result = String.format(Locale.ENGLISH, "%.2f",
              Double.parseDouble(value));
        }
      }
      return result;
    }
    return null;
  }
}