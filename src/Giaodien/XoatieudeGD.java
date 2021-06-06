/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.TieudeDAO;
import Entity.Tieude;

/**
 *
 * @author Minh Hau
 */
public class XoatieudeGD extends javax.swing.JFrame {
	TieudeDAO tddao =new TieudeDAO();
	public static DefaultTableModel dataModelTieude;
    /**
     * Creates new form XoatieudeGD
     */
    public XoatieudeGD() {
        initComponents();
        String[] headers = {"Mã Tiêu đề", "Tên Tiêu đề", "Mô tả","Trạng thái","Số lượng","Giá thuê","Hạn thuê","Loại DVD","Phí trễ hạn"};
        dataModelTieude = new DefaultTableModel(headers, 0);
        btnThoat.addMouseListener(new MouseListener() {
			
        	
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
				XoatieudeGD.this.setVisible(false);
				
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
		btnXoaTieude.addMouseListener(new MouseListener() {
			
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
			public void mouseClicked(MouseEvent arg0) {
				int index = tbTieude.getSelectedRow();
				double giathue = Double.valueOf((String) tbTieude.getValueAt(index, 5));
		        int hanthue = Integer.valueOf((String) tbTieude.getValueAt(index, 6));
		        String loai = (String) tbTieude.getValueAt(index, 7);
				String tentieude = (String) tbTieude.getValueAt(index, 1);
				String mota = (String) tbTieude.getValueAt(index, 2);
				String trangthai = (String) tbTieude.getValueAt(index, 3);
				String matieude = (String) tbTieude.getValueAt(index, 0);
				double phitrehan = Double.valueOf((String) tbTieude.getValueAt(index, 8));
				int soluong =0;
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn tiêu đề cần xóa");
				}else {

						try {
							soluong = tddao.demsoluongDVD(tentieude);
							Tieude td = new Tieude(Integer.valueOf(matieude), tentieude, giathue, hanthue, soluong,phitrehan, loai, mota, trangthai);
							Tieude td2 = tddao.getTieudebyID(Integer.valueOf(matieude));
							if(td2.getDSdvd().size()==0) {
								if (tddao.deleteTieude(td)==true) {
									dataModelTieude.setRowCount(0);
									
									txtTentieude.setText("");
									JOptionPane.showMessageDialog(null, "Xóa tiêu đề thành công!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Còn DVD không được xóa!");
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnChinh = new javax.swing.JPanel();
        lbTieude = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        btnXoaTieude = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTieude = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTentieude = new javax.swing.JTextField();
        btnKiemtraTentieude = new javax.swing.JButton();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("XÓA TIÊU ĐỀ");

        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));

        btnXoaTieude.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\delete.png")); // NOI18N
        btnXoaTieude.setText("Xóa tiêu đề");
        btnXoaTieude.setToolTipText("");
        btnXoaTieude.setPreferredSize(new java.awt.Dimension(220, 100));

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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbTieude);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Tên tiêu đề:");

        txtTentieude.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        btnKiemtraTentieude.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraTentieude.setText("Kiểm tra");

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKiemtraTentieude)))
                        .addGap(0, 132, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtraTentieude, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnXoaTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
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
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(XoatieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XoatieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XoatieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XoatieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XoatieudeGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKiemtraTentieude;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoaTieude;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JTable tbTieude;
    private javax.swing.JTextField txtTentieude;
    // End of variables declaration//GEN-END:variables
}
