package club.mrzero.spring.transaction;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * Spring编程式事物
 * @author: Chenhao
 * @create: 2019-10-08 11:41
 */
public class MyTransaction {

    private JdbcTemplate jdbcTemplate;
    private DataSourceTransactionManager txManager;
    private DefaultTransactionDefinition txDefinition;
    private String insert_sql = "insert into account (balance) values ('100')";

    public void save() {

        // 1、初始化jdbcTemplate
        DataSource dataSource = getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);

        // 2、创建物管理器
        txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);

        // 3、定义事物属性
        txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // 3、开启事物
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        // 4、执行业务逻辑
        try {
            jdbcTemplate.execute(insert_sql);
            //int i = 1/0;
            jdbcTemplate.execute(insert_sql);
            txManager.commit(txStatus);
        } catch (DataAccessException e) {
            txManager.rollback(txStatus);
            e.printStackTrace();
        }

    }

    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://cdb-ri7g4af7.gz.tencentcdb.com:10003/study?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&verifyServerCertificate=false&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("abc123++");
        return dataSource;
    }

}