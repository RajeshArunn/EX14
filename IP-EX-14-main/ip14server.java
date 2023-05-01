package ip14;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;

@WebService(serviceName = "ip14server")
public class ip14server {

    @WebMethod(operationName = "getDetailsByName")
    public String getDetailsByName(@WebParam(name = "name") String name) {
        int p = 0;
        String d = "";
        try {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/product");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from products where product_name='"+name+"'");
            while (rs.next()) {
                    p = rs.getInt(2);
                    d = rs.getString(3);
            }

        } catch (Exception e) {

        }
        if (p != 0 && d != null) {
            return "Name:" + name + "\n" + "Price:" + Integer.toString(p) + "\n" + "Category:" + d;
        } else {
            return "no data found";
        }
    }

    @WebMethod(operationName = "getDetailsByCategory")
    public String getDetailsByCategory(@WebParam(name = "category") String category) {
        int p = 0;
        String d = "";
        try {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/product");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from products where product_category='"+category+"'");
            while (rs.next()) {
                d = rs.getString(1);
                p = rs.getInt(2);
                
            }

        } catch (Exception e) {

        }
        if (p != 0 && d != null) {
            return "Name:" + d + "\n" + "Price:" + Integer.toString(p) + "\n" + "Category:" + category;
        } else {
            return "no data found";
        }
    }
}
