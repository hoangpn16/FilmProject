package film;

import film.motphim.MotPhimModel;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MoviesService implements MoviesInterface {
    @Override
    public void writeToDB(MotPhimModel motPhimModel) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        Connection connection = null;
        try {
                connection = DriverManager
                        .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
                Statement selectStmt = connection.createStatement();
                ResultSet rs=selectStmt.executeQuery("select *from `javacore`.`movies` where `Link`='"+motPhimModel.getLink()+"'");
                String tmp=null;
                while(rs.next()){
                    tmp=rs.getString(11);
                }
                if(tmp == null) {
                    String sql = "insert into `javacore`.`movies` (`Name`,`Avatar`,`Status`,`Director`,`Type`,`Total Episodes`,`Cast`,`Country`,`YearIssue`,`Link`,`Content`) " +
                            "values ('" + motPhimModel.getName() + "','" + motPhimModel.getAvatar() + "','" + motPhimModel.getStatus() + "'" +
                            ",'" + motPhimModel.getDirector() + "','" + motPhimModel.getType() + "','" + motPhimModel.getTotalepisodes() + "'" +
                            ",'" + motPhimModel.getCast() + "','" + motPhimModel.getCountry() + "','" + motPhimModel.getYearissue() + "','" + motPhimModel.getLink() + "','" + motPhimModel.getContent() + "')";
                    selectStmt.execute(sql);
                    System.out.println("inserting");
                }else{
                    selectStmt.execute("update `javacore`.`movies` set `Name`='"+motPhimModel.getName()+"',`Avatar`='"+motPhimModel.getAvatar()+"',`Status`='"+motPhimModel.getStatus()+"',`Total Episodes`='"+motPhimModel.getTotalepisodes()+"' " +
                            "where `Link`='"+motPhimModel.getLink()+"'");
                    System.out.println("updating");
                }

            } catch (SQLException e) {
                System.out.println(e);
                return;
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    @Override
    public void findByName(String name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            Statement selectStmt = connection.createStatement();

            String sql="select *from `javacore`.`movies` where Name LIKE '%"+name+"%'";
            ResultSet resultSet=selectStmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.print("Nội dung:");
                System.out.println(resultSet.getString(12));
                System.out.print("Diễn viên:");
                System.out.println(resultSet.getString(8));
                System.out.print("Số tập:");
                System.out.println(resultSet.getString(7));
                System.out.print("Link:");
                System.out.println(resultSet.getString(11));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void findByYearIssue(String year) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            Statement selectStmt = connection.createStatement();

            String sql="select *from `javacore`.`movies` where YearIssue LIKE '%"+year+"%'";
            ResultSet resultSet=selectStmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.print("Phim:");
                System.out.println(resultSet.getString(2));
                System.out.print("Nội dung:");
                System.out.println(resultSet.getString(12));
                System.out.print("Diễn viên:");
                System.out.println(resultSet.getString(8));
                System.out.print("Số tập:");
                System.out.println(resultSet.getString(7));
                System.out.print("Link:");
                System.out.println(resultSet.getString(11));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void findByType(String type){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            Statement selectStmt = connection.createStatement();

            String sql="select *from `javacore`.`movies` where Type LIKE '%"+type+"%'";
            ResultSet resultSet=selectStmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.print("Phim:");
                System.out.println(resultSet.getString(2));
                System.out.print("Nội dung:");
                System.out.println(resultSet.getString(12));
                System.out.print("Diễn viên:");
                System.out.println(resultSet.getString(8));
                System.out.print("Số tập:");
                System.out.println(resultSet.getString(7));
                System.out.print("Link:");
                System.out.println(resultSet.getString(11));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void findByDirector(String director){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            Statement selectStmt = connection.createStatement();

            String sql="select *from `javacore`.`movies` where Director LIKE '%"+director+"%'";
            ResultSet resultSet=selectStmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.print("Phim:");
                System.out.println(resultSet.getString(2));
                System.out.print("Nội dung:");
                System.out.println(resultSet.getString(12));
                System.out.print("Diễn viên:");
                System.out.println(resultSet.getString(8));
                System.out.println("Số tập:");
                System.out.println(resultSet.getString(7));
                System.out.print("Link:");
                System.out.println(resultSet.getString(11));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void findByCast(String cast) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            Statement selectStmt = connection.createStatement();

            String sql="select *from `javacore`.`movies` where Cast LIKE '%"+cast+"%'";
            ResultSet resultSet=selectStmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.print("Phim:");
                System.out.println(resultSet.getString(2));
                System.out.print("Nội dung:");
                System.out.println(resultSet.getString(12));
                System.out.print("Diễn viên:");
                System.out.println(resultSet.getString(8));
                System.out.println("Số tập:");
                System.out.println(resultSet.getString(7));
                System.out.print("Link:");
                System.out.println(resultSet.getString(11));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
