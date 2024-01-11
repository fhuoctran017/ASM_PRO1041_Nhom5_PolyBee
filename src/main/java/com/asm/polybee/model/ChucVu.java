package com.asm.polybee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "ChucVu")
public class ChucVu {

    @Id
    @Column(name = "IdChucVu")
    String IdChucVu;

    @Column(name = "MaChucVu")
    String MaChucVu;

    @Column(name = "TenChucVu")
    String TenChucVu;
}
