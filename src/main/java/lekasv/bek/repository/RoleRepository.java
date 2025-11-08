package lekasv.bek.repository;

import lekasv.bek.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
