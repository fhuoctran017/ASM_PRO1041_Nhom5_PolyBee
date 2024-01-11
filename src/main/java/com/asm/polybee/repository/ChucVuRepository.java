package com.asm.polybee.repository;

import com.asm.polybee.model.ChucVu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import ultil.HibernateUtil;

public class ChucVuRepository {
    
    public List<ChucVu> getAll() {
        List<ChucVu> listChucVu = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu ", ChucVu.class);
            listChucVu = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChucVu;
    }
    
}
