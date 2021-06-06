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
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.KhachhangDAO;
import DAO.PhitrehanDAO;
import Entity.Khachhang;
import Entity.Phitrehan;

/**
 *
 * @author Minh Hau
 */
public class ThanhtoanPhitrehanGD extends javax.swing.JFrame {

	TradiaGD trd = new TradiaGD();
	ThuediaGD thd = new ThuediaGD();
	KhachhangDAO khdao =new KhachhangDAO();
	PhitrehanDAO pthdao = new PhitrehanDAO();
    /**
     * Creates new form XoaDVDGD
     */
    public ThanhtoanPhitrehanGD() {
        initComponents();
        
       btnKiemtraMaKH1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ChinhsachPhitrehanGD cspthgd = new ChinhsachPhitrehanGD();
			cspthgd.setVisible(true);
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
        btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThanhtoanPhitrehanGD.this.setVisible(false);
				
			}
		});
        
        btnThanhtoan.addMouseListener(new MouseListener() {
			
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
			btnThanhtoan.addMouseListener(new MouseListener() {
			
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
        btnThanhtoan = new javax.swing.JButton();
        lbMessTienphidatra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnKiemtraMaKH = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSdtKH = new javax.swing.JLabel();
        lbMessTienphidatra1 = new javax.swing.JLabel();
        txtPhidatra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbPhitrehandatra = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnKiemtraMaKH1 = new javax.swing.JButton();
        setTitle("Phần mềm cho thuê đĩa");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("THANH TOÁN PHÍ TRỄ HẠN");

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnThanhtoan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnThanhtoan.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\pay2.png")); // NOI18N
        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.setToolTipText("");
        btnThanhtoan.setPreferredSize(new java.awt.Dimension(220, 100));

        lbMessTienphidatra.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessTienphidatra.setForeground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Mã khách hàng:");

        txtMaKh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        btnKiemtraMaKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraMaKH.setText("Kiểm tra");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Tên khách hàng:");

        lbTenKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Số điện thoai:");

        lbSdtKH.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        lbMessTienphidatra1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbMessTienphidatra1.setForeground(new java.awt.Color(255, 0, 0));

        txtPhidatra.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Tiền phí muốn trả:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Tổng tiền phí trễ hạn:");

        lbTongphitrehan1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbTongphitrehan1.setForeground(new java.awt.Color(255, 0, 0));

        lbPhitrehandatra.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Phí trễ hạn đã trả:");

        btnKiemtraMaKH1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnKiemtraMaKH1.setText("Chính sách phí trễ hạn");

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTieude, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel17)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))))
                                .addGap(41, 41, 41)
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTongphitrehan1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbPhitrehandatra, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(lbMessTienphidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbMessTienphidatra1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnKiemtraMaKH1)
                                            .addComponent(btnKiemtraMaKH)))))
                            .addGroup(pnChinhLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKiemtraMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnKiemtraMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(lbSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lbPhitrehandatra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel17))
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbTongphitrehan1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhidatra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addComponent(lbMessTienphidatra1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnChinhLayout.createSequentialGroup()
                        .addComponent(lbMessTienphidatra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGap(58, 58, 58))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {                                         
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
            java.util.logging.Logger.getLogger(ThanhtoanPhitrehanGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhtoanPhitrehanGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhtoanPhitrehanGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhtoanPhitrehanGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhtoanPhitrehanGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnKiemtraMaKH;
    private javax.swing.JButton btnKiemtraMaKH1;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbMessTienphidatra;
    private javax.swing.JLabel lbMessTienphidatra1;
    private javax.swing.JLabel lbPhitrehandatra;
    private javax.swing.JLabel lbSdtKH;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTieude;
    public static final javax.swing.JLabel lbTongphitrehan1 = new javax.swing.JLabel();
    private javax.swing.JPanel pnChinh;
    public static final javax.swing.JTextField txtMaKh = new javax.swing.JTextField();
    private javax.swing.JTextField txtPhidatra;
    // End of variables declaration                   
}
