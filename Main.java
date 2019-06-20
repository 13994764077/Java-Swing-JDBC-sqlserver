package JavaGUI;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *	JavaGUI���ж���д��ͼ�ν���汾
 * */

public class Main {
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Student";
    static Connection con = null;
     
    static JFrame frame = null;//��¼����
    static JPanel panel = null;//��¼���
    
//    static JFrame frameOP = null;//��������(�������������: ��ѯ\����\�Զ������)
//    static JPanel panelSearch = null;//��ѯ���
//    static JPanel panelUpdate = null;//�������
//    static JPanel panelDiy = null;//�Զ���������
    
    public static void main(String[] args) {
        try                                                                                                                                         
        {
            Class.forName(cfn);
            
            //ʵ����һ�����ڶ���
            frame = new JFrame("ѧ����Ϣ�������ݿ�ϵͳ");
            frame.setSize(470,500);
            
    		//ʵ������һ��������
    		panel = new JPanel();
    		//�������ӵ���������
    		frame.add(panel);
    		panel.setLayout(null);
    		
            //��������Ϊ���ӻ�
    		frame.setVisible(true);
    		
            //��¼����: �����˺�����
            Login login = new Login(); //newһ��Login��ִ�е�¼����
    		
            
//    		System.out.println("�����ݿ�Ļ�������: ");
//			System.out.println("ѧ��������Ϣ��: Student");
//			System.out.println("�γ���Ϣ��: Course");
//			System.out.println("ѧ���ɼ���: Scores");
//			System.out.println("���ñ�: Hobby");
//			System.out.println("ѧ���İ��������: StuHobby");
//			System.out.println("��ѧ��Ϣ��: University");
//			System.out.println("ѧ���о���¼ȡ�����: Graduate");
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
            	if(con != null) con.close();
            } 
            catch (Exception e2) 
            {
                e2.printStackTrace();
            }
        }
    }

    //ʹ��Robot����ģ���ڿ���̨�����Ҽ� + ctrl+r������Ч��
    public static void clear() throws AWTException
    {
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON3_MASK);       // ��������Ҽ�
        r.mouseRelease(InputEvent.BUTTON3_MASK);    // �ͷ�����Ҽ�
        r.keyPress(KeyEvent.VK_CONTROL);             // ����Ctrl��
        r.keyPress(KeyEvent.VK_R);                    // ����R��
        r.keyRelease(KeyEvent.VK_R);                  // �ͷ�R��
        r.keyRelease(KeyEvent.VK_CONTROL);            // �ͷ�Ctrl��
        r.delay(100); 
    }
    
}
