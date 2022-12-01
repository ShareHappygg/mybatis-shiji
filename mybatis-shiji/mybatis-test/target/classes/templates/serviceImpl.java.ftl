package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {


    /**
    * 添加指定${table.comment}信息
    * @param param
    * @return
    */
    @Override
    @Transactional
    public  void add${entity}(Add${entity}Param param)
    {
        ${entity} entity = new ${entity}();
        BeanUtil.copyProperties(param,entity);
        baseMapper.insert(entity);
    }

    /**
    * 修改指定${table.comment}详情信息
    * @param param
    * @return
    */
    @Override
    @Transactional
    void update${entity}(Update${entity}Param param)
    {
        ${entity}  entity= baseMapper.selectOne(new QueryWrapper<${entity}>().eq("user_id",""));
        baseMapper.updateById(entity);
    }

    /**
    * 分页获取${entity}基本信息列表
    * @param param
    * @return
    */
    @Override
    public IPage<${entity}> get${entity}List(GetUserListParam param) {

        Page<${entity}> page = new Page<>(param.getPage(),param.getLimit());
        IPage<${entity}> entityPage = baseMapper.selectPage(page,null);
        return  entityPage;
    }

    /**
    * 批量删除${table.comment}信息列表
    * @param param
    * @return
    */
    void delete${entity}(Delete${entity}Param param)
    {
        baseMapper.delete${entity}List(param.getIdsList());
    }






}
</#if>
