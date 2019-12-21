package spring.com;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class FactoryJDBC implements ImplDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void creat(String name, Integer code) {
        String SQL = "insert into Cafe (name,code) values (?,?)";
        jdbcTemplate.update(SQL, name, code);
        System.out.printf("=======NEW : " + name + "  " + code + "===========");
    }

    public DataCafe getDataCafe(Integer id) {
        String SQL = "select * from Cafe where id = ? ";
        DataCafe dataCafe = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new MappingDao());
        return dataCafe;
    }

    public List<DataCafe> geListDataCafe() {
        String SQL = "select * from Cafe";
        List<DataCafe> dataCafes = jdbcTemplate.query(SQL,new MappingDao());
        return dataCafes;
    }

    public void update(Integer id, Integer code) {
    String SQL = "update Cafe set code =? where id =?";
    jdbcTemplate.update(SQL,code,id);
    }

    public void delete(Integer id) {
     String SQL = "delete from Cafe where id = ? ";
     jdbcTemplate.update(SQL,id);
    }
}
