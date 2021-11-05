package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Boolean active = TRUE;

    //connect to database
    public static Connection getConnection(){

        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","farai","faraimunashe");
            return conn;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }

    public static void main(String[] args) {

        while (active==TRUE)
        {
            System.out.println("CHOOSE OPTION FROM MENU: \n 1) Add Live Stock \n 2) Add Gender \n 3) Add Births  \n 4) Add Goat Vaccination Details" +
                    "\n 5) Search Livestock \n 6) Update Livestock \n 7) Delete Livestock \n 8) Get Livestock Age");
            int option = scanner.nextInt();
            switch (option)
            {
                case 1:
                    addFunction();
                    break;

                case 2:
                    addGender();
                    break;

                case 3:
                    addBirthsYacho();
                    break;

                case 4:
                    vaccinateGoats();
                    break;

                case 5:
                    searchLivestock();
                    break;

                case 6:
                    editStock();
                    break;

                case 7:
                    deleteStock();
                    break;


                case 8:
                    getAge();
                    break;

                case 9:
                    active = FALSE;
                    break;

                default:
                    break;
            }
        }
    }



    //all other functions
    public static void addLivestock(String dob, String dod, String sex, String status, Integer age){

        Connection conn = getConnection();
        String query = "INSERT INTO table_name (dob, dod, sex, age) VALUES ('"+ dob+"','"+dod+"', '"+sex+"', '"+age+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }

    }

    //add Goats
    public static void addGoats(String dob, String sex, String status)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO goats (dob, sex, status) VALUES ('"+ dob+"', '"+sex+"', '"+status+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add pigs
    public  static void addPigs(Integer weight, Integer feed, String status, Integer change, String dobChange, Integer ConsPerWeight)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO pigs (weight, feed, status, change, dobChange, -ConsPerWeight) VALUES ('"+weight+"', '"+feed+"', '"+status+"', '"+change+"', '"+dobChange+"', '"+ConsPerWeight+"'))))";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add Male Goats
    public static void addMaleGoats(Integer stock_id, String firstMate)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO maleGoats (stock_id, first_mate) VALUES ('"+stock_id+"', '"+firstMate+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add Female Goats
    public static void addFemaleGoats(Integer stock_id)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO femaleGoats (stock_id) VALUES ('"+stock_id+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add Female Pigs
    public static void addFemalePigs(Integer stock_id)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO femalePigs (stock_id) VALUES ('"+stock_id+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add Male Pigs
    public static void addMalePigs(Integer stock_id, String firstMate)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO malePigs (stock_id, firstMate) VALUES ('"+stock_id+"', '"+firstMate+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add goats vaccination
    public static void addgoatVaccination(Integer stock_id, String DateOfVaccination, String TypeOfVaccination)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO goatVaccination (stock_id, DateOfVaccine, TypeOfVaccine) VALUES ('"+stock_id+"', '"+DateOfVaccination+"', '"+TypeOfVaccination+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //add births
    public static void addBirths(Integer stockId, String dob, Integer numberOfBabies)
    {
        Connection conn = getConnection();
        String query = "INSERT INTO births (stock_id, dob, number_ofBabies) VALUES ('"+stockId+"', '"+dob+"', '"+numberOfBabies+"')";
        Statement st;

        try{

            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //adding function yacho
    public static void  addFunction()
    {
        System.out.println("CHOOSE OPTION FROM Live Stock menu: \n 1) Add Goat \n 2) Add Pig");
        int opt = scanner.nextInt();

        if (opt == 1)
        {
            System.out.println("____Enter Goat Data____");

            System.out.println("Enter DOB: ");
            String dob = scanner.next();
            String dod = "0000-00-00";
            System.out.println("Enter Sex: ");
            String sex = scanner.next();
            System.out.println("Enter Age: ");
            Integer age = scanner.nextInt();
            System.out.println("Enter Status: ");
            String status = scanner.next();

            addLivestock(dob, dod, sex, status, age);
            addGoats(dob, sex, status);
            System.out.println("Successfully added a goat!!");


        }
        else if(opt == 2)
        {
            System.out.println("____Enter Pig Data____");

            System.out.println("Enter Weight: ");
            Integer weight = scanner.nextInt();
            System.out.println("Enter Feed: ");
            Integer feed = scanner.nextInt();
            System.out.println("Enter DOB: ");
            String dob = scanner.next();
            String dod = "0000-00-00";
            System.out.println("Enter Sex: ");
            String sex = scanner.next();
            System.out.println("Enter Age: ");
            Integer age = scanner.nextInt();
            System.out.println("Enter Status: ");
            String status = scanner.next();
            System.out.println("Enter Change: ");
            Integer change = scanner.nextInt();
            System.out.println("Enter Dob Change: ");
            String dobChange = scanner.next();
            System.out.println("Enter Cons Per Weight: ");
            Integer consperweight = scanner.nextInt();

            addLivestock(dob, dod, sex, status, age);
            addPigs(weight, feed, status, change, dobChange, consperweight);
            System.out.println("Successfully added Pigs");

        }
        else
        {
            System.out.println("Option Not Valid");
        }
    }

    //adding gender to live Stock
    public static void addGender()
    {
        System.out.println("CHOOSE OPTION FROM Livestock Gender menu: \n 1) Add Female Goat \n 2) Add Female Pig \n 3) Add Male Goat \n 4) Add Male Pig");
        int opt = scanner.nextInt();

        if(opt == 1)
        {
            System.out.println("____Adding female goats____");
            System.out.println("Enter ID: ");
            Integer stock_id = scanner.nextInt();
            addFemaleGoats(stock_id);
            System.out.println("successfully added a female goat!!");
        }
        else if (opt == 2)
        {
            System.out.println("____Adding female pigs____");
            System.out.println("Enter ID: ");
            Integer stock_id = scanner.nextInt();
            addFemalePigs(stock_id);
            System.out.println("successfully added a female pigs!!");
        }
        else if(opt == 3)
        {
            System.out.println("____Adding male goats____");
            System.out.println("Enter stock ID: ");
            Integer stock_id = scanner.nextInt();
            System.out.println("Enter first mate date: ");
            String firstMate = scanner.next();
            addMaleGoats(stock_id, firstMate);
            System.out.println("successfully added a male goat");
        }
        else if (opt == 4)
        {
            System.out.println("____Adding male pigs____");
            System.out.println("Enter stock ID: ");
            Integer stock_id = scanner.nextInt();
            System.out.println("Enter first mate date: ");
            String firstMate = scanner.next();
            addMalePigs(stock_id, firstMate);
            System.out.println("successfully added a male pig");
        }
        else
        {
            System.out.println("Option not valid");
        }
    }

    //adding the births yacho
    public static void addBirthsYacho()
    {
        System.out.println("____Entering Animal Births____");
        System.out.println("Enter Stock ID: ");
        Integer stockId = scanner.nextInt();
        System.out.println("Enter DOB: ");
        String dob = scanner.next();
        System.out.println("Enter number of babies: ");
        Integer nob = scanner.nextInt();

        addBirths(stockId, dob, nob);
        System.out.println("Successfully added births");

    }

    //adding the goat vaccination yacho
    public static void vaccinateGoats()
    {
        System.out.println("____vaccinated goat____");
        System.out.println("Enter stock ID: ");
        Integer stock_id = scanner.nextInt();
        System.out.println("Enter Date of Vaccination: ");
        String dov = scanner.next();
        System.out.println("Enter Type of Vaccination: ");
        String tov = scanner.next();

        addgoatVaccination(stock_id, dov, tov);
        System.out.println("successfully added vaccination details");
    }

    //real dob search
    public static void realDobSearch(String dob)
    {
        Connection conn = getConnection();
        String query = "SELECT * FROM table_name WHERE dob = '"+dob+"'";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println("stock ID: " + rs.getInt("stockID"));
                System.out.println("DOB: " + rs.getString("dob"));
                System.out.println("Sex: " + rs.getString("sex"));
                System.out.println("Age: " + rs.getInt("age"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    //real dob search
    public static void realPigAgeSearch(Integer age)
    {
        Connection conn = getConnection();
        String query = "SELECT * FROM malePigs WHERE age = '"+age+"'";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println("male Pig ID: " + rs.getInt("male_pigID"));
                System.out.println("stock ID: " + rs.getString("stockID"));
                System.out.println("Mate Date: " + rs.getString("firstMate"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public static void realGoatAgeSearch(Integer age)
    {
        Connection conn = getConnection();
        String query = "SELECT * FROM maleGoats WHERE age = '"+age+"'";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println("male Goat ID: " + rs.getInt("male_goatID"));
                System.out.println("stock ID: " + rs.getString("stockID"));
                System.out.println("Mate Date: " + rs.getString("firstMate"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public static void checkStockToUdate(Integer id)
    {
        Connection conn = getConnection();
        String query = "SELECT * FROM table_name WHERE stockID = '"+id+"'";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            if(rs.next() == false)
            {
                System.out.println("No data found with given ID");
                active = FALSE;
            }

            while(rs.next()){
                System.out.println("Proceed Editing...");
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public static void searchLivestock()
    {
        System.out.println("Select Search Criteria: \n 1)Search Livestock By DOB \n 2) Search Male Pig by Age \n 3) Search Male Goat by Age");
        Integer opt = scanner.nextInt();
        if(opt == 1)
        {
            System.out.println("Enter Livestock DOB: ");
            String dob = scanner.next();
            realDobSearch(dob);
        }
        else if(opt == 2)
        {
            System.out.println("Enter Pig Age: ");
            Integer age = scanner.nextInt();
            realPigAgeSearch(age);
        }
        else if (opt == 3)
        {
            System.out.println("Enter Goat Age: ");
            Integer age = scanner.nextInt();
            realGoatAgeSearch(age);
        }
        else
        {
            System.out.println("Option not valid");
        }
    }


    private static  void delete(Integer id, Integer opt)
    {
        Connection conn = getConnection();

        if(opt == 1)
        {
            try {
                PreparedStatement st;
                st = conn.prepareStatement("DELETE FROM table_name WHERE id = '"+id+"'");
                st.executeUpdate();
                System.out.println("successfully deleted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(opt == 2)
        {
            try {
                PreparedStatement st;
                st = conn.prepareStatement("DELETE FROM pigs WHERE id = '"+id+"'");
                st.executeUpdate();
                System.out.println("successfully deleted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (opt == 3)
        {
            try {
                PreparedStatement st;
                st = conn.prepareStatement("DELETE FROM goats WHERE id = '"+id+"'");
                st.executeUpdate();
                System.out.println("successfully deleted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Option not found");
        }
    }


    public static void editStock()
    {
        Connection conn = getConnection();
        Statement st;

        System.out.println("Enter stock ID: ");
        Integer id = scanner.nextInt();
        checkStockToUdate(id);

        System.out.println("Enter DOB: ");
        String dob = scanner.next();
        String dod = "0000-00-00";
        System.out.println("Enter Sex: ");
        String sex = scanner.next();
        System.out.println("Enter Age: ");
        Integer age = scanner.nextInt();
        System.out.println("Enter Status: ");
        String status = scanner.next();

        try {
            st = conn.createStatement();
            st.executeUpdate("UPDATE table_name SET dob = '" + dob + "', dod = '" + dod + "', dod = '" + sex + "', dod = '" + age + "' WHERE stockID = '" + id + "'");
            System.out.println("successfully updated");
        }catch (SQLException e)
        {
            System.out.println("error: " + e);
        }
    }

    public static void deleteStock()
    {
        Integer opt;
        System.out.println("Select option to delete: \n 1) Livestock \n 2) Pigs \n 3) Goats");
        opt = scanner.nextInt();
        if (opt == 1) {
            System.out.println("Enter Id to Delete");
            Integer id = scanner.nextInt();
            delete(id, opt);
        }
        else if (opt == 2) {
            System.out.println("Enter Id to Delete");
            Integer id = scanner.nextInt();
            delete(id, opt);
        }
        else if (opt == 3) {
            System.out.println("Enter Id to Delete");
            Integer id = scanner.nextInt();
            delete(id, opt);
        }
        else
        {
            System.out.println("option not found");
        }
    }

    public static int getAge()
    {
        System.out.println("Enter Stock ID: ");
        Integer id = scanner.nextInt();
        Integer age;

        Connection conn = getConnection();
        String query = "SELECT * FROM table_name WHERE id = '"+id+"'";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                return rs.getInt("age");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
}
