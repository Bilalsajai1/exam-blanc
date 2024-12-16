package ma.enset.conferenceservice.repositories;

import ma.enset.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ConferenceRepository extends JpaRepository<Conference, String> {
}