package film;

import film.motphim.MotPhimModel;

import java.util.List;

public interface MoviesInterface {
     void writeToDB(MotPhimModel motPhimModel);
     void findByName(String name);
     void findByYearIssue(String year);
     void findByType(String type);
     void findByDirector(String director);
     void findByCast(String cast);


}
