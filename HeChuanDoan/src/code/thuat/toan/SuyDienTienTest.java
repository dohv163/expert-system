package code.thuat.toan;


import java.util.ArrayList;


import hechuandoan.controller.LayBenhTheoMa;
import hechuandoan.io.DocBenh;
import hechuandoan.io.DocLuat;
import hechuandoan.model.Benh;
import hechuandoan.model.Luat;

public class SuyDienTienTest {
	ArrayList<Luat> RULE=new ArrayList<Luat>();
	ArrayList<String> GT=new ArrayList<String>();
	ArrayList<String> KL=new ArrayList<String>();
	ArrayList<Luat> SAT=new ArrayList<Luat>();
	ArrayList<String> TG=new ArrayList<String>();
	DocBenh docbenh=new DocBenh();
	DocLuat docLuat=new DocLuat();
	ArrayList<Benh> BENH=new ArrayList<Benh>();
	public static ArrayList<String> SD=new ArrayList<String>();
	
	
	
	public ArrayList<Benh> thuatToan(ArrayList<String> dsGT){
		RULE=docLuat.docLuat("Data/luat.txt");
		Luat r=new Luat();
		TG=dsGT;
		loc();
		int i=0;
	while(SAT.size()!=0) {
		SD.add("-----------------------Bước thứ: "+(i+1)+"----------------------");
		SD.add("Tập SAT");
		for (Luat luat : SAT) {
			SD.add(luat.toString()+";");
		}
		r=SAT.get(0); // LẤY 1 LUẬT TRONG SAT
		SD.add("Luật r:" +r.toString());
		if (!kiemTraTrung(r.getVePhai())) // kiem tra xem vp cua r da thuoc TG chua neu chua thi them vp va TG
		{
			TG.add(r.getVePhai());
		}
		SD.add("Tập TG ở bước "+(i+1)+": "+TG);
		loatLuatKhoiRULE(r); // tuong ung voi buoc rule=rule\{r} trong giai thuat
		loc(); // lay tap SAT tuong ung voi buoc SAT=LOC(RULE,TG) trong giai thuat
		SD.add("Tập Luật Rule");
		for (Luat luat : RULE) {
			SD.add(luat.toString()+"");
		}
		i++;
	}
	SD.add("=============================");
	
	// lay danh sach benh theo ma
	
		BENH=docbenh.docBenh("Data/Benh.txt");
		LayBenhTheoMa layBenhTheoMa=new LayBenhTheoMa();
		return layBenhTheoMa.layBenhTheoMa(layKetLuan(docLuat.dsLuat("Data/luat.txt")));
	} 
	
	// hàm chức năng.
	
	 public void loatLuatKhoiRULE(Luat r)
	    {
	        int dem=-1;
	        for(int i=0;i<RULE.size();i++)
	        if(r.getVePhai().equals(RULE.get(i).getVePhai()) && r.getVeTrai().equals(RULE.get(i).getVeTrai()))
	        {
	            dem=i;
	            break;
	        }
	        if(dem!=-1)
	        {
	            RULE.remove(dem);
	        }
	    }
	    //---------lay tap SAT
	   public void loc()
	  {
	       SAT.clear();
	        for(int j=0;j<RULE.size();j++)
	        {
	               if(kiemtraTHVa(RULE.get(j).getVeTrai()))
	               {
	                    SAT.add(RULE.get(j));
	                }
	        }
	   }
	   //------------------------------------
	    // vi du neu a va b da thuoc GT thi a.b cung phai thuoc TG
	    public boolean kiemtraTHVa(String str)
	    {
	       String arr[]=str.split(",");
	       int dem=0;
	       for(int i=0;i<arr.length;i++)
	       {
	           for(int j=0;j<TG.size();j++)
	           {
	               if(arr[i].equals(TG.get(j)))
	               {
	                   dem++;
	               }
	           }
	       }
	       if(dem==arr.length)
	            return true;
	       return false;
	    }
	   
	   //kiem tra xem trong TG da co str chua neu co thi tra ve true
	   public boolean kiemTraTrung(String str)
	   {
	       for(int i=0;i<TG.size();i++)
	       {
	           if(TG.get(i).equals(str))
	           {
	               return true;
	           }
	       }
	       return false;
	   }
	   
	   //--Kiem tra xem KL co thuoc TG khong
	   public boolean kt_KL_Thuoc_TG()
	   {
	       int dem=0;
	       for(int i=0;i<KL.size();i++)
	       {
	           for(int j=0;j<TG.size();j++)
	           {
	               if(KL.get(i).equals(TG.get(j)))
	               {
	                   dem++;
	               }
	           }
	       }
	       if(dem==KL.size())
	            return true;
	       return false;
	   }
	   // lay KL tu TG
	   public ArrayList<String> layKetLuan(ArrayList<Luat> dsLuat){
		   ArrayList<String> dsKL=new ArrayList<String>();
		   // lay ve phai luat
		   for (int i = 0; i < dsLuat.size(); i++) {
			for (int j = 0; j < TG.size(); j++) {
				if (dsLuat.get(i).getVePhai().equals(TG.get(j))) {
					dsKL.add(dsLuat.get(i).getVePhai());
				}
			}
		   }
		   return dsKL;
	   }
}
