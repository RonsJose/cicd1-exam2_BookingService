package ie.atu.sample.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responses{
    private Long id;
    private String name;
    private int count;
    private Long roomID;
    private boolean status;
}
