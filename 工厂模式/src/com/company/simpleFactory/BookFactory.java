package com.company.simpleFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 16:46
 **/
class BookFactory {
    // 利用字符串
/*    Book createBook(String name) {
        if ("Java".equals(name)) {
            return new JavaBook();
        } else if ("Python".equals(name)) {
            return new PythonBook();
        } else {
            return null;
        }
    }*/

    // 利用反射——通过类名
/*    public Book createBook(String className) {
        if (!(null == className || "".equals(className))) {
            try {
                return (Book) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }*/

    // 利用反射——通过类
    public Book createBook(Class<? extends Book> clazz) {
        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
