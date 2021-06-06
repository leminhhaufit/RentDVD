/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.KhachhangDAO;
import Entity.Khachhang;

/**
 *
 * @author Minh Hau
 */
public class CapnhatKhachhangGD extends javax.swing.JFrame {

	 KhachhangDAO khdao = new KhachhangDAO();
    /**
     * Creates new form CapnhatKhachhangGD
     */
    public CapnhatKhachhangGD() {
        initComponents();
        try {
			capnhatcomboboxMaKhachHang();
			timbyTenInCBX();
			Khachhang kh = khdao.getKhachhangbyID(1);
			txtTenKH.setText(kh.getTenKH());
			txtSdt.setText(kh.getSdt());
			txtDiachi.setText(kh.getDiachi());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
        //tenkh
        txtTenKH.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String tenKH = txtTenKH.getText().trim();
		        if (tenKH.length() == 0) {
		            lbMessTenKH.setText("");
		        } else {
		        	 if (!(tenKH.length() > 0 && tenKH.matches("^[A-Z]{1}[A-Z\\p{L}\\d,. ]+"))) {
		        		 lbMessTenKH.setText("Viết hoa chữ cái đầu và có cách nhau");
		            } else {
		            	lbMessTenKH.setText("");
		            }
		        }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        //sdt
        txtSdt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String sdt = txtSdt.getText().trim();
		         if(sdt.length()==0){
		            lbMessSdt.setText("");
		        }else{
		            if(!(sdt.length()>0 && sdt.matches("0{1}\\d{9}$"))){
		            	lbMessSdt.setText("Sdt phải là 10 kí tự số - có số 0 ở đầu");

		           }else{
		        	   lbMessSdt.setText("");
		            }
		         }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        //diachi
        txtDiachi.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String dc = txtDiachi.getText().trim();
			       if(dc .length()==0){
			            lbMessDiachi.setText("");
			        }else{
			            if(!(dc.length()>0 && dc.matches("[A-Z\\p{L}\\d,. ]+"))){
			            	lbMessDiachi.setText("Không chứa kí tự đặt biết");
			             }else{
			            	 lbMessDiachi.setText("");
			            }
			       }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        //cbkh
        cbxMaKH.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				try {
					String chon =(String) cbxMaKH.getSelectedItem();
					List<Khachhang> dskh = khdao.getAllKhachhang();
					for(Khachhang kh : dskh) {
						if(String.valueOf(kh.getMaKH()).equals(chon)){
							txtTenKH.setText(kh.getTenKH());
							txtSdt.setText(kh.getSdt());
							txtDiachi.setText(kh.getDiachi());
							
						}
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
        //btn sua 
        btnCapnhatKH.addMouseListener(new MouseListener() {
			
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
				String tenkh = txtTenKH.getText();
				String sdt = txtSdt.getText();
				String diachi = txtDiachi.getText();
				String maKH = (String) cbxMaKH.getSelectedItem();
				Khachhang kh = new Khachhang(Integer.valueOf(maKH), tenkh, sdt, diachi);
				if(!(txtTenKH.getText().equalsIgnoreCase("") && txtSdt.getText().equalsIgnoreCase("")&& txtDiachi.getText().equalsIgnoreCase(""))) {
					if(vaildData()==true) {
						try {
							if(khdao.updateKhachhang(kh)==true) {
								txtTenKH.setText("");
								txtSdt.setText("");
								txtDiachi.setText("");
								JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công!");
								
								
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không được để trống!");
				}
				
			}
		});
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
				CapnhatKhachhangGD.this.setVisible(false);
				
			}
		});
    }
    private void timbyTenInCBX(){
        cbxMaKH.setSelectedItem("");
        cbxMaKH.setEditable(true);
        //AutoCompleteDecorator.decorate();
        
       
    }
    private boolean vaildData(){
        
        String ten = txtTenKH.getText().trim();
        String sdt = txtSdt.getText().trim();
        String dc = txtDiachi.getText().trim();
        
        
       
        if(!(ten.length()>0 && ten.matches("(^[A-Z]{1}[\\p{L}\\s]+)[A-Z]{1}[\\p{L}\\s]+"))){
            lbMessTenKH.setText("Tên không hợp lệ");
            
            return false;
        }
        if(!(sdt.length()>0 && sdt.matches("[0]{1}\\d{9}$"))){
            lbMessSdt.setText("Số điện thoai không hợp lệ");
            return false;
        }
        if(!(dc.length()>0 && dc.matches("[A-Z\\p{L}\\d,. ]+"))){
            lbMessDiachi.setText("Địa chỉ không hợp lệ");
            return false;
        }
       
        lbMessTenKH.setText("");
        lbMessDiachi.setText("");
        lbMessSdt.setText("");
        
        return true;
    }
    private void capnhatcomboboxMaKhachHang() throws Exception {
       
        List<Khachhang> dskh = khdao.getAllKhachhang();
        
        for (Khachhang kh : dskh) {
        	cbxMaKH.addItem(String.valueOf(kh.getMaKH()));
           
        }
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
        jLabel2 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxMaKH = new javax.swing.JComboBox<>();
        btnCapnhatKH = new javax.swing.JButton();
        lbMessTenKH = new javax.swing.JLabel();
        lbMessSdt = new javax.swing.JLabel();
        lbMessDiachi = new javax.swing.JLabel();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("CẬP NHẬT KHÁCH HÀNG");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Tên khách hàng:");

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Số điện thoại:");

        txtSdt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Địa chỉ:");

        txtDiachi.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Mã khách hàng:");

        btnCapnhatKH.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\content-management-system.png")); // NOI18N
        btnCapnhatKH.setText("Cập nhật khách hàng");
        btnCapnhatKH.setPreferredSize(new java.awt.Dimension(220, 100));

        lbMessTenKH.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessTenKH.setForeground(new java.awt.Color(255, 0, 0));

        lbMessSdt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessSdt.setForeground(new java.awt.Color(255, 0, 0));

        lbMessDiachi.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessDiachi.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapnhatKH, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDiachi))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnChinhLayout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnChinhLayout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbxMaKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbMessDiachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbMessSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                    .addContainerGap(268, Short.MAX_VALUE)
                    .addComponent(lbMessTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCapnhatKH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                    .addContainerGap(211, Short.MAX_VALUE)
                    .addComponent(lbMessTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(264, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(CapnhatKhachhangGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapnhatKhachhangGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapnhatKhachhangGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapnhatKhachhangGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapnhatKhachhangGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhatKH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbxMaKH;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbMessDiachi;
    private javax.swing.JLabel lbMessSdt;
    private javax.swing.JLabel lbMessTenKH;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
