package com.wheon.settinglogapi.storage.center;

import jakarta.persistence.*;

@Entity
@Table(name = "center_tb")
public class CenterJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
