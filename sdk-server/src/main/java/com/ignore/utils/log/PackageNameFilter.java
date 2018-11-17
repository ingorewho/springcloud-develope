package com.ignore.utils.log;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:16 2018/11/17
 */
@Plugin(name = "PackageNameFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
public class PackageNameFilter extends AbstractFilter {
    //包名
    private String packgeName;

    public PackageNameFilter(String packgeName,Result match, Result mismatch) {
        super(match, mismatch);
        this.packgeName = packgeName;
    }

    @Override
    public Result filter(LogEvent event) {
        if(!"".equals(packgeName)){
            return event.getSource().getClassName().startsWith(packgeName) ? onMatch : onMismatch;
        }
        return Result.NEUTRAL;
    }
    @PluginFactory
    public static PackageNameFilter createFilter(@PluginAttribute("package") String packageName,
                                                 @PluginAttribute("onMatch")  Result match,
                                                 @PluginAttribute("onMismatch")  Result mismatch) {
        return new PackageNameFilter(packageName, match, mismatch);
    }
}
