package Film;

import Film.MotPhim.MotPhimModel;

import java.io.IOException;
import java.util.List;

public interface MoviesInterface {
    void writeMoviesToFile(MotPhimModel model) throws IOException;
    List<MotPhimModel>findByYearIssue(String YearIssue) throws IOException;
    List<MotPhimModel>findByName(String Name) throws  IOException;
    List<MotPhimModel>findByType(String Type)throws IOException;
    List<MotPhimModel>findByDirector(String Director)throws IOException;
    List<MotPhimModel>findByCast(String Cast)throws IOException;
}
