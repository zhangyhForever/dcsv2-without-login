package com.zicms.common.beetl.function;

import org.beetl.core.Context;
import org.beetl.core.Function;

import java.util.Arrays;

/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/26
 * @ Description  : what to do ...
 */
public class TestFunction implements Function {
    @Override
    public Object call(Object[] objects, Context context) {
        context.getCurrentTag().getHtmlAttribute("p");
        System.out.println(Arrays.toString(objects));
        return "testFunction";
    }
}
