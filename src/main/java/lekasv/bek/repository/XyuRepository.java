package lekasv.bek.repository;

import lekasv.bek.model.Xyu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XyuRepository extends JpaRepository<Xyu, Integer> {
    Xyu findByName(String name);
}
