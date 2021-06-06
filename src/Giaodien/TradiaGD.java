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
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ChitietDattruocDAO;
import DAO.ChitiethoadonDAO;
import DAO.DVDDAO;
import DAO.DattruocDAO;
import DAO.HoadonDAO;
import DAO.KhachhangDAO;
import DAO.PhitrehanDAO;
import DAO.TieudeDAO;
import Entity.ChitietDattruoc;
import Entity.ChitietDattruocID;
import Entity.Chitiethoadon;
import Entity.DVD;
import Entity.Dattruoc;
import Entity.Hoadon;
import Entity.Khachhang;
import Entity.Phitrehan;
import Entity.Tieude;

/**
 *
 * @author Minh Hau
 */
public class TradiaGD extends javax.swing.JFrame {
	
	KhachhangDAO khdao = new KhachhangDAO();
	TieudeDAO tddao =new TieudeDAO();
	HoadonDAO hddao = new HoadonDAO();
	ChitiethoadonDAO cthddao = new ChitiethoadonDAO();
	ChitietDattruocDAO ctdtdao = new ChitietDattruocDAO();
	PhitrehanDAO pthdao = new PhitrehanDAO();
	DattruocDAO dtdao = new DattruocDAO();
	DVDDAO dvddao =new DVDDAO();
	public static DefaultTableModel dataModelTra;
	public static DefaultTableModel dataModelDat;

    /**
     * Creates new form ThuediaGD
     */
    public TradiaGD() {
        initComponents();
        String[] headers = {"Mã DVD","Mã Hóa đơn", "Tên Tiêu đề", "Ngày hết hạn","Mã tiêu đề"};
        dataModelTra = new DefaultTableModel(headers, 0);
        dataModelTra.setRowCount(0);
        tbTradia.setModel(dataModelTra);
        String[] headers2 = {"Mã đặt trước", "Tên Tiêu đề", "Ngày đặt","Tên khách hàng","Số điện thoại"};
        dataModelDat = new DefaultTableModel(headers2, 0);
        dataModelDat.setRowCount(0);
        tbDattruoc.setModel(dataModelDat);
        btnKiemtraMaKH1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChinhsachPhitrehanGD cspthgd = new ChinhsachPhitrehanGD();
				cspthgd.setVisible(true);
				
			}
		});
        lbNgayhientai.setText(String.valueOf(LocalDate.now()));
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
				lbTongphitrehan.setText("");
				txtPhidatra.setText("");
				
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
        btnThanhToanphitrehan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double datra = Double.valueOf(txtPhidatra.getText());
				double tonggia = Double.valueOf(lbTongphitrehan.getText());
				
				try {
					Khachhang kh = khdao.getKhachhangbyID(Integer.valueOf(lbMaKH.getText()));
					
					if(!(txtPhidatra.getText().equalsIgnoreCase(""))) {
						if(datra<=tonggia) {
							double tongmoi = tonggia-datra;
							if(vaildData()==true) {
								
									Phitrehan pth  = new Phitrehan(tongmoi, datra, Date.valueOf(LocalDate.now()),kh);
									pthdao.updatePhitrehan(pth);
									lbPhitrehandatra.setText("");
									lbTongphitrehan.setText("");
									txtPhidatra.setText("");
								JOptionPane.showMessageDialog(null, "Trả phí thành công!");
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
				TradiaGD.this.setVisible(false);
				
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
				double tonggia = Double.valueOf(lbTongphitrehan.getText());
				
				try {
					Khachhang kh = khdao.getKhachhangbyID(Integer.valueOf(lbMaKH.getText()));
					
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
											lbTongphitrehan.setText("");
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
        btnKiemtraMadia.addMouseListener(new MouseListener() {
			
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
				String madia = txtMaDia.getText();
				int count = tbTradia.getRowCount();
				
				try {
					if(!(madia.equalsIgnoreCase(""))) {
						Chitiethoadon dscthd = cthddao.getChitietHDbyMaDVD(Integer.valueOf(madia));
						
						DVD dvd = dvddao.getDVDbyID(Integer.valueOf(madia));
						Hoadon hd = hddao.getHoadonbyID(dscthd.getHoadon().getMaHoadon());
						Khachhang kh = khdao.getKhachhangbyID(hd.getMakh().getMaKH());
						lbTenKH.setText(kh.getTenKH()); lbSdtKH.setText(kh.getSdt());
						lbMaKH.setText(String.valueOf(kh.getMaKH()));
						if(count==0) {
							String[] data = {String.valueOf(dscthd.getDvd().getMaDVD()),String.valueOf(dscthd.getHoadon().getMaHoadon()),dscthd.getTenTieude(),String.valueOf(dscthd.getNgayhethan()),String.valueOf(dvd.getTieude().getMaTieude())};
							dataModelTra.addRow(data);
							tbTradia.setModel(dataModelTra);
						}else {
							for (int i = 0; i < count; i++) {
								
								 if(!(madia.equals(tbTradia.getValueAt(i, 0)))) {
									if(i==count-1) {
										 String[] data = {String.valueOf(dscthd.getDvd().getMaDVD()),String.valueOf(dscthd.getHoadon().getMaHoadon()),dscthd.getTenTieude(),String.valueOf(dscthd.getNgayhethan()),String.valueOf(dvd.getTieude().getMaTieude())};
											dataModelTra.addRow(data);
											tbTradia.setModel(dataModelTra);
											
									 }
								}else {
									JOptionPane.showMessageDialog(null, "Không thể thêm nữa!");
								}
								 
								
							}
							
						
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Không để trống!");
					}
					
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
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
				int index = tbTradia.getSelectedRow();
				
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn đĩa cần xóa!");
				}else {
					dataModelTra.removeRow(index);
					int count = tbTradia.getRowCount();
					if(count==0) {
						lbTenKH.setText("");
						lbSdtKH.setText("");
					}
				}
				
			}
		});
       
        btnTradia.addMouseListener(new MouseListener() {
			
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
				int count = tbTradia.getRowCount();
				if(count==0) {
					JOptionPane.showMessageDialog(null, "Không có đĩa để trả!");
				}else {
					if(!(txtMaDia.getText().equalsIgnoreCase(""))) {
						try {
						for (int i = 0; i < count; i++) {
							 DVD dvd = dvddao.getDVDbyID(Integer.valueOf((String) tbTradia.getValueAt(i, 0)));
							 Tieude td =  tddao.getTieudebyID(Integer.valueOf((String) tbTradia.getValueAt(i, 4)));
							  DVD dvdup = new DVD(dvd.getMaDVD(), "Có thể thuê",td);
							  dvddao.updateDVD(dvdup);
							  Chitiethoadon dscthd = cthddao.getChitietHDbyMaDVD(Integer.valueOf((String) tbTradia.getValueAt(i, 0)));
							  Hoadon hd = hddao.getHoadonbyID(dscthd.getHoadon().getMaHoadon());
							 
							  
							  
							  Date ngayhientai = Date.valueOf(LocalDate.now());
							  //Date ngayhientai = Date.valueOf(LocalDate.of(2021, 1, 1));
							  Date ngayhethan = dscthd.getNgayhethan();
							  if(ngayhethan.compareTo(ngayhientai)<0) {
								  Chitiethoadon cthd = new Chitiethoadon(hd, dvdup, dscthd.getTenTieude(), dscthd.getGiaThue(), dscthd.getHanthue(), dscthd.getNgayhethan(),Date.valueOf(lbNgayhientai.getText()), "Trễ hạn");
								  cthddao.updateChitiethoadon(cthd);
								  
								  
							  }else {
								  Chitiethoadon cthd = new Chitiethoadon(hd, dvdup, dscthd.getTenTieude(), dscthd.getGiaThue(), dscthd.getHanthue(), dscthd.getNgayhethan(),Date.valueOf(lbNgayhientai.getText()), "Đã trả");
								  cthddao.updateChitiethoadon(cthd);
							  }
							  
							  
						}
						danhsachDattruoc();
						ganDiavaoDattruoc();
						capnhatSoluongDVDtrongTieude();
						tinhPhitrehan();
						lbMaKH.setText("");
						 lbSdtKH.setText("");
						  lbTenKH.setText("");
						  dataModelTra.setRowCount(0);
						  JOptionPane.showMessageDialog(null, "Trả thành công!");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Không được để trống!");
					}
					
					
				}
				
				
			}
		});
        
    }
    int soluong1=0;
    public void capnhatSoluongDVDtrongTieude() {
		 
		 String madia = txtMaDia.getText();
		
		 int count = tbTradia.getRowCount();
		 String trangthai="Còn hàng";
		 try {
		 for (int i = 0; i < count; i++) {
			String matd = (String) tbTradia.getValueAt(i, 4);
			Tieude td = tddao.getTieudebyID(Integer.valueOf(matd));
			
			List<DVD> dsdvd= td.getDSdvd();
			int soluong=td.getDSdvd().size();
			
			
			for (int j = 0; j <td.getDSdvd().size(); j++) {
				if(dsdvd.get(j).getTrangthai().equals("Đã được thuê")) {
					soluong--;
					if(soluong==0) {
						 soluong=0;
						 trangthai ="Hết hàng";
					}else {
						
						trangthai="Còn hàng";
					}
				}
				
				
			}
			Tieude td2 = new Tieude(td.getMaTieude(), td.getTenTieude(), td.getGiaThue(), td.getHanThue(), soluong, td.getPhitrehan(), td.getLoaiDVD(), td.getMota(), trangthai);
			tddao.updateTieude(td2);
			
		 } 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    double tongphi=0,datra=0,tongphiall=0,datraall=0;;
    Date ngaytra =null;
    public void tinhPhitrehan() {
    	String makh = lbMaKH.getText();
    	
    	try {
			List<Hoadon> dshd = hddao.getHoadonbyMaKH(Integer.valueOf(makh));
			
			for (int i = 0; i < dshd.size(); i++) {
				List<Chitiethoadon> dscthd = cthddao.getAllChitiethoadonbyMH(dshd.get(i).getMaHoadon());
				for (int j = 0; j <dscthd.size(); j++) {
					if(dscthd.get(j).getTrangthai().equals("Trễ hạn")) {
						DVD dvd = dvddao.getDVDbyID(dscthd.get(j).getDvd().getMaDVD());
						
						tongphi+= dvd.getTieude().getPhitrehan();
						
					}
					
				}
				
				
			}
			Phitrehan pth = new Phitrehan(tongphi, datra, ngaytra, khdao.getKhachhangbyID(Integer.valueOf(makh)));
			pthdao.addPhitrehan(pth);
			List<Phitrehan> dspth2 = pthdao.getAllPhitrehanBymaKH(Integer.valueOf(makh));
			for (int i = 0; i < dspth2.size(); i++) {
				tongphiall+= dspth2.get(i).getTongtienphi();
				datraall+= dspth2.get(i).getTienphidatra();
			}
			
			lbTongphitrehan.setText(String.valueOf(tongphiall));
			lbPhitrehandatra.setText(String.valueOf(datraall));
			System.out.println(tongphi);
			System.out.println(pth);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
   

    public void danhsachDattruoc() {
    	int countTra = tbTradia.getRowCount();
    	String trangthai = "Đang đặt";
    	System.out.println("countTra "+ countTra);
    	for (int i = 0; i < countTra; i++) {
			try {
				List<ChitietDattruoc> dsctdt = ctdtdao.getAllChitietDattruocbymaTieude(Integer.valueOf((String) tbTradia.getValueAt(i, 4)));
				for (int j = 0; j < dsctdt.size(); j++) {
					Dattruoc dt = dtdao.getdattruocbyID(Integer.valueOf(dsctdt.get(j).getDattruoc().getMaDattruoc()));
					Khachhang kh = khdao.getKhachhangbyID(dt.getMakh().getMaKH());
					System.out.println("Dat truoc "+ dt);
					System.out.println("KH "+ kh);
					if(dsctdt.get(j).getTrangthai().equals(trangthai)) {
						String[] data= {String.valueOf(dt.getMaDattruoc()),String.valueOf(dsctdt.get(i).getTieude().getMaTieude()),String.valueOf(dt.getNgayDat()),kh.getTenKH(),kh.getSdt()};
						dataModelDat.addRow(data);
						tbDattruoc.setModel(dataModelDat);
						
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
    public void ganDiavaoDattruoc() {
    	int countTra = tbTradia.getRowCount();
    	int countDat = tbDattruoc.getRowCount();
    	String trangthai = "Đang giữ";
    	try {
    	if(countDat>0) {
    		for (int i = 0; i < countTra; i++) {
        		String madvd = (String) tbTradia.getValueAt(i, 0);
        		String matd = (String) tbTradia.getValueAt(i, 4);
        		
				List<ChitietDattruoc> dsctdt = ctdtdao.getAllChitietDattruocbymaTieude(Integer.valueOf(matd));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date1=null;
				int tam=0,tam2=0;
				for (int j2 = 0; j2 < dsctdt.size(); j2++) {
					if((dsctdt.get(j2).getTrangthai().equalsIgnoreCase("Đang đặt"))) {
						date1 = sdf.format(dsctdt.get(j2).getDattruoc().getNgayDat());
						System.out.println(date1 +" date1");
						tam2=j2;
						System.out.println("tam2-1 "+tam2);
						for (int j = tam2; j < dsctdt.size(); j++) {//size =2 //j=1 //j==2
							
							if((tam2+1)<dsctdt.size()) {
								String date2 = sdf.format(dsctdt.get(tam2+1).getDattruoc().getNgayDat());
								System.out.println(date2 +" date2");
								System.out.println("tam2-2 "+tam2);
								if((dsctdt.get(tam2+1).getTrangthai().equalsIgnoreCase("Đang đặt"))) {
									
								
									System.out.println("Đang giu "+j);
									if(date1.compareTo(date2)>0 ) {
										date1 = date1;
										tam=j;
										System.out.println("Tam count 1 "+tam);
									}else {
										date1 = date2;
										tam=j;
										System.out.println("Tam count 2 "+tam);
									}
								}
								
							}else {
								
								tam=j;
								System.out.println("Tam count 3 "+tam);
							}
						}
					}
				}
				
					
				
				ChitietDattruoc ctdt = new ChitietDattruoc(dsctdt.get(tam).getDattruoc(), dsctdt.get(tam).getTieude(), trangthai, Integer.valueOf(madvd));
				ctdtdao.updateChitietDattruoc(ctdt);
				
				DVD dvd = dvddao.getDVDbyID(Integer.valueOf(madvd));
				DVD dvd2 = new DVD(dvd.getMaDVD(), trangthai, dvd.getTieude());
				dvddao.updateDVD(dvd2);
    		}
    	}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void huyDattruoc() {
    	int index = tbDattruoc.getSelectedRow();
    	String madt = (String) tbDattruoc.getValueAt(index, 0);
    	String matd = (String) tbDattruoc.getValueAt(index, 1);
    	String trangthai = "Đang giữ";
    	String trangthaidvd = "Có thể thuê";
    	try {
			if(index==-1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn mục cần hủy!");
			}else {
				Dattruoc dt = dtdao.getdattruocbyID(Integer.valueOf(madt));
				Tieude td = tddao.getTieudebyID(Integer.valueOf(matd));
				ChitietDattruoc ctdt = ctdtdao.getChitietDattruocbyID(dt.getMaDattruoc());
				ChitietDattruoc ctdt2 = new ChitietDattruoc(dt, td, trangthai,ctdt.getMadvd());
				
				
				DVD dvd = dvddao.getDVDbyID(ctdt.getMadvd());
				DVD dvd2 = new DVD(dvd.getMaDVD(), trangthaidvd, dvd.getTieude());
				ctdtdao.updateChitietDattruoc(ctdt2);
				dvddao.updateDVD(dvd2);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        lbSdtKH = new javax.swing.JLabel();
        txtMaDia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnKiemtraMadia = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTradia = new javax.swing.JTable();
        btnXoaGH = new javax.swing.JButton();
        btnTradia = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pnPhitrehan = new javax.swing.JPanel();
        lbPhitrehan = new javax.swing.JLabel();
        btnThanhToanphitrehan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbNgayhientai = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbPhitrehandatra = new javax.swing.JLabel();
        btnKhongTT = new javax.swing.JButton();
        txtPhidatra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbMessTienphidatra = new javax.swing.JLabel();
        btnKiemtraMaKH1 = new javax.swing.JButton();
        pnDattruoc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDattruoc = new javax.swing.JTable();
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

        pnThue.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0)), "Trả đĩa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24), new java.awt.Color(51, 51, 0))); // NOI18N

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

        btnKiemtraMadia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraMadia.setText("Kiểm tra");

        tbTradia.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbTradia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã DVD", "Mã hóa đơn", "Tên Tiêu đề", "Ngày hết hạn", "Mã tiêu đề"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbTradia);

        btnXoaGH.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\minus.png")); // NOI18N

        btnTradia.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\return.png")); // NOI18N
        btnTradia.setText("Trả đĩa");
        btnTradia.setPreferredSize(new java.awt.Dimension(220, 100));
        btnTradia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTradiaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Mã khách hàng:");

        lbMaKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        javax.swing.GroupLayout pnThueLayout = new javax.swing.GroupLayout(pnThue);
        pnThue.setLayout(pnThueLayout);
        pnThueLayout.setHorizontalGroup(
            pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThueLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKiemtraMadia)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnThueLayout.createSequentialGroup()
                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThueLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaGH, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThueLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnTradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThueLayout.createSequentialGroup()
                        .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnThueLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(lbMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnThueLayout.createSequentialGroup()
                                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbSdtKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(99, 99, 99)))
                .addContainerGap())
        );
        pnThueLayout.setVerticalGroup(
            pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThueLayout.createSequentialGroup()
                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtraMadia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(lbSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaGH))
                .addGap(18, 18, 18)
                .addComponent(btnTradia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnPhitrehan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)), "Phí trễ hạn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24))); // NOI18N

        lbPhitrehan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbPhitrehan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPhitrehan.setText("Thanh toán phí trễ hạn thuê đĩa không?");

        btnThanhToanphitrehan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnThanhToanphitrehan.setForeground(new java.awt.Color(0, 153, 153));
        btnThanhToanphitrehan.setText("Thanh toán");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Ngày hiện tại:");

        lbNgayhientai.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbNgayhientai.setText("24/10/1999");

        lbTongphitrehan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbTongphitrehan.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Tổng tiền phí trễ hạn:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PHÍ TRỄ HẠN");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Phí trễ hạn đã trả:");

        lbPhitrehandatra.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        btnKhongTT.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnKhongTT.setForeground(new java.awt.Color(153, 0, 0));
        btnKhongTT.setText("Không thanh toán");

        txtPhidatra.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Tiền phí muốn trả:");

        lbMessTienphidatra.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessTienphidatra.setForeground(new java.awt.Color(255, 0, 0));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhitrehanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnPhitrehanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPhitrehan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addGroup(pnPhitrehanLayout.createSequentialGroup()
                        .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongphitrehan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPhitrehandatra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnPhitrehanLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKiemtraMaKH1)
                            .addGroup(pnPhitrehanLayout.createSequentialGroup()
                                .addComponent(btnThanhToanphitrehan)
                                .addGap(18, 18, 18)
                                .addComponent(btnKhongTT)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnPhitrehanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessTienphidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnPhitrehanLayout.setVerticalGroup(
            pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhitrehanLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lbPhitrehandatra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbTongphitrehan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPhitrehanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhidatra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessTienphidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbPhitrehan)
                .addGap(51, 51, 51)
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

        pnDattruoc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)), "Danh sách đặt trước", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24))); // NOI18N

        tbDattruoc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbDattruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đặt trước", "Tên Tiêu đề", "Ngày đặt", "Tên khách hàng", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane3.setViewportView(tbDattruoc);
        if (tbDattruoc.getColumnModel().getColumnCount() > 0) {
            tbDattruoc.getColumnModel().getColumn(0).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(1).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(2).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(3).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout pnDattruocLayout = new javax.swing.GroupLayout(pnDattruoc);
        pnDattruoc.setLayout(pnDattruocLayout);
        pnDattruocLayout.setHorizontalGroup(
            pnDattruocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDattruocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pnDattruocLayout.setVerticalGroup(
            pnDattruocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDattruocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        btnQuaylai.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        btnQuaylai.setForeground(new java.awt.Color(204, 0, 0));
        btnQuaylai.setText("Quay lại");

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDattruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnPhitrehan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuaylai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPhitrehan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addComponent(pnThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnDattruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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

    private void btnTradiaActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
            java.util.logging.Logger.getLogger(TradiaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradiaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradiaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradiaGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TradiaGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnKhongTT;
    private javax.swing.JButton btnKiemtraMaKH1;
    private javax.swing.JButton btnKiemtraMadia;
    private javax.swing.JLabel btnQuaylai;
    private javax.swing.JButton btnThanhToanphitrehan;
    private javax.swing.JButton btnTradia;
    private javax.swing.JButton btnXoaGH;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static final javax.swing.JLabel lbMaKH = new javax.swing.JLabel();
    private javax.swing.JLabel lbMessTienphidatra;
    private javax.swing.JLabel lbNgayhientai;
    private javax.swing.JLabel lbPhitrehan;
    private javax.swing.JLabel lbPhitrehandatra;
    private javax.swing.JLabel lbSdtKH;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTieude;
    public static final javax.swing.JLabel lbTongphitrehan = new javax.swing.JLabel();
    private javax.swing.JPanel pnChinh;
    private javax.swing.JPanel pnDattruoc;
    private javax.swing.JPanel pnPhitrehan;
    private javax.swing.JPanel pnThue;
    private javax.swing.JTable tbDattruoc;
    private javax.swing.JTable tbTradia;
    private javax.swing.JTextField txtMaDia;
    private javax.swing.JTextField txtPhidatra;
    // End of variables declaration                   
}
