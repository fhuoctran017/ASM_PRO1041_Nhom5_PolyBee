package com.asm.polybee.repository;

import com.asm.polybee.model.ChucVu;
import com.asm.polybee.model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import ultil.HibernateUtil;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien ", NhanVien.class);
            listNhanVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    

}

   
    
    


    


