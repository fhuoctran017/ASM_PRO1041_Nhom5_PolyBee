package com.asm.polybee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheLoai {

    private String idTheloai;

    private String tenTheLoai;

    private String trangThai;

    @Override
    public String toString() {
        return tenTheLoai; // Chọn một thuộc tính thích hợp để hiển thị làm chuỗi
    }
}
