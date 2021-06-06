/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ChitietDattruocDAO;
import DAO.ChitiethoadonDAO;
import DAO.DVDDAO;
import DAO.HoadonDAO;
import DAO.KhachhangDAO;
import DAO.PhitrehanDAO;
import DAO.TieudeDAO;
import Entity.ChitietDattruoc;
import Entity.Chitiethoadon;
import Entity.DVD;
import Entity.Hoadon;
import Entity.Khachhang;
import Entity.Phitrehan;
import Entity.Tieude;

/**
 *
 * @author Minh Hau
 */
public class ThuediaGD extends javax.swing.JFrame {

	DVDDAO dvddao =new DVDDAO();
	TieudeDAO tddao = new TieudeDAO();
	KhachhangDAO khdao =new KhachhangDAO();
	HoadonDAO hddao =new HoadonDAO();
	ChitiethoadonDAO cthddao = new ChitiethoadonDAO();
	PhitrehanDAO pthdao =new PhitrehanDAO();
	ChitietDattruocDAO ctdtdao = new ChitietDattruocDAO();
	public static DefaultTableModel dataModelThue;
    /**
     * Creates new form ThuediaGD
     */
    public ThuediaGD() {
        initComponents();
        String[] headers = {"Mã DVD", "Tên Tiêu đề", "Giá thuê","Hạn thuê","Mã tiêu đề"};
        dataModelThue = new DefaultTableModel(headers, 0);
        dataModelThue.setRowCount(0);
        tbThuedia.setModel(dataModelThue);
        try {
			randomMaHD();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        btnKiemtraMaKH1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChinhsachPhitrehanGD cspthgd = new ChinhsachPhitrehanGD();
				cspthgd.setVisible(true);
				
			}
		});
        lbNgayhientai.setText(String.valueOf(LocalDate.now()));
        btnQuaylai.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ThuediaGD.this.setVisible(false);
				
			}
		});
        btnKiemtraMadia.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String madvd = txtMaDia.getText();
				if(!(madvd.equalsIgnoreCase(""))) {
					try {
						DVD dvd = dvddao.getDVDbyID(Integer.valueOf(madvd));
						Tieude td = tddao.getTieudebyID(dvd.getTieude().getMaTieude());
						lbGiathue.setText(String.valueOf(td.getGiaThue()));
						lbHanthue.setText(String.valueOf(td.getHanThue()));
						lbLoaidia.setText(td.getLoaiDVD());
						lbTrangthai.setText(dvd.getTrangthai());
						
						lbTieudedia.setText(td.getTenTieude());
						
						
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Không được để trống!");
				}
				
			}
		});
        btnKiemtraMaKH.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String makh = txtMaKh.getText();
				if(!(makh.equalsIgnoreCase(""))) {
					try {
						Khachhang kh = khdao.getKhachhangbyID(Integer.valueOf(makh));
						lbTenKH.setText(kh.getTenKH());
						lbSdtKH.setText(kh.getSdt());
						hienthiPhitrehan();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không được để trống!");
				}
				
			}
		});
        btnThemvaoGH.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbThuedia.getRowCount();
				if(!(txtMaDia.getText().equalsIgnoreCase("") && txtMaKh.getText().equalsIgnoreCase(""))) {
					if(!(lbTrangthai.getText().equalsIgnoreCase("Đã được thuê"))) {
						try {
							DVD dvd = dvddao.getDVDbyID(Integer.valueOf(txtMaDia.getText()));
							String[] data= {txtMaDia.getText(),lbTieudedia.getText(),lbGiathue.getText(),lbHanthue.getText(),String.valueOf(dvd.getTieude().getMaTieude())};
							dataModelThue.addRow(data);
							tbThuedia.setModel(dataModelThue);
							lbTrangthai.setText("Đã được thuê");
							tinhtongtien();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Không thể thuê!");
					}
							
	
				}else {
					JOptionPane.showMessageDialog(null, "Không có thông tin!");
				}
				
				
			}
		});
        btnXoaGH.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbThuedia.getSelectedRow();
				int count = tbThuedia.getRowCount();
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "Mới bạn chọn dòng cần xóa");
				}else {
					dataModelThue.removeRow(index);
					lbTrangthai.setText("Có thể thuê");
					tinhtongtien();
					
				}
				
			}
		});
        btnThuedia.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Date ngaythue = Date.valueOf(LocalDate.now());
				int count =tbThuedia.getRowCount();
				
				String makh = txtMaKh.getText();
				
				String madvd = txtMaDia.getText();
				
				if(count==0) {
					JOptionPane.showMessageDialog(null, "Chưa có đĩa để thuê!");
				}else {
					if(!(makh.equalsIgnoreCase("")&& lbTonggiaThue.getText().equalsIgnoreCase(""))) {
						
						try {
							double tongtien = Double.valueOf(lbTonggiaThue.getText());
							Khachhang kh = khdao.getKhachhangbyID(Integer.valueOf(makh));
							Hoadon hd = new Hoadon(count, tongtien, ngaythue, kh);
							
							if(hddao.addHoadon(hd)==true) {
								
									int mahd = Integer.valueOf(lbMahoadon.getText());
									
								  for (int i = 0; i < count; i++) {
								  
								  int madvdct = Integer.valueOf((String) tbThuedia.getValueAt(i, 0)); 
								  double giathue =Double.valueOf((String) tbThuedia.getValueAt(i, 2)); 
								  int hanthue = Integer.valueOf((String) tbThuedia.getValueAt(i, 3)); 
								  String tentieude = (String) tbThuedia.getValueAt(i, 1); 
								  Hoadon hoadon = hddao.getHoadonbyID(mahd); 
								  DVD dvd = dvddao.getDVDbyID(madvdct);
								  DVD dvdup = new DVD(madvdct, lbTrangthai.getText(), tddao.getTieudebyID(Integer.valueOf((String) tbThuedia.getValueAt(i, 4))));
								  dvddao.updateDVD(dvdup);

								  String trangthai ="Đang thuê";
								  Calendar cal = Calendar.getInstance();
								  cal.add(Calendar.DATE, hanthue);
								  
								  SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
								  Date ngaytra = null;
								  Chitiethoadon cthd = new Chitiethoadon(hoadon, dvd, tentieude, giathue, hanthue, Date.valueOf(dateFormat.format(cal.getTime())), ngaytra, trangthai);
									  
									  cthddao.addChitiethoadon(cthd);
								  
								  }
								  capnhapTrangthaiDattruoc();
								  capnhatSoluongDVDtrongTieude();
								  
								  txtMaDia.setText("");
								  txtMaKh.setText(""); lbGiathue.setText(""); lbHanthue.setText("");
								  lbLoaidia.setText(""); lbSdtKH.setText(""); lbTenKH.setText("");
								  lbTieudedia.setText(""); lbTonggiaThue.setText("");
								  lbTrangthai.setText("");
								  lbTonggiaThue.setText("");
								  lbMahoadon.setText("");
								  randomMaHD();
								  dataModelThue.setRowCount(0); JOptionPane.showMessageDialog(null,
								  "Thuê đĩa thành công!");
								  
								 
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Không được để trống");
					}
				}
				
				}
				
			
		});
        txtPhidatra.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String phidatra = txtPhidatra.getText().trim();
		         if(phidatra.length()==0){
		            lbMessTienphidatra.setText("");
		        }else{
		            if(!(phidatra.length()>0 && phidatra.matches("^[1-9]{1}\\d+"))){
		            	lbMessTienphidatra.setText("Phí trễ hạn phải có số đầu khác 0");

		           }else{
		        	   lbMessTienphidatra.setText("");
		            }
		         }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        btnThanhToanphitrehan.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double datra = Double.valueOf(txtPhidatra.getText());
				double tonggia = Double.valueOf(lbTongphitrehan1.getText());
				
				try {
					Khachhang kh = khdao.getKhachhangbyID(Integer.valueOf(txtMaKh.getText()));
					
					if(!(txtPhidatra.getText().equalsIgnoreCase(""))) {
						if(datra<=tonggia) {
							double tongmoi = tonggia-datra;
							List<Phitrehan> dspth = pthdao.getAllPhitrehanBymaKH(kh.getMaKH());
							if(vaildData()==true) {
								for (int i = 0; i < dspth.size(); i++) {
									if(dspth.get(i).getTongtienphi()>0) {
										
											
											Phitrehan pth  = new Phitrehan(dspth.get(i).getMaPhitrehan(),tongmoi, datra, Date.valueOf(LocalDate.now()),kh);
											pthdao.updatePhitrehan(pth);
											lbPhitrehandatra.setText("");
											lbTongphitrehan1.setText("");
											txtPhidatra.setText("");
										JOptionPane.showMessageDialog(null, "Trả phí thành công!");
									}
									}
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Phí trả không lớn hơn tổng giá");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Không được để trống!");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Không thể thanh toán!");
				}
				
				
				
			}
				
				
			
		});
        btnKhongTT.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lbPhitrehandatra.setText("");
				lbTongphitrehan1.setText("");
				txtPhidatra.setText("");
				
			}
		});
    }
    private boolean vaildData(){
		  
        
        String phidatra = txtPhidatra.getText().trim();

        if(!(phidatra.length()>0 && phidatra.matches("^[1-9]{1}\\d+"))){
      	  lbMessTienphidatra.setText("Phí trễ hạn không hợp lệ");
            
            return false;
        }
       
        lbMessTienphidatra.setText("");
        
        
        return true;
    }
    private void tinhtongtien() {
    	int count = tbThuedia.getRowCount();
    	System.out.println(count);
    	double tong=0;
    	for (int i = 0; i < count; i++) {
    		
			tong+= Double.valueOf((String) tbThuedia.getValueAt(i, 2));
    		
		}
    	String tong2 = String.valueOf(tong);
    	String[] arr = tong2.split("\\.");
    	lbTonggiaThue.setText(Arrays.asList(arr).get(0));
    }
    
	 public void randomMaHD() throws Exception {
	    	
	    	
			int count = hddao.demsoluongHoadon();
			System.out.println(count+"dem");
			int mahd =1;
			int count2	= count;
			List<Hoadon> dshd = hddao.getAllHoadon();
			if(count==0) {
				mahd=1;
				lbMahoadon.setText(String.valueOf(mahd));
			}else {
				while(count2<=dshd.get(count-1).getMaHoadon()) {
					if(count2==dshd.get(count-1).getMaHoadon()) {
						for (int i = 0; i < count2; i++) {
							if(mahd==dshd.get(count-1).getMaHoadon()) {
								mahd++;
								lbMahoadon.setText(String.valueOf(mahd));
								System.out.println("Ma kh" + mahd);
								break;
							}
							mahd++;
							System.out.println(mahd+"test");
						}
					}
					count2++;
					System.out.println(count2+"dem2");
				}	
			}
    }
	 int soluong1=0;
	 public void capnhatSoluongDVDtrongTieude()  {
		 
		 String madia = txtMaDia.getText();
		
		 int count = tbThuedia.getRowCount();
		 String trangthai="Còn hàng";
		 
		 try {
			 for (int i = 0; i < count; i++) {
					String matd = (String) tbThuedia.getValueAt(i, 4);
					Tieude td = tddao.getTieudebyID(Integer.valueOf(matd));
					//1
					List<DVD> dsdvd= new ArrayList<DVD>();
					dsdvd = td.getDSdvd();//3 //2 
					
					int soluong1=  dsdvd.size();
					int soluong =soluong1;//3  //2
					System.out.println("size dsdvd: "+soluong);
					for (int j = 0; j <td.getDSdvd().size(); j++) { //3 //2
						if(dsdvd.get(j).getTrangthai().equals("Đã được thuê")) {
							soluong--;
							if(soluong==0) {
								 soluong=0;
								 trangthai ="Hết hàng";
							}
						}
						System.out.println("soluong dvd con "+ soluong);
						
					}
					Tieude td2 = new Tieude(td.getMaTieude(), td.getTenTieude(), td.getGiaThue(), td.getHanThue(), soluong, td.getPhitrehan(), td.getLoaiDVD(), td.getMota(), trangthai);
					tddao.updateTieude(td2);
				 } 
		 } catch (Exception e) {
			 JOptionPane.showMessageDialog(null,
					  "Thuê đĩa thành công!");
			}
		
	 }
	
	 public void hienthiPhitrehan() throws NumberFormatException, Exception {
		 String makh = txtMaKh.getText();
		 double tongphiall=0,dattraall=0;
		 List<Phitrehan> dspth2 = pthdao.getAllPhitrehanBymaKH(Integer.valueOf(makh));
			for (int i = 0; i < dspth2.size(); i++) {
				tongphiall+= dspth2.get(i).getTongtienphi();
				dattraall+= dspth2.get(i).getTienphidatra();
			}
			txtPhidatra.setText(String.valueOf(tongphiall));
			lbTongphitrehan1.setText(String.valueOf(tongphiall));
			lbPhitrehandatra.setText(String.valueOf(dattraall));
			
	 }
	 public void capnhapTrangthaiDattruoc() {
		 int count = tbThuedia.getRowCount();
		 try {
		 for (int i = 0; i < count; i++) {
			 String matd = (String) tbThuedia.getValueAt(i, 4);
			 String trangthai = "Đã nhận";
			 
			List<ChitietDattruoc> dsctdt = ctdtdao.getAllChitietDattruocbymaTieude(Integer.valueOf(matd));
			String madvd = (String) tbThuedia.getValueAt(i, 0);
			for (int j = 0; j < dsctdt.size(); j++) {
				if(Integer.valueOf(madvd)==dsctdt.get(j).getMadvd()) {
					ChitietDattruoc ctdt = new ChitietDattruoc(dsctdt.get(j).getDattruoc(), dsctdt.get(j).getTieude(), trangthai, Integer.valueOf(madvd));
					ctdtdao.updateChitietDattruoc(ctdt);
				}
			}
			 
			
		}
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        pnChinh = new javax.swing.JPanel();
	        lbTieude = new javax.swing.JLabel();
	        pnThue = new javax.swing.JPanel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        lbTenKH = new javax.swing.JLabel();
	        lbSdtKH = new javax.swing.JLabel();
	        txtMaDia = new javax.swing.JTextField();
	        jLabel5 = new javax.swing.JLabel();
	        btnKiemtraMaKH = new javax.swing.JButton();
	        btnKiemtraMadia = new javax.swing.JButton();
	        jLabel6 = new javax.swing.JLabel();
	        lbTieudedia = new javax.swing.JLabel();
	        lbLoaidia = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        lbGiathue = new javax.swing.JLabel();
	        lbHanthue = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        btnThuedia = new javax.swing.JButton();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        tbThuedia = new javax.swing.JTable();
	        btnThemvaoGH = new javax.swing.JButton();
	        btnXoaGH = new javax.swing.JButton();
	        jLabel13 = new javax.swing.JLabel();
	        lbTonggiaThue = new javax.swing.JLabel();
	        jLabel14 = new javax.swing.JLabel();
	        lbTrangthai = new javax.swing.JLabel();
	        jLabel15 = new javax.swing.JLabel();
	        lbMahoadon = new javax.swing.JLabel();
	        pnPhitrehan = new javax.swing.JPanel();
	        lbPhitrehan = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        lbNgayhientai = new javax.swing.JLabel();
	        jLabel12 = new javax.swing.JLabel();
	        jLabel16 = new javax.swing.JLabel();
	        lbPhitrehandatra = new javax.swing.JLabel();
	        jLabel17 = new javax.swing.JLabel();
	        btnThanhToanphitrehan = new javax.swing.JButton();
	        btnKhongTT = new javax.swing.JButton();
	        txtPhidatra = new javax.swing.JTextField();
	        lbMessTienphidatra = new javax.swing.JLabel();
	        jLabel11 = new javax.swing.JLabel();
	        btnKiemtraMaKH1 = new javax.swing.JButton();
	        btnQuaylai = new javax.swing.JLabel();
	        setTitle("Phần mềm cho thuê đĩa");
	     	//dat cua so giua man hinh
	        setLocationRelativeTo(null);
	        //khong cho phong to cua so
	        setResizable(false);

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
	        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        lbTieude.setText("PHẦN MỀM CHO THUÊ ĐĨA");

	        pnThue.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0)), "Thuê đĩa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24), new java.awt.Color(51, 51, 0))); // NOI18N

	        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel2.setText("Mã khách hàng:");

	        txtMaKh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

	        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel3.setText("Tên khách hàng:");

	        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel4.setText("Số điện thoai:");

	        lbTenKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        lbSdtKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        txtMaDia.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

	        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel5.setText("Mã đĩa:");

	        btnKiemtraMaKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
	        btnKiemtraMaKH.setText("Kiểm tra");

	        btnKiemtraMadia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
	        btnKiemtraMadia.setText("Kiểm tra");

	        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel6.setText("Tiêu đề đĩa:");

	        lbTieudedia.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        lbLoaidia.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel7.setText("Loại đĩa:");

	        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel8.setText("Giá thuê:");

	        lbGiathue.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        lbHanthue.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel9.setText("Hạn thuê:");

	        btnThuedia.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        btnThuedia.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\for-rent.png")); // NOI18N
	        btnThuedia.setText("Thuê đĩa");
	        btnThuedia.setPreferredSize(new java.awt.Dimension(220, 100));
	        btnThuedia.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnThuediaActionPerformed(evt);
	            }
	        });

	        tbThuedia.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        tbThuedia.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null}
	            },
	            new String [] {
	                "Mã DVD", "Tên Tiêu đề", "Giá thuê", "Hạn thuê", "Mã tiêu đề"
	            }
	        ) {
	            Class[] types = new Class [] {
	                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        jScrollPane2.setViewportView(tbThuedia);

	        btnThemvaoGH.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\plus.png")); // NOI18N

	        btnXoaGH.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\minus.png")); // NOI18N

	        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel13.setText("Tổng giá thuê:");

	        lbTonggiaThue.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
	        lbTonggiaThue.setForeground(new java.awt.Color(204, 0, 0));

	        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel14.setText("Trạng thái đĩa:");

	        lbTrangthai.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel15.setText("Mã hóa đơn:");

	        lbMahoadon.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        javax.swing.GroupLayout pnThueLayout = new javax.swing.GroupLayout(pnThue);
	        pnThue.setLayout(pnThueLayout);
	        pnThueLayout.setHorizontalGroup(
	            pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnThueLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(pnThueLayout.createSequentialGroup()
	                        .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(18, 18, 18)
	                        .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(lbSdtKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addGap(99, 99, 99))
	                    .addGroup(pnThueLayout.createSequentialGroup()
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
	                        .addGap(18, 18, 18)
	                        .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(btnThemvaoGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(btnXoaGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(pnThueLayout.createSequentialGroup()
	                        .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThueLayout.createSequentialGroup()
	                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGap(18, 18, 18)
	                                    .addComponent(lbGiathue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThueLayout.createSequentialGroup()
	                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGap(18, 18, 18)
	                                    .addComponent(lbLoaidia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThueLayout.createSequentialGroup()
	                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(lbTieudedia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThueLayout.createSequentialGroup()
	                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGap(18, 18, 18)
	                                    .addComponent(lbHanthue, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addGroup(pnThueLayout.createSequentialGroup()
	                                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThueLayout.createSequentialGroup()
	                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(lbMahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThueLayout.createSequentialGroup()
	                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGap(18, 18, 18)
	                                .addComponent(btnKiemtraMaKH))
	                            .addGroup(pnThueLayout.createSequentialGroup()
	                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(pnThueLayout.createSequentialGroup()
	                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(txtMaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(btnKiemtraMadia))
	                            .addGroup(pnThueLayout.createSequentialGroup()
	                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(btnThuedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(lbTonggiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        pnThueLayout.setVerticalGroup(
	            pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThueLayout.createSequentialGroup()
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(lbMahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jLabel2)
	                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(btnKiemtraMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(lbTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel4)
	                    .addComponent(lbSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5)
	                    .addComponent(txtMaDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnKiemtraMadia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbTieudedia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(lbLoaidia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(lbGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel9)
	                    .addComponent(lbHanthue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(14, 14, 14)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel14)
	                    .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(pnThueLayout.createSequentialGroup()
	                        .addComponent(btnThemvaoGH)
	                        .addGap(18, 18, 18)
	                        .addComponent(btnXoaGH)))
	                .addGap(18, 18, 18)
	                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel13)
	                    .addComponent(lbTonggiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(btnThuedia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(29, 29, 29))
	        );

	        pnPhitrehan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)), "Phí trễ hạn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24))); // NOI18N

	        lbPhitrehan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
	        lbPhitrehan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        lbPhitrehan.setText("Thanh toán phí trễ hạn thuê đĩa không?");

	        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
	        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel10.setText("Ngày hiện tại:");

	        lbNgayhientai.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
	        lbNgayhientai.setText("24/10/1999");

	        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
	        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel12.setText("PHÍ TRỄ HẠN");

	        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel16.setText("Phí trễ hạn đã trả:");

	        lbPhitrehandatra.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

	        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel17.setText("Tổng tiền phí trễ hạn:");

	        lbTongphitrehan1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
	        lbTongphitrehan1.setForeground(new java.awt.Color(255, 0, 0));

	        btnThanhToanphitrehan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
	        btnThanhToanphitrehan.setForeground(new java.awt.Color(0, 153, 153));
	        btnThanhToanphitrehan.setText("Thanh toán");

	        btnKhongTT.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
	        btnKhongTT.setForeground(new java.awt.Color(153, 0, 0));
	        btnKhongTT.setText("Không thanh toán");

	        txtPhidatra.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

	        lbMessTienphidatra.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
	        lbMessTienphidatra.setForeground(new java.awt.Color(255, 0, 0));

	        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
	        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
	        jLabel11.setText("Tiền phí muốn trả:");

	        btnKiemtraMaKH1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
	        btnKiemtraMaKH1.setText("Chính sách phí trễ hạn");

	        javax.swing.GroupLayout pnPhitrehanLayout = new javax.swing.GroupLayout(pnPhitrehan);
	        pnPhitrehan.setLayout(pnPhitrehanLayout);
	        pnPhitrehanLayout.setHorizontalGroup(
	            pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnPhitrehanLayout.createSequentialGroup()
	                .addGap(83, 83, 83)
	                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(lbNgayhientai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(pnPhitrehanLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhitrehanLayout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(lbPhitrehan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(pnPhitrehanLayout.createSequentialGroup()
	                        .addGap(27, 27, 27)
	                        .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(btnKiemtraMaKH1)
	                            .addGroup(pnPhitrehanLayout.createSequentialGroup()
	                                .addComponent(btnThanhToanphitrehan)
	                                .addGap(18, 18, 18)
	                                .addComponent(btnKhongTT)))
	                        .addGap(47, 47, 47)))
	                .addContainerGap())
	            .addGroup(pnPhitrehanLayout.createSequentialGroup()
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel16))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                    .addComponent(lbMessTienphidatra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(txtPhidatra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
	                    .addComponent(lbTongphitrehan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(lbPhitrehandatra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addGap(0, 0, Short.MAX_VALUE))
	        );
	        pnPhitrehanLayout.setVerticalGroup(
	            pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhitrehanLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel16)
	                    .addComponent(lbPhitrehandatra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel17)
	                    .addComponent(lbTongphitrehan1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(5, 5, 5)
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtPhidatra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(lbMessTienphidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(1, 1, 1)
	                .addComponent(lbPhitrehan)
	                .addGap(18, 18, 18)
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnThanhToanphitrehan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnKhongTT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(btnKiemtraMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel10)
	                    .addComponent(lbNgayhientai)))
	        );

	        btnQuaylai.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
	        btnQuaylai.setForeground(new java.awt.Color(204, 0, 0));
	        btnQuaylai.setText("Quay lại");

	        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
	        pnChinh.setLayout(pnChinhLayout);
	        pnChinhLayout.setHorizontalGroup(
	            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnChinhLayout.createSequentialGroup()
	                .addComponent(pnThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(pnPhitrehan, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
	            .addGroup(pnChinhLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(122, 122, 122))
	        );
	        pnChinhLayout.setVerticalGroup(
	            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnChinhLayout.createSequentialGroup()
	                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(pnChinhLayout.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(btnQuaylai)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(pnPhitrehan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(pnThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(pnChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(pnChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }// </editor-fold>                        

	    private void btnThuediaActionPerformed(java.awt.event.ActionEvent evt) {                                           
	        // TODO add your handling code here:
	    }                                          

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(ThuediaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ThuediaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ThuediaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ThuediaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new ThuediaGD().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton btnKhongTT;
	    private javax.swing.JButton btnKiemtraMaKH;
	    private javax.swing.JButton btnKiemtraMaKH1;
	    private javax.swing.JButton btnKiemtraMadia;
	    private javax.swing.JLabel btnQuaylai;
	    private javax.swing.JButton btnThanhToanphitrehan;
	    private javax.swing.JButton btnThemvaoGH;
	    private javax.swing.JButton btnThuedia;
	    private javax.swing.JButton btnXoaGH;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel13;
	    private javax.swing.JLabel jLabel14;
	    private javax.swing.JLabel jLabel15;
	    private javax.swing.JLabel jLabel16;
	    private javax.swing.JLabel jLabel17;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JLabel lbGiathue;
	    private javax.swing.JLabel lbHanthue;
	    private javax.swing.JLabel lbLoaidia;
	    private javax.swing.JLabel lbMahoadon;
	    private javax.swing.JLabel lbMessTienphidatra;
	    private javax.swing.JLabel lbNgayhientai;
	    private javax.swing.JLabel lbPhitrehan;
	    private javax.swing.JLabel lbPhitrehandatra;
	    private javax.swing.JLabel lbSdtKH;
	    private javax.swing.JLabel lbTenKH;
	    private javax.swing.JLabel lbTieude;
	    private javax.swing.JLabel lbTieudedia;
	    private javax.swing.JLabel lbTonggiaThue;
	    public static final javax.swing.JLabel lbTongphitrehan1 = new javax.swing.JLabel();
	    private javax.swing.JLabel lbTrangthai;
	    private javax.swing.JPanel pnChinh;
	    private javax.swing.JPanel pnPhitrehan;
	    private javax.swing.JPanel pnThue;
	    private javax.swing.JTable tbThuedia;
	    private javax.swing.JTextField txtMaDia;
	    public static final javax.swing.JTextField txtMaKh = new javax.swing.JTextField();
	    private javax.swing.JTextField txtPhidatra;
	    // End of variables declaration                   
}
