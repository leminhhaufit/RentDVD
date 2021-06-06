/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DAO.ChitiethoadonDAO;
import DAO.HoadonDAO;
import DAO.KhachhangDAO;
import DAO.PhitrehanDAO;
import Entity.Chitiethoadon;
import Entity.Hoadon;
import Entity.Khachhang;
import Entity.Phitrehan;

/**
 *
 * @author Minh Hau
 */
public class BaocaoveKHGD extends javax.swing.JFrame {
	KhachhangDAO khdao =new KhachhangDAO();
	ChitiethoadonDAO cthddao = new ChitiethoadonDAO();
	HoadonDAO hddao = new HoadonDAO();
	PhitrehanDAO pthdao = new PhitrehanDAO();
	public static DefaultTableModel dataModelKH;
	public static DefaultTableModel dataModelKH1;
	public static DefaultTableModel dataModelKH2;
	public static DefaultTableModel dataModelKH3;
    /**
     * Creates new form Clerk
     */
    public BaocaoveKHGD() {
        initComponents();
        capnhatCBLoaiBC();
        String[] headers = {"Mã KH","Tên khách hàng", "Số điện thoai", "Địa chỉ"};
        dataModelKH = new DefaultTableModel(headers, 0);
        String[] headers1 = {"Mã KH","Tên khách hàng", "Số điện thoai", "Địa chỉ","Tổng đĩa đang thuê"};
        dataModelKH1 = new DefaultTableModel(headers1, 0);
        String[] headers2 = {"Tên khách hàng", "Số điện thoai", "Địa chỉ","Tên tiêu đề","Ngày hết hạn"};
        dataModelKH2 = new DefaultTableModel(headers2, 0);
        String[] headers3 = {"Tên tiêu đề", "Ngày hết hạn", "Ngày trã DVD","Tên khách hàng","Tổng tiền phí trễ hạn"};
        dataModelKH3 = new DefaultTableModel(headers3, 0);
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
				BaocaoveKHGD.this.setVisible(false);
				
			}
		});
        btnTTCoban.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataModelKH.setRowCount(0);
				dataModelKH1.setRowCount(0);
				dataModelKH2.setRowCount(0);
				BCcoban();
				
			}
		});
        btnTongdia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataModelKH.setRowCount(0);
				dataModelKH1.setRowCount(0);
				dataModelKH2.setRowCount(0);
				BcTongsoDiadangsohuu();
			}
		});
        btnTTQuahan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataModelKH.setRowCount(0);
				dataModelKH1.setRowCount(0);
				dataModelKH2.setRowCount(0);
				BcTtQuahan();
				
			}
		});
        btnConno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataModelKH.setRowCount(0);
				dataModelKH1.setRowCount(0);
				dataModelKH2.setRowCount(0);
				dataModelKH3.setRowCount(0);
				BcTtTienNo();
				
			}
		});
    }

    public void capnhatCBLoaiBC() {
    	cbxLoaiBC.addItem("Tất cả khách hàng");
    	cbxLoaiBC.addItem("Chỉ khách hàng có 1 hoặc nhiều đĩa quá hạn");
    	cbxLoaiBC.addItem("Chỉ khách hàng nợ 1 hoặc nhiều phí trả quá hạn");
    }
    public void BCcoban() {
    	String loaibc = (String) cbxLoaiBC.getSelectedItem();
    	
    	try {
    		List<Khachhang> dskh = khdao.getAllKhachhang();
    		List<Chitiethoadon> dscthd = cthddao.getAllChitiethoadon();
    		List<Hoadon> dshd = hddao.getAllHoadon();
    		List<Phitrehan> dspth = pthdao.getAllPhitrehan();
	    	if(loaibc.equalsIgnoreCase("Tất cả khách hàng")) {
	    		
					
					for (int i = 0; i < dskh.size(); i++) {
						String[] data = {String.valueOf(dskh.get(i).getMaKH()),dskh.get(i).getTenKH(),dskh.get(i).getSdt(),dskh.get(i).getDiachi()};
						dataModelKH.addRow(data);
						tbDattruoc.setModel(dataModelKH);
					}
				
	    	}else if(loaibc.equalsIgnoreCase("Chỉ khách hàng có 1 hoặc nhiều đĩa quá hạn")) {
	    		for (int i = 0; i < dskh.size(); i++) {
	    			for (int j = 0; j < dshd.size(); j++) {
						if(dskh.get(i).getMaKH()==dshd.get(j).getMakh().getMaKH()) {
							List<Chitiethoadon> dscthd1 = cthddao.getAllChitiethoadonbyMH(dshd.get(j).getMaHoadon());
							
							for (int k = 0; k < dscthd1.size(); k++) {
								if(dscthd1.get(k).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
									Khachhang kh = khdao.getKhachhangbyID(dshd.get(j).getMakh().getMaKH());
									String[] data = {String.valueOf(kh.getMaKH()),kh.getTenKH(),kh.getSdt(),kh.getDiachi()};
									dataModelKH.addRow(data);
									tbDattruoc.setModel(dataModelKH);
								}
							}
						}
					}
	    		}
	    	}else {
	    		double tphi = 0.0;
	    		for (int i = 0; i < dskh.size(); i++) {
	    			for (int j = 0; j < dspth.size(); j++) {
						if(dskh.get(i).getMaKH()==dspth.get(j).getMakh().getMaKH()) {
							//List<Phitrehan> dspth1 = pthdao.getAllPhitrehanBymaKH(dspth.get(j).getMakh().getMaKH());
							System.out.println(Double.valueOf(dspth.get(j).getTongtienphi()));
							if(dspth.get(j).getTongtienphi()>tphi) {
								Khachhang kh = khdao.getKhachhangbyID(dspth.get(j).getMakh().getMaKH());
								String[] data = {String.valueOf(kh.getMaKH()),kh.getTenKH(),kh.getSdt(),kh.getDiachi()};
								dataModelKH.addRow(data);
								tbDattruoc.setModel(dataModelKH);
							}
						}
					}
	    		}
	    	}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    public void BcTongsoDiadangsohuu() {
    	String loaibc = (String) cbxLoaiBC.getSelectedItem();
    	
    	try {
    		List<Khachhang> dskh = khdao.getAllKhachhang();
    		List<Hoadon> dshd = hddao.getAllHoadon();
    		List<Phitrehan> dspth = pthdao.getAllPhitrehan();
    		if(loaibc.equalsIgnoreCase("Tất cả khách hàng")) {
    			for (int i = 0; i < dskh.size(); i++) {
    				List<Hoadon> dshd1 = hddao.getHoadonbyMaKH(dskh.get(i).getMaKH());
					/*
					 * List<Chitiethoadon> cthd =
					 * cthddao.getAllChitiethoadonbyMH(dshd1.get(i).getMaHoadon()); int
					 * tongdia=cthd.size(); for (int j = 0; j < dshd1.size(); j++) {
					 * 
					 * 
					 * int k=0; while (k <cthd.size()) {
					 * if(cthd.get(k).getTrangthai().equalsIgnoreCase("Đang thuê")) { tongdia--; }
					 * k++; }
					 * 
					 * }
					 */
    				int tongdia=0;
    				for (int j = 0; j < dshd1.size(); j++) {
    					List<Chitiethoadon> cthd = cthddao.getAllChitiethoadonbyMH(dshd1.get(j).getMaHoadon());
    					
    					for (int k = 0; k < cthd.size(); k++) {
							if(cthd.get(k).getTrangthai().equalsIgnoreCase("Đang thuê")) {
								tongdia++;
							}
						}
    						
    					
    				}
    				System.out.println("tong dia so huu cua kh "+tongdia);
    				Khachhang kh = khdao.getKhachhangbyID(dskh.get(i).getMaKH());
    				String[] data = {String.valueOf(kh.getMaKH()),kh.getTenKH(),kh.getSdt(),kh.getDiachi(),String.valueOf(tongdia)};
    				dataModelKH1.addRow(data);
    				tbDattruoc.setModel(dataModelKH1);
    			}
    		}else if(loaibc.equalsIgnoreCase("Chỉ khách hàng có 1 hoặc nhiều đĩa quá hạn")) {
    			for (int i = 0; i < dskh.size(); i++) {
    				List<Hoadon> dshd1 = hddao.getHoadonbyMaKH(dskh.get(i).getMaKH());
    				
    				int tongdia=0;
    				for (int j = 0; j < dshd1.size(); j++) {
    					List<Chitiethoadon> cthd = cthddao.getAllChitiethoadonbyMH(dshd1.get(j).getMaHoadon());
    					
    					for (int k = 0; k < cthd.size(); k++) {
							if(cthd.get(k).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
								tongdia++;
							}
						}
    						
    					
    				}
    				System.out.println("tong dia so huu cua kh "+tongdia);
    				Khachhang kh = khdao.getKhachhangbyID(dskh.get(i).getMaKH());
    				String[] data = {String.valueOf(kh.getMaKH()),kh.getTenKH(),kh.getSdt(),kh.getDiachi(),String.valueOf(tongdia)};
    				dataModelKH1.addRow(data);
    				tbDattruoc.setModel(dataModelKH1);
    			}
    		}else {
    			double tphi = 0.0;
    			
	    		for (int i = 0; i < dskh.size(); i++) {
	    			for (int j = 0; j < dspth.size(); j++) {
						if(dskh.get(i).getMaKH()==dspth.get(j).getMakh().getMaKH()) {
							//List<Phitrehan> dspth1 = pthdao.getAllPhitrehanBymaKH(dspth.get(j).getMakh().getMaKH());
							System.out.println(Double.valueOf(dspth.get(j).getTongtienphi()));
							if(dspth.get(j).getTongtienphi()>tphi) {
								Khachhang kh = khdao.getKhachhangbyID(dspth.get(j).getMakh().getMaKH());
								 String[] data = {String.valueOf(kh.getMaKH()),kh.getTenKH(),kh.getSdt(),kh.getDiachi()};
								 dataModelKH1.addRow(data);
								 tbDattruoc.setModel(dataModelKH1);
							}
						}
					}
	    		}
	    		
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
    public void BcTtQuahan() {
    	String loaibc = (String) cbxLoaiBC.getSelectedItem();
    	try {
    		List<Chitiethoadon> ctdt = cthddao.getAllChitiethoadon();
			List<Khachhang> dskh = khdao.getAllKhachhang();
    		if(loaibc.equalsIgnoreCase("Tất cả khách hàng")) {
    			
    			for (int i = 0; i < ctdt.size(); i++) {
					if(ctdt.get(i).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
						Hoadon hd = hddao.getHoadonbyID(ctdt.get(i).getHoadon().getMaHoadon());
						Khachhang kh = khdao.getKhachhangbyID(hd.getMakh().getMaKH());
						String[] data = {kh.getTenKH(),kh.getSdt(),kh.getDiachi(),ctdt.get(i).getTenTieude(),String.valueOf(ctdt.get(i).getNgayhethan())};
						dataModelKH2.addRow(data);
						tbDattruoc.setModel(dataModelKH2);
					}
    			
    			}
    		}else if(loaibc.equalsIgnoreCase("Chỉ khách hàng có 1 hoặc nhiều đĩa quá hạn")) {
    			for (int i = 0; i < ctdt.size(); i++) {
					if(ctdt.get(i).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
						Hoadon hd = hddao.getHoadonbyID(ctdt.get(i).getHoadon().getMaHoadon());
						Khachhang kh = khdao.getKhachhangbyID(hd.getMakh().getMaKH());
						
						String[] data = {kh.getTenKH(),kh.getSdt(),kh.getDiachi(),ctdt.get(i).getTenTieude(),String.valueOf(ctdt.get(i).getNgayhethan())};
						dataModelKH2.addRow(data);
						tbDattruoc.setModel(dataModelKH2);
					}
    			
    			}
			}else {
				for (int i = 0; i < ctdt.size(); i++) {
					if(ctdt.get(i).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
						Hoadon hd = hddao.getHoadonbyID(ctdt.get(i).getHoadon().getMaHoadon());
						Khachhang kh = khdao.getKhachhangbyID(hd.getMakh().getMaKH());
						List<Phitrehan> dspth = pthdao.getAllPhitrehanBymaKH(kh.getMaKH());
						for (int j = 0; j < dspth.size(); j++) {
							if(dspth.get(j).getTongtienphi()>0) {
								String[] data = {kh.getTenKH(),kh.getSdt(),kh.getDiachi(),ctdt.get(i).getTenTieude(),String.valueOf(ctdt.get(i).getNgayhethan())};
								dataModelKH2.addRow(data);
								tbDattruoc.setModel(dataModelKH2);
							}
						}
						
					}
    			
    			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void BcTtTienNo() {
    	String loaibc = (String) cbxLoaiBC.getSelectedItem();
    	try {
    		List<Chitiethoadon> dscthd = cthddao.getAllChitiethoadon();
    		List<Phitrehan> dspth = pthdao.getAllPhitrehan();
    		if(loaibc.equalsIgnoreCase("Tất cả khách hàng")) {
    			for (int i = 0; i < dscthd.size(); i++) {
					if(dscthd.get(i).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
						String tentd = dscthd.get(i).getTenTieude();
						Date ngayhethan = dscthd.get(i).getNgayhethan();
						Date ngaytradvd = dscthd.get(i).getNgaytraDVD();
						int makh = dscthd.get(i).getHoadon().getMakh().getMaKH();
						List<Phitrehan> dspth2 = pthdao.getAllPhitrehanBymaKH(makh);
						double tong2=0;
						for (int j = 0; j < dspth2.size(); j++) {
							tong2 = dspth2.get(i).getTongtienphi();
							tong2+=tong2;
						}
						System.out.println("Tong phi tre han BC: "+tong2);
						Khachhang kh = khdao.getKhachhangbyID(makh);
						String[] data = {dscthd.get(i).getTenTieude(),String.valueOf(dscthd.get(i).getNgayhethan()),String.valueOf(dscthd.get(i).getNgaytraDVD()),kh.getTenKH(),String.valueOf(tong2)};
						dataModelKH3.addRow(data);
						tbDattruoc.setModel(dataModelKH3);
					}
				}
    		}else if(loaibc.equalsIgnoreCase("Chỉ khách hàng có 1 hoặc nhiều đĩa quá hạn")) {
    			for (int i = 0; i < dscthd.size(); i++) {
					if(dscthd.get(i).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
						String tentd = dscthd.get(i).getTenTieude();
						Date ngayhethan = dscthd.get(i).getNgayhethan();
						Date ngaytradvd = dscthd.get(i).getNgaytraDVD();
						int makh = dscthd.get(i).getHoadon().getMakh().getMaKH();
						List<Phitrehan> dspth2 = pthdao.getAllPhitrehanBymaKH(makh);
						double tong2=0;
						for (int j = 0; j < dspth2.size(); j++) {
							tong2 = dspth2.get(i).getTongtienphi();
							tong2+=tong2;
						}
						System.out.println("Tong phi tre han BC: "+tong2);
						Khachhang kh = khdao.getKhachhangbyID(makh);
						String[] data = {dscthd.get(i).getTenTieude(),String.valueOf(dscthd.get(i).getNgayhethan()),String.valueOf(dscthd.get(i).getNgaytraDVD()),kh.getTenKH(),String.valueOf(tong2)};
						dataModelKH3.addRow(data);
						tbDattruoc.setModel(dataModelKH3);
					}
				}
    		}else {
    			for (int i = 0; i < dscthd.size(); i++) {
					if(dscthd.get(i).getTrangthai().equalsIgnoreCase("Trễ hạn")) {
						String tentd = dscthd.get(i).getTenTieude();
						Date ngayhethan = dscthd.get(i).getNgayhethan();
						Date ngaytradvd = dscthd.get(i).getNgaytraDVD();
						int makh = dscthd.get(i).getHoadon().getMakh().getMaKH();
						List<Phitrehan> dspth2 = pthdao.getAllPhitrehanBymaKH(makh);
						double tong2=0;
						for (int j = 0; j < dspth2.size(); j++) {
							tong2 = dspth2.get(i).getTongtienphi();
							tong2+=tong2;
						}
						System.out.println("Tong phi tre han BC: "+tong2);
						if(tong2>0) {
							Khachhang kh = khdao.getKhachhangbyID(makh);
							String[] data = {dscthd.get(i).getTenTieude(),String.valueOf(dscthd.get(i).getNgayhethan()),String.valueOf(dscthd.get(i).getNgaytraDVD()),kh.getTenKH(),String.valueOf(tong2)};
							dataModelKH3.addRow(data);
							tbDattruoc.setModel(dataModelKH3);
						}
					}
    			}
    		}
		} catch (Exception e) {
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
        btnTTQuahan = new javax.swing.JButton();
        btnQuaylai = new javax.swing.JLabel();
        cbxLoaiBC = new javax.swing.JComboBox<>();
        btnTTCoban = new javax.swing.JButton();
        btnTongdia = new javax.swing.JButton();
        btnConno = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDattruoc = new javax.swing.JTable();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("BÁO CÁO VỀ KHÁCH HÀNG");

        btnTTQuahan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTTQuahan.setText("Thông tin quá hạn");
        btnTTQuahan.setPreferredSize(new java.awt.Dimension(220, 100));

        btnQuaylai.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        btnQuaylai.setForeground(new java.awt.Color(204, 0, 0));
        btnQuaylai.setText("Quay lại");

        cbxLoaiBC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTTCoban.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTTCoban.setText("Thông tin cơ bản");
        btnTTCoban.setPreferredSize(new java.awt.Dimension(220, 100));

        btnTongdia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTongdia.setText("Tổng số đĩa đang có");
        btnTongdia.setPreferredSize(new java.awt.Dimension(220, 100));

        btnConno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnConno.setText("Thông tin còn nợ");
        btnConno.setPreferredSize(new java.awt.Dimension(220, 100));

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
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTTQuahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTTCoban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTongdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxLoaiBC, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxLoaiBC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnTTCoban, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTongdia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTTQuahan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnQuaylai)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(BaocaoveKHGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaocaoveKHGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaocaoveKHGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaocaoveKHGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaocaoveKHGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnConno;
    private javax.swing.JLabel btnQuaylai;
    private javax.swing.JButton btnTTCoban;
    private javax.swing.JButton btnTTQuahan;
    private javax.swing.JButton btnTongdia;
    private javax.swing.JComboBox<String> cbxLoaiBC;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JTable tbDattruoc;
    // End of variables declaration                   
}
