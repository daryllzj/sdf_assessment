package sdf;

public class Calculator {

    private Float last;
    private Float result;

    // takes in arguments from Main Class
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

    // checks if there is any value to last
    public Float getLast() {
        // if there is no value for last return float
        if (last == null) {
            return 0f;
        }
        // if there is a value for last, return value
        return last;
    }


    // sets new value to last
    public void setLast(Float last) {
        this.last = last;
    }

    
    
    
}
