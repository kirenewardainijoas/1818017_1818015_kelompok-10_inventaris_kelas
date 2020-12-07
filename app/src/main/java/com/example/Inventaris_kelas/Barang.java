package com.example.Inventaris_kelas;

public class Barang {
    private String _id, Jenis, Jml, Nmr;
    public Barang(String id, String Jenis, String Jml, String Nmr) {
        this._id = id;
        this.Jenis = Jenis;
        this.Jml = Jml;
        this.Nmr= Nmr;
    }
    public Barang() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }

    public String getJml() {
        return Jml;
    }

    public void setJml(String jml) {
        Jml = jml;
    }

    public String getNmr() {
        return Nmr;
    }

    public void setNmr(String nmr) {
        Nmr = nmr;
    }
}

