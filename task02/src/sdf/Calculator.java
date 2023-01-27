package sdf;

public class Calculator {

    private Float last;
    private Float result;

    public Float calculate(Float firstNum, String operator, Float secondNum) {

        switch (operator) {
            case "+":
            result = firstNum + secondNum;
            break;
            case "-":
            result = firstNum - secondNum;
            break;
            case "/":
            result = firstNum / secondNum;
            break;
            case "*":
            result = firstNum * secondNum;
            break;
            default:
            break;
            }
            return result;
    }

    public Float getLast() {
        if (last == null) {
            return 0f;
        }
        return last;
    }

    public void setLast(Float last) {
        this.last = last;
    }

    
    
    
}
