package lekasv.bek.repository;

import lekasv.bek.model.Testik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestikRepository extends JpaRepository<Testik, Integer> {
    List<Testik> findByName(String name);
}
