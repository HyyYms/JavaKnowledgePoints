package com.company.jdbc;

import java.sql.ResultSet;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 20:54
 **/
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
