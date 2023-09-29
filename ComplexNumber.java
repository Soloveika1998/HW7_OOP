public class ComplexNumber {
    /**
     * @param truePart Реальная часть
     */
    private double truePart;
    
    /**
     * @param imageneryPart Мнимая часть
     */
    private double imageneryPart;

    //Конструктор комплексного числа
    public ComplexNumber(double truePart, double imageneryPart) {
        this.truePart = truePart;
        this.imageneryPart = imageneryPart;
    }
    
    public double getTruePart() {
        return truePart;
    }
    
    public void setTruePart(double truePart) {
        this.truePart = truePart;
    }

    public double getImageneryPart() {
        return imageneryPart;
    }
    
    public void setImageneryPart(double imageneryPart) {
        this.imageneryPart = imageneryPart;
    }
    
    @Override
    public String toString() {
        return " [" + truePart + " " + " " + imageneryPart + "i]";
    }
}

