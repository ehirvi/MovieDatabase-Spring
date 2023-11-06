package hh.sof03.moviedatabase.domain;

import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {

    Director findByName(String name);

}
