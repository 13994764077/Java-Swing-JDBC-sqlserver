package JavaGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *	��������ִ�и���(����\ɾ��\�޸�)����
 * */

public class Update {
	
	Statement statement = null;
	
	int highth = 500;
	public Update()
	{
		try 
		{
			// ����������µı�ǩ
    		JLabel AskLabel = new JLabel("�����Ƿ�Ҫ���и���(yes/no)? ");
    		AskLabel.setBounds(10,highth, 200, 25);
    		Main.panel.add(AskLabel);
    		// �����ı���
    		JTextField Ask = new JTextField(20);
    		Ask.setBounds(190, highth, 100, 25);
    		Main.panel.add(Ask);
    		// ����ȷ������İ�ť
    		JButton AskButton = new JButton("ȷ��");
    		AskButton.setBounds(300, highth, 70, 25);
    		Main.panel.add(AskButton);
    		//Ϊ��ť���һ������¼�(��������ť�ͻ�ִ�ж�Ӧ��actionPerformed()����
    		ActionListener al1 = new ActionListener()
    		{
    			@Override
    			public void actionPerformed(ActionEvent e) 
    			{
    				String inputAsk = Ask.getText();
    				if(inputAsk.equals("yes"))
    				{
    					//��ʼ���и���
    					try 
    					{
    						System.out.println("��ʼ���и���");
    						
    			    		JLabel OPLabel = new JLabel("��������Ҫִ�еĸ��²���SQL���:");
    			    		highth += 30;
    			    		OPLabel.setBounds(10,highth, 250, 25);
    			    		Main.panel.add(OPLabel);
    			    		// �����ı���
    			    		JTextField OPText = new JTextField(20);
    			    		highth += 23;
    			    		OPText.setBounds(10, highth, 300, 25);
    			    		Main.panel.add(OPText);
    			    		// ����ȷ������İ�ť
    			    		JButton AskButton = new JButton("ȷ��");
    			    		AskButton.setBounds(320, highth, 70, 25);
    			    		Main.panel.add(AskButton);
    			    		ActionListener al2 = new ActionListener() 
    			    		{
    			    			@Override
    			    			public void actionPerformed(ActionEvent e) 
    			    			{					
    			    				String OPSQL = OPText.getText();
    			    				System.out.println("ִ�е����Ϊ: "+OPSQL);
    			    				
    			    				try 
    			    				{
										statement = Main.con.createStatement();
										statement.executeUpdate(OPSQL);
										
										System.out.println("ִ�гɹ���");
										
							    		JLabel TrueLabel = new JLabel("ִ�гɹ���");
							    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
							    		highth += 18;
							    		TrueLabel.setBounds(10,highth, 200, 25);
							    		Main.panel.add(TrueLabel);
    			    				}
    			    				catch (Exception e2) 
    			    				{
    			    					
    			    					System.out.println("ִ��ʧ�ܣ�����SQL�������д���");
    			    					
							    		JLabel TrueLabel = new JLabel("ִ��ʧ�ܣ�����SQL�������д���");
							    		highth += 18;
							    		TrueLabel.setBounds(10,highth, 200, 25);
							    		Main.panel.add(TrueLabel);
										e2.printStackTrace();
									}
    			    			}
    			    		};
    			    		AskButton.addActionListener(al2);
    			    			
    					}
    					catch (Exception e1) 
    					{
							e1.printStackTrace();
						}
    				}
    				else 
    				{
    					//����Ҫ���и���
    					System.out.println("����Ҫ���и���");
					}
    			}
    		};
    		AskButton.addActionListener(al1);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(statement != null) statement.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
}
