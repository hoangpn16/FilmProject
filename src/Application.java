import Film.MotPhim.MotPhimModel;
import Film.MotPhim.MotPhimParser;
import Film.MoviesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        String url="https://motphim.net/phim-thuyet-minh.html";
        MotPhimParser motPhimParser = new MotPhimParser();
        MoviesService moviesService=new MoviesService();
        List<String> linkArray = motPhimParser.parserListLink(url);// Ghi du lieu vao file(database)
//        for(String link:linkArray){
//            MotPhimModel phim = motPhimParser.parserDetail(link);
//            moviesService.writeMoviesToFile(phim);
//            System.out.println(phim.getName());
//        }
        List<MotPhimModel> result = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("---------------------------MENU-------------------------------------------------------");
            System.out.println("Enter 1:Search by YearIssue");
            System.out.println("Enter 2:Search by Name");
            System.out.println("Enter 3:Search by Type");
            System.out.println("Enter 4:Search by Director");
            System.out.println("Enter 5:Search by Cast");
            System.out.println("Enter 6:Exit");
            String choose=sc.nextLine();
            switch (choose){
                case "1":
                    System.out.println("Nhap vao YearIssue:");
                    String yearissue = sc.nextLine();
                    result=moviesService.findByYearIssue(yearissue);
                    for(MotPhimModel model: result){
                        System.out.println(model);
                    }
                    break;
                case "2":
                    System.out.println("Nhap vao Name:");
                    String name=sc.nextLine();
                    result =moviesService.findByName(name);
                    for (MotPhimModel model: result){
                        System.out.println(model);
                    }
                    break;
                case "3":
                    System.out.println("Nhap vao Type:");
                    String type=sc.nextLine();
                    result=moviesService.findByType(type);
                    for(MotPhimModel model:result){
                        System.out.println(model);
                    }
                    break;
                case "4":
                    System.out.println("Nhap vao Director");
                    String director = sc.nextLine();
                    result=moviesService.findByDirector(director);
                    for(MotPhimModel model:result){
                        System.out.println(model);
                    }
                    break;
                case "5":
                    System.out.println("Nhap vao Cast");
                    String cast = sc.nextLine();
                    result=moviesService.findByCast(cast);
                    for(MotPhimModel model:result){
                        System.out.println(model);
                    }
                    break;
                case "6":
                    System.out.println("GoodBye");
                    return;
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
