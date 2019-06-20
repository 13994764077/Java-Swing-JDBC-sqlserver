package JavaGUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *	����ʵ�����ݿ��¼����
 * */

public class Login {

	public String zh,mm;

	public Login() {
        
		//������¼���滶ӭ��ǩ
		JLabel LoginLabel = new JLabel("���ݿ��¼����");
		LoginLabel.setFont(new Font("΢���ź�",1,20)); 
		LoginLabel.setBounds(140, 20,200, 20);//(x,y,width,height)
		Main.panel.add(LoginLabel);
		
		//��һ��ͼƬ�ڻ�ӭ��ǩ����
		JLabel LoginPhoto = new JLabel(new ImageIcon("src/JavaGUI/��¼����1.png"));
		LoginPhoto.setBounds(10,40,80,80);
		Main.panel.add(LoginPhoto);
		
		//���������˺ź�����ı�ǩ\�ı���\��ť
		JLabel ZHLabel = new JLabel("�˺�: ");
		ZHLabel.setBounds(100, 60, 80, 25);
		Main.panel.add(ZHLabel);
		// �����ı������������˺�
		JTextField ZHText = new JTextField(20);
		ZHText.setBounds(150, 60, 100, 25);
		Main.panel.add(ZHText);
		// ����ȷ�������˺ŵİ�ť
		JButton ZHButton = new JButton("ȷ��");
		ZHButton.setBounds(260, 60, 70, 25);
		Main.panel.add(ZHButton);
		//Ϊ��ť���һ������¼�(��������ť�ͻ�ִ�ж�Ӧ��actionPerformed()����
		ActionListener al1 = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{					
				//���˺��ı����е��ַ�����ֵ��zh
				String inputZH = ZHText.getText();
				zh = inputZH;
				System.out.println("�˺�Ϊ: "+zh);
			}
		};
		ZHButton.addActionListener(al1);
		
		//���������˺ź�����ı�ǩ\�ı���\��ť
		JLabel MMLabel = new JLabel("����: ");
		MMLabel.setBounds(100, 90, 80, 25);
		Main.panel.add(MMLabel);
		// ���������������������
		JPasswordField MMText = new JPasswordField(20);
		MMText.setBounds(150, 90, 100, 25);
		Main.panel.add(MMText);
		// ����ȷ����������İ�ť
		JButton MMButton = new JButton("ȷ��");
		MMButton.setBounds(260, 90, 70, 25);
		Main.panel.add(MMButton);
		//Ϊ��ť���һ������¼�(��������ť�ͻ�ִ�ж�Ӧ��actionPerformed()����
		ActionListener al2 = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{					
				//���˺��ı����е��ַ�����ֵ��mm
				char[] inputMM = MMText.getPassword(); // ����1����ô��ȡ������ַ���
				mm = String.valueOf(inputMM);;
				
				System.out.println("����Ϊ: "+mm);
				
				//���������˺ź�����֮��ʼ����¼�Ƿ�ɹ�
				if(!Check())
				{
					//��¼ʧ�ܾ�ֱ���˳���
					System.exit(-1);
				}
				else 
				{
					//��¼�ɹ���Ҫ: 1.�رյ�¼���� 2.��ִ�ж����ݿ�����Ĵ���

//					Main.frameOP = new JFrame("ѧ����Ϣ�������ݿ�ϵͳ");
//					Main.frameOP.setSize(480,500);
//		            
//					Main.panelSearch = new JPanel();
//					Main.frameOP.add(Main.panelSearch);
//					Main.panelSearch.setLayout(null);
//		    		
//					Main.frameOP.setVisible(true);
					
//		            ��ѯ����: ��¼����Ժ�ֱ�����´��ڵ�panelSearch�����в�ѯ����
					
					//ֱ���ڵ�¼����Ͻ��в�ѯ����
		            Search search = new Search(); //newһ��Search��ִ�в�ѯ����
		            
		            
				}
			}
		};
		MMButton.addActionListener(al2);
		
	}

	//����¼�Ƿ�ɹ�
	public boolean Check()
	{
        try 
        {
        	Main.con = DriverManager.getConnection(Main.url,zh,mm);
        	System.out.println("��¼�ɹ���");
        	
        	//bug����ӡ�����������ǩ��Ϣ
    		JLabel LoginTrueLabel = new JLabel(" ��¼�ɹ��� ");
    		LoginTrueLabel.setFont(new Font("΢���ź�",1,15)); 
    		LoginTrueLabel.setBounds(100,120, 100, 25);
    		Main.panel.add(LoginTrueLabel);
        	return true;
		} 
        catch (Exception e) 
        {
			System.out.println("�˺�����������󣬼����˳�ϵͳ!");
    		JLabel LoginFlaseLabel_1 = new JLabel(" �˺�����������󣬼����˳�ϵͳ! ");
    		LoginFlaseLabel_1.setFont(new Font("΢���ź�",1,15)); 
    		LoginFlaseLabel_1.setBounds(10, 120, 300, 25);
    		Main.panel.add(LoginFlaseLabel_1);	
			try 
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
//			System.out.println("���˳�ϵͳ��");
			JLabel LoginFlaseLabel_2 = new JLabel(" ���˳�ϵͳ��");
			LoginFlaseLabel_2.setBounds(10, 130, 100, 25);
			LoginFlaseLabel_2.setFont(new Font("΢���ź�",1,15)); 
    		Main.panel.add(LoginFlaseLabel_2);
			return false;
		}	
	}
}
