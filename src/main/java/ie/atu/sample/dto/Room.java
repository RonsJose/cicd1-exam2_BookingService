package ie.atu.sample.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Long id;
    private String name;
    private int capacity;
}
