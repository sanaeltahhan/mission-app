package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerJtm")
public class ListerProchainesMissionsParTJM implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		List<Mission> missions = missionRepository.rechercheMissionFuturTjm(new BigDecimal ("250.50"));

		for (Mission m : missions) {

			System.out.println(m.getLibelle() + " : " + m.getDateDebut());
		}

	}

}
