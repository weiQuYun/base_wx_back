package com.wqy.wx.back;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.nio.file.Paths;

/**
 * 成都微趣云网络科技有限公司
 *
 * @ClassName: GeneratorCode
 * @Description: TODO
 * @Author licm
 * @Date 2020/3/9 21:35
 * @Version V1.0
 * @Explain :
 **/
public class GeneratorCode {
    private static String packageName = "com.wqy.BaseBoot.plus2";
    private static String outDir = "E:/myspace/WaterBack/src/main/java";
    private static String entity = "entity";
    private static String mapper = "mapper";
    private static String service = "service";
    private static String impl = "service.impl";
    private static String controller = "controller";
    private static String xml = "mapper.xml";
    private static boolean isOverEntity = true;
    private static boolean isOverController = false;
    private static boolean isOverService = false;
    private static boolean isOverServiceImpl = false;
    private static boolean isOverMapper = false;
    private static boolean isOverXml = false;
    private static String entityVM = "/entity.java.vm";
    private static String controllerVM = "/controller.java.vm";
    private static String serviceVM = "";
    private static String serviceImplVM = "";
    private static String mapperVM = "";
    private static String xmlVM = "";
    private static String [] baseDir = {entity, mapper, service, impl, controller};
    public static void main(String[] args) {
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = true;
        generateByTables(serviceNameStartWithI, packageName,
                "menu");
    }



    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/water?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(false)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                //修改替换成你需要的表名，多个表名传数组
                .setInclude(tableNames)
                // 自定义实体父类
//                .setSuperEntityClass("com.wqy.BaseBoot.waterdao.BaseEntity")
                // 自定义实体，公共字段
                .setSuperEntityColumns( "id", "add_time","update_time", "add_user_id","update_user_id","del_status" )
//                .setTableFillList(tableFillList)
                .setEntityBooleanColumnRemoveIsPrefix(true);
        config.setActiveRecord(true)
                .setAuthor("licm")
                .setOutputDir(outDir)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setFileOverride(true)
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columList;
                .setBaseColumnList(true)
                .setOpen(false);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        PackageConfig pcf = initPackage();
        TemplateConfig tc = initTemplateConfig(packageName);
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(pcf)
                .setTemplate(tc)
                .execute();
    }

    /**
     * 根据自己的需要，修改哪些包下面的 要覆盖还是不覆盖
     * @param packageName
     */
    private static TemplateConfig initTemplateConfig(String packageName) {
        TemplateConfig tc = new TemplateConfig();
        for(String tmp : baseDir) {
            initVM(tc);
            File file = new File(Paths.get(outDir, String.join("/", packageName.split("\\.")), tmp).toString());
            String[] list = file.list();
            if(list != null && list.length > 0) {
                if(!isOverController) {
                    tc.setController(null);
                }
                if(!isOverService) {
                    tc.setService(null);
                }
                if(!isOverServiceImpl) {
                    tc.setServiceImpl(null);
                }
                if(!isOverEntity) {
                    tc.setEntity(null);
                }
                if(!isOverMapper) {
                    tc.setEntity(null);
                }
                if(!isOverXml) {
                    tc.setXml(null);
                }
            }
        }
        return tc;

    }



    private static void initVM(TemplateConfig tc) {
        if(stringIsNotNull(entityVM)) {
            tc.setEntity(entityVM);
        }
        if(stringIsNotNull(mapperVM)) {
            tc.setMapper(mapperVM);
        }
        if(stringIsNotNull(serviceImplVM)) {
            tc.setServiceImpl(serviceImplVM);
        }
        if(stringIsNotNull(serviceVM)) {
            tc.setService(serviceVM);
        }
        if(stringIsNotNull(xmlVM)) {
            tc.setXml(xmlVM);
        }
        if(stringIsNotNull(controllerVM)) {
            tc.setController(controllerVM);
        }
    }
    /**
     * 简单判断字符串是不是为空
     * @param s
     * @return
     */
    private static boolean stringIsNotNull(String s) {
        if(null != s && !s.equals("") && s.length() > 0 && s.trim().length() > 0) {
            return true;
        }
        return false;
    }
    /**
     * 初始化包目录配置
     * @return
     */
    private static PackageConfig initPackage() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName);
        packageConfig.setService(service);
        packageConfig.setServiceImpl(impl);
        packageConfig.setController(controller);
        packageConfig.setEntity(entity);
        packageConfig.setXml(xml);
        return packageConfig;
    }
}
