package padilah.farid.hadits.similiarityhaditsfarid.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Hadits")
public class Hadits extends Model {

    @Column(name = "Jenis")
    public String jenis;

    @Column(name = "HaditsSatu")
    public String haditsSatu;

    @Column(name = "HaditsDua")
    public String haditsDua;

    public Hadits(){
    }

    public Hadits(String jenis, String haditsSatu, String haditsDua) {
        this.jenis = jenis;
        this.haditsSatu = haditsSatu;
        this.haditsDua = haditsDua;
    }
}
