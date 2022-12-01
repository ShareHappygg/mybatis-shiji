package com.example.mybatisTest.generator.processor.param.delete;

import com.example.mybatisTest.generator.processor.BaseCodeGenProcessor;
import com.example.mybatisTest.generator.spi.CodeGenProcessor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.Set;

/**
 * @author gim vo 代码生成器
 */
@AutoService(value = CodeGenProcessor.class)
public class GetDeleteCodeGenProcessor extends BaseCodeGenProcessor {


  public  static  final String PREFIX ="Delete";

  public  static  final String PREFIX_BEHAVIOR="删除";

  public static final String SUFFIX = "Param";

  @Override
  public Class<? extends Annotation> getAnnotation() {
    return GenDeleteParam.class;
  }

  @Override
  public String generatePackage(TypeElement typeElement) {
    return typeElement.getAnnotation(GenDeleteParam.class).pkgName();
  }

  @Override
  protected void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment) {

    Set<VariableElement> fields = findFields(typeElement,
        ve -> Objects.isNull(ve.getAnnotation(GenDeleteParam.class)));
    String className = PREFIX+typeElement.getSimpleName() + SUFFIX;
    ApiModel annotation = typeElement.getAnnotation(ApiModel.class);
    Builder builder = TypeSpec.classBuilder(className)
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Data.class)
        .addAnnotation(AnnotationSpec.builder(Accessors.class)
                .addMember("chain","$L",true).build())
        .addAnnotation(AnnotationSpec.builder(JsonIgnoreProperties.class)
                .addMember("value","$L","{ \"handler\" }").build())
        .addAnnotation(AnnotationSpec.builder(ApiModel.class)
                .addMember("value","$S",annotation.value())
                .addMember("description","$S",PREFIX_BEHAVIOR+annotation.description()+SUFFIX).build());

    addSetterAndGetterMethod(builder, fields);

    String packageName = generatePackage(typeElement);
//    genJavaFile(packageName, builder);
//    genJavaFile(packageName, getSourceTypeWithConstruct(typeElement,sourceClassName, packageName, className));
    genJavaSourceFile(packageName,typeElement.getAnnotation(GenDeleteParam.class).sourcePath(),builder);
  }
}
