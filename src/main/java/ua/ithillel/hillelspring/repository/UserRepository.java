package ua.ithillel.hillelspring.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.ithillel.hillelspring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByEmailAndPhone(String email, int phone);
    User getUserByIdAndNameOrSurname(Integer id,String name, String surname);
    @Transactional
    @Modifying
    @Query("update User u set u.phone = ?1 where u.id = ?2")
    Integer update(int phone, Integer id);

}
