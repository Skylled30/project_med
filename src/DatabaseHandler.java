import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void addVitamin(Vitamins vitamins){
        String insert = "INSERT INTO " + Const.VITAMINS_TABLE + " (" + Const.VITAMINS_NAME + ", " +
                Const.VITAMINS_COMPANY + ", " + Const.VITAMINS_PRICE + ", " + Const.VITAMINS_DATA + ", " +
                Const.VITAMINS_MAIN_ELEMENT + ") " +
                "VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, vitamins.getName());
            preparedStatement.setString(2, vitamins.getCompany());
            preparedStatement.setDouble(3, vitamins.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println();
        }
    }

    public ArrayList<Pharmacy> getUser(){
        String query = "SELECT * FROM user";
        ArrayList<Pharmacy> vitamins = new ArrayList<>();

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int index = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String company = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                String data = resultSet.getString(5);
                String mainElement = resultSet.getString(6);
                Vitamins vitamins1 = new Vitamins(name, company, price, data, mainElement);
                vitamins.add(vitamins1);
            }
            return vitamins;

        } catch (SQLException e) {
            System.out.println("Ошибка при выолнеии запроса!");
        }
        return null;
    }

    public void getData(ArrayList<Pharmacy> medicinesDatabase){
        String dataVitamin = "SELECT * FROM user";

        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(dataVitamin);
            while(resultSet.next()){
                int index = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String company = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                String data = resultSet.getString(5);
                String mainElement = resultSet.getString(6);
                medicinesDatabase.add(new Vitamins(name, company, price, data, mainElement));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
