package com.example.mybatisTest.generator.processor.param.delete;

import java.lang.annotation.*;

/**
 * @Author: Gim
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GenDeleteParam {

    String pkgName();

    String sourcePath() default "src/main/java";

    boolean overrideSource() default false;

    boolean isPage() default true;
}
