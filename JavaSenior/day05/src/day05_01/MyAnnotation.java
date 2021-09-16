package day05_01;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @acthor KKKKK
 * @creay 2021-04-19-{TIME}
 */
@Repeatable(MyAnnotations.class)
@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
    String value() default "hello";


}
