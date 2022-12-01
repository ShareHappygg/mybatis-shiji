package com.example.mybatisTest.generator.processor;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.mybatisTest.generator.annotation.FieldDesc;
import com.example.mybatisTest.generator.annotation.TypeConverter;
import com.example.mybatisTest.generator.context.ProcessingEnvironmentHolder;
import com.example.mybatisTest.generator.spi.CodeGenProcessor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.javassist.compiler.ast.Symbol;
import org.checkerframework.checker.units.qual.C;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic.Kind;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author gim
 */
public abstract class BaseCodeGenProcessor implements CodeGenProcessor {

  public static final String PREFIX = "Base";
  private FieldSpec.Builder fieldSpec;

  @Override
  public void generate(TypeElement typeElement, RoundEnvironment roundEnvironment)
      throws Exception {
    //添加其他逻辑扩展
    generateClass(typeElement, roundEnvironment);
  }

  /**
   * 生成class 类
   *
   * @param typeElement
   * @param roundEnvironment
   * @return
   */
  protected abstract void generateClass(TypeElement typeElement,
      RoundEnvironment roundEnvironment);

  /**
   * 过滤属性
   *
   * @param typeElement
   * @param predicate
   * @return
   */
  public Set<VariableElement> findFields(TypeElement typeElement,
      Predicate<VariableElement> predicate) {
    List<? extends Element> fieldTypes = typeElement.getEnclosedElements();
    Set<VariableElement> variableElements = new LinkedHashSet<>();
    for (VariableElement e : ElementFilter.fieldsIn(fieldTypes)) {
      if (predicate.test(e)) {
        variableElements.add(e);
      }
    }
    return variableElements;
  }

//  public Set<VariableElement> findGetListFields(TypeElement typeElement,
//                                         Predicate<VariableElement> predicate) {
//    List<? extends Element> fieldTypes = typeElement.getEnclosedElements();
//
//    Set<VariableElement> variableElements = new LinkedHashSet<>();
//    for (VariableElement e : ElementFilter.fieldsIn(fieldTypes)) {
//      if (predicate.test(e)) {
//        variableElements.add(e);
//      }
//    }
//    return variableElements;
//  }

//  /**
//   * 获取名称默认上下文
//   *
//   * @param typeElement
//   * @return
//   */
//  public DefaultNameContext getNameContext(TypeElement typeElement) {
//    DefaultNameContext context = new DefaultNameContext();
//    String serviceName = GenServiceProcessor.SERVICE_PREFIX + typeElement.getSimpleName()
//        + GenServiceProcessor.SERVICE_SUFFIX;
//    String implName = typeElement.getSimpleName() + GenServiceImplProcessor.IMPL_SUFFIX;
//    String repositoryName = typeElement.getSimpleName() + GenRepositoryProcessor.REPOSITORY_SUFFIX;
//    String mapperName = typeElement.getSimpleName() + GenMapperProcessor.SUFFIX;
//    String voName = typeElement.getSimpleName() + VoCodeGenProcessor.SUFFIX;
//    String queryName = typeElement.getSimpleName() + GenQueryProcessor.QUERY_SUFFIX;
//    String creatorName = typeElement.getSimpleName() + CreatorCodeGenProcessor.SUFFIX;
//    String updaterName = typeElement.getSimpleName() + GenUpdaterProcessor.SUFFIX;
//    String createRequestName =
//        typeElement.getSimpleName() + GenCreateRequestProcessor.CREATE_REQUEST_SUFFIX;
//    String updateRequestName =
//        typeElement.getSimpleName() + GenUpdateRequestProcessor.UPDATE_REQUEST_SUFFIX;
//    String queryRequestName =
//        typeElement.getSimpleName() + GenQueryRequestProcessor.QUERY_REQUEST_SUFFIX;
//    String responseName = typeElement.getSimpleName() + GenResponseProcessor.RESPONSE_SUFFIX;
//    String feignName = typeElement.getSimpleName() + GenFeignProcessor.FEIGN_SUFFIX;
//    String controllerName = typeElement.getSimpleName() + GenControllerProcessor.CONTROLLER_SUFFIX;
//    context.setServiceClassName(serviceName);
//    context.setRepositoryClassName(repositoryName);
//    context.setMapperClassName(mapperName);
//    context.setVoClassName(voName);
//    context.setQueryClassName(queryName);
//    context.setCreatorClassName(creatorName);
//    context.setUpdaterClassName(updaterName);
//    context.setImplClassName(implName);
//    context.setCreateClassName(createRequestName);
//    context.setUpdateClassName(updateRequestName);
//    context.setQueryRequestClassName(queryRequestName);
//    context.setResponseClassName(responseName);
//    context.setFeignClassName(feignName);
//    context.setControllerClassName(controllerName);
//    Optional.ofNullable(typeElement.getAnnotation(GenCreator.class)).ifPresent(anno -> {
//      context.setCreatorPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenUpdater.class)).ifPresent(anno -> {
//      context.setUpdaterPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenQuery.class)).ifPresent(anno -> {
//      context.setQueryPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenVo.class)).ifPresent(anno -> {
//      context.setVoPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenRepository.class)).ifPresent(anno -> {
//      context.setRepositoryPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenMapper.class)).ifPresent(anno -> {
//      context.setMapperPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenService.class)).ifPresent(anno -> {
//      context.setServicePackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenServiceImpl.class)).ifPresent(anno -> {
//      context.setImplPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenCreateRequest.class)).ifPresent(anno -> {
//      context.setCreatePackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenUpdateRequest.class)).ifPresent(anno -> {
//      context.setUpdatePackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenQueryRequest.class)).ifPresent(anno -> {
//      context.setQueryRequestPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenResponse.class)).ifPresent(anno -> {
//      context.setResponsePackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenFeign.class)).ifPresent(anno -> {
//      context.setFeignPackageName(anno.pkgName());
//    });
//    Optional.ofNullable(typeElement.getAnnotation(GenController.class)).ifPresent(anno -> {
//      context.setControllerPackageName(anno.pkgName());
//    });
//    return context;
//  }

  /**
   * 获取父类
   *
   * @param element
   * @return
   */
  public TypeElement getSuperClass(TypeElement element) {
    TypeMirror parent = element.getSuperclass();
    if (parent instanceof DeclaredType) {
      Element elt = ((DeclaredType) parent).asElement();
      if (elt instanceof TypeElement) {
        return (TypeElement) elt;
      }
    }
    return null;
  }

  public void addSetterAndGetterMethod(TypeSpec.Builder builder,
      Set<VariableElement> variableElements) {
    for (VariableElement ve : variableElements) {
      TypeName typeName = TypeName.get(ve.asType());
      FieldSpec.Builder fieldSpec = FieldSpec
          .builder(typeName, ve.getSimpleName().toString(), Modifier.PRIVATE)
          .addAnnotations(getAnnotationSpec(ve,false,typeName));
      builder.addField(fieldSpec.build());
    }
  }

  public void addGetListParamMetHod(TypeSpec.Builder builder,
                                    Set<VariableElement> variableElements,boolean isPage) {
    if (isPage) {
      List<String> fieldName = new ArrayList<>();
      fieldName.add("page");
      fieldName.add("limit");

      List<AnnotationSpec> annotationSpec = getAnnotationSpec("当前页面", "page", "当前页面不为空");

      FieldSpec.Builder pageField = FieldSpec
              .builder(TypeName.INT, fieldName.get(0), Modifier.PRIVATE)
              .addAnnotations(annotationSpec);
      builder.addField(pageField.build());


      annotationSpec =getAnnotationSpec("当前页面大小","limit","当前页面大小不能空");
      FieldSpec.Builder limitField = FieldSpec
              .builder(TypeName.INT, fieldName.get(1), Modifier.PRIVATE)
              .addAnnotations(annotationSpec);
      builder.addField(limitField.build());


    }

    for (VariableElement ve : variableElements) {
      TypeName typeName = TypeName.get(ve.asType());
      FieldSpec.Builder fieldSpec = null;
      if (!ve.getSimpleName().contentEquals("serialVersionUID")) {
        fieldSpec = FieldSpec
                .builder(typeName, ve.getSimpleName().toString(), Modifier.PRIVATE)
                        .addAnnotations(getAnnotationSpec(ve,true,typeName));
        builder.addField(fieldSpec.build());
      }

    }
  }


  private  List<AnnotationSpec> getAnnotationSpec(String apiModelProperty,String jsonProperty,String validPropertySpec )
  {
    AnnotationSpec pageModelPropertySpec = AnnotationSpec.builder(ApiModelProperty.class)
            .addMember("value", "$S", apiModelProperty).build();
    AnnotationSpec pagePropertySpec = AnnotationSpec.builder(JsonProperty.class).
            addMember("value","$S",jsonProperty).build();
    AnnotationSpec pageValidPropertySpec = AnnotationSpec.builder(NotNull.class).
            addMember("message","$S",validPropertySpec).build();
    return  List.of(pageModelPropertySpec,pagePropertySpec,pageValidPropertySpec);
  }

  private List<AnnotationSpec> getAnnotationSpec(VariableElement ve,boolean isValid,TypeName typeName)
  {
    if (ve.getAnnotation(ApiModelProperty.class)==null&&ve.getAnnotation(JsonProperty.class)==null&&ve.getAnnotation(TableId.class)==null)
    {
       return  Collections.EMPTY_LIST;
    }
    AnnotationSpec apiModelPropertySpec = AnnotationSpec.builder(ApiModelProperty.class).addMember("value", "$S", ve.getAnnotation(ApiModelProperty.class).value()).build();
    AnnotationSpec jsonPropertySpec = AnnotationSpec.builder(JsonProperty.class).addMember("value", "$S", ve.getAnnotation(TableField.class)==null?ve.getAnnotation(TableId.class).value():ve.getAnnotation(TableField.class).value()).build();

    List<AnnotationSpec> annotationSpecList = new ArrayList<>(List.of(apiModelPropertySpec,jsonPropertySpec));
    if (isValid)
    {
      String suffix="不能为空";
      AnnotationSpec validSpec = AnnotationSpec.builder(NotBlank.class).addMember("message", "$S", ve.getAnnotation(ApiModelProperty.class).value()+suffix).build();
      annotationSpecList.add(validSpec);
    }
    if (typeName.toString().equals("java.util.Date"))
    {
      AnnotationSpec timePropertySpec = AnnotationSpec.builder(JsonFormat.class)
              .addMember("pattern", "$S", "yyyy-MM-dd HH:mm:ss")
              .addMember("timezone","$S","GMT+8")
              .build();
      annotationSpecList.add(timePropertySpec);
    }

    return annotationSpecList;
  }


  /**
   * 应用转化器
   * @param builder
   * @param variableElements
   */
  public void addSetterAndGetterMethodWithConverter(TypeSpec.Builder builder,
      Set<VariableElement> variableElements) {
    for (VariableElement ve : variableElements) {
      TypeName typeName;
      if (Objects.nonNull(ve.getAnnotation(TypeConverter.class))) {
        //这里处理下泛型的情况，比如List<String> 这种，TypeConverter FullName 用逗号分隔"java.lang.List
        String fullName = ve.getAnnotation(TypeConverter.class).toTypeFullName();
        Iterable<String> classes = Splitter.on(",").split(fullName);
        int size = Iterables.size(classes);
        if(size > 1){
          //泛型生成像这样
          //ParameterizedTypeName.get(ClassName.get(JsonObject.class), ClassName.get(String.class))
          typeName = ParameterizedTypeName.get(ClassName.bestGuess(Iterables.get(classes,0)),ClassName.bestGuess(Iterables.get(classes,1)));
        }else {
          typeName = ClassName.bestGuess(ve.getAnnotation(TypeConverter.class).toTypeFullName());
        }
      } else {
        typeName = TypeName.get(ve.asType());
      }
      FieldSpec.Builder fieldSpec = FieldSpec
          .builder(typeName, ve.getSimpleName().toString(), Modifier.PRIVATE)
              .addAnnotation(AnnotationSpec.builder(ApiModelProperty.class)
                      .addMember("value", "$S", getFieldDesc(ve))
              .build());
      builder.addField(fieldSpec.build());
      String fieldName = getFieldDefaultName(ve);
      MethodSpec.Builder getMethod = MethodSpec.methodBuilder("get" + fieldName)
          .returns(typeName)
          .addModifiers(Modifier.PUBLIC)
          .addStatement("return $L", ve.getSimpleName().toString());
      MethodSpec.Builder setMethod = MethodSpec.methodBuilder("set" + fieldName)
          .returns(void.class)
          .addModifiers(Modifier.PUBLIC)
          .addParameter(typeName, ve.getSimpleName().toString())
          .addStatement("this.$L = $L", ve.getSimpleName().toString(),
              ve.getSimpleName().toString());
      builder.addMethod(getMethod.build());
      builder.addMethod(setMethod.build());
    }
  }


  protected void addIdSetterAndGetter(TypeSpec.Builder builder){
    MethodSpec.Builder getMethod = MethodSpec.methodBuilder("getId")
        .returns(ClassName.get(Long.class))
        .addModifiers(Modifier.PUBLIC)
        .addStatement("return $L", "id");
    MethodSpec.Builder setMethod = MethodSpec.methodBuilder("setId")
        .returns(void.class)
        .addModifiers(Modifier.PUBLIC)
        .addParameter(TypeName.LONG,"id")
        .addStatement("this.$L = $L", "id","id");
    builder.addMethod(getMethod.build());
    builder.addMethod(setMethod.build());
  }

  protected String getFieldDesc(VariableElement ve) {
    return Optional.ofNullable(ve.getAnnotation(FieldDesc.class))
        .map(s -> s.name()).orElse(ve.getSimpleName().toString());
  }

  protected String getFieldDefaultName(VariableElement ve) {
    return ve.getSimpleName().toString().substring(0, 1).toUpperCase() + ve.getSimpleName()
        .toString().substring(1);
  }


  public void genJavaSourceFile(String packageName, String pathStr,
      TypeSpec.Builder typeSpecBuilder) {
    TypeSpec typeSpec = typeSpecBuilder.build();
    JavaFile javaFile = JavaFile
        .builder(packageName, typeSpec)
        .addFileComment("---Auto Generated by Only4Play ---")
        .build();
//    System.out.println(javaFile);
    String packagePath =
        packageName.replace(".", File.separator) + File.separator + typeSpec.name + ".java";
    try {
      Path path = Paths.get(pathStr);
      File file = new File(path.toFile().getAbsolutePath());
      if(!file.exists()){
        return;
      }
      String sourceFileName = path.toFile().getAbsolutePath() + File.separator + packagePath;
      File sourceFile = new File(sourceFileName);
      if (sourceFile.exists()) {
          sourceFile.delete();
      }
      javaFile.writeTo(file);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public TypeSpec.Builder getSourceType(String sourceName, String packageName,
      String superClassName) {
    TypeSpec.Builder sourceBuilder = TypeSpec.classBuilder(sourceName)
        .superclass(ClassName.get(packageName, superClassName))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Data.class);
    return sourceBuilder;
  }

  public TypeSpec.Builder getSourceTypeWithConstruct(TypeElement e, String sourceName,
      String packageName, String superClassName) {
    MethodSpec.Builder constructorSpecBuilder = MethodSpec.constructorBuilder()
        .addParameter(TypeName.get(e.asType()), "source")
        .addModifiers(Modifier.PUBLIC);
    constructorSpecBuilder.addStatement("super(source)");
    TypeSpec.Builder sourceBuilder = TypeSpec.classBuilder(sourceName)
        .superclass(ClassName.get(packageName, superClassName))
        .addModifiers(Modifier.PUBLIC)
        .addMethod(MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PUBLIC)
            .build())
        .addMethod(constructorSpecBuilder.build())
        .addAnnotation(Data.class);
    return sourceBuilder;
  }


  protected void genJavaFile(String packageName, TypeSpec.Builder typeSpecBuilder) {
    JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build())
        .addFileComment("---Auto Generated by Only4Play ---").build();
    try {
      javaFile.writeTo(ProcessingEnvironmentHolder.getEnvironment().getFiler());
    } catch (IOException e) {
      ProcessingEnvironmentHolder.getEnvironment().getMessager()
          .printMessage(Kind.ERROR, e.getMessage());
    }
  }

}
