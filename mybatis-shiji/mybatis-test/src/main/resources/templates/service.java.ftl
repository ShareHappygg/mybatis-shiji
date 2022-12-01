package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 添加指定${table.comment}信息
    * @param param
    * @return
    */
    void add${entity}(Add${entity}Param param);

    /**
    * 修改指定${table.comment}详情信息
    * @param param
    * @return
    */
    void update${entity}(Update${entity}Param param);

    /**
    * 分页获取${table.comment}信息列表
    * @param param
    * @return
    */
    IPage<${entity}> get${entity}List(GetList${entity}Param param);

    /**
    * 批量删除${table.comment}信息列表
    * @param param
    * @return
    */
    void delete${entity}(Delete${entity}Param param);

}
</#if>
