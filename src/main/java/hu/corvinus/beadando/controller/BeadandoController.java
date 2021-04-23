package hu.corvinus.beadando.controller;

import hu.corvinus.beadando.controller.dto.BeadandoDto;
import hu.corvinus.beadando.controller.dto.BeadandoRecordDto;
import hu.corvinus.beadando.service.BeadandoService;
import hu.corvinus.beadando.service.BeadandoSzoveg;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("/szoveg")
@RestController
public class BeadandoController {

    private final BeadandoService beadandoService;

    public BeadandoController(BeadandoService beadandoService) {
        this.beadandoService = beadandoService;
    }

    @PostMapping("/record")
    public void record(@RequestBody BeadandoRecordDto dto) {
        try {
            if (dto.getSzoveg().isEmpty()){
                beadandoService.record(
                        new BeadandoSzoveg.Builder()
                                .szoveg("Alma a fa alatt")
                                .build()
                );
            } else {
                beadandoService.record(
                        new BeadandoSzoveg.Builder()
                                .szoveg(dto.getSzoveg())
                                .build()
            );}
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

        @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<BeadandoDto> query () {
            return beadandoService.getAll().stream().map(model ->
                    new BeadandoDto.Builder()
                            .szoveg(new StringBuilder(model.getSzoveg()).reverse().toString())
                            .build())
                    .collect(Collectors.toList());
        }
    }


