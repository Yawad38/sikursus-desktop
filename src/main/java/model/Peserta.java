package model;

public class Peserta extends Orang{
    private String nim;
    private String jenisKelamin;
    private String prodi;
    private String email;

    // WAJIB: Constructor tanpa parameter agar "new Peserta()" di DAO tidak eror
    public Peserta() {
        super();
    }

    public Peserta(String nim, String nama, String jenisKelamin, String prodi, String noHp, String email) {
        setNim(nim);
        setNama(nama);
        setJenisKelamin(jenisKelamin);
        setProdi(prodi);
        setNoHp(noHp);
        setEmail(email);
    }
    
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
//pertemuan 9
//    private int idPeserta;
//    private String nim;
//    private String nama;
//    private String jenisKelamin;
//    private String prodi;
//    private String noHp;
//    private String email;
//
   

//    public int getIdPeserta() { return idPeserta; }
//    public void setIdPeserta(int idPeserta) { this.idPeserta = idPeserta; }
//    public String getNim() { return nim; }
//    public String getNama() { return nama; }
//    public String getJenisKelamin() { return jenisKelamin; }
//    public String getProdi() { return prodi; }
//    public String getNoHp() { return noHp; }
//    public String getEmail() { return email; }
    
//pertemuan 7/8?
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