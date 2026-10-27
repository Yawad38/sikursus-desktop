CREATE DATABASE IF NOT EXISTS db_sikursus CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE db_sikursus;

CREATE TABLE users (
  id_user INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  role ENUM('ADMIN','OPERATOR') NOT NULL DEFAULT 'OPERATOR',
  aktif BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE peserta (
  id_peserta INT AUTO_INCREMENT PRIMARY KEY,
  nim VARCHAR(30) NOT NULL UNIQUE,
  nama VARCHAR(100) NOT NULL,
  jenis_kelamin ENUM('L','P') NOT NULL,
  prodi VARCHAR(100) NOT NULL,
  no_hp VARCHAR(25),
  email VARCHAR(120)
);

CREATE TABLE instruktur (
  id_instruktur INT AUTO_INCREMENT PRIMARY KEY,
  nama VARCHAR(100) NOT NULL,
  keahlian VARCHAR(120) NOT NULL,
  no_hp VARCHAR(25),
  email VARCHAR(120)
);

CREATE TABLE kursus (
  id_kursus INT AUTO_INCREMENT PRIMARY KEY,
  kode_kursus VARCHAR(20) NOT NULL UNIQUE,
  nama_kursus VARCHAR(120) NOT NULL,
  level ENUM('BASIC','INTERMEDIATE','ADVANCED') NOT NULL,
  biaya DECIMAL(12,2) NOT NULL CHECK (biaya >= 0)
);

CREATE TABLE kelas (
  id_kelas INT AUTO_INCREMENT PRIMARY KEY,
  id_kursus INT NOT NULL,
  id_instruktur INT NOT NULL,
  nama_kelas VARCHAR(100) NOT NULL,
  tanggal_mulai DATE NOT NULL,
  kapasitas INT NOT NULL DEFAULT 20,
  FOREIGN KEY (id_kursus) REFERENCES kursus(id_kursus),
  FOREIGN KEY (id_instruktur) REFERENCES instruktur(id_instruktur)
);

CREATE TABLE pendaftaran (
  id_pendaftaran INT AUTO_INCREMENT PRIMARY KEY,
  id_peserta INT NOT NULL,
  id_kelas INT NOT NULL,
  tanggal_daftar DATE NOT NULL,
  status ENUM('DAFTAR','AKTIF','SELESAI','BATAL') NOT NULL DEFAULT 'DAFTAR',
  UNIQUE KEY uk_peserta_kelas (id_peserta, id_kelas),
  FOREIGN KEY (id_peserta) REFERENCES peserta(id_peserta),
  FOREIGN KEY (id_kelas) REFERENCES kelas(id_kelas)
);

CREATE TABLE pembayaran (
  id_pembayaran INT AUTO_INCREMENT PRIMARY KEY,
  id_pendaftaran INT NOT NULL,
  tanggal_bayar DATE NOT NULL,
  nominal DECIMAL(12,2) NOT NULL CHECK (nominal > 0),
  metode ENUM('TUNAI','TRANSFER','QRIS') NOT NULL,
  status ENUM('MENUNGGU','LUNAS','BATAL') NOT NULL DEFAULT 'MENUNGGU',
  FOREIGN KEY (id_pendaftaran) REFERENCES pendaftaran(id_pendaftaran)
);

INSERT INTO peserta (nim,nama,jenis_kelamin,prodi,no_hp,email) VALUES
('252001','Ahmad Fauzan','L','Informatika','081234567801','ahmad@example.test'),
('252002','Siti Rahmah','P','Informatika','081234567802','siti@example.test');

INSERT INTO instruktur (nama,keahlian,no_hp,email) VALUES
('Dina Pratama','Java Desktop','081211110001','dina@example.test'),
('Rizal Maulana','Data Science','081211110002','rizal@example.test');

INSERT INTO kursus (kode_kursus,nama_kursus,level,biaya) VALUES
('JAVA-BSC','Java Desktop Fundamental','BASIC',500000),
('DS-BSC','Data Science Fundamental','BASIC',650000);

INSERT INTO kelas (id_kursus,id_instruktur,nama_kelas,tanggal_mulai,kapasitas) VALUES
(1,1,'Java-A','2026-11-10',25),
(2,2,'DS-A','2026-11-12',20);

INSERT INTO pendaftaran (id_peserta,id_kelas,tanggal_daftar,status) VALUES
(1,1,'2026-11-01','AKTIF'),
(2,2,'2026-11-02','AKTIF');

INSERT INTO pembayaran (id_pendaftaran,tanggal_bayar,nominal,metode,status) VALUES
(1,'2026-11-03',500000,'TRANSFER','LUNAS'),
(2,'2026-11-04',650000,'QRIS','LUNAS');
