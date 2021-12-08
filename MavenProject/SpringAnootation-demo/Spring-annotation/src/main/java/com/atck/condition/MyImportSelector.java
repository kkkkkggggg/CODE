package com.atck.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector
{
    /**
     * 返回值就是要导入到容器中的组件全类名
     *
     * @param importingClassMetadata ：当前标注@Import注解的类的所有注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata)
    {
        return new String[]{"com.atck.bean.Blue","com.atck.bean.Yellow"};
    }
}
