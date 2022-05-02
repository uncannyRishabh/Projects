import java.sql.*;

@SuppressWarnings({"FieldCanBeLocal"})
public class DBUtils {
    private final String url = "jdbc:postgresql://localhost:8080/postgres"; //"ENTER_URL_HERE";
    private final String userName = "postgres"; // "ENTER_YOUR_USERNAME_HERE";
    private final String password = "Baloney@1"; //"ENTER_PASSWORD_HERE";
    private Connection connection;

//    private int mId;
//    private int mAge;
//    private String mName;
//    private String mAddress;

    public DBUtils(){
        try {
            connection= DriverManager.getConnection(url, userName, password);
            PreparedStatement st = connection
                    .prepareStatement("CREATE TABLE IF NOT EXISTS STUDENT(Stu_id int, Stu_Name varchar(30), Stu_Age int, Stu_address varchar(50))");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
//            System.exit(0);
            e.printStackTrace();
        }
    }

    public void addStudent(int sId, int sAge, String sName, String sAddress){
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO student (Stu_id,Stu_Name,Stu_Age,Stu_address) VALUES (?, ?, ?, ?)");
            st.setInt(1, sId);
            st.setString(2, sName);
            st.setInt(3, sAge);
            st.setString(4, sAddress);
            st.executeUpdate();
            st.close();

            System.out.println("INSERTED ["+sId+", "+sName+", "+sAge+", "+sAddress+"] SUCCESSFULLY");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int sid,String sname,int sage,String saddress) {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM student WHERE stu_id = ?");
            st.setInt(1, sid);
            st.execute();
            ResultSet rs = st.getResultSet();
            if(!rs.next()) {
                System.out.println("Student Not Found!");
            }
            else {
                PreparedStatement stmt = connection.prepareStatement("UPDATE student set stu_Name=?,stu_age=?,stu_address=? where Stu_id=?");
                stmt.setString(1,sname);
                stmt.setInt(2,sage);
                stmt.setString(3,saddress);
                stmt.setInt(4, sid);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Updated Successfully...");
            }
            st.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM student WHERE stu_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();

            System.out.println("DELETED "+id+" SUCCESSFULLY");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getStudentById(int id) {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM student WHERE stu_id = ?");
            st.setInt(1, id);
            st.execute();
            ResultSet rs = st.getResultSet();
            if(!rs.next()) {
                System.out.println("Student Not Found!");
            }
            else {
                System.out.printf(" |%-12s|%-20s|%-14s|%s %n ", " Student-ID ", " Student-Name ", " Student-Age ", " Student-Address");
                System.out.printf("|%-12s|%-20s|%-14s|%s %n ", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            st.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents(){
        try{
            Statement st = connection.createStatement();
            st.execute("select * from student");
            ResultSet rs = st.getResultSet();
            System.out.printf(" |%-12s|%-20s|%-14s|%s %n ", " Student-ID ", " Student-Name ", " Student-Age ", " Student-Address");
            while (rs.next()) {
                System.out.printf("|%-12s|%-20s|%-14s|%s %n "
                        , rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getStudentByName(String sName) {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM student WHERE stu_name = ?");
            st.setString(1, sName);
            ResultSet rs = st.executeQuery();
            System.out.printf(" |%-12s|%-20s|%-14s|%s %n ", " Student-ID ", " Student-Name ", " Student-Age ", " Student-Address");
            if(!rs.next()) {
                System.out.println("Student Not Found!");
            }
            else{
                System.out.printf("|%-12s|%-20s|%-14s|%s %n "
                        , rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            st.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


}
