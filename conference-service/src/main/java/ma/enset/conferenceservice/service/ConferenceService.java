package ma.enset.conferenceservice.service;



import ma.enset.conferenceservice.dtos.ConferenceDTO;

import java.util.List;
import java.util.Optional;

public interface ConferenceService {
    List<ConferenceDTO> getAllConferences();
    Optional<ConferenceDTO> getConferenceById(Long id);
    ConferenceDTO createConference(ConferenceDTO conferenceDTO);
    void deleteConference(Long id);
    ConferenceDTO updateConference(ConferenceDTO conferenceDTO);
}
