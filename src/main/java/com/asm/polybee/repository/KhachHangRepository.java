
package com.asm.polybee.repository;

import com.asm.polybee.model.KhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import ultil.HibernateUtil;


public class KhachHangRepository {
    public List<KhachHang> getAll() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
            listKhachHang= query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }
}
