package ma.enset.keynoteservice.mappers;


import ma.enset.keynoteservice.dtos.KeynoteDTO;
import ma.enset.keynoteservice.entities.Keynote;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KeynoteMapper {
    KeynoteMapper INSTANCE = Mappers.getMapper(KeynoteMapper.class);
    KeynoteDTO keynoteToKeynoteDTO(Keynote keynote);
    Keynote keynoteDTOToKeynote(KeynoteDTO keynoteDTO);
}
