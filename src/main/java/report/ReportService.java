package report;

import config.Database;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportService {

    // Laporan Master Peserta (Pertemuan 12)
    public static void tampilkanLaporanPeserta() {
        try (Connection conn = Database.getConnection();
             InputStream reportStream = ReportService.class.getResourceAsStream("/report/laporan_peserta.jasper")) {
            
            if (reportStream == null) {
                JOptionPane.showMessageDialog(null, "File /report/laporan_peserta.jasper tidak ditemukan!");
                return;
            }

            JasperPrint print = JasperFillManager.fillReport(reportStream, null, conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan peserta: " + ex.getMessage());
        }
    }

    // Laporan Pendaftaran Ber-Parameter (Pertemuan 13)
    public static void cetakPendaftaran(int idPendaftaran) {
        try (Connection conn = Database.getConnection();
             InputStream reportStream = ReportService.class.getResourceAsStream("/report/laporan_pendaftaran.jasper")) {
            
            if (reportStream == null) {
                JOptionPane.showMessageDialog(null, "File /report/laporan_pendaftaran.jasper tidak ditemukan!");
                return;
            }

            Map<String, Object> params = new HashMap<>();
            params.put("P_ID_PENDAFTARAN", idPendaftaran);

            JasperPrint print = JasperFillManager.fillReport(reportStream, params, conn);

            if (print.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data laporan untuk ID " + idPendaftaran + " tidak ditemukan.");
                return;
            }

            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan pendaftaran: " + ex.getMessage());
        }
    }
}