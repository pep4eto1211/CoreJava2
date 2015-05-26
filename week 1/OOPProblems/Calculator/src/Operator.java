public class Operator{
    private char actionSimbol;

    public Operator(char actionSimbol) {
        this.actionSimbol = actionSimbol;
    }

    public double doAction(double a, double b) {
        switch (actionSimbol){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
            case '^':
                return Math.pow(a, b);
            default:
                return Double.MAX_VALUE;
        }
    }

    public int compareTo(Operator other){
        if (this.actionSimbol == other.actionSimbol){
            return 0;
        }
        else
        if(this.actionSimbol == '^'){
            return 1;
        }
        else
        if(other.actionSimbol == '^')
        {
            return -1;
        }
        else
        if ((this.actionSimbol == '*') && (other.actionSimbol == '/')){
            return 0;
        }
        else
        if ((this.actionSimbol == '/') && (other.actionSimbol == '*')){
            return 0;
        }
        else
        if ((this.actionSimbol == '+') && (other.actionSimbol == '-')){
            return 0;
        }
        else
        if ((this.actionSimbol == '-') && (other.actionSimbol == '+')){
            return 0;
        }
        else
        if ((this.actionSimbol == '*') && ((other.actionSimbol == '+') || (other.actionSimbol == '-'))){
            return 1;
        }
        else
        if ((this.actionSimbol == '/') && ((other.actionSimbol == '+') || (other.actionSimbol == '-'))){
            return 1;
        }
        else
        if (((other.actionSimbol == '*') || (other.actionSimbol == '/')) && ((this.actionSimbol == '+') ||
                (this.actionSimbol == '-'))){
            return -1;
        }
        return 0;
    }
}
