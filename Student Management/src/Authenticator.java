import java.sql.*;
import java.util.Objects;

public class Authenticator {
    private final String url = "jdbc:postgresql://localhost:8080/postgres"; //"ENTER_URL_HERE";
    private final String userName = "postgres"; // "ENTER_YOUR_USERNAME_HERE";
    private final String password = "Baloney@1"; //"ENTER_PASSWORD_HERE";
    private Connection connection;

    private final String userID;
    private final String userPass;

    public void init(){
        try{
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS CREDENTIALS" +
                            "(id varchar(16) UNIQUE, password varchar(16))");
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Authenticator(String userName, String password){
        userID = userName;
        userPass = password;

        init();
    }

    public boolean logInUser(){
        try{
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = connection.prepareStatement("SELECT password FROM CREDENTIALS WHERE id = ? ");
            st.setString(1,userID);
            ResultSet set = st.executeQuery();
            if(set.next()){
                if(Objects.equals(set.getString(1),userPass)){
                    System.out.println("SIGNED IN SUCCESSFULLY");
                    return true;
                }
                else{
                    System.out.println("INCORRECT PASSWORD");
                }
            }
            else{
                System.out.println("USER NOT FOUND");
            }
            st.close();

        }
        catch (SQLException e){
            System.out.println("STATE "+e.getSQLState());
            e.printStackTrace();
        }
        return false;
    }

    public boolean addUser(){
        try{
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = connection.prepareStatement("INSERT INTO CREDENTIALS" +
                    " (id, password) VALUES( ? , ?)");
            st.setString(1,userID);
            st.setString(2,userPass);
            st.execute();
            st.close();
            System.out.println("SIGNED IN SUCCESSFULLY");
            return true;
        }
        catch (SQLException e){
            if(Objects.equals(e.getSQLState(),"23505")){
                e.printStackTrace();
                System.out.println("USER ALREADY EXISTS. TRY LOGGING IN");
            }
            else{
                System.out.println("STATE : "+e.getSQLState());
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean checkIfUserExists(){
        try{
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = connection
                    .prepareStatement("SELECT id FROM CREDENTIALS WHERE id = '?' ");
            st.setString(1,userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                System.out.print(rs.getString(1));
            }
            rs.close();
            st.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
//23505
//42P01
//