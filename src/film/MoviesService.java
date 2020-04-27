//package film;
//
//import film.motphim.MotPhimModel;
//
//import java.io.*;
//import java.util.List;
//import java.util.ArrayList;
//
//public class MoviesService implements MoviesInterface {
//
//    // Tim kiem theo YearIssue
//   @Override
//    public List<MotPhimModel> findByYearIssue(String YearIssue) throws IOException {
//        List<MotPhimModel> response = new ArrayList<>();
//        File file;
//        FileReader fr = new FileReader("C:\\Users\\Phan Nho Hoang\\Desktop\\FilmProject\\hoangpn16-ProjectFilm\\data-film.text");
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        while (true) {
//            line = br.readLine();
//            if (line == null) {
//                break;
//            }
//            MotPhimModel model = new MotPhimModel();
//            String[] items = line.split(";");
//            for (String item : items) {
//                if (item.startsWith("Name:")) {
//                    model.setName(item.replace("Name:", ""));
//                }
//                if (item.startsWith("Avatar:")) {
//                    model.setName(item.replace("Avatar:", ""));
//                }
//                if (item.startsWith("Status:")) {
//                    model.setStatus(item.replace("Status:", ""));
//                }
//                if (item.startsWith("Director:")) {
//                    model.setDirector(item.replace("Director:", ""));
//                }
//                if (item.startsWith("Type:")) {
//                    model.setType(item.replace("Type:", ""));
//                }
//                if (item.startsWith("Total Episodes:")) {
//                    model.setTotalepisodes(item.replace("Total Episodes:", ""));
//                }
//                if (item.startsWith("Cast:")) {
//                    model.setCast(item.replace("Cast:", ""));
//                }
//                if (item.startsWith("Country:")) {
//                    model.setCountry(item.replace("Country:", ""));
//                }
//                if (item.startsWith("YearIssue:")) {
//                    model.setYearissue(item.replace("YearIssue:", ""));
//                }
//                if(item.startsWith("Link:")){
//                    model.setLink(item.replace("Link:",""));
//                }
//                if (item.startsWith("Content:")) {
//                    model.setName(item.replace("Content:", ""));
//                }
//            }
//            if (model.getYearissue().equals(YearIssue)) {
//                response.add(model);
//            }
//        }
//        return response;
//    }
//
//    // Tim kiem theo ten
//    @Override
//    public List<MotPhimModel> findByName(String Name) throws IOException {
//        List<MotPhimModel> response = new ArrayList<>();
//        File file;
//        FileReader fr = new FileReader("C:\\Users\\Phan Nho Hoang\\Desktop\\FilmProject\\hoangpn16-ProjectFilm\\data-film.text");
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        while (true) {
//            line = br.readLine();
//            if (line == null) {
//                break;
//            }
//            MotPhimModel model = new MotPhimModel();
//            String[] items = line.split(";");
//            for (String item : items) {
//                if (item.startsWith("Name:")) {
//                    model.setName(item.replace("Name:", ""));
//                }
//                if (item.startsWith("Avatar:")) {
//                    model.setName(item.replace("Avatar:", ""));
//                }
//                if (item.startsWith("Status:")) {
//                    model.setStatus(item.replace("Status:", ""));
//                }
//                if (item.startsWith("Director:")) {
//                    model.setDirector(item.replace("Director:", ""));
//                }
//                if (item.startsWith("Type:")) {
//                    model.setType(item.replace("Type:", ""));
//                }
//                if (item.startsWith("Total Episodes:")) {
//                    model.setTotalepisodes(item.replace("Total Episodes:", ""));
//                }
//                if (item.startsWith("Cast:")) {
//                    model.setCast(item.replace("Cast:", ""));
//                }
//                if (item.startsWith("Country:")) {
//                    model.setCountry(item.replace("Country:", ""));
//                }
//                if (item.startsWith("YearIssue:")) {
//                    model.setYearissue(item.replace("YearIssue:", ""));
//                }
//                if(item.startsWith("Link:")){
//                    model.setLink(item.replace("Link:",""));
//                }
//                if (item.startsWith("Content:")) {
//                    model.setName(item.replace("Content:", ""));
//                }
//            }
//            if (model.getName().contains(Name)) {
//                response.add(model);
//            }
//        }
//        return response;
//    }
//
//    // Tìm theo Type( Thể loại)
//    @Override
//    public List<MotPhimModel> findByType(String Type) throws IOException {
//        List<MotPhimModel> response = new ArrayList<>();
//        File file;
//        FileReader fr = new FileReader("C:\\Users\\Phan Nho Hoang\\Desktop\\FilmProject\\hoangpn16-ProjectFilm\\data-film.text");
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        while (true) {
//            line = br.readLine();
//            if (line == null) {
//                break;
//            }
//            if(line.contains(Type)){
//                System.out.println(line);
//            }
//        }
//        return response;
//    }
//
//    //Tìm theo Director
//    @Override
//    public List<MotPhimModel> findByDirector(String Director) throws IOException {
//        List<MotPhimModel> response = new ArrayList<>();
//        File file;
//        FileReader fr = new FileReader("C:\\Users\\Phan Nho Hoang\\Desktop\\FilmProject\\hoangpn16-ProjectFilm\\data-film.text");
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        while (true) {
//            line = br.readLine();
//            if (line == null) {
//                break;
//            }
//            if(line.contains(Director)){
//                System.out.println(line);
//            }
//        }
//        return response;
//    }
//    // Tìm theo Cast
//
//    @Override
//    public List<MotPhimModel> findByCast(String Cast) throws IOException {
//        List<MotPhimModel> response = new ArrayList<>();
//        File file;
//        FileReader fr = new FileReader("C:\\Users\\Phan Nho Hoang\\Desktop\\FilmProject\\hoangpn16-ProjectFilm\\data-film.text");
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        while (true) {
//            line = br.readLine();
//            if (line == null) {
//                break;
//            }
//            if(line.contains(Cast)){
//                System.out.println(line);
//            }
//        }
//        return response;
//    }
//}