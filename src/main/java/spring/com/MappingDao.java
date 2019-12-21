package spring.com;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappingDao implements RowMapper<DataCafe> {
    public DataCafe mapRow(ResultSet resultSet, int i) throws SQLException {
        DataCafe dataCafe = new DataCafe();
        dataCafe.setId(resultSet.getInt("id"));
        dataCafe.setName(resultSet.getString("name"));
        dataCafe.setCode(resultSet.getInt("code"));

        return dataCafe;
    }
}
