package example.com.opiskelijaelama.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JuomapeliRepository extends JpaRepository <Juomapeli, Long>{
	List<Juomapeli> findAll();

}
