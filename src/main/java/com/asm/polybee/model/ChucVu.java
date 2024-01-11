package com.asm.polybee.model;


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


public class ChucVu {

    
    String idChucVu;

    
    String maChucVu;

   
    String tenChucVu;
    
    @Override
    public String toString() {
        return tenChucVu;
    }
}
