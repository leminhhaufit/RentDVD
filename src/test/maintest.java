package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional.TxType;

import Connect.MyEntityManager;
import DAO.KhachhangDAO;
import DAO.TaikhoanDAO;
import DAO.TieudeDAO;
import Entity.Khachhang;
import Entity.Taikhoan;
import Giaodien.ThuediaGD;
import Giaodien.TradiaGD;

public class maintest {
	//sum = 1 + x/n!....
	public static int giaithua(int n) {
		if(n==1) {
			return 1;
		}
		return n*giaithua(n-1);
	}
	public static void main(String[] args) throws Exception {
		
		int x=2, n = 2,dem=1,tong=0;
		for (int i = 1; i <= n; i++) {
			if(n<1) {
				tong = tong+1;
			}else {
				tong += x/giaithua(i);
				if(i==n) {
					tong++;
				}
				
			}
			
		}
		System.out.println(tong);
		
		Integer[] arr = new Integer[1000];
		int i;
	    for (i=0; i < arr.length; i++) {
	        arr[i] = i;
	        
	        
	    }
	    Collections.shuffle(Arrays.asList(arr));
	    System.out.println(Arrays.toString(arr));
	    Date ngaythue = Date.valueOf(LocalDate.now());
	    System.out.println(ngaythue);
	    Random random = new Random();
	    List<Integer> randomNumbers = random.ints(0, 10).distinct().limit(10).boxed().collect(Collectors.toList());
	    System.out.println(randomNumbers);
	    System.out.println(randomNumbers.get(1));
	    
	    String t = "10000.0";
	    String[] arr2 = t.split("\\."); 
	    System.out.println(Arrays.asList(arr2).get(0));
		//tao csdl
	    EntityManager em = Persistence.createEntityManagerFactory("XDPMDemo").createEntityManager();
		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd"); Date d =
		 * Date.valueOf(LocalDate.now()); Calendar c1 = Calendar.getInstance();
		 * c1.setTime(d); c1.add(Calendar.DATE, -20);
		 * System.out.println(c1.getTime().toString()); Date d2 =
		 * Date.valueOf(dateFormat.format(c1.getTime())); System.out.println(d2); Date
		 * ngayhientai = Date.valueOf(LocalDate.now()); if(d2.compareTo(ngayhientai)<0)
		 * { System.out.println("Trể hạn"); }else { System.out.println("Chưa Trể hạn");
		 * } TradiaGD trd = new TradiaGD(); trd.tinhPhitrehan(); KhachhangDAO khdao =new
		 * KhachhangDAO(); Khachhang kh = khdao.getKhachhangbyID(2); if(kh==null) {
		 * System.out.println(kh); }else { System.out.println("khác "+kh); }
		 */
		/*
		 * ThuediaGD thd = new ThuediaGD(); thd.txtMaKh.setText("!");
		 * System.out.println(thd.txtMaKh.getText());
		 */
		/*
		 * TieudeDAO tddao = new TieudeDAO(); int soluong =
		 * tddao.demsoluongDVD("Conan Mới"); System.out.println(soluong);
		 */
		 //them nv vao tai khoan
		// them tai khoan truoc bằng cách set taikhoan trong class nhanvien
		
		
		/*
		 * Nhanvien nv = new Nhanvien("Minh Hau", LocalDate.now(), "0123456789", "Nam",
		 * "HCM", "Quanly"); NhanvienDAO nvdao = new NhanvienDAO(); try { TaikhoanDAO
		 * tkdao = new TaikhoanDAO(); Taikhoan tk = new Taikhoan("QL001", "admin");
		 * nv.setTaikhoan(tk); nvdao.addNhanvien(nv); } catch (Exception e) {
		 * System.out.println("loi"); }
		 */
		 
		  
		/*
		 * System.out.println("Nhap ten dang nhap:\n"); Scanner sc = new
		 * Scanner(System.in); //String tk = sc.nextLine();
		 * System.out.println("Nhap mat khau;\n"); //String mk = sc.nextLine();
		 */		  
		
		
		/*
		 * String tk = "QL001"; String mk="admin"; TaikhoanDAO tkdao =new TaikhoanDAO();
		 * Taikhoan tk2 = tkdao.getTaikhoanbyID(tk); System.out.println(tk2);
		 * if(tk.equalsIgnoreCase(tk2.getTenDangnhap()) &&
		 * mk.equalsIgnoreCase(tk2.getMatkhau())) {
		 * System.out.println("Dang nhap thanh cong!");
		 * 
		 * }
		 * 
		 * NhanvienDAO nvdao =new NhanvienDAO(); List<Nhanvien> dsnv=
		 * nvdao.getNhanvienbyTendangnhap("QL001");
		 * System.out.println(dsnv.get(0).getQuyen());
		 */
		  
		
		  
		 
	}
	
	
	
	
	
}
