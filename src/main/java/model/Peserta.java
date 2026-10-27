package model;

public class Peserta {//extends Orang 
    private int idPeserta;
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String prodi;
    private String noHp;
    private String email;

    public Peserta(String nim, String nama, String jenisKelamin, String prodi, String noHp, String email) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.prodi = prodi;
        this.noHp = noHp;
        this.email = email;
    }

    public int getIdPeserta() { return idPeserta; }
    public void setIdPeserta(int idPeserta) { this.idPeserta = idPeserta; }
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getJenisKelamin() { return jenisKelamin; }
    public String getProdi() { return prodi; }
    public String getNoHp() { return noHp; }
    public String getEmail() { return email; }
}
//
////    public void setNim(String nim) {
////        if (nim == null || nim.trim().isEmpty()) {
////            throw new IllegalArgumentException("NIM wajib diisi");
////        }
////        this.nim = nim.trim();
////    }
////
////    public void setProdi(String prodi) {
////        if (prodi == null || prodi.trim().isEmpty()) {
////            throw new IllegalArgumentException("Prodi wajib diisi");
////        }
////        this.prodi = prodi.trim();
////    }
////
////    @Override
////    public String getInfo() {
////        return "PESERTA | " + super.getInfo() + " | NIM: " + getNim() + " | Prodi: " + getProdi();
////    }
//}