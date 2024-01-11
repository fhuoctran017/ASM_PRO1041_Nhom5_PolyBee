package ultil;

import com.asm.polybee.model.ChatLieu;
import com.asm.polybee.model.ChucVu;
import com.asm.polybee.model.HoaDon;
import com.asm.polybee.model.HoaDonChiTiet;
import com.asm.polybee.model.KhachHang;
import com.asm.polybee.model.MauSac;
import com.asm.polybee.model.NhanVien;
import com.asm.polybee.model.SanPham;
import com.asm.polybee.model.SanPhamChiTiet;
import com.asm.polybee.model.Size;
import com.asm.polybee.model.TheLoai;
import com.asm.polybee.model.ThuongHieu;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=ASM_PRO1041_PolyBee");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(Size.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ThuongHieu.class);
        conf.addAnnotatedClass(TheLoai.class);
        conf.addAnnotatedClass(ChatLieu.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(SanPhamChiTiet.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhachHang.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
