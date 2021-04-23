package hu.corvinus.beadando.controller.dto;

import hu.corvinus.beadando.dao.BeadandoSzoveg;

public class BeadandoDto {
    private final String szoveg;

    public String getSzoveg() {
        return szoveg;
    }

    private BeadandoDto(Builder builder) {
        this.szoveg = builder.szoveg;
    }

    public static class Builder {

        private String szoveg;

        public Builder szoveg(final String szoveg) {
            this.szoveg = szoveg;
            return this;
        }

        public BeadandoDto build() {
            return new BeadandoDto(this);
        }
    }
}
