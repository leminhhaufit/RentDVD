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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ChitietDattruocDAO;
import DAO.ChitiethoadonDAO;
import DAO.DattruocDAO;
import DAO.HoadonDAO;
import DAO.KhachhangDAO;
import DAO.TieudeDAO;
import Entity.ChitietDattruoc;
import Entity.Dattruoc;
import Entity.Hoadon;
import Entity.Khachhang;
import Entity.Tieude;

/**
 *
 * @author Minh Hau
 */
public class DattruocGD extends javax.swing.JFrame {
	TieudeDAO tddao =new TieudeDAO();
	public static DefaultTableModel dataModelTieude;
	public static DefaultTableModel dataModelDattruoc;
	KhachhangDAO khdao =new KhachhangDAO();
	DattruocDAO dtdao = new DattruocDAO();
	ChitietDattruocDAO ctdtdao = new ChitietDattruocDAO();
    /**
     * Creates new form XoatieudeGD
     */
    public DattruocGD() {
        initComponents();
        String[] headers = {"Mã Tiêu đề", "Tên Tiêu đề", "Mô tả","Trạng thái","Số lượng","Giá thuê","Hạn thuê","Loại DVD","Phí trễ hạn"};
        dataModelTieude = new DefaultTableModel(headers, 0);
        String[] headers1 = {"Mã Tiêu đề", "Tên Tiêu đề", "Mô tả","Trạng thái","Số lượng","Giá thuê","Hạn thuê","Loại DVD","Phí trễ hạn"};
        dataModelDattruoc = new DefaultTableModel(headers1, 0);
        try {
			randomMaHD();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DattruocGD.this.setVisible(false);
				
				
			}
		});
        btnKiemtraTentieude.addMouseListener(new MouseListener() {
			
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
				String tentd = txtTentieude.getText();
				
				if(!(tentd.equalsIgnoreCase(""))) {
					try {
						List<Tieude> dstd = tddao.getTieudebyTenGangiong(tentd);
						dataModelTieude.setRowCount(0);
						
						for (int i = 0; i < dstd.size(); i++) {
							String[] data= {String.valueOf(dstd.get(i).getMaTieude()),dstd.get(i).getTenTieude(),dstd.get(i).getMota(),dstd.get(i).getTrangthai(),String.valueOf(dstd.get(i).getSoluong()),String.valueOf(dstd.get(i).getGiaThue()),String.valueOf(dstd.get(i).getHanThue()),dstd.get(i).getLoaiDVD(),String.valueOf(dstd.get(i).getPhitrehan())};
							dataModelTieude.addRow(data);
							tbTieude.setModel(dataModelTieude);
						}
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không được để trống");
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
        btnDatthem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tbTieude.getSelectedRow();
				int counttd = tbTieude.getRowCount();
				int countdt = tbDattruoc.getRowCount();
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn tiêu đề!");
				}else {
					String matd = (String) tbTieude.getValueAt(index, 0);
					String tentd = (String) tbTieude.getValueAt(index, 1);
					String mota = (String) tbTieude.getValueAt(index, 2);
					String trth = (String) tbTieude.getValueAt(index, 3);
					String sl = (String) tbTieude.getValueAt(index, 4);
					String giathue = (String) tbTieude.getValueAt(index, 5);
					String hanthue = (String) tbTieude.getValueAt(index, 6);
					String loai = (String) tbTieude.getValueAt(index, 7);
					String phi = (String) tbTieude.getValueAt(index, 8);
					if(Integer.valueOf((String) tbTieude.getValueAt(index, 4))<=0) {
						String[]data = {matd,tentd,mota,trth,sl,giathue,hanthue,loai,phi};
						dataModelDattruoc.addRow(data);
						tbDattruoc.setModel(dataModelDattruoc);
						
							
						
					}else {
						JOptionPane.showMessageDialog(null, "Không được đặt tiêu đề còn đĩa");
					}
					
				}
				
			}
		});
       btnHuydatthem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tbDattruoc.getSelectedRow();
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn tiêu đề cần hủy đặt trước!");
				}else {
					
					
					dataModelDattruoc.removeRow(index);
					tbDattruoc.setModel(dataModelDattruoc);
					
				}
				
			}
		});
        btnDattruoc.addMouseListener(new MouseListener() {
			
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
				String madt = lbMahoadon.getText();
				int count = tbDattruoc.getRowCount();
				String makh = txtMaKh.getText();
				Date ngayDat = Date.valueOf(LocalDate.now());
				System.out.println("Ngay dat "+ngayDat);
				String trangthai = "Đang đặt";
				Khachhang kh;
				try {
				if(count==0) {
					JOptionPane.showMessageDialog(null, "Chưa có tiêu đề để thuê!");
				}else {
					if(!(txtTentieude.getText().equalsIgnoreCase(""))) {
							
						if(!makh.equalsIgnoreCase("")) {
								kh = khdao.getKhachhangbyID(Integer.valueOf(makh));
								Dattruoc dt = new Dattruoc(count, ngayDat, kh);
								if(dtdao.adddattruoc(dt)) {
									for (int i = 0; i < count; i++) {
										String matd = (String) tbTieude.getValueAt(i, 0);
										Dattruoc dt2 = dtdao.getdattruocbyID(Integer.valueOf(madt));
										Tieude td = tddao.getTieudebyID(Integer.valueOf(matd));
										ChitietDattruoc ctdt = new ChitietDattruoc(dt2, td, trangthai,0);
										ctdtdao.addChitietDattruoc(ctdt);
									
									}
								}
								txtMaKh.setText(""); 
						  lbSdtKH.setText(""); lbTenKH.setText("");
						  
						  lbMahoadon.setText("");
						  randomMaHD();
						  dataModelTieude.setRowCount(0); 
						  JOptionPane.showMessageDialog(null,
						  "Đặt tiêu đề thành công!");
						}else {
							JOptionPane.showMessageDialog(null, "Không được để trống");
						}
						
	
					}else {
						JOptionPane.showMessageDialog(null, "Không được để trống");
					}
				}	
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}		
				
		});
    }
    public void randomMaHD() throws Exception {
    	
    	
		int count = dtdao.demsoluongdattruoc();
		System.out.println(count+"dem");
		int mahd =1;
		int count2	= count;
		List<Dattruoc> dshd = dtdao.getAlldattruoc();
		if(count==0) {
			mahd=1;
			lbMahoadon.setText(String.valueOf(mahd));
		}else {
			while(count2<=dshd.get(count-1).getMaDattruoc()) {
				if(count2==dshd.get(count-1).getMaDattruoc()) {
					for (int i = 0; i < count2; i++) {
						if(mahd==dshd.get(count-1).getMaDattruoc()) {
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
        btnThoat = new javax.swing.JButton();
        btnDattruoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTieude = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTentieude = new javax.swing.JTextField();
        btnKiemtraTentieude = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbMahoadon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnKiemtraMaKH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbSdtKH = new javax.swing.JLabel();
        btnDatthem = new javax.swing.JButton();
        btnHuydatthem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDattruoc = new javax.swing.JTable();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("ĐẶT TRƯỚC");

        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));

        btnDattruoc.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\delete.png")); // NOI18N
        btnDattruoc.setText("Đặt trước");
        btnDattruoc.setToolTipText("");
        btnDattruoc.setPreferredSize(new java.awt.Dimension(220, 100));

        tbTieude.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbTieude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã tiêu đề", "Tên tiêu đề", "Mô tả", "Trạng thái", "Số lượng", "Giá thuê", "Hạn thuê", "Loại DVD", "Phí trễ hạn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbTieude);
        if (tbTieude.getColumnModel().getColumnCount() > 0) {
            tbTieude.getColumnModel().getColumn(0).setResizable(false);
            tbTieude.getColumnModel().getColumn(1).setResizable(false);
            tbTieude.getColumnModel().getColumn(2).setResizable(false);
            tbTieude.getColumnModel().getColumn(3).setResizable(false);
            tbTieude.getColumnModel().getColumn(4).setResizable(false);
            tbTieude.getColumnModel().getColumn(5).setResizable(false);
            tbTieude.getColumnModel().getColumn(6).setResizable(false);
            tbTieude.getColumnModel().getColumn(7).setResizable(false);
            tbTieude.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Tên tiêu đề:");

        txtTentieude.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        btnKiemtraTentieude.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraTentieude.setText("Kiểm tra");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Mã hóa đơn:");

        lbMahoadon.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Mã khách hàng:");

        txtMaKh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        btnKiemtraMaKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraMaKH.setText("Kiểm tra");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Tên khách hàng:");

        lbTenKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Số điện thoại:");

        lbSdtKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        btnDatthem.setText("v");

        btnHuydatthem.setText("^");

        tbDattruoc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbDattruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã tiêu đề", "Tên tiêu đề", "Mô tả", "Trạng thái", "Số lượng", "Giá thuê", "Hạn thuê", "Loại DVD", "Phí trễ hạn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDattruoc);
        if (tbDattruoc.getColumnModel().getColumnCount() > 0) {
            tbDattruoc.getColumnModel().getColumn(0).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(1).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(2).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(3).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(4).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(5).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(6).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(7).setResizable(false);
            tbDattruoc.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbSdtKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKiemtraMaKH)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(28, 28, 28))
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbMahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKiemtraTentieude)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDattruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(btnDatthem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(btnHuydatthem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnKiemtraTentieude, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtraMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lbSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatthem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuydatthem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDattruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(DattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DattruocGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDatthem;
    private javax.swing.JButton btnDattruoc;
    private javax.swing.JButton btnHuydatthem;
    private javax.swing.JButton btnKiemtraMaKH;
    private javax.swing.JButton btnKiemtraTentieude;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMahoadon;
    private javax.swing.JLabel lbSdtKH;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JTable tbDattruoc;
    private javax.swing.JTable tbTieude;
    public static final javax.swing.JTextField txtMaKh = new javax.swing.JTextField();
    private javax.swing.JTextField txtTentieude;
    // End of variables declaration                   
}
