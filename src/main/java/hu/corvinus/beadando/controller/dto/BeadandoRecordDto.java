package hu.corvinus.beadando.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeadandoRecordDto {
     private String szoveg;

     public BeadandoRecordDto(String szoveg) {
          this.szoveg = szoveg;
     }

     public String getSzoveg() {
          return szoveg;
     }
}
