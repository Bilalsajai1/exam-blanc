package ma.enset.conferenceservice.service;

import jakarta.transaction.Transactional;

import ma.enset.conferenceservice.dtos.ConferenceDTO;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.mappers.ConferenceMapper;
import ma.enset.conferenceservice.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Override
    public List<ConferenceDTO> getAllConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        return conferences.stream()
                .map(ConferenceMapper.INSTANCE::conferenceToConferenceDTO)
                .toList();
    }
    @Override
    public Optional<ConferenceDTO> getConferenceById(Long id) {
        return conferenceRepository.findById(String.valueOf(id))
                .map(ConferenceMapper.INSTANCE::conferenceToConferenceDTO);
    }
    @Override
    public ConferenceDTO createConference(ConferenceDTO conferenceDTO) {
        Conference conference = ConferenceMapper.INSTANCE.conferenceDTOToConference(conferenceDTO);
        Conference savedConference = conferenceRepository.save(conference);
        return ConferenceMapper.INSTANCE.conferenceToConferenceDTO(savedConference);
    }
    @Override
    public void deleteConference(Long id) {
        conferenceRepository.deleteById(String.valueOf(id));
    }
    @Override
    public ConferenceDTO updateConference(ConferenceDTO conferenceDTO) {
        if (conferenceDTO.getId() == null) {
            throw new IllegalArgumentException("cant be null.");
        }
        Conference existingConference = conferenceRepository.findById(String.valueOf(conferenceDTO.getId()))
                .orElseThrow(() -> new RuntimeException("cant find : " + conferenceDTO.getId()));
        existingConference.setTitre(conferenceDTO.getTitre());
        existingConference.setType(conferenceDTO.getType());
        existingConference.setDate(conferenceDTO.getDate());
        existingConference.setDuree(conferenceDTO.getDuree());
        existingConference.setNombreInscrits(conferenceDTO.getNombreInscrits());
        existingConference.setScore(conferenceDTO.getScore());
        Conference updatedConference = conferenceRepository.save(existingConference);
        return ConferenceMapper.INSTANCE.conferenceToConferenceDTO(updatedConference);
    }

}
