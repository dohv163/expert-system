package code.thuat.toan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import hechuandoan.io.DocLuat;
import hechuandoan.model.Luat;

public class ThuatToan {
	ArrayList<Luat> RULE=new ArrayList<Luat>();
	ArrayList<String> GT=new ArrayList<String>();
	ArrayList<String> KL=new ArrayList<String>();
	ArrayList<Luat> SAT=new ArrayList<Luat>();
	ArrayList<String> TG=new ArrayList<String>();
	public static ArrayList<String> SD=new ArrayList<String>();
	DocLuat docLuat=new DocLuat();
	
	// DOC LUAT
	public  void docLuat(String path) {
		try {
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			String line=br.readLine();
			String arr[];
			while ( line !=null) {
	            arr=line.split("->");
	            RULE.add(new Luat(arr[0],arr[1]));
	            line=br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String thuatToan(ArrayList<String> giaThiet,ArrayList<String> ketLuan){
		docLuat("../luat.txt");
		GT=giaThiet;
		KL=ketLuan;
		
		SD.add("Giả Thiết");
		SD.addAll(GT);

		SD.add("Kết Luận");
		SD.addAll(KL);
		
		SD.add("Tập luật");
		for (Luat string : RULE) {
			// System.out.println(string);
			SD.add(string.toString());
		}
		Luat r=new Luat();
		TG=GT;
		loc();
		int i=0;
	while(kt_KL_Thuoc_TG()==false && SAT.size()!=0) {
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
	if (kt_KL_Thuoc_TG()) 
		return KL.toString();
	return null;
	} 
	private ArrayList<String> dsKL(ArrayList<Luat> dsVP,ArrayList<String> dsTG){
		ArrayList<String> dsKL=new ArrayList<String>();
		for (int i = 0; i < dsVP.size(); i++) {
			for (int j = 0; j < dsTG.size(); j++) {
				if (dsVP.get(i).getVePhai().equals(dsTG.get(j))) {
					dsKL.add(dsVP.get(i).getVePhai());
				}
			}
		}
		return dsKL;
	}
	// 
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
	       //neu dem bang do dai cua tap ket luan thi KL thuoc TG
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
}
