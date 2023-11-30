import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class JDBCExample {

    // Method to establish a database connection
    private static Connection getConnection() throws Exception {
        // Load database connection properties from the property file
        Properties props = new Properties();
        InputStream input = JDBCExample.class.getClassLoader().getResourceAsStream("database.properties");
        props.load(input);

        // Extract properties
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        String dbName = props.getProperty("dbName");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        // Load JDBC driver and create a connection
        Class.forName(driver);
        return DriverManager.getConnection(url + dbName, username, password);
    }

    public static void main(String[] args) {
        try {
            // Q.1: Using JDBC, create a table called CONTACT_INFO
            createTable();

            // Q.2: Using JDBC, ALTER the above table to add PHONE and EMAIL fields
            alterTable();

            // Q.3: Using JDBC, insert data into the CONTACT_INFO table
            insertData();

            // Q.4: Using JDBC, update city and state values and display the number of rows updated
            updateData();

            // Q.5: Using executeQuery method of the statement class, select data and display formatted output
            selectData();

            // Q.6: Using result set, get metadata information
            getMetadata();

            // Q.7: Create, insert, select, and drop a table named student using prepared statements
            prepareStatements();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // SQL statement to create the CONTACT_INFO table
            String createTableSQL = "CREATE TABLE CONTACT_INFO (" +
                    "CONTACT_ID INTEGER NOT NULL PRIMARY KEY," +
                    "FIRST_NAME VARCHAR(20) NOT NULL," +
                    "MI CHAR(1) NULL," +
                    "LAST_NAME VARCHAR(30) NOT NULL," +
                    "STREET VARCHAR(50) NOT NULL," +
                    "CITY VARCHAR(30) NOT NULL," +
                    "STATE VARCHAR(30) NOT NULL," +
                    "ZIP VARCHAR(30) NOT NULL)";
            statement.executeUpdate(createTableSQL);
        }
    }

    private static void alterTable() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // SQL statement to add PHONE and EMAIL fields to the CONTACT_INFO table
            String alterTableSQL = "ALTER TABLE CONTACT_INFO ADD PHONE VARCHAR(16), ADD EMAIL VARCHAR(50)";
            statement.executeUpdate(alterTableSQL);
        }
    }

    private static void insertData() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // SQL statement to insert data into the CONTACT_INFO table
            String insertDataSQL = "INSERT INTO CONTACT_INFO VALUES (1, 'John', 'D', 'Doe', '123 Main St', 'City1', 'State1', '12345')";
            statement.executeUpdate(insertDataSQL);
        }
    }

    private static void updateData() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // SQL statement to update city and state values
            String updateDataSQL = "UPDATE CONTACT_INFO SET CITY = 'NewCity', STATE = 'NewState' WHERE CONTACT_ID = 1";
            int rowsUpdated = statement.executeUpdate(updateDataSQL);
            System.out.println("Number of rows updated: " + rowsUpdated);
        }
    }

    private static void selectData() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // SQL statement to select data from the CONTACT_INFO table
            String selectDataSQL = "SELECT FIRST_NAME, LAST_NAME, PHONE, EMAIL FROM CONTACT_INFO";
            ResultSet resultSet = statement.executeQuery(selectDataSQL);

            while (resultSet.next()) {
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String phone = resultSet.getString("PHONE");
                String email = resultSet.getString("EMAIL");

                // Display formatted output
                System.out.printf("Name: %s %s, Phone: %s, Email: %s%n", firstName, lastName, phone, email);
            }
        }
    }

    private static void getMetadata() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // SQL statement to select data from the CONTACT_INFO table
            String selectDataSQL = "SELECT * FROM CONTACT_INFO";
            ResultSet resultSet = statement.executeQuery(selectDataSQL);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Column Count: " + columnCount);

            for (int i = 1; i <= columnCount; i++) {
                // Display metadata information
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Column Type: " + metaData.getColumnType(i));
                System.out.println("Column Label: " + metaData.getColumnLabel(i));
            }
        }
    }

    private static void prepareStatements() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");
             PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM student");
             Statement dropStatement = connection.createStatement()) {

            // Create table student
            String createTableSQL = "CREATE TABLE student (" +
                    "studentid INT, " +
                    "name VARCHAR(255), " +
                    "course VARCHAR(255), " +
                    "grade VARCHAR(255))";
            dropStatement.executeUpdate("DROP TABLE IF EXISTS student");
            dropStatement.executeUpdate(createTableSQL);

            // Insert data into the student table
            insertStatement.setInt(1, 1);
            insertStatement.setString(2, "John");
            insertStatement.setString(3, "Math");
            insertStatement.setString(4, "A");
            insertStatement.executeUpdate();

            // Select and display data from the student table
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentid");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                String grade = resultSet.getString("grade");

                // Display data
                System.out.printf("Student ID: %d, Name: %s, Course: %s, Grade: %s%n", studentId, name, course, grade);
            }

            // Drop the student table
            dropStatement.executeUpdate("DROP TABLE student");
            connection.commit();
        }
    }
}
