import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ClassInfo {
    String author();
    Class<?>[] relatedClasses();
    int revision() default 1;
    boolean checked() default true;
}
