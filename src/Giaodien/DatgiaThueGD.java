/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class DatgiaThueGD extends javax.swing.JFrame {

	TieudeDAO tddao =new TieudeDAO();
	public static DefaultTableModel dataModelTieude;
	
    /**
     * Creates new form XoatieudeGD
     */
    public DatgiaThueGD() {
        initComponents();
        String[] headers = {"Mã Tiêu đề", "Tên Tiêu đề", "Mô tả","Trạng thái","Số lượng","Giá thuê","Hạn thuê","Loại DVD","Phí trễ hạn"};
        dataModelTieude = new DefaultTableModel(headers, 0);
        txtGiathue.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String giathue = txtGiathue.getText().trim();
		         if(giathue.length()==0){
		            lbMessGiathue.setText("");
		        }else{
		            if(!(giathue.length()>0 && giathue.matches("^[1-9]{1}\\d+"))){
		            	lbMessGiathue.setText("Giá thuê có số đầu khác 0");

		           }else{
		        	   lbMessGiathue.setText("");
		            }
		         }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DatgiaThueGD.this.setVisible(false);
				
			}
		});
			
		btnDatgiathue.addMouseListener(new MouseListener() {
			
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
				
		        
				int soluong =0;
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn tiêu đề cần đặt giá");
				}else {
					int hanthue = Integer.valueOf((String) tbTieude.getValueAt(index, 6));
			        String loai = (String) tbTieude.getValueAt(index, 7);
					String tentieude = (String) tbTieude.getValueAt(index, 1);
					String mota = (String) tbTieude.getValueAt(index, 2);
					String trangthai = (String) tbTieude.getValueAt(index, 3);
					String matieude = (String) tbTieude.getValueAt(index, 0);
					double phitrehan = Double.valueOf((String) tbTieude.getValueAt(index, 8));
				
				if(!(txtGiathue.getText().equalsIgnoreCase(""))) {
					double giathue = Double.valueOf(txtGiathue.getText());
					if(vaildData()==true) {
						
						try {
							soluong = tddao.demsoluongDVD(tentieude);
							Tieude td = new Tieude(Integer.valueOf(matieude), tentieude, giathue, hanthue, soluong,phitrehan, loai, mota, trangthai);
							if (tddao.updateTieude(td)==true) {
								dataModelTieude.setRowCount(0);
								txtGiathue.setText("");
								txtTentieude.setText("");
								JOptionPane.showMessageDialog(null, "Đặt giá thuê thành công!");
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}else {
						JOptionPane.showMessageDialog(null, "Đặt giá thuê không thành công!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không được để trống!");
				}
				
			}
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
		tbTieude.addMouseListener(new MouseListener() {
			
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
				int index = tbTieude.getSelectedRow();
				txtGiathue.setText((String) tbTieude.getValueAt(index, 5));
				
			}
		});
    }
    private boolean vaildData(){
		  
      
      String giathue = txtGiathue.getText().trim();

      if(!(giathue.length()>0 && giathue.matches("^[1-9]{1}\\d+"))){
    	  lbMessGiathue.setText("Giá thuê không hợp lệ");
          
          return false;
      }
     
      lbMessGiathue.setText("");
      
      
      return true;
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
        jLabel6 = new javax.swing.JLabel();
        btnDatgiathue = new javax.swing.JButton();
        txtGiathue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTieude = new javax.swing.JTable();
        txtTentieude = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbMessGiathue = new javax.swing.JLabel();
        btnKiemtraTentieude = new javax.swing.JButton();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("ĐẶT GIÁ THUÊ");

        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Giá thuê:");

        btnDatgiathue.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\tag (1).png")); // NOI18N
        btnDatgiathue.setText("Đặt giá thuê");
        btnDatgiathue.setToolTipText("");
        btnDatgiathue.setPreferredSize(new java.awt.Dimension(220, 100));

        txtGiathue.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

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

        txtTentieude.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Tên tiêu đề:");

        lbMessGiathue.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessGiathue.setForeground(new java.awt.Color(255, 0, 0));

        btnKiemtraTentieude.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraTentieude.setText("Kiểm tra");

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDatgiathue, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbMessGiathue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtGiathue, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))))
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKiemtraTentieude)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtraTentieude, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMessGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatgiathue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(DatgiaThueGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatgiaThueGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatgiaThueGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatgiaThueGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatgiaThueGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDatgiathue;
    private javax.swing.JButton btnKiemtraTentieude;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMessGiathue;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JTable tbTieude;
    private javax.swing.JTextField txtGiathue;
    private javax.swing.JTextField txtTentieude;
    // End of variables declaration                         
}
