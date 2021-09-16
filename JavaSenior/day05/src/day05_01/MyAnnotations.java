package day05_01;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @acthor KKKKK
 * @creay 2021-04-19-{TIME}
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotations
{
    MyAnnotation[] value();
}
