import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.getDbConnection();


    }
}

