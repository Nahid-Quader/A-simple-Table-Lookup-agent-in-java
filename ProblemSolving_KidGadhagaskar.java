/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *

/**
 *
 * @author MH
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class ProblemSolving_KidGadhagaskar extends JFrame
{

    /**
     * @param args the command line arguments
     */
    int goal=0;
    int count=0;
     private JTextField utxt;
    private JTextArea chatWindow;
    private String q;
    private String a;
    private JTextField question=new JTextField("Type your question and PRESS ENTER");
    private JTextField answer =new JTextField("type your answer and PRESS ENTER");
     JFrame frame=new JFrame("Add Question");
    private JButton b=new JButton("Click to add question");
    private JButton submit=new JButton("Submit");
    Map<String, String> map = new HashMap<String, String>();
    public void MatureGadhagaskar() throws IOException
    {
        
      mapRead();
      JPanel panel = new JPanel();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(400,400); 
      add(panel,BorderLayout.NORTH);
      panel.add(b);        
      String msg;
      setTitle("MatureGadhagaskar");
      utxt=new JTextField("Ask a question");
      add(utxt,BorderLayout.SOUTH);
      chatWindow=new JTextArea();
      add(new JScrollPane(chatWindow));
      add(chatWindow,BorderLayout.CENTER);
      setVisible(true);
      goal=Goal();
      FaceTheProblem();
  } 
    
    
  public void FaceTheProblem()
  { 
        utxt.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                Action("You : "+event.getActionCommand());
                Solve(event.getActionCommand());
                utxt.setText("");
            }       
         }
        );
        
         b.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==b)
                {
                    
                     Container content = frame.getContentPane();
                     content.setLayout(new GridLayout(3, 1));
                     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                     frame.setSize(400,200);
                     frame.setVisible(true);
                     content.add(question);
                     content.add(answer);
                     content.add(submit);
                }
            }       
         }
        );
        
         submit.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==submit)
                {
                     TableEntry(q,a);
                     frame.setVisible(false);
                     frame.dispose();
                }
            }       
         }
        );
         
        question.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                q=event.getActionCommand();
                if(q!=null)
                {
                    question.setText("question recieved!!");
                }
            }       
         }
        );
        
        
        answer.addActionListener
        (
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                a=event.getActionCommand();
                if(a!=null)
                {
                    answer.setText("asnwer recieved!!");
                }
            }       
         }
        );   
    }
  
  
  
  
   public int Goal()
   {
       Scanner sc=new Scanner(System.in);
       System.out.println("how many question will gadhagaskar face? ");
       int ans=sc.nextInt()+1;
       return ans;
   }
    
    
    public void TableEntry(String q,String a)
    {
        System.out.println(q+" "+a);
       if(!q.equals(null) | !a.equals(null)) 
       {
            map.put(q,a);
            mapWrite();
       }
       else
       {
           Action("Please enter both question and answer");
       }
       
    }
  
    //Solve means find the answer of that question
    public void Solve(String q)
    {
        if(map.get(q)==null)
        {
            Action("Sorry answer is not available in my table!!!");
        }
        else
        {
            String ans=map.get(q);
            
            Action("MatureGadhagaskar  : "+ans);
            goal--;
        }
    }
    
    
    private void mapWrite()
    {
        File file = new File("Map.txt");
        try
        {
           BufferedWriter bw = new BufferedWriter(new FileWriter(file));
           for(String p:map.keySet())
           {
              bw.write(p + "," +map.get(p));
              bw.newLine();
           }
           bw.flush();
           bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    
    private void mapRead()
    {
        java.io.File file = new java.io.File("Map.txt");
        try
            {
               BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
               String l;
               while((l = br.readLine()) != null)
               {
                  String[] args = l.split("[,]", 2);
                  if(args.length != 2)continue;
                  String p = args[0];//.replaceAll(" ", "");
                  String b = args[1];//.replaceAll(" ", "");
                   map.put(p,b);
               }
               br.close();
            }
        
         catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    
    
    private void Action(final String msg)
    {
     SwingUtilities.invokeLater
    (
        new Runnable()
        {
          public void run()
          {
              if(goal>0)
              {
                chatWindow.append("\n"+msg);
              }
              else
              {
                  if(count==0)
                  {
                    chatWindow.append("\n My goal is accomplished!! so program ends now! thank you.");
                    utxt.setEditable(false);
                    count++;
                  }
              }
          }
        }
    );
        
    }
    
    
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        ProblemSolving_KidGadhagaskar t=new ProblemSolving_KidGadhagaskar();
        try
        {
            t.MatureGadhagaskar();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
