package dev.mission.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
	
	@Query("select mission from Mission mission where mission.dateDebut>=now()")
	List<Mission> rechercheMissionFutur();
	
	@Query("select mission from Mission mission where mission.dateDebut>=now() and tauxJournalier > tj")
	List<Mission> rechercheMissionFuturTjm(BigDecimal tj);

}
