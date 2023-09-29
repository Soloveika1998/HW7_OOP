//Класс реализующий бизнес модель 
public class CalculatorModel implements MathOperations {

    private static CalculatorModel instance;

    // Функция для реализации синглтон патерна
    public static CalculatorModel getInstance() {
        if (instance == null) {
            return new CalculatorModel();
        }
        return instance;
    }

    @Override
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber temp = new ComplexNumberBuilder().build();
        temp.setTruePart(Double
                .parseDouble(ComplexNumberBuilder.truncateUptoTwoDecimal(num1.getTruePart() + num2.getTruePart())));
        temp.setImageneryPart(Double
                .parseDouble(ComplexNumberBuilder
                        .truncateUptoTwoDecimal(num1.getImageneryPart() + num2.getImageneryPart())));
        return temp;
    }

    @Override
    public ComplexNumber subtraction(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber temp = new ComplexNumberBuilder().build();
        temp.setTruePart(Double
                .parseDouble(ComplexNumberBuilder.truncateUptoTwoDecimal(num1.getTruePart() - num2.getTruePart())));
        temp.setImageneryPart(Double
                .parseDouble(ComplexNumberBuilder
                        .truncateUptoTwoDecimal(num1.getImageneryPart() - num2.getImageneryPart())));
        return temp;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber temp = new ComplexNumberBuilder().build();
        temp.setTruePart(Double
                .parseDouble(ComplexNumberBuilder.truncateUptoTwoDecimal(
                        (num1.getTruePart() * num2.getTruePart())
                                - (num1.getImageneryPart() * num2.getImageneryPart()))));
        temp.setImageneryPart(Double
                .parseDouble(ComplexNumberBuilder.truncateUptoTwoDecimal(
                        (num1.getImageneryPart() * num2.getTruePart())
                                - (num1.getTruePart() * num2.getImageneryPart()))));
        return temp;
    }

    @Override
    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber temp = new ComplexNumberBuilder().build();
        temp.setTruePart(Double
                .parseDouble(ComplexNumberBuilder.truncateUptoTwoDecimal(
                        ((num1.getTruePart() * num2.getTruePart())
                                + (num1.getImageneryPart() * num2.getImageneryPart()))
                                / (Math.pow(num2.getTruePart(), 2)) + Math.pow(num2.getImageneryPart(), 2))));
        temp.setImageneryPart(Double
                .parseDouble(ComplexNumberBuilder.truncateUptoTwoDecimal(
                        ((num1.getImageneryPart() * num2.getTruePart())
                                - (num1.getTruePart() * num2.getImageneryPart()))
                                / (Math.pow(num2.getTruePart(), 2)) + Math.pow(num2.getImageneryPart(), 2))));

        return temp;
    }

}