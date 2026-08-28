import java.util.Scanner;

class Produk {
    String kdProduk, nmProduk;
    int hrgBeli, hrgJual;

    public void inputProduk() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kode Produk : ");
        kdProduk = input.nextLine();
        System.out.print("Nama Produk : ");
        nmProduk = input.nextLine();
        System.out.print("Harga Beli  : ");
        hrgBeli = input.nextInt();
    }
}

class Grosir extends Produk {
    int noNota, jmlJual, totJual, jnsByr, ppn, bunga, totByr;
    String ketByr, souvenir;

    Scanner input = new Scanner(System.in);

    public Grosir(String Cabang) {

    }

    public void setNota() {
        System.out.print("No Nota - ");
        noNota = input.nextInt();
    }

    public void inputJumlah() {
        System.out.print("Jumlah Jual : ");
        jmlJual = input.nextInt();
        totJual = jmlJual * getHargaJual();
    }

    public int getHargaJual() {
        if (hrgBeli > 200000) {
            return hrgJual = hrgBeli + (hrgBeli * 10/100);
        } 
        else if (hrgBeli > 100000) {
            return hrgJual = hrgBeli + (hrgBeli * 15/100);
        } 
        else if (hrgBeli > 50000) {
            return hrgJual = hrgBeli + (hrgBeli * 20/100);
        } 
        else if (hrgBeli > 25000) {
            return hrgJual = hrgBeli + (hrgBeli * 30/100);
        } 
        else {
            return hrgJual = hrgBeli + (hrgBeli * 50/100);  
        }
    }

    public void jenisPembayaran() {
        int tempo;
        
        System.out.println("Jenis Pembayaran");
        System.out.println("1 - Cash");
        System.out.println("2 - Tempo");
        System.out.print("Pilih Jenis Pembayaran = ");
        jnsByr = input.nextInt();
        
        if (jnsByr == 1) {
            ketByr = "Cash";
            ppn = totJual * 11/100;
            bunga = 0;
        }
        
        if (jnsByr == 2) {
            ketByr = "Tempo";
            System.out.print("Tempo (mingguan)       = ");
            tempo = input.nextInt();
            ppn = totJual * 11/100;
            if (tempo > 2) {
                ketByr = "Tempo";
                bunga = totJual * 50/100;
            }
        }
    }

    public String souvenir() {
        if (jnsByr == 1) {
            if (totByr >= 100000 && totByr <= 500000) {
                return souvenir = "Mangkok";
            } 
            else if (totByr > 500000 && totByr <= 750000) {
                return souvenir = "Payung";
            } 
            else if (totByr > 750000 && totByr <= 1000000) {
                return souvenir = "Tas Belanja";
            } 
            else if (totByr > 1000000) {
                return souvenir = "Voucher 100rb";
            } 
            else {
                return souvenir = "Tidak Ada";
            }
        } 
        else {
            return souvenir = "Tidak Ada";
        }
    }

    public int hitungJual() {
        return totByr = totJual + ppn + bunga;
    }

    public void cetak() {
        System.out.println(noNota + "\t\t" + kdProduk + "\t\t" + nmProduk + "\t" + hrgBeli + "\t\t" + getHargaJual() + "\t\t" + jmlJual + "\t\t" + totJual + "\t\t" + ketByr + "\t\t" + ppn + "\t\t" + bunga + "\t\t" + hitungJual() + "\t\t" + souvenir());
    }
}

public class GrosirSembako {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h;
        
        System.out.println("Program Toko Grosir Sembako Sumber Rezeki");
        System.out.println("");

        System.out.print("Jumlah Grosir -> ");
        h = input.nextInt();
        System.out.println("");
        
        Grosir[] grosir = new Grosir[h];
        for (int i = 0; i < h; i++) {
            grosir[i] = new Grosir("Semarang");
            System.out.println("===============================");
            grosir[i].setNota();
            System.out.println("");
            grosir[i].inputProduk();
            grosir[i].inputJumlah();
            System.out.println("");
            grosir[i].jenisPembayaran();
            System.out.println("===============================");
            System.out.println("");
        }
        
        System.out.println("Daftar List Tabulasi Toko Grosir");
        System.out.println("");
        System.out.println("No Nota\t\tKode Produk\tNama Produk\tHarga Beli\tHarga Jual\tJumlah Jual\tTotal Jual\tKet Bayar\tPPN\t\tBunga\t\tTotal Bayar\tSouvenir");
        for (int j = 0; j < h; j++) {
            grosir[j].cetak();
        }
    }
}