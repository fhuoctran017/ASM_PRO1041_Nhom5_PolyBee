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
    
    
    public void printNhanVienAttributes() {
        List<ChucVu> listChucVu = getAll();
        if (listChucVu != null) {
            for (ChucVu chucVu : listChucVu) {
                System.out.println("IdChucVu: " + chucVu.getIdChucVu());
                System.out.println("MaChucVu: " + chucVu.getMaChucVu());
                System.out.println("TenChucVu: " + chucVu.getTenChucVu());
                System.out.println("--------------------");
            }
        }
    }
    
    public static void main(String[] args) {
        ChucVuRepository chucVuRepository = new ChucVuRepository();
        chucVuRepository.printNhanVienAttributes();
    }
}
