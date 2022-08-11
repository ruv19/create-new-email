package emailolusturma;
import java.util.Scanner;

public class email {
    
    static public  String ad;
    static public String soyad;
    static private String sifre;
    static private int defaultsifreuzunluk=10;
    static private String bolum;
    static public String eposta;
    static private int kutukapasite=500;
    static private String email_alf;
    static private String sirket_eklentisi="aeysirket.com";
    static private String tel_no;
    static String[] istenmeyenler={"1","2","3","4","5","6","7","8","9","0","!","+","%","-","&"};
    static public String turkceharf="üöışçğ";
    static public  String ingilizceharf="uoiscg";
    static public String ad2, soyad2, email;
     
    public email (String ad , String soyad){
    
        this.ad=ad;
        this.soyad=soyad;
        
        System.out.println("Eposta adresi oluşturuluyor:"+this.ad+" "+this.soyad);

        this.bolum=bolumkontrol();
        this.sifre=randomsifre(defaultsifreuzunluk);
        
        eposta=ad.toLowerCase()+"."+soyad.toLowerCase()+"@"+bolum+"."+sirket_eklentisi;
        email=emailCheckIt(eposta);
        this.tel_no=phonenumber();
    }

    private String phonenumber() {
        Scanner scan = new Scanner (System.in);
        System.out.println("Telefon numaranızı giriniz:");
        tel_no=scan.nextLine();
        return tel_no;   
    }
    
    private String bolumkontrol(){
        System.out.println("Departman Kodları\nsatış departmanı için 1 \ngeliştirme departmanı için 
        2\nmuhasebe departmanı için 3\nhiçbiri için 0\nDepartman kodlarını giriniz:");
        Scanner in = new Scanner(System.in);
        int bolum_secme=in.nextInt();
        if(bolum_secme==1)  {return "satış";}
        else if(bolum_secme==2) {return "geliştirme";}
        else if(bolum_secme==3) {return "muhasebe";}
        else {return " ";}
    }
    

    public static String emailCheckIt(String email){

String turkceKarakterler[]={"ı","ö","ğ","ü","ç","ş"};
String ingilizceKarakterler[]={"i","o","g","u","c","s"};

for(int i = 0 ; i< turkceKarakterler.length;i++) {

email = email.replace(turkceKarakterler[i], ingilizceKarakterler[i]);
}

return email;
}

    private String randomsifre(int length) {
        String sifre1 = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] sifre = new char[length];
        for(int i=0; i<length ;i++)
        {
           int rand = (int)(Math.random()*sifre1.length());
           sifre[i] = sifre1.charAt(rand);
        }
        return new String (sifre);
    } 
    
     
    
    public void setKapasite(int kapasite) {

        this.kutukapasite=kapasite;
    }
    
    public void setalternatifemail(String eposta2) {

        this.email_alf=eposta2;
    }
    
    public void sifredegistir(String sifre2) {

        this.sifre=sifre2;
    }
    
    public int getKapasite() {return kutukapasite;}
    public String getalternatifemail() {return email_alf;}
    public String getsifredegistir() {return sifre;}
    
    
    public String bilgi() {
        
        return "Kullanıcı adınız: "+ad+" "+soyad+
                "\nTelefon numarası "+tel_no+
               "\nşirket epostanız: "+email+
               "\neposta kutu kapasitesi: "+kutukapasite+"mb";
    }
}
