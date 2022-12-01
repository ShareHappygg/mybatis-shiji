package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@RestController
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>


   @Autowired
   private  ${entity}Service ${table.entityPath}Service;

  /**
   * 获取${table.comment}基本信息列表
   * @param param
   * @return
   */
   @PostMapping("/list")
   @ApiOperation("获取${entity}基本信息列表")
   public ResultApi<${entity}Vo> list(@RequestBody @Validated Get${entity}ListParam param)
   {
      IPage<${entity}Vo> entityIPage = ${table.entityPath}Service.list(param);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("list",entityIPage.getRecords());
      jsonObject.put("count",entityIPage.getTotal());
      return ResultApi.success(jsonObject);
    }

    /**
    * 修改指定${table.comment}详情信息
    * @param param
    * @return
    */
    @PostMapping("/update")
    @ApiOperation("修改指定${table.comment}详情信息")
    public  ResultApi  update(@RequestBody @Validated Update${entity}Param param)
    {
        ${table.entityPath}Service.update${entity}(param);
        return  ResultApi.success(ResultApi.successDone(ImStateCode.SUCCESS_UPDATE));
    }

    /**
    * 删除指定${table.comment}详情信息
    * @param param
    * @return
    */
    @PostMapping("/delete")
    @ApiOperation("批量删除${table.comment}详情信息")
    public  ResultApi delete(@RequestBody @Validated DelUserParam param)
    {
        ${table.entityPath}Service.delete${entity}(param);
        return  ResultApi.success(ResultApi.successDone(ImStateCode.SUCCESS_DELETE));
    }

  }
</#if>
