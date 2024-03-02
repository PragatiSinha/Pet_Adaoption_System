package Shopkeeper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

class main {
    public void login() {
        System.out.println("Welcome to Pet Adoption System\nPlease choose Your Profile\n1. Shopkeeper\n2. Customer");
        Scanner scr = new Scanner(System.in);
        int choice = scr.nextInt();
        String exit;

        while (true) {
            if (choice == 1) {
                System.out.println("Welcome " + choice);
                Connection con = null;
                try {
                    con = DBConnections.createDBConnection();
                    if (con != null) {
                        System.out.println("Enter your Username");
                        String adminname = scr.next();
                        System.out.println("Enter the Password");
                        String pass = scr.next();

                        String query = "INSERT INTO login(AdminUsername , AdminPassword) VALUES (?,?)";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, adminname);
                        preparedStatement.setString(2, pass);

                        preparedStatement.executeUpdate();
                        System.out.println("Shopkeeper LoggedIn Successful");
                        System.out.println("Choose the Category");
                        System.out.println("1. Dogs");
                        System.out.println("2. Cats");
                        System.out.println("3. Other-Pets");
                       // System.out.println("5. Approval-List");
                        int categoryChoice = scr.nextInt();
                        if (categoryChoice == 1) {
                            System.out.println("What Function do you want to Perform");
                            System.out.println("1. Add Dog");
                            System.out.println("2. Delete Dog");
                            System.out.println("3. Update Dog Information");
                            System.out.println("4. List Dog");
                            int funChoice = scr.nextInt();
                            Dog obj = new Dog();
                            OtherPets obj4 = new OtherPets();
                            switch (funChoice) {
                                case 1:
                                    obj.add();
                                    break;
                                case 2:
                                    obj.delete();
                                    break;
                                case 3:
                                    obj.updateInfo();
                                    break;
                                case 4:
                                    obj.view();
                                    break;
                                default:
                                    System.out.println("Something went wrong, try again");
                                    break;
                            }
                        }
                        else if (categoryChoice==2){
                            System.out.println("What Function do you want to Perform");
                            System.out.println("1. Add Cat");
                            System.out.println("2. Delete Cat");
                            System.out.println("3. Update Cat Information");
                            System.out.println("4. List Cat");
                            int funChoiceCat = scr.nextInt();
                            Cat obj1= new Cat();
                            switch (funChoiceCat) {
                                case 1:
                                    obj1.add();
                                    break;
                                case 2:
                                    obj1.delete();
                                    break;
                                case 3:
                                    obj1.updateInfo();
                                    break;
                                case 4:
                                    obj1.view();
                                    break;
                                default:
                                    System.out.println("Something went wrong, try again");
                                    break;
                            }
                        }
                        else if(categoryChoice==3){
                            System.out.println("What Function do you want to Perform");
                            System.out.println("1. Add Pet");
                            System.out.println("2. Delete Pet");
                            System.out.println("3. Update Pet Information");
                            System.out.println("4. List Pet");
                            int funChoiceBird = scr.nextInt();
                            OtherPets obj3= new OtherPets();
                            switch (funChoiceBird) {
                                case 1:
                                    obj3.add();
                                    break;
                                case 2:
                                    obj3.delete();
                                    break;
                                case 3:
                                    obj3.updateInfo();
                                    break;
                                case 4:
                                    obj3.view();
                                    break;
                                default:
                                    System.out.println("Something went wrong, try again");
                                    break;
                            }
                            System.out.println("Operation Performed Successfully. Do you want to Perform other function (y/n)?");
                            String datainput = scr.next();
                            if (datainput.equalsIgnoreCase("n")) {
                                break;
                            } else {
                                System.out.println("Invalid Choice Try-Again");
                            }

                        }


                        }
                        }



                 catch (SQLException e) {
                    System.out.println("Data Not Inserted: " + e.getMessage());
                }
            } else if (choice == 2) {
                System.out.println("Welcome " + choice);
                Connection con = null;
                try {
                    con = DBConnections.createDBConnection();
                    if (con != null) {
                        System.out.println("Enter the username");
                        String username = scr.next();
                        System.out.println("Enter the Password");
                        String userpass = scr.next();

                        String query1 = "INSERT INTO login(Userusername , UserPassword) VALUES (?,?)";
                        PreparedStatement preparedStatement = con.prepareStatement(query1);
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, userpass);

                        preparedStatement.executeUpdate();
                        System.out.println("Customer LoggedIn Successful");
                        customer obj2= new customer();
                        System.out.println("Which Category would you like to browse\n" +
                                "1.Dog" +
                                "2.Cat" +
                                 "3.Other-Animals");
                        String userinput=scr.nextLine();
                        switch(userinput) {
                            case "1":
                                obj2.viewDog();
                                customer.userInfo();
                                break;
                            case "2":
                                obj2.viewCat();
                                customer.userInfo();
                                break;
                            case "3":
                                obj2.viewOtherPet();
                                customer.userInfo();
                                break;

                        }
                    } else {
                        System.out.println("Invalid Choice Try-Again");
                    }

                } catch (SQLException e) {
                    System.out.println("Data Not Inserted: " + e.getMessage());
                }
            }
        }
    }
}

interface Animal{
    void add();
    void delete();
    void  updateInfo();
    void view();

}
 class Dog implements Animal {
    private String name;
    private String Breed;
    private String age;
    private String sex;
    private String description;


    Scanner scr = new Scanner(System.in);

     public void add() {

        while (true) {
            Connection con = null;
            try {
                con = DBConnections.createDBConnection();


                if (con != null) {
                    Scanner scr = new Scanner(System.in);
                    System.out.println("Add Dog Name");
                    String userName = scr.nextLine();
                    System.out.println("Add Breed");
                    String breedType = scr.nextLine();
                    System.out.println("Add Age");
                    String ageOfDog = scr.nextLine();
                    System.out.println("Add sex");
                    String dogSex = scr.nextLine();
                    System.out.println("Add Description");
                    String dis = scr.nextLine();

                    String query = "INSERT INTO dog (name, breed, age, sex, description) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, breedType);
                    preparedStatement.setString(3, ageOfDog);
                    preparedStatement.setString(4, dogSex);
                    preparedStatement.setString(5, dis);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully into the dog table!");
                    } else {
                        System.out.println("Data insertion failed!");
                    }
                } else {
                    System.out.println("Failed to establish a database connection!");
                }
            } catch (SQLException e) {
                System.out.println("Database operation failed: " + e.getMessage());
            } finally {
                // Close the connection in the finally block to ensure it's always closed, whether an exception occurs or not
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
            System.out.println("Do you want to Add more Data y/n");
            String addData = scr.nextLine();
            if (addData.equals("n")) {
                break;
            }
        }
    }


   public  void delete() {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("Enter the name of Dog u want to Remove");
            String delname = scr.nextLine();
            Connection con = null;
            try {
                con = DBConnections.createDBConnection();
                if (con != null) {
                    String query = "DELETE FROM dog WHERE name=?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, delname);
                    int rowsDeleted = preparedStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Data Deleted Successfully");
                    } else {
                        System.out.println("No matching data found to delete.");
                    }
                    System.out.println("Do you want to Delete more Data y/n");
                    String deleteData = scr.nextLine();
                    if (deleteData.equals("n")) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Data not Deleed");
            }
        }


    }

   public  void updateInfo() {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("Enter the Name of dog whose data you want to update");
            String updateData = scr.nextLine();
            System.out.println("Enter the updated Breed");
            String breedupdate = scr.nextLine();
            System.out.println("Enter the updated Age");
            String sexupdate = scr.nextLine();
            System.out.println("Enter the updated Sex");
            String ageupdate = scr.nextLine();
            System.out.println("Enter the updated Description");
            String disupdate = scr.nextLine();
            Connection con = null;
            try {
                con = DBConnections.createDBConnection();
                if (con != null) {
                    String query = "UPDATE dog SET breed=?,age=?,sex=?description=?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, breedupdate);
                    preparedStatement.setString(2, sexupdate);
                    preparedStatement.setString(3, ageupdate);
                    preparedStatement.setString(4, disupdate);
                    int dataUpdateded = preparedStatement.executeUpdate();
                    if (dataUpdateded > 0) {
                        System.out.println("Data Updated Successfully");
                    } else {
                        System.out.println("Something Went Wrong");

                    }
                    System.out.println("Do you want to Update more Data y/n");
                    String addData = scr.nextLine();
                    if (addData.equals("n")) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
    }


   public  void view() {
        Connection con = null;
        ResultSet viewResult = null;
        try {
            con = DBConnections.createDBConnection();
            if (con != null) {
                String query = "SELECT * FROM dog";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                viewResult = preparedStatement.executeQuery();
                while (viewResult.next()) {
                    String name = viewResult.getString("name");
                    String breed = viewResult.getString("breed");
                    String age = viewResult.getString("age");
                    String sex = viewResult.getString("sex");
                    String description = viewResult.getString("discription");

                    System.out.println("Name:" + name);
                    System.out.println("Breed:" + breed);
                    System.out.println("Age:" + age);
                    System.out.println("Sex:" + sex);
                    System.out.println("Description:" + description);
                    System.out.println("___________________________");

                }

            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong Please Try Again" + e.getMessage());
        }
    }


    }


class Cat extends Dog implements  Animal{
   public  void add(){
        Scanner scr = new Scanner(System.in);
        System.out.println("Add Cat Name");
        String catName = scr.nextLine();
        System.out.println("Add Breed");
        String breedType = scr.nextLine();
        System.out.println("Add Age");
        String ageOfCat = scr.nextLine();
        System.out.println("Add sex");
        String catSex = scr.nextLine();
        System.out.println("Add Description");
        String descrp = scr.nextLine();

        Connection con= null;
        try {
            con = DBConnections.createDBConnection();
            if (con != null) {
                String query = "INSERT INTO  cat (name,breed,age,sex,description) VALUES OF (?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                 preparedStatement.setString(1, catName);
                 preparedStatement.setString(2, breedType);
                preparedStatement.setString(1, ageOfCat);
                 preparedStatement.setString(1, catSex);
                 preparedStatement.setString(1, descrp);
                int outcome = preparedStatement.executeUpdate();
            }
        }
            catch(Exception e){
                System.out.println("Something Went wrong"+e.getMessage());

            }
    }
    public void delete() {
        while (true) {
            System.out.println("Enter the name of Cat whose Data you want to Delete");
            String catname = scr.nextLine();
            Connection con = null;
            try {

                con = DBConnections.createDBConnection();
                if (con != null) {
                    String query = "DELETE FROM cat WHERE (name=?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, catname);
                    int result = preparedStatement.executeUpdate();
                    if (result > 0) {
                        System.out.println("Data Deleted Successfully");
                    } else {
                        System.out.println("No matching Data Found to Delete");
                    }
                    System.out.println("Do you want to Delete more Data (y/n)");
                    String deldata = scr.nextLine();
                    if (deldata.equalsIgnoreCase("n")) {
                        break;

                    }
                }

            } catch (Exception e) {
                System.out.println("Something went Wrong " + e.getMessage());

            }
        }
    }
   public  void updateInfo(){
       System.out.println("Enter the Name of Cat whose Data you want to update");
       String catName=scr.nextLine();
       System.out.println("Add Breed");
       String catBreed = scr.nextLine();
       System.out.println("Add Age");
       String catAge =scr.nextLine();
       System.out.println("Add Sex");
       String catSex=scr.nextLine();
       System.out.println("Add Description");
       String catDes=scr.nextLine();
       Connection con =null;
       try{
           con=DBConnections.createDBConnection();
           if(con!=null){
               String query = "UPDATE cat SET breed=?,age=?,sex=?,description=?";
               PreparedStatement preparedStatement=con.prepareStatement(query);
               preparedStatement.setString(1,catBreed);
               preparedStatement.setString(2,catAge);
               preparedStatement.setString(3,catSex);
               preparedStatement.setString(4,catDes);
               int outcome=preparedStatement.executeUpdate();
               if(outcome>0){
                   System.out.println("Data Updated Successfully");
               }
               else{
                   System.out.println("Try Again");
               }



           }
       }
       catch(Exception e){
           System.out.println("Error Occured"+e.getMessage());
       }

    }
    public void view(){
       Connection con = null;
       ResultSet viewResult=null;
       try{
           con=DBConnections.createDBConnection();
           if(con!=null){
               String query= "SELECT * FRM cat";
               PreparedStatement preparedStatement=con.prepareStatement(query);
               viewResult = preparedStatement.executeQuery();
               while (viewResult.next()) {
                   String name = viewResult.getString("name");
                   String breed = viewResult.getString("breed");
                   String age = viewResult.getString("age");
                   String sex = viewResult.getString("sex");
                   String description = viewResult.getString("discription");

                   System.out.println("Name:" + name);
                   System.out.println("Breed:" + breed);
                   System.out.println("Age:" + age);
                   System.out.println("Sex:" + sex);
                   System.out.println("Description:" + description);
                   System.out.println("___________________________");


               }
       }

    }
       catch(Exception e){
           System.out.println("Something went Wrong"+e.getMessage());
       }

        }


}
class OtherPets implements Animal {
    public void add() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the Name of Pet");
        String birdName = scr.nextLine();
        System.out.println("Enter the Pet Breed");
        String birdBreed = scr.nextLine();
        System.out.println("Enter the Age of Pet");
        String birdAge = scr.nextLine();
        System.out.println("Enter the sex of Pet");
        String birdSex = scr.nextLine();
        System.out.println("Enter the Description of Pet");
        String birdDes = scr.nextLine();

        Connection con = null;
        con = DBConnections.createDBConnection();
        try {
            if (con != null) {
                String query = "INSERT INTO otheranimals(name,breed,age,sex,description) VALUE OF(?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, birdName);
                preparedStatement.setString(2, birdBreed);
                preparedStatement.setString(3, birdAge);
                preparedStatement.setString(4, birdSex);
                preparedStatement.setString(5, birdDes);
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    System.out.println("Data Added Successfully");

                }

            }

        } catch (Exception e) {
            System.out.println("Data Did Not Got Added" + e.getMessage());

        }
    }

    public void delete() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the Name of Pet whose Data you Want to Delete");
        String delBird = scr.nextLine();
        Connection con = null;

        try {
            con = DBConnections.createDBConnection();

            while (true) {

                if (con != null) {
                    String query = "DELETE FROM otheranimals WHERE (name=?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    int outcome = preparedStatement.executeUpdate();
                    if (outcome > 0) {
                        System.out.println("Data Deleted Successfully");
                    }
                    System.out.println("Do you want to Delete more Data??(y/n)");
                    String uchoice = scr.nextLine();
                    if (uchoice.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong Try Again!!!" + e.getMessage());
        }


    }

    public void updateInfo() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the name of Pet whose data you want to update");
        String petUpdate = scr.nextLine();
        System.out.println("Update Breed");
        String petBreed = scr.nextLine();
        System.out.println("Update Age ");
        String petAge = scr.nextLine();
        System.out.println("Update Sex");
        String petSex = scr.nextLine();
        System.out.println("Update Description");
        String petDes = scr.nextLine();
        Connection con = null;
        con = DBConnections.createDBConnection();
        try {
            if (con != null) {
                String query = "SELECT * FROM cat WHERE (name=?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, petBreed);
                preparedStatement.setString(2, petAge);
                preparedStatement.setString(3, petSex);
                preparedStatement.setString(4, petDes);
                int outcomes = preparedStatement.executeUpdate();
                if (outcomes > 0) {
                    System.out.println("Data Inserted Successfully");
                } else {
                    System.out.println("Something went Wrong");
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occured" + e.getMessage());
        }


    }

    public void view() {
        Scanner scr = new Scanner(System.in);
        Connection con = null;
        ResultSet view = null;
        con = DBConnections.createDBConnection();
        try {
            if (con != null) {
                String query = "SELECT * FROM otheranimals(name,breed,age,sex,description)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                while (view.next()) {
                    String name = view.getString("name");
                    String breed = view.getString("breed");
                    String age = view.getString("age");
                    String sex = view.getString("sex");
                    String description = view.getString("discription");

                    System.out.println("Name:" + name);
                    System.out.println("Breed:" + breed);
                    System.out.println("Age:" + age);
                    System.out.println("Sex:" + sex);
                    System.out.println("Description:" + description);
                    System.out.println("___________________________");

                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

    class customer {
        public static void userInfo() {
            Scanner scr = new Scanner(System.in);
            System.out.println("Register Yourself on Furry Friends  ");
            System.out.println("Enter Your Full Name");
            String name = scr.nextLine();
            System.out.println("Enter your Contact Number");
            int phoneNo = scr.nextInt();
            System.out.println("Enter your Email-id");
            String mailId = scr.nextLine();
            System.out.println("Thank-You for Your Details our team will contact you soon");

        }

        public void viewDog() {
            ResultSet view = null;
            Scanner scr= new Scanner(System.in);
            Connection con = null;
            try {
                con = DBConnections.createDBConnection();
                if (con != null) {
                    String query = "SELECT * FROM dog";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    view = preparedStatement.executeQuery();
                    while (view.next()) {
                        String name = view.getString("name");
                        String breed = view.getString("breed");
                        String age = view.getString("age");
                        String sex = view.getString("sex");
                        String des = view.getString("description");


                        System.out.println("Name:" + name);
                        System.out.println("Breed:" + breed);
                        System.out.println("Age:" + age);
                        System.out.println("Sex:" + sex);
                        System.out.println("Description:" + des);
                        System.out.println("_________________________");
                        System.out.println("");
                        System.out.println("Please Select the Name of Dog you would like to Adopt");
                        String userChoice = scr.nextLine();

                        String query1 = "SELECT * FROM dog WHERE name = ?";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query1);
                        preparedStatement1.setString(1, userChoice);

                        ResultSet chosenAnimal = preparedStatement1.executeQuery();

                        if (chosenAnimal.next()) {
                            String chosenName = chosenAnimal.getString("name");
                            String chosenBreed = chosenAnimal.getString("breed");
                            String chosenAge = chosenAnimal.getString("age");
                            String chosenSex = chosenAnimal.getString("sex");
                            String chosenDes = chosenAnimal.getString("description");

                            System.out.println("Chosen Dog Details:");
                            System.out.println("Name: " + chosenName);
                            System.out.println("Breed: " + chosenBreed);
                            System.out.println("Age: " + chosenAge);
                            System.out.println("Sex: " + chosenSex);
                            System.out.println("Description: " + chosenDes);
                        } else {
                            System.out.println("Animal with name " + userChoice + " not found.");
                        }
                        System.out.println("Please Confirm your Adoption (Yes/No)");
                        String userinput = scr.nextLine();
                        if (userinput.equalsIgnoreCase("yes")) {
                            System.out.println("We will Contact You Soon");
                        } else if (userinput.equalsIgnoreCase("No")) {
                            System.out.println("Thank-you for Browsing Hope we will Contact you Soon");
                        } else {
                            System.out.println("Please Enter a Valid Input");
                        }
                    }

                }

            } catch (Exception e) {
                System.out.println("Something Wennt Wrong Please Try again" + e.getMessage());
            }
        }

        void viewCat() {
            Connection con = null;
            ResultSet view = null;
            con = DBConnections.createDBConnection();
            try {
                if (con != null) {
                    String query = "SELECT * from cat";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    view = preparedStatement.executeQuery();
                    while (view.next()) {
                        String name = view.getString("name");
                        String breed = view.getString("breed");
                        String age = view.getString("age");
                        String sex = view.getString("sex");
                        String des = view.getString("description");


                        System.out.println("Name:" + name);
                        System.out.println("Breed:" + breed);
                        System.out.println("Age:" + age);
                        System.out.println("Sex:" + sex);
                        System.out.println("Description:" + des);
                        System.out.println("_________________________");
                        System.out.println("");
                        System.out.println("Please Select the Name of Cat you would like to Adopt");
                        Scanner scr= new Scanner(System.in);
                        String userChoice = scr.nextLine();

                        String query1 = "SELECT * FROM cat WHERE name = ?";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query1);
                        preparedStatement1.setString(1, userChoice);

                        ResultSet chosenAnimal = preparedStatement1.executeQuery();

                        if (chosenAnimal.next()) {
                            String chosenName = chosenAnimal.getString("name");
                            String chosenBreed = chosenAnimal.getString("breed");
                            String chosenAge = chosenAnimal.getString("age");
                            String chosenSex = chosenAnimal.getString("sex");
                            String chosenDes = chosenAnimal.getString("description");

                            System.out.println("Chosen Cat Details:");
                            System.out.println("Name: " + chosenName);
                            System.out.println("Breed: " + chosenBreed);
                            System.out.println("Age: " + chosenAge);
                            System.out.println("Sex: " + chosenSex);
                            System.out.println("Description: " + chosenDes);
                        } else {
                            System.out.println("Animal with name " + userChoice + " not found.");
                        }
                        System.out.println("Please Confirm your Adoption (Yes/No)");
                        String userinput = scr.nextLine();
                        if (userinput.equalsIgnoreCase("yes")) {
                            System.out.println("We will Contact You Soon");
                        } else if (userinput.equalsIgnoreCase("No")) {
                            System.out.println("Thank-you for Browsing Hope we will Contact you Soon");
                        } else {
                            System.out.println("Please Enter a Valid Input");
                        }
                    }

                }

            } catch (Exception e) {
                System.out.println("Something Went Wrong Please Try again" + e.getMessage());
            }
        }

        void viewOtherPet() {
            Connection con = null;
            ResultSet view = null;
            con = DBConnections.createDBConnection();
            try {
                if (con != null) {
                    String query = "SELECT & FROM other otheranimals";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    view = preparedStatement.executeQuery();
                    while (view.next()) {
                        String name = view.getString("name");
                        String breed = view.getNString("breed");
                        String age = view.getString("age");
                        String sex = view.getString("sex");
                        String des = view.getString("description");

                        System.out.println("Name:" + name);
                        System.out.println("Breed:" + breed);
                        System.out.println("Age:" + age);
                        System.out.println("Sex:" + sex);
                        System.out.println("Description:" + des);
                        System.out.println("_________________________");
                        System.out.println("");
                        System.out.println("Please Select the Name of Animal you would like to Adopt");
                        Scanner scr= new Scanner(System.in);
                        String userChoice = scr.nextLine();
                        String query1 = "SELECT * FROM cat WHERE name = ?";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query1);
                        preparedStatement1.setString(1, userChoice);

                        ResultSet chosenAnimal = preparedStatement1.executeQuery();

                        if (chosenAnimal.next()) {
                            String chosenName = chosenAnimal.getString("name");
                            String chosenBreed = chosenAnimal.getString("breed");
                            String chosenAge = chosenAnimal.getString("age");
                            String chosenSex = chosenAnimal.getString("sex");
                            String chosenDes = chosenAnimal.getString("description");

                            System.out.println("Chosen Cat Details:");
                            System.out.println("Name: " + chosenName);
                            System.out.println("Breed: " + chosenBreed);
                            System.out.println("Age: " + chosenAge);
                            System.out.println("Sex: " + chosenSex);
                            System.out.println("Description: " + chosenDes);
                        } else {
                            System.out.println("Animal with name " + userChoice + " not found.");
                        }
                        System.out.println("Please Confirm your Adoption (Yes/No)");
                        String userinput = scr.nextLine();
                        if (userinput.equalsIgnoreCase("yes")) {
                            System.out.println("We will Contact You Soon");
                        } else if (userinput.equalsIgnoreCase("No")) {
                            System.out.println("Thank-you for Browsing Hope we will Contact you Soon");
                        } else {
                            System.out.println("Please Enter a Valid Input");
                        }
                    }

                }
            } catch (Exception e) {
                System.out.println("Something Went Wrong Please Try again" + e.getMessage());
            }
        }
    }


    public class Admin {
        public static void main(String[] args) {
            main obj = new main();
            obj.login();


        }
    }



