import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double doCalculations(String[] expressionElements){
        Stack<Double> numbersStack = new Stack<>();
        Stack<Operator> operatorsStack = new Stack<>();
        while(Arrays.asList(expressionElements).indexOf("(") != -1){
            List<String> subList = new ArrayList<>();
            int openIndex = 0;
            for (int i = 0; i < expressionElements.length; i++){
                if((expressionElements[i].equals("(")) && (!expressionElements[i + 1].equals("("))){
                    openIndex = i;
                    break;
                }
            }
            int closeIndex = 0;
            int openBracketsNumber = 0;
            int closeBracketsNumber = 0;
            for(int i = openIndex; i < expressionElements.length; i++){
                if(expressionElements[i].equals("(")){
                    openBracketsNumber++;
                }
                else
                if(expressionElements[i].equals(")")){
                    closeBracketsNumber++;
                }
                else{
                    subList.add(expressionElements[i]);
                }
                if (openBracketsNumber == closeBracketsNumber){
                    closeIndex = i;
                    break;
                }
            }
            String[] subArray = new String[subList.size()];
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < openIndex; i++){
                newList.add(expressionElements[i]);
            }
            newList.add(String.valueOf(doCalculations(subList.toArray(subArray))));
            for (int i = closeIndex + 1; i < expressionElements.length; i++){
                newList.add(expressionElements[i]);
            }
            expressionElements = new String[newList.size()];
            expressionElements = newList.toArray(expressionElements);
        }
        for (int i = expressionElements.length - 1; i > -1; i--) {
            String singleElement = expressionElements[i];
            if (isDouble(singleElement)) {
                numbersStack.push(Double.parseDouble(singleElement));
            } else {
                operatorsStack.push(new Operator(singleElement.charAt(0)));
            }
        }
        Stack<Double> tempNumbersStack = new Stack<>();
        Stack<Operator> tempOperatorsStack = new Stack<>();
        double answer = 0;
        while (!operatorsStack.isEmpty()) {
            Operator currentOperator = operatorsStack.pop();
            if(!operatorsStack.isEmpty()) {
                if(currentOperator.compareTo(operatorsStack.peek()) != -1){
                    answer = currentOperator.doAction(numbersStack.pop(), numbersStack.pop());
                    numbersStack.push(answer);
                }
                else{
                    while (currentOperator.compareTo(operatorsStack.peek()) == -1){
                        tempOperatorsStack.push(currentOperator);
                        tempNumbersStack.push(numbersStack.pop());
                        currentOperator = operatorsStack.pop();
                        if (operatorsStack.isEmpty()){
                            break;
                        }
                    }
                    answer = currentOperator.doAction(numbersStack.pop(), numbersStack.pop());
                    numbersStack.push(answer);
                    while(!tempOperatorsStack.isEmpty()){
                        operatorsStack.push(tempOperatorsStack.pop());
                        numbersStack.push(tempNumbersStack.pop());
                    }
                }
            }
            else{
                answer = currentOperator.doAction(numbersStack.pop(), numbersStack.pop());
                numbersStack.push(answer);
            }
        }
        return numbersStack.pop();
    }

    public static void main(String[] args){
        System.out.println("Welcome human!");
        System.out.println("While writing your expressions, separate every character with space.");
        while(true){
            System.out.println("Enter expression:");
            Scanner in = new Scanner(System.in);
            String expression = in.nextLine();
            if (!expression.equals("exit")) {
                String[] expressionElements = expression.split(" ");
                System.out.println("Answer:");
                try {
                    System.out.println(doCalculations(expressionElements));
                }
                catch (Exception e){
                    System.out.println("There has been a mistake here. Try again!");
                }
            }
            else{
                System.out.println("Bye!");
                break;
            }
        }
    }
}
