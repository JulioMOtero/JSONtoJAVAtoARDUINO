
package conexao;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class ControlePorta {
  private OutputStream serialOut;
  private int taxa;
  private String portaCOM;

  /**
   * Construtor da classe ControlePorta
   * @param portaCOM - COM from Arduino
   * @param taxa - usualy 9600
   */
  public ControlePorta(String portaCOM, int taxa) {
    this.portaCOM = portaCOM;
    this.taxa = taxa;
    this.initialize();
  }     
 

  private void initialize() {
    try {
      //define portId from CommPortIdentifier to comunicate with serial 
      CommPortIdentifier portId = null;
      try {
        //if COM exist
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
      }catch (NoSuchPortException npe) {
        //if COM not found
        JOptionPane.showMessageDialog(null, "Porta COM nao encontrada.",
                  "Porta COM", JOptionPane.PLAIN_MESSAGE);
      }
      //open COM 
      SerialPort port = (SerialPort) portId.open("Comunicacao serial", this.taxa);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.taxa, //taxa de transferencia da porta serial 
                               SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                               SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                               SerialPort.PARITY_NONE); //receber e enviar dados
    }catch (Exception e) {
      e.printStackTrace();
    }
}

  /**
   * close communication with COM
   */
  public void close() {
    try {
        serialOut.close();
    }catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Nao foi possivel fechar porta COM.",
                "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * @param opcao - value to send
   */
  public void enviaDados(int opcao){
    try {
      serialOut.write(opcao);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Nao foi possivel enviar o dado. ",
                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
    }
  } 
}
