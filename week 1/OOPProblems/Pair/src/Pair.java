import java.util.Objects;

public class Pair {
    private Object firstMember;
    private Object secondMember;

    public Pair(){
    }

    public Pair(Object firstObject, Object secondObject){
        firstMember = firstObject;
        secondMember = secondObject;
    }

    public Object getFirstMember() {
        return firstMember;
    }

    public Object getSecondMember() {
        return secondMember;
    }

    public String toString(){
        return firstMember.toString() + " : " + secondMember.toString();
    }

    public boolean equals(Pair otherPair){
        if (this.firstMember.equals(otherPair.firstMember) && this.secondMember.equals(otherPair.secondMember)){
            return true;
        }
        else{
            return false;
        }
    }
}
