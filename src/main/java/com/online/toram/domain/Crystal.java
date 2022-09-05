package com.online.toram.domain;

import com.online.toram.domain.item.CrystalKind;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Crystal {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String competency;

    @Enumerated(EnumType.STRING)
    private CrystalKind crystalKind;
    private String before;

    private Crystal(String name, CrystalKind crystalKind, String competency, String before) {
        this.name = name;
        this.crystalKind = crystalKind;
        this.before = before;
    }

    public static Crystal createCrystal(String name, CrystalKind crystalKind, String competency, String before) {
        return new Crystal(name, crystalKind, competency, before);
    }

    // 업데이트 로직
    public void updateName(String name) {
        this.name = name;
    }

    public void updateCrystalKind(CrystalKind crystalKind) {
        this.crystalKind = crystalKind;
    }

    public void updateBefore(String before) {
        this.before = before;
    }

    public void updateCompetency(String competency) {
        this.competency = competency;
    }
}
