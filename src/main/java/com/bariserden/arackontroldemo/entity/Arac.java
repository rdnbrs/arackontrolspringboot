package com.bariserden.arackontroldemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "araclar")
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "arac_adi")
    private String aracAdi;

    @Column(name = "muhimmat", columnDefinition = "integer default 0")
    private Integer muhimmat;

    @Column(name = "yakit", columnDefinition = "Decimal(10,2) default 0")
    private Double yakit;

    @Column(name = "hasar_durum", columnDefinition = "Decimal(10,2) default 0")
    private Double hasarDurum;

    public Arac() {
    }

    public Arac(String aracAdi, Integer muhimmat, Double yakit, Double hasarDurum) {
        this.aracAdi = aracAdi;
        this.muhimmat = muhimmat;
        this.yakit = yakit;
        this.hasarDurum = hasarDurum;
    }

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
        return "Arac{" +
                "id=" + id +
                ", aracAdi='" + aracAdi + '\'' +
                ", muhimmat=" + muhimmat +
                ", yakit=" + yakit +
                ", hasarDurum=" + hasarDurum +
                '}';
    }
}
