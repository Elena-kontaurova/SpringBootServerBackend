package lekasv.bek.repository;

import lekasv.bek.model.Xyu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XyuRepository extends JpaRepository<Xyu, Integer> {
    List<Xyu> findByName(String name);
}
