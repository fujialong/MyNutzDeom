package cn.com.jero.mynutzdeom;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class MainSetup implements Setup {

    private final static Log log = Logs.get();

    @Override
    public void init(NutConfig nc) {
        MainConfig conf = nc.getIoc().get(MainConfig.class, "conf");
        nc.setAttribute("rs", conf.getAppRs());
        nc.setAttribute("appnm", conf.get("app-name", "MyNutzDeom"));
        log.infof("MyNutzDeom version %s", MyNutzDeom.VERSION);
        Ioc ioc = nc.getIoc();
       // Dao dao = ioc.get(Dao.class);
        System.out.println("注意啦,要创建表了,我的天那!");
       // Daos.createTablesInPackage(dao, "cn.com.jero.mynutzdeom.bean", false);
    }

    @Override
    public void destroy(NutConfig nc) {}
}
