package com.company.jdbc;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 21:10
 **/
public class MemberDao extends JdbcTmplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from member";
        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setName(rs.getString("name"));
                member.setAddr(rs.getString("addr"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                return member;
            }
        }, null);
    }
}
