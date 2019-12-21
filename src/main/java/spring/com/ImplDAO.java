package spring.com;

import javax.sql.DataSource;
import java.util.List;

public interface ImplDAO {
    public void setDataSource(DataSource dataSource);
    public void creat(String name, Integer code);
    public DataCafe getDataCafe(Integer id);
    public List<DataCafe> geListDataCafe();
    public void update(Integer id, Integer code);
    public void delete(Integer id);
}
