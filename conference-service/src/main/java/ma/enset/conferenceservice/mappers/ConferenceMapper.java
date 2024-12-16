package ma.enset.conferenceservice.mappers;


import ma.enset.conferenceservice.dtos.ConferenceDTO;
import ma.enset.conferenceservice.entities.Conference;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConferenceMapper {
    ConferenceMapper INSTANCE = Mappers.getMapper(ConferenceMapper.class);
    ConferenceDTO conferenceToConferenceDTO(Conference conference);
    Conference conferenceDTOToConference(ConferenceDTO conferenceDTO);
}
