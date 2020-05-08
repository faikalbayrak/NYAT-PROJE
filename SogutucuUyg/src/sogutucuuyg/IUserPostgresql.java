
package sogutucuuyg;

import java.sql.Connection;
public interface IUserPostgresql {
    public User Scan(String username,String pass);
    public Connection Connect();
}
