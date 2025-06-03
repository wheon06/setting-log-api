package com.wheon.settinglogapi.storage.center;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.wheon.settinglogapi.domain.center.Center;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "center_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CenterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static CenterEntity of(
            Center center
    ) {
        return new CenterEntity(center.getName());
    }

    private CenterEntity(String name) {
        this.name = name;
    }
}
