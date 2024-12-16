package ma.enset.keynoteservice.dtos;
import lombok.*;

@Builder
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KeynoteDTO {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}