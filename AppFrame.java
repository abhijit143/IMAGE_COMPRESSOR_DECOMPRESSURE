package GUI;

import comp_decomp.compreesor;
import comp_decomp.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class AppFrame extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton ("Select File To Compress");
        compressButton.setBounds(100,100,200,30);
        compressButton.addActionListener(this);

        decompressButton = new JButton ("Select File To Decompress");
        decompressButton.setBounds(250,100,200,30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compreesor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }

        if(e.getSource() == decompressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }

    }

}

