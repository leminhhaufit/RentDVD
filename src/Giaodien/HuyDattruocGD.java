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
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ChitietDattruocDAO;
import DAO.DattruocDAO;
import DAO.KhachhangDAO;
import DAO.TieudeDAO;
import Entity.ChitietDattruoc;
import Entity.Dattruoc;
import Entity.Khachhang;
import Entity.Tieude;

/**
 *
 * @author Minh Hau
 */
public class HuyDattruocGD extends javax.swing.JFrame {
	TieudeDAO tddao =new TieudeDAO();
	public static DefaultTableModel dataModelTieude;
	KhachhangDAO khdao =new KhachhangDAO();
	DattruocDAO dtdao = new DattruocDAO();
	ChitietDattruocDAO ctdtdao = new ChitietDattruocDAO();
    /**
     * Creates new form XoatieudeGD
     */
    public HuyDattruocGD() {
        initComponents();
        String[] headers = {"Mã Đặt trước","Mã Tiêu đề", "Tên Tiêu đề", "Mô tả","Trạng thái","Số lượng","Giá thuê","Hạn thuê","Loại DVD","Phí trễ hạn","Ngày đặt"};
        dataModelTieude = new DefaultTableModel(headers, 0);
        btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HuyDattruocGD.this.setVisible(false);
				
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
				String trangthai = "Đang đặt";
				if(!(makh.equalsIgnoreCase(""))) {
					try {
						Khachhang kh = khdao.getKhachhangbyID(Integer.valueOf(makh));
						lbTenKH.setText(kh.getTenKH());
						lbSdtKH.setText(kh.getSdt());
						List<Dattruoc> dsdt = dtdao.getdattruocbyMaKH(Integer.valueOf(makh));
						System.out.println("ds dat truoc"+dsdt);
						
						
						dataModelTieude.setRowCount(0);
						
						for (int i = 0; i < dsdt.size(); i++) {
							System.out.println("ds dat truoc = "+dsdt.get(i).getMaDattruoc()+dsdt.size());
							List<ChitietDattruoc> dsctdt = ctdtdao.getAllChitietDattruocbyID(dsdt.get(i).getMaDattruoc());
							for (int j = 0; j < dsctdt.size(); j++) {
								if(dsctdt.get(j).getTrangthai().equals(trangthai)) {
									Tieude td = tddao.getTieudebyID(dsctdt.get(j).getTieude().getMaTieude());
									String[] data= {String.valueOf(dsctdt.get(j).getDattruoc().getMaDattruoc()),td.getTenTieude(),td.getMota(),td.getTrangthai(),String.valueOf(td.getSoluong()),String.valueOf(td.getGiaThue()),String.valueOf(td.getHanThue()),td.getLoaiDVD(),String.valueOf(td.getPhitrehan()),String.valueOf(dsdt.get(j).getNgayDat())};
									dataModelTieude.addRow(data);
									tbTieude.setModel(dataModelTieude);
								}
							}
							
						}
						
						
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
        btnHuyDattruoc.addMouseListener(new MouseListener() {
			
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
				int count = tbTieude.getRowCount();
				int index = tbTieude.getSelectedRow();
				System.out.println("index table "+index);
				String trangthai = "Đã hủy";
				if(count==0) {
					JOptionPane.showMessageDialog(null, "Chưa có đĩa để thuê!");
				}
				else{
					if((!(txtMaKh.getText().equalsIgnoreCase(""))) ) {
						if(index>=0) {
							try {
								
									
									List<ChitietDattruoc> dsctdt = ctdtdao.getAllChitietDattruocbyID(Integer.valueOf((String) tbTieude.getValueAt(index, 0)));
									for (int i = 0; i < dsctdt.size(); i++) {
										ChitietDattruoc ctdt = new ChitietDattruoc(dsctdt.get(i).getDattruoc(), dsctdt.get(i).getTieude(), trangthai);
										if(ctdtdao.updateChitietDattruoc(ctdt)) {
											dataModelTieude.setRowCount(0);
											lbTenKH.setText("");
											lbSdtKH.setText("");
											txtMaKh.setText("");
											JOptionPane.showMessageDialog(null, "Hủy đặt thành công");
										}
									
									}
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "Hủy đặt không thành công");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Chưa chọn dòng cần hủy");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Không được để trống!");
					}
			}
			}
		});
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
        btnHuyDattruoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTieude = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        btnKiemtraMaKH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbSdtKH = new javax.swing.JLabel();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("HỦY ĐẶT TRƯỚC");

        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));

        btnHuyDattruoc.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\delete.png")); // NOI18N
        btnHuyDattruoc.setText("Hủy đặt trước");
        btnHuyDattruoc.setToolTipText("");
        btnHuyDattruoc.setPreferredSize(new java.awt.Dimension(220, 100));

        tbTieude.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbTieude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đặt trước", "Mã tiêu đề", "Tên tiêu đề", "Mô tả", "Trạng thái", "Số lượng", "Giá thuê", "Hạn thuê", "Loại DVD", "Phí trễ hạn", "Ngày đặt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
            tbTieude.getColumnModel().getColumn(9).setResizable(false);
            tbTieude.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Mã khách hàng:");

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

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuyDattruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKiemtraMaKH))
                                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbSdtKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                        .addComponent(lbTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 141, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtraMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnHuyDattruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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
            java.util.logging.Logger.getLogger(HuyDattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HuyDattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HuyDattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HuyDattruocGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HuyDattruocGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnHuyDattruoc;
    private javax.swing.JButton btnKiemtraMaKH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSdtKH;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JTable tbTieude;
    private javax.swing.JTextField txtMaKh;
    // End of variables declaration              
}
