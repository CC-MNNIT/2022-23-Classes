import java.sql.*;

public class Database {
    static Connection connection;

    public static void main(String[] args) {
        connection=getConnection();
        String empName;
        try {
            // Creating a statement
            Statement s=connection.createStatement();

            // Creating a query to insert values into the table
            String q1="insert into employee (empName,age,deptId) values ('Simran',22,2)";
            s.execute(q1);


            //SQL Injection: Let's say you have a query to get the details of the employee with a given name stored in the variable empName


            empName="'Abhyudita' or true";
            //If the given input is used as the empName the final query becomes : select * from employee where empName='Abhyudita' or true;
            // Since we have an OR condition in which one input is true, the where clause becomes true and the query will return the following result
            // Abhyudita 21 1
            // Saurabh 21 2
            // Utkarsh 22 3
            // Harsh 22 3

            String q3="select * from employee where empName= "+ empName;
            ResultSet resultSet=s.executeQuery(q3);
            while (resultSet.next()){
                System.out.println(resultSet.getString(2)+" "+resultSet.getInt(3)+ " "+resultSet.getInt(4));
            }

            //This way by using createStatement and concatenation it is very easy for a hacker to destroy your database by giving smart inputs.
            // This is called SQL injection

            //To avoid injection we will use parameterised queries using prepared statement

            String q2="select * from employee where empName=?";
            // The ? is a parameter whose values will be added at runtime
            PreparedStatement preparedStatement=connection.prepareStatement(q2);


            preparedStatement.setString(1 ,empName);
            //Here if we use the same empName value the prepared statement becomes select * from employee where empName='Abhyudita or true';
            // Note the difference from the previous query, here the empName becomes "Abhyudita or true" instead of "Abhyudita"
            System.out.println(preparedStatement);
            resultSet=preparedStatement.executeQuery();
            // On execution the table will be searched and no entry with empName= "Abhyudita or true" will be found and an empty resultset will be returned
            while (resultSet.next())System.out.println(resultSet.getString(2)+" "+resultSet.getInt(3)+ " "+resultSet.getInt(4));

            //Hence by using prepared statements we can avoid injection.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static Connection getConnection(){
        if(connection!=null)return connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dummy";
            connection= DriverManager.getConnection(url,"root","enter your password");
            System.out.println("Database Connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
