package example.com.opiskelijaelama.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long>{


	//ensimmäiset 5 ovat tapahtumatietojen hakuun fronttia varten
	@Query(value = "Select * "
			+ "from tapahtuma "
			+ "left join appro on appro.tapahtuma_id = tapahtuma.tapahtuma_id "
			+ "left join gambinakokous on gambinakokous.tapahtuma_id = tapahtuma.tapahtuma_id "
			+ "left join rastikierros on rastikierros.tapahtuma_id = tapahtuma.tapahtuma_id "
			+ "left join sitsit on sitsit.tapahtuma_id = tapahtuma.tapahtuma_id "
			+ "where tapahtuma.tapahtuma_id <= :id ;", nativeQuery = true)
	List<Tapahtuma> etsiTapahtumatiedot(Long id);
	
}
