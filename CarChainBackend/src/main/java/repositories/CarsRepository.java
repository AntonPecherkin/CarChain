package repositories;

import entities.CarModified;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<CarModified, Long> {
    /*CarModified findByCarId(Long id);*/
}
