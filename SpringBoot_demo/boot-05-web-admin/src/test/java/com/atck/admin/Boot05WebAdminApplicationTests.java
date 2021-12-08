package com.atck.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    // @Autowired
    // SqlSessionFactory sqlSessionFactory;

    // @Autowired
    // RedisTemplate<String,String> redisTemplate;

    @Test
    void contextLoads()
    {
        String sql = "select count(*) from tbl_user";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);

        log.info("记录总数"+aLong.toString());

        log.info("数据源类型是{"+ dataSource.getClass() +"}");
    }

    // @Test
    // public void test()
    // {
    //     SqlSession sqlSession = sqlSessionFactory.openSession();
    //
    //     EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
    //
    //     Employee employee = mapper.selectEmpById(1);
    //
    //     log.info("employee:" + employee.toString());
    // }

    // @Test
    // public void test()
    // {
    //     List clientList = redisTemplate.getClientList();
    //
    //     ValueOperations valueOperations = redisTemplate.opsForValue();
    //
    //     valueOperations.set("k1","v12");
    //
    //     Object k1 = valueOperations.get("k1");
    //
    //     log.info(clientList.toString() + "------" + k1.toString());
    // }
}
