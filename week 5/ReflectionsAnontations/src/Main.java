import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {
    public static void main(String args[]){
        MyClass myInstance = new MyClass();
        ClassInfo myAnnotation = myInstance.getClass().getAnnotation(ClassInfo.class);
        System.out.println("Class author: " + myAnnotation.author());
        System.out.println("Revision: " + myAnnotation.revision());
        System.out.println("Class checked: " + myAnnotation.checked());
        System.out.println("Related classes:");
        for (Class singleReletedClass : myAnnotation.relatedClasses()){
            System.out.println(singleReletedClass.getName());
        }
    }
}
