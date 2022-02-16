package example.com.opiskelijaelama.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long>{


	// ensimmäiset 4 ovat tapahtumatietojen hakuun fronttia varten
	@Query(value = "SELECT * "
			+ "FROM TAPAHTUMA "
			+ "JOIN APPRO ON APPRO.TAPAHTUMA_ID = TAPAHTUMA.TAPAHTUMA_ID "
			+ "WHERE TAPAHTUMA.TAPAHTUMA_ID <= :id ; ",
			nativeQuery = true)
	Tapahtuma etsiAppro(Long id);
	
	@Query(value = "SELECT * "
			+ "FROM TAPAHTUMA "
			+ "JOIN GAMBINAKOKOUS ON GAMBINAKOKOUS.TAPAHTUMA_ID = TAPAHTUMA.TAPAHTUMA_ID "
			+ "WHERE TAPAHTUMA.TAPAHTUMA_ID <= :id ; ",
			nativeQuery = true)
	Tapahtuma etsiGambinakokous(Long id);
	
	@Query(value = "SELECT * "
			+ "FROM TAPAHTUMA "
			+ "JOIN RASTIKIERROS ON RASTIKIERROS.TAPAHTUMA_ID = TAPAHTUMA.TAPAHTUMA_ID "
			+ "WHERE TAPAHTUMA.TAPAHTUMA_ID <= :id ; ",
			nativeQuery = true)
	Tapahtuma etsiRastikierros(Long id);
	
	@Query(value = "SELECT * "
			+ "FROM TAPAHTUMA "
			+ "JOIN SITSIT ON SITSIT.TAPAHTUMA_ID = TAPAHTUMA.TAPAHTUMA_ID "
			+ "WHERE TAPAHTUMA.TAPAHTUMA_ID <= :id ; ",
			nativeQuery = true)
	Tapahtuma etsiSitsit(Long id);

}
