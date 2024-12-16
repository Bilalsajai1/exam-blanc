package ma.enset.keynoteservice.services;

import jakarta.transaction.Transactional;

import ma.enset.keynoteservice.dtos.KeynoteDTO;
import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.mappers.KeynoteMapper;
import ma.enset.keynoteservice.repositories.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KeynoteServiceImpl implements KeynoteService{
    private KeynoteRepository keynoteRepository;
    public KeynoteServiceImpl(KeynoteRepository keynoteRepository) {
        this.keynoteRepository = keynoteRepository;
    }
    @Override
    public List<KeynoteDTO> getAllKeynotes() {
        List<Keynote> keynotes = keynoteRepository.findAll();
        return keynotes.stream()
                .map(KeynoteMapper.INSTANCE::keynoteToKeynoteDTO)
                .toList();
    }
    @Override
    public Optional<KeynoteDTO> getKeynoteById(String id) {
        return keynoteRepository.findById(id)
                .map(KeynoteMapper.INSTANCE::keynoteToKeynoteDTO);
    }

    @Override
    public KeynoteDTO createKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = KeynoteMapper.INSTANCE.keynoteDTOToKeynote(keynoteDTO);
        Keynote savedKeynote = keynoteRepository.save(keynote);
        return KeynoteMapper.INSTANCE.keynoteToKeynoteDTO(savedKeynote);
    }

    @Override
    public void deleteKeynote(String id) {
        keynoteRepository.deleteById(id);
    }

    @Override
    public KeynoteDTO updateKeynote(KeynoteDTO keynoteDTO) {
        if (keynoteDTO.getId() == null) {
            throw new IllegalArgumentException("L'ID de la keynote ne peut pas être null.");
        }
        Keynote existingKeynote = keynoteRepository.findById(keynoteDTO.getId())
                .orElseThrow(() -> new RuntimeException("Keynote introuvable avec l'ID : " + keynoteDTO.getId()));
        existingKeynote.setNom(keynoteDTO.getNom());
        existingKeynote.setPrenom(keynoteDTO.getPrenom());
        existingKeynote.setEmail(keynoteDTO.getEmail());
        existingKeynote.setFonction(keynoteDTO.getFonction());
        Keynote updatedKeynote = keynoteRepository.save(existingKeynote);
        return KeynoteMapper.INSTANCE.keynoteToKeynoteDTO(updatedKeynote);
    }


}
