package com.bariserden.arackontroldemo.dto;

import javax.validation.constraints.NotNull;

public class AracDto {

    private Long id;
    @NotNull
    private String aracAdi;
    @NotNull
    private Integer muhimmat;
    @NotNull
    private Double yakit;
    @NotNull
    private Double hasarDurum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAracAdi() {
        return aracAdi;
    }

    public void setAracAdi(String aracAdi) {
        this.aracAdi = aracAdi;
    }

    public Integer getMuhimmat() {
        return muhimmat;
    }

    public void setMuhimmat(Integer muhimmat) {
        this.muhimmat = muhimmat;
    }

    public Double getYakit() {
        return yakit;
    }

    public void setYakit(Double yakit) {
        this.yakit = yakit;
    }

    public Double getHasarDurum() {
        return hasarDurum;
    }

    public void setHasarDurum(Double hasarDurum) {
        this.hasarDurum = hasarDurum;
    }

    @Override
    public String toString() {
        return "AracDto{" +
                "id=" + id +
                ", aracAdi='" + aracAdi + '\'' +
                ", muhimmat=" + muhimmat +
                ", yakit=" + yakit +
                ", hasarDurum=" + hasarDurum +
                '}';
    }
}
