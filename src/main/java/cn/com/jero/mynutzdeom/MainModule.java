package cn.com.jero.mynutzdeom;

import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Modules(scanPackage = true, packages = "cn.com.jero.mynutzdeom.modules")
@IocBy(type = ComboIocProvider.class,
        args = {"*js",
                "ioc",
                "*anno",
                "cn.com.jero.mynutzdeom.modules",
                "*tx",
                "*async"})
@SetupBy(MainSetup.class)
@ChainBy(args = {"chain"})
public class MainModule {}
