import film.MoviesService;
import film.motphim.MotPhimModel;
import film.motphim.MotPhimParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MotPhimParser motPhimParser = new MotPhimParser();
        MoviesService moviesService=new MoviesService();
//        MoviesService moviesService=new MoviesService();
//        List<String> linkArray = motPhimParser.parserListLink(url);// Ghi du lieu vao file(database)
//        for(String link:linkArray){
//            MotPhimModel phim = motPhimParser.parserDetail(link);
//            moviesService.writeMoviesToFile(phim);
//            System.out.println(phim.getName());
//        }

        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("---------------------------MENU-------------------------------------------------------");
            System.out.println("Enter 1: Insert/ Update data to DataBase");
            System.out.println("Enter 2:Search film by Name");
            System.out.println("Enter 3:Search film by YearIssue");
            System.out.println("Enter 4:Search film by Type");
            System.out.println("Enter 5:Search film by Director");
            System.out.println("Enter 6:Search film by Cast");
            System.out.println("Enter 7:Exit");
            String choose=sc.nextLine();
            switch (choose){
                case "1":
                    motPhimParser.parserAllMovies();
                    break;
                case "2":
                    System.out.println("Enter the name of film");
                    String name=sc.nextLine();
                    moviesService.findByName(name);
                    break;
                case "3":
                    System.out.println("Enter the year issue of film");
                    String year=sc.nextLine();
                    moviesService.findByYearIssue(year);
                    break;
                case "4":
                    System.out.println("Enter the type of film");
                    String type=sc.nextLine();
                    moviesService.findByType(type);
                    break;
                case "5":
                    System.out.println("Enter the director of film");
                      String director = sc.nextLine();
                      moviesService.findByDirector(director);
                    break;
                case "6":
                    System.out.println("Enter the cast of film");
                    String cast = sc.nextLine();
                    moviesService.findByCast(cast);
                    break;
                case "7":
                    System.out.println("GoodBye ^_^");
                    return;
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
