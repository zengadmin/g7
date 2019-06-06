package com.fyqz.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成
 *
 * @author zengchao
 */
public class Generator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D://GeneratorCode");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(true);
        gc.setAuthor("zengchao");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setServiceImplName("%sServiceImpl");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1/renren_fast?characterEncoding=utf8");
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix("sys_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setTablePrefix(new String[] { "g11_" });// 此处可以修改为您的表前缀
         strategy.setExclude(new String[]{"test"}); // 排除生成的表
        strategy.setInclude(new String[]{"sys_user"});//需要生成的表
        // 自定义实体父类
        strategy.setSuperEntityClass("com.fyqz.common.core.BaseModel");
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(new String[]{"id"});
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("com.fyqz.common.core.BaseMapper");
        // 自定义 service 父类
        //strategy.setSuperServiceClass("com.fyqz.core.base.BaseService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("com.fyqz.common.core.BaseService");
        // 自定义 controller 父类
        strategy.setSuperControllerClass("com.fyqz.common.core.AbstractController");
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.fyqz.modules.sys");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("mapper.xml");
        pc.setServiceImpl("service.impl");
        pc.setService("service");
       // pc.setController("controller");
        mpg.setPackageInfo(pc);
        // 放置自己项目的 src/main/resources/tpl 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity("tpl/entity.java.vm");
        tc.setMapper("tpl/mapper.java.vm");
        tc.setXml("tpl/mapper.xml.vm");
        tc.setService("tpl/service.java.vm");
        tc.setServiceImpl("tpl/serviceImpl.java.vm");
        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
    }
}
