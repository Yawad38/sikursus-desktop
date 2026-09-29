package latihan;    //package

public class LatihanBiayaKursus {           //class
    public static void main(String[] args){ //main method
        
        //Variabel
        String kode = "JAVA-BSC";
        String nama = "Java Desktop Fundamental";
        double biaya = 3_146_000;
        double diskon = 0.15;
        boolean aktif = true;
        double biaya_registrasi = 500_000;
  
        if (biaya >= 3_000_000) {
            diskon = 0.15;
        } else if(biaya >= 1_500_000 && biaya <= 3_000_000){
            diskon = 0.10;
        } else {
            diskon = 0.05;
        }
              
        double potongan = biaya * diskon;
        double total = biaya - potongan + biaya_registrasi;
        
        // Perbaikan blok Status
        String status;
        if (total >= 3_000_000) {
            status = "Mahal";
        } else {
            status = "Terjangkau";
        }

        //Output
        System.out.println("Kode    :" + kode);
        System.out.println("Kursus  :" + nama);
        System.out.println("Aktif   :" + aktif);
        System.out.printf("Diskon   : %.0f%%%n", (diskon * 100));
        System.out.printf("Total    : Rp%,.0f%n", total);
        System.out.println("Status  : " + status);
    } // Tanda titik koma (;) di sini sudah dihapus
}
