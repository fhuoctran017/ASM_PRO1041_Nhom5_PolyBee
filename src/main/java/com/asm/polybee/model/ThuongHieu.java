package com.asm.polybee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThuongHieu {

    private String idThuongHieu;

    private String tenThuongHieu;

    private String trangThai;

    @Override
    public String toString() {
        return tenThuongHieu; // Chọn một thuộc tính thích hợp để hiển thị làm chuỗi
    }
}
